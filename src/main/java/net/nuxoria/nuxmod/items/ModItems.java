package net.nuxoria.nuxmod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nuxoria.nuxmod.NuxoriaMod;
import net.nuxoria.nuxmod.blocks.ModBlock;
import net.nuxoria.nuxmod.items.custom.EightBallItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NuxoriaMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NUX_TAB)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NUX_TAB)));

    public static final RegistryObject<Item> ALIEN_SHIT = ITEMS.register("alien_shit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NUX_TAB)));

    public static final RegistryObject<Item> EIGHT_BALL_ITEM = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.NUX_TAB).stacksTo(1)));

    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.NUX_TAB).food(
                    new FoodProperties.Builder().nutrition(6)
                            .alwaysEat()
                            .meat()
                            .saturationMod(0.0f)
                            .fast()
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f)
                            .build()
            )));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
