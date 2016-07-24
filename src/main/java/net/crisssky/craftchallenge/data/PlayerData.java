package net.crisssky.craftchallenge.data;

import net.crisssky.craftchallenge.configuration.settings.SettingValue;

public enum PlayerData {

    SETTINGS_MAIN_PATH("Settings", new SettingValue(" ")),
    TOOGLE_CHALLENGES("Settings.toggle-challenges", new SettingValue(false));

    private String path;
    private SettingValue value;

    PlayerData(String path, SettingValue value) {
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
