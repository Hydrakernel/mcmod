package com.enchantmentplusmod;

import com.enchantmentplusmod.registry.ModEnchantments;
import com.enchantmentplusmod.registry.ModLootTables;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnchantmentPlusMod implements ModInitializer {
    public static final String MOD_ID = "enchantmentplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEnchantments.registerEnchantments();
        ModLootTables.modifyLootTables();
        
        LOGGER.info("Enchantment Plus initialized!");
    }
}