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

/**
 * Allows you to manage additional user data and be initialized at the same time as {@link NBotUser}.
 *
 * <p><strong>Information:</strong> To register a class custom user you must call the {@link fr.neutronstars.nbot.api.NBot#registerCustomUser(Class)} method.</p>
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public abstract class NBotCustomUser
{
    /**
     * Main instance of the user.
     */
    private final NBotUser user;

    /**
     * The constructor should only initialize the user. To load it, use the {@link #load()} method. Also remember to put the constructor's visibility in public.
     *
     * @param user
     *      Main instance of user.
     */
    protected NBotCustomUser(NBotUser user)
    {
        this.user = user;
    }

    /**
     * Retrieve the main instance of user.
     * @return the main instance of user.
     */
    public final NBotUser getUser()
    {
        return user;
    }

    /**
     * This method is called when the object is initialized. This allows you to load the user's data.
     */
    public abstract void load();

    /**
     * This method is called when the user needs to be saved.
     */
    public abstract void save();
}
