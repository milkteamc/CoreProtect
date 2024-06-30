package tw.maoyue;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class OwnerUtils {
    private static final NamespacedKey ownerUUID = new NamespacedKey("KioCG-ContainerOwner".toLowerCase(), "OwnerUUID".toLowerCase());

    private static @Nullable UUID getOwner(final @NotNull PersistentDataHolder holder) {
        final String uuidString = holder.getPersistentDataContainer().get(ownerUUID, PersistentDataType.STRING);
        return uuidString != null ? UUID.fromString(uuidString) : null;
    }

    public static boolean isOwner(final @NotNull Container container, final @NotNull Player player) {
        return player.hasPermission("coreprotect.teleport") || player.getUniqueId().equals(getOwner(container));
    }
}
