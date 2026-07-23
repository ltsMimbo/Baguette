package org.baguette.untitled.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.baguette.untitled.Untitled;

import java.util.function.Function;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Untitled.LOGGER.info("Registering Mod Items for {}.", Untitled.MOD_ID.toUpperCase());

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(RUBY);
        });
    }
}
