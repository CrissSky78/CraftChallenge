package net.crisssky.craftchallenge.configuration.message;

public enum Message {

    COMMANDS_MAIN_PATH("Commands", " "),
    INFO_HEADER("Commands.header", "&a---------------[ &bCraftChallenge &a]---------------"),
    INFO_FOOTER("Commands.footer", "&a---------------------------------------------"),
    COMMAND_LIST_FORMAT("Commands.command-list-format", "&6> [COMMAND] &e: [DESCRIPTION]"),
    SUBCOMMANDS("Commands.subcommands", " "),
    SUBCOMMANDS_HELP_DESC("Commands.subcommands.help-description", "View command help."),
    SUBCOMMANDS_LIST_DESC("Commands.subcommands.list-description", "View list of your unopened/current/finished challenges."),
    SUBCOMMANDS_SEND_DESC("Commands.subcommands.send-description", "Send a challenge to a player."),

    GENERAL_MAIN_PATH("General", " "),
    UNREADED_CHALLENGES("General.unreaded-challenges", "&aYou have&e [VALUE] unopened &achallenge(s)!"),
    CLICK_TO_SEE("General.click-to-see", "&bClick to see !");

    private String path;
    private String defaultMessage;

    Message(String path, String defaultMessage) {
        this.path = path;
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public String getPath() {
        return path;
    }

}
