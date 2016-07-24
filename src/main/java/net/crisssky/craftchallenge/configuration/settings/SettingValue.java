package net.crisssky.craftchallenge.configuration.settings;

public class SettingValue<T> {

    private T value;

    public SettingValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
