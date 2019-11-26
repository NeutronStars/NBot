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
import fr.neutronstars.nbot.api.event.Cancellable;

/**
 * This event is called when a user executes a command. This one can be canceled.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public class UserCommandExecuteEvent extends NBotUserEvent implements Cancellable
{
    /**
     * The name of the command.
     */
    private String name;

    /**
     * The list of arguments after the name of the command.
     */
    private String[] args;

    /**
     * If this event needs to be canceled.
     */
    private boolean cancelled;

    public UserCommandExecuteEvent(NBotUser user, String name, String[] args)
    {
        super(user);
        this.name = name;
        this.args = args;
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

    /**
     * Retrieve the name of the command executed by the user.
     * @return the name of the command.
     */
    public String getCommandName()
    {
        return name;
    }

    /**
     * Change the name of the command.
     * @param name
     *      The new name of the command.
     */
    public void setCommandName(String name)
    {
        this.name = name;
    }

    /**
     * Retrieve the list of arguments after the name of the command.
     * @return the list of arguments.
     */
    public String[] getCommandArgs()
    {
        return args;
    }

    /**
     * Change the list of arguments after the name of the command.
     * @param args
     *      The new list of arguments.
     */
    public void setCommandArgs(String... args)
    {
        this.args = args;
    }
}
