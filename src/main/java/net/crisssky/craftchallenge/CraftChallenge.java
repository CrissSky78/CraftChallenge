package net.crisssky.craftchallenge;

import net.crisssky.craftchallenge.command.PluginCommand;
import net.crisssky.craftchallenge.command.subcommands.HelpSubCommand;
import net.crisssky.craftchallenge.command.subcommands.ListSubCommand;
import net.crisssky.craftchallenge.command.subcommands.SendChallengeSubCommand;
import net.crisssky.craftchallenge.configuration.message.MessageManager;
import net.crisssky.craftchallenge.configuration.settings.SettingManager;
import net.crisssky.craftchallenge.data.DataManager;
import net.crisssky.craftchallenge.player.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class CraftChallenge extends JavaPlugin {

    private CraftChallenge instance;
    private Logger logger;
    private MessageManager messageManager;
    private SettingManager settingManager;
    private PluginCommand command;
    private DataManager dataManager;

    public CraftChallenge getInstance() {
        return instance;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    public SettingManager getSettingManager() {
        return settingManager;
    }

    public PluginCommand getCommand() {
        return command;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();
        messageManager = new MessageManager(this);
        settingManager = new SettingManager(this);
        dataManager = new DataManager(this);

        new PlayerJoin(this);

        logger.info("============= CraftChallenge =============");
        logger.info(" ");
        logger.info("Loading CraftChallenge version " + getDescription().getVersion() + " by " + getDescription().getAuthors() + "... ");
        logger.info("Website: " + getDescription().getWebsite());
        logger.info(" ");
        messageManager.load();
        logger.info(" ");
        settingManager.load();
        logger.info("");
        dataManager.load();
        logger.info("==========================================");

        command = new PluginCommand(this);
        command.addSubCommand(new HelpSubCommand(this));
        command.addSubCommand(new ListSubCommand(this));
        command.addSubCommand(new SendChallengeSubCommand(this));

    }

    @Override
    public void onDisable() {

    }

}
