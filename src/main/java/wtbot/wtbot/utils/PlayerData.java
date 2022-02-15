package wtbot.wtbot.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import wtbot.wtbot.enums.EnumState;

public class PlayerData {
    @Getter
    @Setter
    public Location location;
    @Getter
    @Setter
    public ItemStack[] storageI;
    @Getter
    @Setter
    public ItemStack[] ArmorI;
    @Getter
    @Setter
    public ItemStack Offhand;
    @Getter
    @Setter
    public EnumState state;

    public PlayerData(){
        this.state = EnumState.ALIVE;
    }
}
