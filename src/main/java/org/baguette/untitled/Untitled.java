package org.baguette.untitled;

import net.fabricmc.api.ModInitializer;

public class Untitled implements ModInitializer {

    @Override
    public void onInitialize() {
    }

    public class ModItemIds {
        public static ResourceKey<Item> create(String name) {
            // Create the item key.
            return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Untitled.MOD_ID, name));
        }
    }
}
