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
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.PrivateChannel;

public class UserPrivateMessageEvent extends NBotUserEvent
{
    /**
     * The message send by the user.
     */
    private final Message message;

    /**
     * The text channel or message was sent.
     */
    private final PrivateChannel privateChannel;

    /**
     * The constructor for boot the user.
     *
     * @param user the instance of user.
     * @param message the message send by the user.
     */
    public UserPrivateMessageEvent(NBotUser user, Message message)
    {
        super(user);
        this.message = message;
        this.privateChannel = message.getPrivateChannel();
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
     * Retrieve the private channel or the message was send by the user.
     * @return the private channel object of JDA.
     */
    public PrivateChannel getPrivateChannel()
    {
        return privateChannel;
    }
}
