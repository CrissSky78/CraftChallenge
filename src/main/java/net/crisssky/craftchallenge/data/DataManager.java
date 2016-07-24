package net.crisssky.craftchallenge.data;

import net.crisssky.craftchallenge.CraftChallenge;
import net.crisssky.craftchallenge.player.ChallengePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DataManager {

    private CraftChallenge instance;
    private Logger logger;
    private File dataFile;
    private List<ChallengePlayer> online = new ArrayList<ChallengePlayer>();

    public DataManager(CraftChallenge instance) {
        this.instance = instance;
        this.logger = instance.getLogger();
    }

    public void load() {
        logger.info("Loading the data manager...");
        logger.info(" ");
        logger.info("Preparing data folder..");

        dataFile = new File(instance.getDataFolder(), "data");

        if (!dataFile.exists()) {
            logger.info("Data folder doesn't exist !");
            dataFile.mkdir();
            logger.info("Data folder created !");
        } else {
            logger.info("Loading registered players !");

            int i = 0;

            for (File file : dataFile.listFiles()) {
                // TODO/ REGISTER PLS.
                i++;
            }

        }

    }

    public void register(ChallengePlayer player) {
        File file = getPlayerFile(player);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File getPlayerFile(ChallengePlayer player) {
        return new File(dataFile, player.getUniqueId().toString() + ".yml");
    }

    public FileConfiguration getPlayerFileConfiguration(ChallengePlayer player) {
        return YamlConfiguration.loadConfiguration(getPlayerFile(player));
    }

}
