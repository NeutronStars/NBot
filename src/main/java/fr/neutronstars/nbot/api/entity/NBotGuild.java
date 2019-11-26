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
package fr.neutronstars.nbot.api.entity;

import fr.neutronstars.nbot.api.command.CommandType;
import fr.neutronstars.nbot.api.language.Language;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Manage the data of a Guild.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface NBotGuild
{
    /**
     * Retrieve the instance of the guild of JDA.
     * @return  the guild object of JDA.
     */
    Guild getGuild();

    /**
     * Retrieve the prefix of command for a guild.
     * @return the prefix of command.
     */
    String getPrefix();

    /**
     * Retrieve the language selected of the guild.
     *
     * <p><strong>Information: </strong> The default language is {@link fr.neutronstars.nbot.api.language.LanguageTypes#EN_US}.</p>
     *
     * @return the language selected.
     */
    Language getLanguage();

    /**
     * Check if a textual channel has permission.
     *
     * @param channel
     *      the channel to check.
     * @param permission
     *      the permission to check.
     * @return True if the textual channel has permission.
     */
    boolean hasPermission(TextChannel channel, String permission);

    /**
     * Check if a member has permission.
     *
     * @param member
     *      The member to check.
     * @param user
     *      The instance NBotUser of user to check if the user does not have basic denied permission
     * @param commandType
     *      The command type of the command executed.
     * @param permission
     *      The permission to check.
     * @return True if the member has permission.
     */
    boolean hasPermission(Member member, NBotUser user, CommandType commandType, String permission);

    /**
     * Save the guild data.
     */
    void save();
}
