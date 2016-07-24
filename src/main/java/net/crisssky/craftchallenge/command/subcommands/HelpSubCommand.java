package net.crisssky.craftchallenge.command.subcommands;

import net.crisssky.craftchallenge.CraftChallenge;
import net.crisssky.craftchallenge.command.SubCommand;
import net.crisssky.craftchallenge.configuration.message.Message;
import org.bukkit.entity.Player;

public class HelpSubCommand extends SubCommand {

    private CraftChallenge instance;

    public HelpSubCommand(CraftChallenge instance) {
        super("help", null, instance.getMessageManager().getMessage(Message.SUBCOMMANDS_HELP_DESC), "/challenge help");
        this.instance = instance;
    }

    protected void executeSubCommand(Player player, String[] args) {
        instance.getCommand().sendHelp(player);
    }

}
