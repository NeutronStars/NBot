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
package fr.neutronstars.nbot.api.event.guild;

import fr.neutronstars.nbot.api.entity.NBotGuild;
import fr.neutronstars.nbot.api.event.Event;

/**
 * Any class event that will use the {@link NBotGuild} will extend this class.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public abstract class NBotGuildEvent implements Event
{
    /**
     * The instance of the guild.
     */
    private final NBotGuild guild;

    /**
     * The constructor call for init the guild.
     * @param guild
     *      The guild to init.
     */
    protected NBotGuildEvent(NBotGuild guild)
    {
        this.guild = guild;
    }

    /**
     * Retrieve the instance of the guild.
     * @return the instance of the guild.
     */
    public NBotGuild getGuild()
    {
        return guild;
    }
}
