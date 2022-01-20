package de.notecho.spotify.bot.modules;

import com.github.twitch4j.TwitchClient;
import de.notecho.spotify.bot.instance.BotInstance;
import de.notecho.spotify.database.user.entities.module.Module;
import de.notecho.spotify.database.user.entities.module.ModuleEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BaseModule {

    private Module module;

    private BotInstance root;

    public abstract void register(TwitchClient client);

    public void sendMessage(ModuleEntry entry, String... args) {
        String result = entry.getValue();
        for (int i = 0; i < args.length; i += 2)
            result = result.replace(args[i], args[i + 1]);
        root.getClient().getChat().sendMessage(root.getLogin(), result);
    }

}