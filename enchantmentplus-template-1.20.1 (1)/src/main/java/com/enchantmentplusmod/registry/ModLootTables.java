package com.enchantmentplusmod.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTables {
    private static final Identifier[] CHEST_LOOT_TABLES = {
        new Identifier("minecraft", "chests/simple_dungeon"),
        new Identifier("minecraft", "chests/abandoned_mineshaft"),
        new Identifier("minecraft", "chests/stronghold_library"),
        new Identifier("minecraft", "chests/nether_bridge"),
        new Identifier("minecraft", "chests/bastion_treasure"),
        new Identifier("minecraft", "chests/end_city_treasure")
    };
    
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && isTargetLootTable(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(UniformLootNumberProvider.create(0, 1))
                    .with(ItemEntry.builder(Items.BOOK)
                        .apply(EnchantRandomlyLootFunction.builder()
                            .add(ModEnchantments.LIFE_STEAL)
                            .add(ModEnchantments.THUNDER_STRIKE)
                            .add(ModEnchantments.AUTO_SMELT)
                            .add(ModEnchantments.VEIN_MINER)
                            .add(ModEnchantments.FEATHER_FALL)
                            .add(ModEnchantments.POISON_RESISTANCE)
                            .add(ModEnchantments.EXPLOSIVE_ARROW)
                            .add(ModEnchantments.HOMING_ARROW)))
                    .build();
                
                tableBuilder.pool(poolBuilder);
            }
        });
    }
    
    private static boolean isTargetLootTable(Identifier id) {
        for (Identifier tableId : CHEST_LOOT_TABLES) {
            if (tableId.equals(id)) {
                return true;
            }
        }
        return false;
    }
}