package io.github.cadiboo.examplemod.event;

import io.github.cadiboo.examplemod.ExampleMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import static io.github.cadiboo.examplemod.init.ModItems.PILL_ITEM;


@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Pill {

    @SubscribeEvent
    public static void onClickEmpty(PlayerInteractEvent.RightClickItem e) {
        World world = e.getWorld();
        if ((e.getWorld()).isRemote)
            return;
        PlayerEntity player = e.getPlayer();
        ItemStack itemstack = e.getItemStack();

        // func_77977_a()  getTranslationKey()
        // func_77973_b()  getItem()

        if (itemstack.getItem().toString() == PILL_ITEM.get().toString()) {
            ExampleMod.LOGGER.debug("Pill");
            EffectInstance effect = new EffectInstance(Effects.SPEED, 200);
            player.addPotionEffect(effect);
            itemstack.shrink(1);
            /*
                itemstack.func_196085_b(1);
                itemstack.func_190920_e(1);
                itemstack.func_190915_d(1);
                itemstack.func_82841_c(1);
                itemstack.func_190918_g(1);
                itemstack.func_77979_a(1);
                itemstack.func_190917_f(1);

                itemstack.setDamage(1);
                itemstack.setCount(1);
                itemstack.setAnimationsToGo(1);
                itemstack.setRepairCost(1);
                itemstack.shrink(1);
                itemstack.split(1);
                itemstack.grow(1);
     */

            ExampleMod.LOGGER.debug("Pill done");
        }
        ExampleMod.LOGGER.debug("AAAAA Pill item name: done");
    }
}

