package com.enchantmentplusmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public abstract class CustomEnchantment extends Enchantment {
    protected CustomEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }
    
    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}