package net.crisssky.craftchallenge.command.subcommands;

import net.crisssky.craftchallenge.CraftChallenge;
import net.crisssky.craftchallenge.command.SubCommand;
import net.crisssky.craftchallenge.configuration.message.Message;
import net.crisssky.craftchallenge.configuration.message.MessageManager;
import org.bukkit.entity.Player;

public class ListSubCommand extends SubCommand {

    private CraftChallenge instance;
    private MessageManager messageManager;

    public ListSubCommand(CraftChallenge instance) {
        super("list", null, instance.getMessageManager().getMessage(Message.SUBCOMMANDS_LIST_DESC), "/challenge list");
        this.instance = instance;
    }

    protected void executeSubCommand(Player player, String[] args) {

    }
}

