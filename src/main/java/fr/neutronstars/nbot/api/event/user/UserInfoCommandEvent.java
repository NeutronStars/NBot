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
package fr.neutronstars.nbot.api.event.user;

import fr.neutronstars.nbot.api.entity.NBotUser;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Called when a user execute the info command.
 */
public class UserInfoCommandEvent extends NBotUserEvent
{
    /**
     * List of fields to add to the embed of the info command.
     */
    private final List<MessageEmbed.Field> fields = new ArrayList<>();

    /**
     * Embed color of the info command.
     */
    private Color color;

    /**
     * The constructor for boot the user.
     * @param user the instance of user.
     */
    protected UserInfoCommandEvent(NBotUser user, @NotNull Color color)
    {
        super(user);
        this.color = color;
    }

    /**
     * Retrieve the embed color of the info command.
     * @return the embed color of the info command.
     */
    @NotNull
    public Color getColor()
    {
        return color;
    }

    /**
     * Change the embed color of the info command.
     * @param color
     *          New embed color of the info command.
     */
    public void setColor(@NotNull Color color)
    {
        this.color = color;
    }

    /**
     * Retrieve the field list to add to the embed of the info command.
     * @return the field list to add to the embed of the info command.
     */
    @NotNull
    public List<MessageEmbed.Field> getFields()
    {
        return fields;
    }

    /**
     * Add a field to the embed of the info command.
     * @param field
     *          the field to add to the embed of the info command.
     */
    public void addField(@NotNull MessageEmbed.Field field){
        this.fields.add(field);
    }
}
