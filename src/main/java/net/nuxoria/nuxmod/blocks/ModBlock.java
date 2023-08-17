package net.nuxoria.nuxmod.blocks;

import com.mojang.blaze3d.shaders.Uniform;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import net.nuxoria.nuxmod.NuxoriaMod;
import net.nuxoria.nuxmod.blocks.custom.AlienBlock;
import net.nuxoria.nuxmod.blocks.custom.JumpyBlock;
import net.nuxoria.nuxmod.blocks.custom.LavaLampBlock;
import net.nuxoria.nuxmod.items.ModCreativeModeTab;
import net.nuxoria.nuxmod.items.ModItems;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

public class ModBlock {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NuxoriaMod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.NUX_TAB);

    public static final RegistryObject<Block> ALIEN_BLOCK = registerBlock("alien_block",
            () -> new AlienBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 18)
                    .sound(SoundType.GLASS)), ModCreativeModeTab.NUX_TAB);
    public static final RegistryObject<Block> ALIEN_SHIT_BLOCK = registerBlock("alien_shit_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 18).sound(SoundType.SLIME_BLOCK).requiresCorrectToolForDrops()),
            ModCreativeModeTab.NUX_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)), ModCreativeModeTab.NUX_TAB);

    public static final RegistryObject<Block> LAVA_LAMP_BLOCK = registerBlock("lava_lamp_block",
            () -> new LavaLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .lightLevel(state -> state.getValue(LavaLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.NUX_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {

        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
