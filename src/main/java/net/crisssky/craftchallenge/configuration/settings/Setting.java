package net.crisssky.craftchallenge.configuration.settings;


public enum Setting {

    GENERAL_MAIN_PATH("General", new SettingValue(" ")),
    NOTIF_ON_JOIN("General.notification-on-join", new SettingValue(true));

    private String path;
    private SettingValue value;

    Setting(String path, SettingValue value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public SettingValue getValue() {
        return value;
    }

}
