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
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * Stores and manages the permissions of command.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface CommandPermission
{
    /**
     * Retrieve the permission of the command;
     * @return the permission of the command.
     */
    String getPermission();

    /**
     * Retrieves which type of user can execute the command.
     * @return The type of user who can execute the command.
     */
    CommandType getCommandType();

    /**
     * Check if the user can execute the command in the textual channel.
     *
     * @param user
     *      The user who execute the command.
     * @param channel
     *      The textual channel where the command is executed.
     * @param checkChannel
     *      Should we check the permission of the textual channel ?
     * @param showError
     *      Should we send information if the textual channel does not have permission ?
     * @return True if the user has permission.
     */
    boolean hasPermission(NBotUser user, MessageChannel channel, boolean checkChannel, boolean showError);
}
