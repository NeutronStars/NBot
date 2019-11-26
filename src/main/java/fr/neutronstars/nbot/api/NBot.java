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
package fr.neutronstars.nbot.api;

import fr.neutronstars.nbot.api.command.CommandManager;
import fr.neutronstars.nbot.api.configuration.Configuration;
import fr.neutronstars.nbot.api.entity.NBotGuildManager;
import fr.neutronstars.nbot.api.entity.NBotUser;
import fr.neutronstars.nbot.api.entity.NBotCustomUser;
import fr.neutronstars.nbot.api.language.Language;
import fr.neutronstars.nbot.api.language.LanguageInfo;
import fr.neutronstars.nbot.api.plugin.PluginManager;
import fr.neutronstars.nbot.api.plugin.NBotPlugin;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

/**
 * Manager class of NBot.
 *
 * @author NeutronStars
 * @version 1.0.0
 */
public abstract class NBot
{
    /**
     * Instance of NBot.
     */
    private static NBot nBot;

    /**
     * Retrieve the instance of NBot.
     * @return the instance of nbot.
     */
    public static NBot get(){
        return NBot.nBot;
    }

    /**
     * Set the main instance of NBot.
     *
     * @param nBot
     *      The main instance of nbot.
     * @throws IllegalArgumentException
     *      Can throw {@link IllegalArgumentException} if the instance of NBot is already initialized.
     */
    public static void set(@NotNull NBot nBot)
    {
        if(NBot.nBot != null)
            throw new IllegalArgumentException("Cannot set a new instance of NBot.");
        NBot.nBot = nBot;
    }

    /**
     * Retrieve instance Logger of NBot
     * @return The main logger
     */
    @NotNull
    public abstract Logger getLogger();

    /**
     * Retrieve a new instance of {@link NBotUser}
     *
     * @param user
     *      User of JDA
     * @return The user custom of NBot.
     */
    public abstract NBotUser getUser(@NotNull User user);

    /**
     * Register a new class of {@link NBotCustomUser}
     * @param clazz
     *      Class who extends of {@link NBotCustomUser}
     */
    public abstract void registerCustomUser(@NotNull Class<? extends NBotCustomUser> clazz);

    /**
     * Retrieve the name of API.
     * @return the name of API.
     */
    @NotNull
    public abstract String getName();

    /**
     * Retrieve the version of API
     * @return the version of API
     */
    @NotNull
    public abstract String getVersion();

    /**
     * Retrieve the version of JDA.
     * @return the version of JDA.
     */
    @NotNull
    public abstract String getJDAVersion();

    /**
     * Retrieve instance of the ShardManager of JDA.
     * @return the shardManager
     */
    @Nullable
    public abstract ShardManager getShardManager();

    /**
     * Retrieve a new instance of {@link Configuration} with the path.
     *
     * <p>If not exist then a new file is create.</p>
     *
     * @return the configuration.
     */
    @NotNull
    public abstract Configuration getConfiguration(@NotNull String path);

    /**
     * Retrieve a new instance of {@link Configuration} of {@link NBotPlugin}.
     *
     * @param plugin
     *      The instance of plugin.
     * @return the configuration of plugin.
     */
    @NotNull
    public abstract Configuration getConfiguration(@NotNull NBotPlugin plugin);

    /**
     * Retrieve the instance of {@link PluginManager}
     * @return the plugin manager.
     */
    @NotNull
    public abstract PluginManager getPluginManager();

    /**
     * Check if the name matches or begin with one of the words in the array.
     * <p>Examples:</p>
     * <p>getString("f", "bar", "foo") return an optional with the String "foo".</p>
     * <p>getString("ba", "bar", "foo") return an optional with the String "bar".</p>
     * <p>getString("hello world", "bar", "foo") return an optional empty.</p>
     * @param name
     *      world to search.
     * @param args
     *      list of words for the search.
     * @return {@link Optional} of word from the list that corresponds to the word of the search.
     */
    @NotNull
    public abstract Optional<String> getString(@NotNull String name, @NotNull String... args);

    /**
     * Stop the program.
     */
    public abstract void shutdown();

    /**
         * Retrieve the instance of {@link CommandManager}
     * @return the command map.
     */
    @NotNull
    public abstract CommandManager getCommandManager();

    /**
     * Check if the user is an owner
     * @return isOwner
     */
    public abstract boolean isOwner(@NotNull NBotUser user);

    /**
     * Retrieve a language registered with {@link LanguageInfo}.
     *
     * @param languageInfo
     *      the name of language.
     * @return the language.
     */
    @Nullable
    public abstract Language getLanguage(LanguageInfo languageInfo);

    /**
     * Retrieve the names list of languages registered.
     *
     * @return the names list of languages.
     */
    public abstract List<String> getLanguages();

    /**
     * Register a {@link Language} of {@link NBotPlugin}.
     * @param plugin
     *      the instance of plugin
     * @param languageInfo
     *      the name of language
     * @param path
     *      the path of the location of {name}.json in the resources of plugin.
     */
    public abstract void registerLanguage(@NotNull NBotPlugin plugin, @NotNull LanguageInfo languageInfo, @NotNull String path);

    /**
     * Retrieve instance of {@link NBotGuildManager}
     * @return the manager of guilds.
     */
    @NotNull
    public abstract NBotGuildManager getGuildManager();
}
