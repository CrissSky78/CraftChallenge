package net.crisssky.craftchallenge.player;

import net.crisssky.craftchallenge.CraftChallenge;
import net.crisssky.craftchallenge.configuration.message.Message;
import net.crisssky.craftchallenge.configuration.message.MessageManager;
import net.crisssky.craftchallenge.configuration.settings.SettingManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private CraftChallenge instance;
    private MessageManager messageManager;
    private SettingManager settingManager;

    public PlayerJoin(CraftChallenge instance) {
        this.instance = instance;
        this.messageManager = instance.getMessageManager();
        this.settingManager = instance.getSettingManager();
        Bukkit.getPluginManager().registerEvents(this, instance);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ChallengePlayer challengePlayer = new ChallengePlayer(player.getUniqueId());

        instance.getDataManager().register(challengePlayer);

        int unReadedChallenges = challengePlayer.getReceivedChallenges().size();

        if (unReadedChallenges > 0) {
            messageManager.send(player, Message.UNREADED_CHALLENGES, true,
                    new String[]{"[VALUE]"},
                    new String[]{"" + unReadedChallenges});

            TextComponent value = new TextComponent(messageManager.getMessage(Message.CLICK_TO_SEE));
            value.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/challenge list"));
            value.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§5Click !").create()));

            player.spigot().sendMessage(value);

        }

    }

}
