package net.crisssky.craftchallenge.command.subcommands;

import net.crisssky.craftchallenge.CraftChallenge;
import net.crisssky.craftchallenge.command.SubCommand;
import net.crisssky.craftchallenge.configuration.message.Message;
import net.crisssky.craftchallenge.configuration.message.MessageManager;
import org.bukkit.entity.Player;

public class SendChallengeSubCommand extends SubCommand {

    private CraftChallenge instance;
    private MessageManager messageManager;

    public SendChallengeSubCommand(CraftChallenge instance) {
        super("send", null, instance.getMessageManager().getMessage(Message.SUBCOMMANDS_SEND_DESC), "/challenge send <player>");
        this.instance = instance;
        this.messageManager = instance.getMessageManager();
    }

    protected void executeSubCommand(Player player, String[] args) {

    }

}
