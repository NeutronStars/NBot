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
package fr.neutronstars.nbot.api.event.server;

/**
 * this event is called when NBot is starting up. This event allows you to load the plugin's resources.
 *
 * <p><strong>Warning: </strong>The ShardManager of NBot is not initialized yet.</p>
 *
 * <p><strong>Information: </strong>All plugins are loaded. So you can use your plugin dependencies correctly.</p>
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public class NBotServerStartingEvent implements NBotServerEvent
{
    public NBotServerStartingEvent()
    {
        super();
    }
}
