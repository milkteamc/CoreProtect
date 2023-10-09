package tw.maoyue;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemTW {
    private static final Map<String, String> itemTW = new HashMap<>();
    private static final Map<String, String> entityTW = new HashMap<>();
    private static final Map<String, String> enchantmentTW = new HashMap<>();

    public void loadItemTW(final @NotNull FileConfiguration config) {
        Objects.requireNonNull(config.getConfigurationSection("item")).getValues(false)
                .forEach((material, itemTW) -> ItemTW.itemTW.put(material, (String) itemTW));

        Objects.requireNonNull(config.getConfigurationSection("entity")).getValues(false)
                .forEach((material, entityTW) -> ItemTW.entityTW.put(material, (String) entityTW));

        Objects.requireNonNull(config.getConfigurationSection("enchantment")).getValues(false)
                .forEach((material, enchantmentTW) -> ItemTW.enchantmentTW.put(material, (String) enchantmentTW));
    }


    public static @NotNull String getItemTW(@NotNull String string, boolean withEnglish) {
        if (string.endsWith("smithing_template")) {
            string = "smithing_template";
        }

        return itemTW.containsKey(string) ? itemTW.get(string) + (withEnglish ? "(" + string + ")" : "") : string;
    }
    public static @NotNull String getItemTW(@NotNull String string) {
        return getItemTW(string, true);
    }


    public static @NotNull String getEntityTW(final @NotNull String string) {
        return entityTW.containsKey(string) ? entityTW.get(string) + "(" + string + ")" : string;
    }


    public static @NotNull String getEnchantmentTW(final @NotNull String string) {
        return enchantmentTW.getOrDefault(string.toLowerCase(), string);
    }
}