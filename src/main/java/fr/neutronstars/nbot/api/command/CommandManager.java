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
package fr.neutronstars.nbot.api.command;


import fr.neutronstars.nbot.api.plugin.NBotPlugin;

/**
 * All commands are saved and managed by this class.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface CommandManager
{
    /**
     * Retrieve the default prefix for execute a command.
     * @return the prefix by default.
     */
    String getPrefix();

    /**
     * Register a command from a plugin.
     *
     * @param plugin
     *      The plugin owner of the command.
     * @param name
     *      The name of the command.
     * @param description
     *      The description of the command.
     * @param executor
     *      The instance to call when executing the command.
     * @param permission
     *      The permission needed to execute the command.
     * @param commandType
     *      Which type of user can execute the command.
     */
    void registerCommand(NBotPlugin plugin, String name, String description, CommandExecutor executor, String permission, CommandType commandType);

    /**
     * Register a command form a plugin with a custom permission.
     *
     * @param plugin
     *      The plugin owner of the command.
     * @param name
     *      The name of the command.
     * @param description
     *      The description of the command.
     * @param executor
     *      The instance to call when executing the command.
     * @param commandPermission
     *      The instance of custom permission.
     */
    void registerCommand(NBotPlugin plugin, String name, String description, CommandExecutor executor, CommandPermission commandPermission);
}
