package net.crisssky.craftchallenge.command;

import net.crisssky.craftchallenge.CraftChallenge;
import net.crisssky.craftchallenge.configuration.message.Message;
import net.crisssky.craftchallenge.configuration.message.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PluginCommand implements CommandExecutor {

    private CraftChallenge instance;
    private Logger logger;
    private MessageManager messageManager;

    private List<SubCommand> subCommands = new ArrayList<SubCommand>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command !");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sendHelp(player);
            return true;
        }

        for (SubCommand subCmd : subCommands) {
            if (args[0].equalsIgnoreCase(subCmd.getName())) {
                subCmd.executeSubCommand(player, args);
                return true;
            }
        }

        sendHelp(player);

        return true;
    }

    public void sendHelp(Player player) {
        messageManager.send(player, Message.INFO_HEADER, false);
        for (SubCommand cmd : subCommands) {
            messageManager.send(player, Message.COMMAND_LIST_FORMAT, false,
                    new String[]{"[COMMAND]", "[DESCRIPTION]"},
                    new String[]{cmd.getUsage(), cmd.getDescription()});
        }
        messageManager.send(player, Message.INFO_FOOTER, false);
    }

    public PluginCommand(CraftChallenge instance) {
        this.instance = instance;
        instance.getCommand("challenge").setExecutor(this);
        this.logger = instance.getLogger();
        logger.info("Main command registered !");
        this.messageManager = instance.getMessageManager();
    }

    public PluginCommand addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
        logger.info("\"" + subCommand.getName() + "\" subcommand registered !");
        return this;
    }

}
