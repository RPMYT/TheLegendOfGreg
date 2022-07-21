package com.spectraspatial.log.api.player.statistic;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;

import java.util.Map;

public interface Statistic {
    /**
     * @return The display name (not ID!) of the statistic.
     * @implNote Standard format is to use three characters (STR, VIT, INT, etc) - unless the {@code full} parameter is true, in which case there is no standard.
     * @param full Return the "full" name (e.g. "Strength" instead of "STR") of the statistic if {@code true}.
     */
    String name(boolean full);

    /**
     * @return A list of EAMs this statistic has.
     * @implNote Make sure to use {@link Statistic#level(LivingEntity)} when calculating EAMs!
     * @param target Can be used to have the statistic perform differently for specific entities.
     *               <br/> It is also required when calling {@link Statistic#level(LivingEntity)}.
     */
    Map<EntityAttribute, EntityAttributeModifier> modifiers(LivingEntity target);

    /**
     * @param target The target entity for this method.
     * @return The "level" of this statistic - or, the amount of points the {@code target} has put into it,
     * @implNote This is not restricted to players - make sure you handle mobs as well!
     */
    int level(LivingEntity target);
}
