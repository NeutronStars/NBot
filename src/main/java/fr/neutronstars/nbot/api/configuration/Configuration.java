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
package fr.neutronstars.nbot.api.configuration;

import java.io.IOException;

/**
 * Read and write in configuration files for NBot.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface Configuration
{
    /**
     * Check if a value exists on these keys.
     *
     * @param nodes
     *      It's an array of strings to retrieve a value from the configuration.
     * @return True if a value exists.
     */
    boolean has(String... nodes);

    /**
     * Retrieve a value from the configuration. If the value was not found then we return the default value.
     *
     * <p><strong>Warning:</strong> The type 'T' can throw {@link ClassCastException} !</p>
     *
     * @param def
     *      The default value if the nodes are not found.
     * @param nodes
     *      It's an array of strings to retrieve a value from the configuration.
     * @param <T>
     *      The type of value sought. Warning: Can throw {@link ClassCastException}.
     * @return The value in the configuration. If not found then return the default value.
     */
    <T> T get(T def, String... nodes);

    /**
     * Retrieve a value from the configuration. If the value was not found, we add the default value in the configuration and return it.
     *
     * <p><strong>Warning:</strong> The type 'T' can throw {@link ClassCastException} !</p>
     * <p><strong>Information:</strong> No save will be made. Remember to call the {@link #save()} method.</p>
     *
     * @param def
     *      The default value if the nodes are not found.
     * @param nodes
     *      It's an array of strings to retrieve a value from the configuration.
     * @param <T>
     *      The type of value sought. Warning: Can throw {@link ClassCastException}.
     * @return The value in the configuration. If not found then return the default value.
     */
    <T> T getOrSet(T def, String... nodes);

    /**
     * Retrieve a value from the configuration. If the value is not found, we add the default value in the configuration and we save it if the save parameter is true then we return it.
     *
     * <p><strong>Warning:</strong> The type 'T' can throw {@link ClassCastException} !</p>
     * <p><strong>Information:</strong> No save will be made if the save parameter is false. Remember to call the {@link #save()} method.</p>
     *
     * @param def
     *      The default value if the nodes are not found.
     * @param save
     *      If True then {@link #save()} method will call.
     * @param nodes
     *      It's an array of strings to retrieve a value from the configuration.
     * @param <T>
     *      The type of value sought. Warning: Can throw {@link ClassCastException}.
     * @return The value in the configuration. If not found then return the default value.
     */
    <T> T getOrSet(T def, boolean save, String... nodes);

    /**
     * Add a new value in the configuration.
     *
     * <p><strong>Information:</strong> No save will be made. Remember to call the {@link #save()} method.</p>
     *
     * @param value
     *      The value to add.
     * @param nodes
     *      It's an array of strings to retrieve a value from the configuration.
     */
    void set(Object value, String... nodes);

    /**
     * Add a new value in the configuration and we save it if the save parameter is true.
     *
     * <p><strong>Information:</strong> No save will be made if the save parameter is false. Remember to call the {@link #save()} method.</p>
     *
     * @param value
     *      The value to add.
     * @param save
     *      If True then {@link #save()} method will call.
     * @param nodes
     *      It's an array of strings to retrieve a value from the configuration.
     */
    void set(Object value, boolean save, String... nodes);

    /**
     * Save the configuration file.
     *
     * @throws IOException
     */
    void save() throws IOException;
}
