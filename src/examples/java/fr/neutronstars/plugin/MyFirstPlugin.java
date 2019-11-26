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
package fr.neutronstars.plugin;

import fr.neutronstars.nbot.api.NBot;
import fr.neutronstars.nbot.api.command.CommandType;
import fr.neutronstars.nbot.api.event.Listener;
import fr.neutronstars.nbot.api.event.server.NBotServerStartedEvent;
import fr.neutronstars.nbot.api.event.server.NBotServerStartingEvent;
import fr.neutronstars.nbot.api.event.server.NBotServerStoppedEvent;
import fr.neutronstars.nbot.api.language.LanguageTypes;
import fr.neutronstars.nbot.api.plugin.NBotPlugin;
import fr.neutronstars.plugin.command.TestCommand;
import fr.neutronstars.plugin.entity.TestCustomUserEntity;
import fr.neutronstars.plugin.listener.PluginListener;

/*
 * This is the main instance of your plugin. Your class needs to extend the NBotPlugin class.
 *
 * Warning:
 *      Do not forget to create the file "plugin.json". This must contain the "main" key that will be redirected to your main class that extends from NBotPlugin.
 *      If you have plugin dependencies. Enter their identifications in "plugin.json" using the key "depends".
 */
public class MyFirstPlugin extends NBotPlugin
{
    /*
     * You need to complete the constructor of NBotPlugin.
     *
     * The parameters:
     *      id: The identification of your plugin.
     *      name: The name of your plugin.
     *      version: The version of your plugin.
     *      description: The description of your plugin. (Called by the language of user.)
     *      authors: It's an array of strings for the owners of your project.
     *
     * Warning: The plugin id must be unique and must have only alpha-numeric characters without spaces.
     */
    public MyFirstPlugin()
    {
        super("first_plugin", "My First Plugin", "1.0", "description", "NeutronStars");
    }

    /*
     * NBotStartingEvent is called when NBot starting up. This event allows you to load the plugin's resources.
     *
     * Warning: The ShardManager of NBot is not initialized yet.
     *
     * Info: All plugins are loaded. So you can use your plugin dependencies correctly.
     */
    @Listener
    public void onStarting(NBotServerStartingEvent event)
    {
        /*
         * You can use the plugin's default logger.
         */
        super.getLogger().info("Starting of "+super.getName()+"...");

        /*
         * You can manage the plugin configuration.
         *
         * Parameters:
         *      def: The default value if the nodes have not been found.
         *      save: If True then the save will be done if the nodes have not been found.
         *      nodes: It's an array of strings to retrieve a value from the configuration.
         */
        String info = super.getConfiguration().getOrSet("This is an info !", true, "info");

        /*
         * You can load your language files.
         *
         * Parameters:
         *      type: The name of language. The file name must be renamed exactly as the type and followed by the extension ".json". (example: EN_US.json)
         *      path: The path of the language file. Must start and end with a "/".
         *
         * Info: You can also create other languages ​​than those provided by NBot.
         */
        super.registerLanguage(LanguageTypes.EN_US, "/assets/language/");
        super.registerLanguage(LanguageTypes.FR_FR, "/assets/language/");

        /*
         * You can register a custom user that will be loaded at the same time as NBotUser initialization.
         *
         * Parameters:
         *      clazz: Your class that extends from NBotCustomUser.
         *
         * Info: To recover the instance of your custom class. You must recover the instance of NBotUser and then call the #get(Class <? extends NBotCustomUser>) method.
         * Example:
         *      TestCustomUserEntity customUserEntity = nbotUser.get(TestCustomUserEntity.class);
         */
        NBot.get().registerCustomUser(TestCustomUserEntity.class);

        /*
         * To register your commands. Proceed like this:
         *
         * Parameters:
         *      name: The name of your command.
         *      description: The description of your command. (Called by the language of user.)
         *      executor: Your Class that implement from CommandExecutor.
         *      permission: The permission of your command.
         *      type: Those who can execute your command. (ALL [by default], ADMIN, OWNER)
         *
         * Warning: If the user does not have permission, the command can not be executed even if CommandType is ALL.
         */
        super.registerCommand("test", "command.test.description", new TestCommand(this), super.getId()+".command.test", CommandType.ALL);

        /*
         * You can register your events with the PluginManager.
         *
         * Parameters:
         *      plugin: The main plugin of the listeners.
         *      listeners: It's an array of object that contains the methods with the @Listener annotation.
         *
         * Warning: You don't have to register the listeners of the class that extends from NBotPlugin. This will be done automatically when initializing it.
         */
        NBot.get().getPluginManager().registerEvents(this, new PluginListener());
    }

    /*
     * NBotStartedEvent is called when NBot has finished loading its resources and has logged the ShardManager.
     */
    @Listener
    public void onStarted(NBotServerStartedEvent event)
    {
        super.getLogger().info(super.getName()+" started !");
    }

    /*
     * NBotStoppedEvent is called when NBot stops.
     */
    @Listener
    public void onStopped(NBotServerStoppedEvent event)
    {
        super.getLogger().info(super.getName()+" stopped !");
    }
}