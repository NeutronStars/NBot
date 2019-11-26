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

/**
 * Implement this class if the event is to be canceled.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public interface Cancellable
{
    /**
     * Check is the event is cancelled.
     * @return True if the event is cancelled.
     */
    boolean isCancelled();

    /**
     * Should the event be canceled ?
     *
     * @param cancelled
     *      True if the event must be cancelled.
     */
    void setCancelled(boolean cancelled);
}
