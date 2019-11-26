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

import fr.neutronstars.nbot.api.configuration.Configuration;
import fr.neutronstars.nbot.api.language.Language;
import net.dv8tion.jda.api.entities.User;

/**
 * Manage the user data.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface NBotUser
{
    /**
     * Retrieve the instance of JDA user.
     * @return the user of JDA.
     */
    User getUser();

    /**
     * Retrieve the instance of class registered in {@link fr.neutronstars.nbot.api.NBot#registerCustomUser(Class)}.
     * @param clazz
     *      The class type to retrieve.
     * @param <T>
     *     The type of instance.
     * @return the instance of the class that extends from NBotCustomUser.
     */
    <T extends NBotCustomUser> T get(Class<T> clazz);

    /**
     * Retrieve the language selected by the user.
     *
     * <p><strong>Information:</strong> The default language is {@link fr.neutronstars.nbot.api.language.LanguageTypes#EN_US}</p>
     *
     * @return the language selected.
     */
    Language getLanguage();

    /**
     * Retrieve the data file of user.
     * @return the data file.
     */
    Configuration getConfiguration();

    /**
     * Check if the user has permission.
     *
     * <p><strong>Warning: </strong>This method only checks for the user and not for the member of a guild.</p>
     *
     * @param permission
     *      the permission to check.
     * @return True if the user has permission.
     */
    boolean hasPermission(String permission);

    /**
     * Add permission to the user.
     * @param permission
     *      the permission to add.
     */
    void addPermission(String permission);

    /**
     * Remove permission to the user.
     * @param permission
     *      the permission to remove.
     */
    void removePermission(String permission);

    /**
     * Add group permission to the user.
     * @param group
     *      the name of group permission to add.
     */
    void addGroupPermission(String group);

    /**
     * Remove group permission to the user.
     * @param group
     *      the name of group permission to remove.
     */
    void removeGroupPermission(String group);

    /**
     * Save the data of user.
     */
    void save();
}
