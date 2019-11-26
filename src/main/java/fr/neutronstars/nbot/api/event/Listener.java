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

import fr.neutronstars.nbot.api.plugin.NBotPlugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation must be placed above the event methods to be registered.
 * The class that contains the list of annotated event methods in this annotation must be registered using {@link fr.neutronstars.nbot.api.plugin.PluginManager#registerEvents(NBotPlugin, Object...)} method.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Listener
{
    /**
     * Should the method be called if the event has been canceled ?
     *
     * <p><strong>Default Value: </strong>False</p>
     *
     * @return True if the method should not be called if the event was canceled.
     */
    boolean ignoreCancelled() default false;

    /**
     * The order in which the method must be called.
     *
     * <p><strong>Default Value: </strong>{@link EventPriority#NORMAL}</p>
     *
     * @return the order in which the method must be called.
     */
    EventPriority priority() default EventPriority.NORMAL;
}
