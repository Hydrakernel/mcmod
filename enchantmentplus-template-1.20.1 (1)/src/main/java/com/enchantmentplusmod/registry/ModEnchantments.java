package com.enchantmentplusmod.registry;

import com.enchantmentplusmod.enchantments.*;
import com.enchantmentplusmod.enchantments.armor.FeatherFallEnchantment;
import com.enchantmentplusmod.enchantments.tool.AutoSmeltEnchantment;
import com.enchantmentplusmod.enchantments.weapon.LifeStealEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    // 武器附魔
    public static final Enchantment LIFE_STEAL = new LifeStealEnchantment();
    public static final Enchantment THUNDER_STRIKE = new ThunderStrikeEnchantment();
    
    // 工具附魔
    public static final Enchantment AUTO_SMELT = new AutoSmeltEnchantment();
    public static final Enchantment VEIN_MINER = new VeinMinerEnchantment();
    
    // 盔甲附魔
    public static final Enchantment FEATHER_FALL = new FeatherFallEnchantment();
    public static final Enchantment POISON_RESISTANCE = new PoisonResistanceEnchantment();
    
    // 弓箭附魔
    public static final Enchantment EXPLOSIVE_ARROW = new ExplosiveArrowEnchantment();
    public static final Enchantment HOMING_ARROW = new HomingArrowEnchantment();

    public static void registerEnchantments() {
        register("life_steal", LIFE_STEAL);
        register("thunder_strike", THUNDER_STRIKE);
        register("auto_smelt", AUTO_SMELT);
        register("vein_miner", VEIN_MINER);
        register("feather_fall", FEATHER_FALL);
        register("poison_resistance", POISON_RESISTANCE);
        register("explosive_arrow", EXPLOSIVE_ARROW);
        register("homing_arrow", HOMING_ARROW);
    }

    private static void register(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, new Identifier(EnchantmentPlusMod.MOD_ID, name), enchantment);
    }
}