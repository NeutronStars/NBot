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
package fr.neutronstars.plugin.command;

import fr.neutronstars.nbot.api.command.CommandExecutor;
import fr.neutronstars.nbot.api.entity.NBotUser;
import fr.neutronstars.nbot.api.plugin.NBotPlugin;
import fr.neutronstars.plugin.entity.TestCustomUserEntity;
import net.dv8tion.jda.api.entities.Message;

/*
 * To create a command, you must implements CommandExecutor.
 */
public class TestCommand implements CommandExecutor
{
    private final NBotPlugin plugin;

    public TestCommand(NBotPlugin plugin)
    {
        this.plugin = plugin;
    }

    /*
     * The method will be called when a user executes this command.
     *
     * Parameters:
     *      user: The user who executed the command.
     *      message: The message of the user.
     *      args: The list of arguments after the name of the command.
     *
     * return: If True then the user will be saved.
     */
    @Override
    public boolean onCommand(NBotUser user, Message message, String... args)
    {

        /*
         * Retrieve the instance of the class user custom.
         *
         * Parameters:
         *      clazz: Your class that extends from NBotCustomUser.
         */
        TestCustomUserEntity customUserEntity = user.get(TestCustomUserEntity.class);

        /*
         * You can use the methods of your custom class.
         *
         * Note: I add 1 to the number of test count.
         */
        customUserEntity.addTestCount(1);

        /*
         * Answer the user his test count using his selected language.
         *
         * Language Parameters:
         *      plugin: The plugin to recover the good translation.
         *      nodes: It's an array of strings to retrieve the translation from the language.
         */
        message.getChannel().sendMessage(
                String.format(user.getLanguage().get(plugin, "command", "test", "show"), customUserEntity.getTestCount())
        ).queue();

        /*
         * Should the user be registered ?
         *
         * Note: Yes, I added 1 to the number of test count.
         */
        return true;
    }
}
