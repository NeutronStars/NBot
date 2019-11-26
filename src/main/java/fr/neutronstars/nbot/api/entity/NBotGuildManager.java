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

import net.dv8tion.jda.api.entities.Guild;

import java.util.List;

/**
 * All Guilds of NBot are loaded and managed by this class.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface NBotGuildManager
{
    /**
     * Retrieve the guilds list loaded.
     * @return the guilds list loaded.
     */
    List<NBotGuild> getGuilds();

    /**
     * Retrieve the instance of {@link NBotGuild} with the JDA Guild.
     *
     * <p><strong>Information:</strong> If {@link NBotGuild} is not loaded then it will be loaded and added to the list of other guilds.</p>
     *
     * @param guild
     *      The JDA Guild for retrieve the instance of NBotGuild.
     * @return the instance of NBotGuild.
     */
    NBotGuild getGuild(Guild guild);
}
