package net.crisssky.craftchallenge.configuration.settings;

import net.crisssky.craftchallenge.CraftChallenge;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class SettingManager {

    private CraftChallenge instance;
    private Logger logger;
    private FileConfiguration config;

    public SettingManager(CraftChallenge instance) {
        this.instance = instance;
        this.logger = instance.getLogger();
    }

    public void load() {
        logger.info("Loading config...");

        logger.info(" ");

        File file = new File(instance.getDataFolder(), "config.yml");

        if (!file.getParentFile().exists()) {
            logger.info("Config parent file doesn't exist !");
            file.getParentFile().mkdir();
            logger.info("Config parent file created !");
        }

        logger.info(" ");

        if (!file.exists()) {
            logger.info("Config file doesn't exist ! ");
            try {
                file.createNewFile();
            } catch (IOException e) {
                logger.info("Error while creating config file! Please report..");
                e.printStackTrace();
                instance.getPluginLoader().disablePlugin(instance);
            }
            logger.info("Config file created !");
        }

        logger.info(" ");

        config = YamlConfiguration.loadConfiguration(file);

        logger.info("Preparing file....");

        int created = 0;

        for (Setting values : Setting.values()) {
            if (!config.contains(values.getPath())) {
                config.set(values.getPath(), values.getValue().getValue());
                created++;
            }
        }

        logger.info(created + " new setting(s) added to config file !");

        logger.info(" ");

        try {
            config.save(file);
        } catch (IOException e) {
            logger.info("Error while saving message file! Please report..");
            e.printStackTrace();
            instance.getPluginLoader().disablePlugin(instance);
        }

        logger.info("Config file saved !");

        logger.info(" ");

        logger.info("Config successfully loaded !");
    }

    public SettingValue getValue(Setting setting) {
        return new SettingValue(config.get(setting.getPath()));
    }

}
