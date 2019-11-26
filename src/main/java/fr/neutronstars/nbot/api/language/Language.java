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
package fr.neutronstars.nbot.api.language;

import fr.neutronstars.nbot.api.plugin.NBotPlugin;

/**
 * Allows you to retrieve the translations of a language.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface Language
{
    /**
     * Retrieve the language name.
     * @return the name of language.
     */
    String getName();

    /**
     * Retrieve the good translation of language.
     *
     * <p><strong>Information: </strong>If the translation was not found then we will return the list of nodes spaced by points.</p>
     *
     * @param plugin
     *      The plugin to recover the good translation.
     * @param nodes
     *      It's an array of strings to retrieve the translation from the language.
     * @return the translation from the language.
     */
    String get(NBotPlugin plugin, String... nodes);
}
