package org.baguette.untitled.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.baguette.untitled.Untitled;

import java.util.function.Function;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            properties -> new Block(properties.strength( 4f)
                    .requiresCorrectToolForDrops().sound(SoundType.IRON)));



    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name)))));
    }

    public static void registerModBlocks () {
        Untitled.LOGGER.info("Registering Mod Blocks for {}.", Untitled.MOD_ID.toUpperCase());

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {
            output.accept(RUBY_BLOCK);
        });
    }
}
