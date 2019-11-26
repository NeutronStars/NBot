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
package fr.neutronstars.nbot.api.plugin;

import fr.neutronstars.nbot.api.event.Event;

import java.util.Optional;

/**
 * Manage the list of plugins loaded.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface PluginManager
{
    /**
     * Retrieve a plugin with the class.
     * @param clazz Class of Plugin
     * @return plugin
     */
    Optional<? extends NBotPlugin> getPlugin(Class<? extends NBotPlugin> clazz);

    /**
     * Register a list of method with the annotation @Listener
     * @param plugin plugin of events
     * @param listeners list of methods with @Listener.
     */
    void registerEvents(NBotPlugin plugin, Object... listeners);

    /**
     * Execute the methods register with the param Event
     * @param event The event to call
     */
    void callEvent(Event event);
}
