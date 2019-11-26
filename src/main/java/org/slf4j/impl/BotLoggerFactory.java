package org.slf4j.impl;

import fr.neutronstars.nbot.api.NBot;
import org.slf4j.ILoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Origin Code by SLF4J-Simple [Link=https://github.com/qos-ch/slf4j/tree/master/slf4j-simple]
 * Modified by NeutronStars
 */

public class BotLoggerFactory implements ILoggerFactory
{
    private final ConcurrentMap<String, BotLogger> loggerMap = new ConcurrentHashMap<>();
    private final BufferedWriter writer;

    public BotLoggerFactory() throws IOException
    {
        this.writer = newFileLogger();
    }

    private BufferedWriter newFileLogger() throws IOException
    {
        File folder = new File("logs");
        if(!folder.exists() && !folder.mkdir())
        {
            throw new IOException("Can't create the log folder.");
        }

        File file = new File(folder, "latest.log");

        if(file.exists())
        {
            zipFile(folder, file);
            if(!file.delete())
            {
                this.getLogger("ERROR").warn("Can't delete the latest file logger in the logs folder.");
            }
        }
        return new BufferedWriter(new FileWriter(file));
    }

    public BotLogger getLogger(String name)
    {
        BotLogger logger = loggerMap.get(name);
        if (logger != null) {
            return logger;
        } else {
            BotLogger newInstance = new BotLogger(name, this);
            BotLogger oldInstance = loggerMap.putIfAbsent(name, newInstance);
            return oldInstance == null ? newInstance : oldInstance;
        }
    }

    protected void log(String log)
    {
        if(this.writer == null)
        {
            return;
        }

        try {
            this.writer.write(log);
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zipFile(File folder, File file) throws IOException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_YYYY__HH_mm_ss");
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(folder, simpleDateFormat.format(new Date()) + ".zip"))))
        {
            zipOutputStream.setMethod(ZipOutputStream.STORED);
            zipOutputStream.setLevel(Deflater.BEST_COMPRESSION);

            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            in.read(bytes, 0, bytes.length);
            in.close();

            String[] path = file.getPath().split("/");
            String splitFormat = "/";
            if(path.length < 3)
            {
                path = file.getPath().split("\\\\");
                splitFormat = "\\";
            }

            StringBuilder builder = new StringBuilder();

            for(int i = 1; i <path.length-1; i++)
                builder.append(path[i]).append(splitFormat);
            builder.append(path[path.length-1]);

            ZipEntry entry = new ZipEntry(builder.toString());
            entry.setTime(file.lastModified());

            CRC32 crc32 = new CRC32();
            crc32.update(bytes);

            entry.setSize(bytes.length);
            entry.setCrc(crc32.getValue());

            zipOutputStream.putNextEntry(entry);

            zipOutputStream.write(bytes);
            zipOutputStream.closeEntry();

            zipOutputStream.flush();
        }catch (Exception exception){
            this.getLogger("ERROR").error(exception.getMessage(), exception);
        }
    }

    public void close()
    {
        try {
            this.writer.close();
        } catch (IOException e) {
            NBot.get().getLogger().error("Can't close the buffer writer of logger.");
        }
    }
}
