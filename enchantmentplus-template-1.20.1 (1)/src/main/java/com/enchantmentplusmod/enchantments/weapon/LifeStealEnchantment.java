package com.enchantmentplusmod.enchantments.weapon;

import com.enchantmentplusmod.enchantments.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class LifeStealEnchantment extends CustomEnchantment {
    public LifeStealEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, 
              new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof PlayerEntity && target instanceof LivingEntity) {
            LivingEntity livingTarget = (LivingEntity) target;
            float damageDealt = livingTarget.getRecentDamageSource() != null ? 
                livingTarget.getRecentDamageSource().getDamage() : 0;
            
            // 恢复伤害值的10%/20%/30%生命值
            float healAmount = damageDealt * (0.1f * level);
            user.heal(healAmount);
        }
    }
    
    @Override
    public int getMinPower(int level) {
        return 15 + (level - 1) * 9;
    }
    
    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }
}