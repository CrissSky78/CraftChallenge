package net.crisssky.craftchallenge.command;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    private String name;
    private String permission;
    private String description;
    private String usage;

    public SubCommand(String name, String permission, String description, String usage) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }

    public String getUsage() {
        return usage;
    }

    protected abstract void executeSubCommand(Player player, String[] args);

}
