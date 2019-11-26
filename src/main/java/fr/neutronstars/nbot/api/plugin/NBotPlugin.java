/**
 * Copyright 2019 NeutronStars
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.neutronstars.nbot.api.plugin;

import fr.neutronstars.nbot.api.NBot;
import fr.neutronstars.nbot.api.command.CommandExecutor;
import fr.neutronstars.nbot.api.command.CommandPermission;
import fr.neutronstars.nbot.api.command.CommandType;
import fr.neutronstars.nbot.api.configuration.Configuration;
import fr.neutronstars.nbot.api.language.LanguageInfo;
import org.slf4j.Logger;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * Main instance from create a plugin.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public abstract class NBotPlugin
{
    /**
     * The instance of logger for this plugin.
     */
    private final Logger logger;

    /**
     * The identification of this plugin.
     */
    private final String id;

    /**
     * The name of this plugin.
     */
    private final String name;

    /**
     * The description of this plugin.
     *
     * <p><strong>Information: </strong>The description uses the language selected by the user.</p>
     */
    private final String description;

    /**
     * The version of this plugin.
     */
    private final String version;

    /**
     * List of authors of this plugin.
     */
    private final String[] authors;

    /**
     * Default configuration of this plugin.
     */
    private Configuration configuration;

    /**
     * The main controller to boot this plugin.
     *
     * <p><strong>Warning: </strong>The constructor of the class children must not have a parameter.</p>
     *
     * @param id
     *      The identification of this plugin.
     * @param name
     *      The name of this plugin.
     * @param version
     *      The version of this plugin.
     * @param description
     *      The description of this plugin.
     * @param authors
     *      The list of authors of this plugin.
     */
    protected NBotPlugin(String id, String name, String version, String description, String... authors)
    {
        this.id = id.replace(" ", "_").toLowerCase();
        this.name = name;
        this.version = version;
        this.description = description;
        this.authors = authors;

        logger = StaticLoggerBinder.getSingleton().getLoggerFactory().getLogger(name);
    }

    /**
     * Retrieve the identification of this plugin.
     * @return the identification of this plugin.
     */

    public String getId()
    {
        return id;
    }

    /**
     * Retrieve the name of this plugin.
     * @return the name of this plugin.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Retrieve the version of this plugin.
     * @return the version of this plugin.
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * Retrieve the description of this plugin.
     * @return the description of this plugin.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Retrieve the list of authors of this plugin.
     * @return the list of authors of this plugin.
     */
    public String[] getAuthors()
    {
        return authors;
    }

    /**
     * Retrieve the logger of this plugin.
     * @return the logger of this plugin.
     */
    public Logger getLogger()
    {
        return logger;
    }


    /**
     * Register the commands of this plugin.
     *
     * <p><strong>Warning: </strong>If the user does not have permission, the command can not be executed even if CommandType is ALL.</p>
     *
     * <p><strong>Information: </strong>The command type is for all by default.</p>
     *
     * @param name
     *      The name of the command.
     * @param description
     *      The description of the command.
     * @param executor
     *      The instance of the command class.
     * @param permission
     *      The permission of the command.
     */
    public void registerCommand(String name, String description, CommandExecutor executor, String permission)
    {
        this.registerCommand(name, description, executor, permission, CommandType.ALL);
    }

    /**
     * Register a commands of this plugin.
     *
     * <p><strong>Warning: </strong>If the user does not have permission, the command can not be executed even if CommandType is ALL.</p>
     *
     * @param name
     *      The name of the command.
     * @param description
     *      The description of the command.
     * @param executor
     *      The instance of the command class.
     * @param permission
     *      The permission of the command.
     * @param commandType
     *      Those who can execute your command. (ALL [by default], ADMIN, OWNER)
     */
    public void registerCommand(String name, String description, CommandExecutor executor, String permission, CommandType commandType)
    {
        NBot.get().getCommandManager().registerCommand(this, name, description, executor, permission, commandType);
    }

    /**
     * Register a command of this plugin with a custom permission.
     *
     * @param name
     *      The name of the command.
     * @param description
     *      The description of the command.
     * @param executor
     *      The instance of the command class.
     * @param commandPermission
     *      The instance of custom permission.
     */
    public void registerCommand(String name, String description, CommandExecutor executor, CommandPermission commandPermission)
    {
        NBot.get().getCommandManager().registerCommand(this, name, description, executor, commandPermission);
    }

    /**
     * Load a language of this plugin.
     *
     * @param type
     *      The nom of language. The file name must be renamed exactly as the type and followed by the extension ".json". (example: EN_US.json)
     * @param path
     *      The path of the language file. Must start and end with a "/".
     */
    public void registerLanguage(LanguageInfo type, String path)
    {
        NBot.get().registerLanguage(this, type, path);
    }

    /**
     * Retrieve a new instance of {@link Configuration} of this plugin.
     * @return a new instance of {@link Configuration} of this plugin.
     */
    public Configuration getConfiguration()
    {
        if(this.configuration == null)
        {
            this.configuration = NBot.get().getConfiguration(this);
        }
        return this.configuration;
    }
}
