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
package fr.neutronstars.nbot.api.event;

/**
 * This enum is used to manage the order of event calls.
 *
 * Event priority call order:
 *      1 - LOWEST
 *      2 - LOW
 *      3 - NORMAL [Default]
 *      4 - HIGH
 *      5 - HIGHEST
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public enum EventPriority
{
    LOWEST(0),
    LOW(1),
    NORMAL(2),
    HIGH(3),
    HIGHEST(4);

    private final int order;

    EventPriority(int order)
    {
        this.order = order;
    }

    public int getOrder()
    {
        return order;
    }

    public static EventPriority[] getEventPriorityByOrder()
    {
        EventPriority[] eventPriorities = new EventPriority[EventPriority.values().length];

        for(EventPriority eventPriority : EventPriority.values())
        {
            eventPriorities[eventPriority.order] = eventPriority;
        }
        return eventPriorities;
    }
}
