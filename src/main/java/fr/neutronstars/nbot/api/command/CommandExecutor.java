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

import fr.neutronstars.nbot.api.entity.NBotUser;
import net.dv8tion.jda.api.entities.Message;

/**
 * Implement this interface to create commands.
 *
 * <p><strong>Information:</strong> To register a command you must call the {@link fr.neutronstars.nbot.api.plugin.NBotPlugin#registerCommand(String, String, CommandExecutor, String, CommandType)} method of your class {@link fr.neutronstars.nbot.api.plugin.NBotPlugin}.</p>
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface CommandExecutor
{
    /**
     * The method is called when a user executes the command.
     *
     * @param user
     *      The user who execute the command.
     * @param message
     *      The message of user.
     * @param args
     *      The list of arguments after the name of the command.
     * @return If the user needs to be saved.
     */
    boolean onCommand(NBotUser user, Message message, String... args);

    /**
     * The method is called when a user executes the help command with the name of this command.
     *
     * @param user
     *      The user who execute the command.
     * @param message
     *      The message of user.
     * @param args
     *      The list of arguments after the name of the command.
     *
     * @return If the method was correctly executed.
     */
    default boolean onCommandHelp(NBotUser user, Message message, String... args)
    {
        return false;
    }
}
