package com.enchantmentplusmod.enchantments.armor;

import com.enchantmentplusmod.enchantments.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FeatherFallEnchantment extends CustomEnchantment {
    public FeatherFallEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_FEET, 
              new EquipmentSlot[]{EquipmentSlot.FEET});
    }
    
    @Override
    public void onUserDamaged(LivingEntity user, DamageSource source, int level) {
        if (source.isFromFalling()) {
            // 减少坠落伤害：每级减少25%伤害
            float reduction = 0.25f * level;
            user.setVelocity(user.getVelocity().multiply(1.0, 1.0 - reduction, 1.0));
            
            // 高级别时给予缓降效果
            if (level >= 2) {
                user.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SLOW_FALLING, 100, 0));
            }
        }
    }
    
    @Override
    public int getMinPower(int level) {
        return 10 + 10 * (level - 1);
    }
    
    @Override
    public int getMaxPower(int level) {
        return 50;
    }
}