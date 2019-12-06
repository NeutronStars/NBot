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

import fr.neutronstars.nbot.api.entity.NBotGuild;
import fr.neutronstars.nbot.api.entity.NBotUser;
import fr.neutronstars.nbot.api.event.Cancellable;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * This event is called when a user send a message in a channel guild. This one can be canceled.
 *
 * <p>Warning: If this message is canceled, the API attempts to delete it. If the Bot does not have permission, the message can not be canceled.</p>
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public class UserGuildMessageEvent extends NBotUserEvent implements Cancellable
{
    /**
     * The message send by the user.
     */
    private final Message message;

    /**
     * The text channel or message was sent.
     */
    private final TextChannel channel;

    /**
     * The NBot guild or the message was sent.
     */
    private final NBotGuild nBotGuild;

    /**
     * If this event needs to be canceled.
     */
    private boolean cancelled;

    /**
     * The constructor for boot the user.
     *
     * @param user the instance of user.
     * @param nBotGuild the instance of Nbot guild.
     * @param message the message send by the user.
     */
    public UserGuildMessageEvent(NBotUser user, NBotGuild nBotGuild, Message message)
    {
        super(user);
        this.message = message;
        this.channel = message.getTextChannel();
        this.nBotGuild = nBotGuild;
    }

    /**
     * Retrieve the message send by the user.
     * @return the message object of JDA.
     */
    public Message getMessage()
    {
        return message;
    }

    /**
     * Retrieve the text channel or the message was send by the user.
     * @return the text channel object of JDA.
     */
    public TextChannel getChannel()
    {
        return channel;
    }

    /**
     *
     * Retrieve the instance of NBot Guild or the message was sent.
     *
     * @return the instance of NBot Guild.
     */
    public NBotGuild getNBotGuild()
    {
        return nBotGuild;
    }

    /**
     * Check is the event is cancelled.
     * @return True if the event is cancelled.
     */
    @Override
    public boolean isCancelled()
    {
        return cancelled;
    }

    /**
     * Should the event be canceled ?
     *
     * @param cancelled
     *      True if the event must be cancelled.
     */
    @Override
    public void setCancelled(boolean cancelled)
    {
        this.cancelled = cancelled;
    }
}
