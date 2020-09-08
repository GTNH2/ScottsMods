package com.scottkillen.mod.scottstweaks.tweaks.planting;

import com.scottkillen.mod.koresample.common.util.event.ForgeEventListener;
import com.scottkillen.mod.scottstweaks.config.Settings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public final class Planter extends ForgeEventListener
{
    @SubscribeEvent
    public void onItemExpire(ItemExpireEvent event) {
        if (Settings.INSTANCE.doPlantGrowable()) {
            final Item item = event.entityItem.getEntityItem().getItem();
            Block block = Block.getBlockFromItem(item);
            final World world = event.entityItem.worldObj;
            final int x = (int) event.entityItem.posX;
            final int y = (int) event.entityItem.posY;
            final int z = (int) event.entityItem.posZ;
            if (item instanceof IPlantable) {
                block = ((IPlantable) item).getPlant(world, x, y, z);
                plantGrowable(world, x, y, z, block, -1);
            }
            else if (block instanceof IGrowable) {
                final int metadata = event.entityItem.getEntityItem().getItemDamage();
                plantGrowable(world, x, y, z, block, metadata);
            }
        }
    }

    private static void plantGrowable(World world, int x, int y, int z, Block block, int metadata) {
        if (block.canPlaceBlockAt(world, x, y, z)) {
            world.setBlock(x, y, z, block);
            if (metadata != -1)
                world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
            world.scheduleBlockUpdate(x, y, z, block, 1);
        }
    }
}
