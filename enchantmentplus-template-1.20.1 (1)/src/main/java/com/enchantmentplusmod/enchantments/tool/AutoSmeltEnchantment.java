package com.enchantmentplusmod.enchantments.tool;

import com.enchantmentplusmod.enchantments.CustomEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.Optional;

public class AutoSmeltEnchantment extends CustomEnchantment {
    public AutoSmeltEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, 
              new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    
    public static ItemStack getSmeltedResult(World world, ItemStack stack) {
        if (world.isClient) return stack;
        
        ServerWorld serverWorld = (ServerWorld) world;
        Optional<SmeltingRecipe> recipe = serverWorld.getRecipeManager()
            .getFirstMatch(RecipeType.SMELTING, new SimpleInventory(stack), serverWorld);
        
        if (recipe.isPresent()) {
            ItemStack result = recipe.get().getOutput().copy();
            result.setCount(stack.getCount());
            return result;
        }
        return stack;
    }
    
    @Override
    public int getMinPower(int level) {
        return 15;
    }
    
    @Override
    public int getMaxPower(int level) {
        return 60;
    }
}