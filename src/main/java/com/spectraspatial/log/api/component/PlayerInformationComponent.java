package com.spectraspatial.log.api.component;

import com.spectraspatial.log.api.player.PlayerInformationContainer;
import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"unused", "unchecked", "rawtypes"})
public class PlayerInformationComponent implements PlayerComponent, AutoSyncedComponent {
    private PlayerInformationContainer info;

    @Override
    public void readFromNbt(NbtCompound tag) {
        this.info = PlayerInformationContainer.deserialize(tag.getCompound("InfoContainer"));
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.put("InfoContainer", this.info.serialize());
    }

    @Override
    public void copyForRespawn(@NotNull Component original, boolean lossless, boolean keepInventory, boolean sameCharacter) {
        PlayerComponent.super.copyForRespawn(original, lossless, keepInventory, sameCharacter);
    }
}
