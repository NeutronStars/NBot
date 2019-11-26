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
package fr.neutronstars.plugin.listener;

import fr.neutronstars.nbot.api.event.EventPriority;
import fr.neutronstars.nbot.api.event.Listener;
import fr.neutronstars.nbot.api.event.user.UserCommandExecuteEvent;

/*
 * This class contains a method list with the @Listener annotation.
 */
public class PluginListener
{
    /*
     *  Event methods must have the @Listener annotation in order to be saved.
     *
     * Parameters of @Listener:
     *      ignoreCancelled: If True and the event is canceled then this method will not be called. (The value is false by default.)
     *      priority: Call order of the event.
     *
     * Event priority call order:
     *      LOWEST
     *      LOW
     *      NORMAL [Default value]
     *      HIGH
     *      HIGHEST
     */
    @Listener(ignoreCancelled = true, priority = EventPriority.LOW)
    public void onCommandExecute(UserCommandExecuteEvent event)
    {
        /*
         * Cancel the event if the name of the command is "test".
         */
        event.setCancelled(event.getCommandName().equalsIgnoreCase("test"));
    }
}
