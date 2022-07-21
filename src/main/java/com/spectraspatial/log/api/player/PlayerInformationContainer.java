package com.spectraspatial.log.api.player;

import com.spectraspatial.log.api.player.statistic.Statistic;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

import java.util.ArrayList;

public class PlayerInformationContainer {
    private String name;
    private final ArrayList<Statistic> stats = new ArrayList<>();

    private PlayerInformationContainer() {}

    public NbtCompound serialize() {
        NbtCompound root = new NbtCompound();

        root.putString("Name", this.name);
        return root;
    }

    public static PlayerInformationContainer deserialize(NbtCompound data) {
        PlayerInformationContainer container = new PlayerInformationContainer();

        NbtList stats = (NbtList) data.get("Statistics");

        return container;
    }
}
