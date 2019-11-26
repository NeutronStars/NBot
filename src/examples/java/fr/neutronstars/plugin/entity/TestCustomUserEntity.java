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
package fr.neutronstars.plugin.entity;

import fr.neutronstars.nbot.api.entity.NBotCustomUser;
import fr.neutronstars.nbot.api.entity.NBotUser;

/*
 * To create a custom user, you must extends NBotCustomUser.
 */
public class TestCustomUserEntity extends NBotCustomUser
{
    /*
     * A test value for the example.
     */
    private int testCount;

    /*
     * The constructor must compulsorily ask THAT the NBotUser !
     */
    public TestCustomUserEntity(NBotUser user)
    {
        super(user);
    }

    /*
     * A getter test for the example.
     */
    public int getTestCount()
    {
        return testCount;
    }

    /*
     * A method test for the example.
     */
    public void addTestCount(int testCount)
    {
        this.testCount+=testCount;
    }

    /*
     * This method is called when the object is initialized. This allows you to load the user's data.
     */
    @Override
    public void load()
    {
        this.testCount = super.getUser().getConfiguration().get(0, "testCount");
    }

    /*
     * This method is called when the user needs to be saved.
     */
    @Override
    public void save()
    {
        super.getUser().getConfiguration().set(testCount, "testCount");
    }
}
