package net.crisssky.craftchallenge.configuration.message;

import net.crisssky.craftchallenge.CraftChallenge;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class MessageManager {

    private CraftChallenge instance;
    private Logger logger;
    private FileConfiguration messages;

    public MessageManager(CraftChallenge instance) {
        this.instance = instance;
        this.logger = instance.getLogger();
    }

    public void load() {
        logger.info("Loading messages...");

        logger.info(" ");

        File file = new File(instance.getDataFolder(), "messages.yml");

        if (!file.getParentFile().exists()) {
            logger.info("Message parent file doesn't exist !");
            file.getParentFile().mkdir();
            logger.info("Message parent file created !");
        }

        logger.info(" ");

        if (!file.exists()) {
            logger.info("Message file doesn't exist ! ");
            try {
                file.createNewFile();
            } catch (IOException e) {
                logger.info("Error while creating message file! Please report..");
                e.printStackTrace();
                instance.getPluginLoader().disablePlugin(instance);
            }
            logger.info("Message file created !");
        }

        logger.info(" ");

        messages = YamlConfiguration.loadConfiguration(file);

        logger.info("Preparing file....");

        int created = 0;

        for (Message values : Message.values()) {
            if (!messages.contains(values.getPath())) {
                messages.set(values.getPath(), values.getDefaultMessage());
                created++;
            }
        }

        logger.info(created + " new message(s) added to message file !");

        logger.info(" ");

        try {
            messages.save(file);
        } catch (IOException e) {
            logger.info("Error while saving message file! Please report..");
            e.printStackTrace();
            instance.getPluginLoader().disablePlugin(instance);
        }

        logger.info("Message file saved !");

        logger.info(" ");

        logger.info("Messages successfully loaded !");
    }

    public void send(Player player, Message message, boolean prefix) {
        player.sendMessage((prefix ? instance.getDescription().getPrefix() : "") + messages.getString(message.getPath()).replaceAll("&", "§"));
    }

    public void send(Player player, Message message, boolean prefix, String[] toReplace, String[] replaceValue) {
        String msg = (prefix ? instance.getDescription().getPrefix() + " " : "") + messages.getString(message.getPath());

        for (int i = 0; i < toReplace.length; i++) {
            if (msg.contains(toReplace[i])) {
                msg = msg.replace(toReplace[i], replaceValue[i]);
            }
        }

        player.sendMessage(msg.replaceAll("&", "§"));
    }

    public void broadcast(Message message, boolean prefix) {
        for (Player online : Bukkit.getOnlinePlayers())
            send(online, message, prefix);
    }

    public void broadcast(Message message, boolean prefix, String[] toReplace, String[] replaceValue) {
        for (Player online : Bukkit.getOnlinePlayers())
            send(online, message, prefix, toReplace, replaceValue);
    }

    public String getMessage(Message message) {
        return messages.getString(message.getPath()).replaceAll("&", "§");
    }

}
