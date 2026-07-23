package org.baguette.untitled;

import net.fabricmc.api.ModInitializer;
import org.baguette.untitled.block.ModBlocks;
import org.baguette.untitled.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Untitled implements ModInitializer {
    public static final String MOD_ID = "untitled";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
