package tw.maoyue;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class LogUtils {
    public static boolean notLogEntity(final Entity entity) {
        if (entity.getEntitySpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER) {
            return true;
        }

        return false;
    }

    public static boolean notLogBlock(final Block block) {
        switch (block.getWorld().getEnvironment()) {
            case NORMAL: {
                switch (block.getType()) {
                    case STONE:
                    case DEEPSLATE:
                    case GRANITE:
                    case DIORITE:
                    case ANDESITE:
                    case TUFF:
                    case CALCITE:
                    case DIRT:
                    case GRAVEL:
                        if (block.getLocation().getBlockY() < 32) {
                            return true;
                        }
                }
                break;
            }
            case NETHER: {
                switch (block.getType()) {
                    case BASALT:
                    case BLACKSTONE:
                    case GRAVEL:
                    case MAGMA_BLOCK:
                    case NETHERRACK:
                    case SOUL_SAND:
                    case SOUL_SOIL:
                        return true;
                }
                break;
            }
            case THE_END: {
                if (block.getType() == Material.END_STONE) {
                    final Location location = block.getLocation();
                    if (location.getBlockX() > 512 || location.getBlockZ() > 512) {
                        return true;
                    }
                }
                break;
            }
        }

        return false;
    }
}
