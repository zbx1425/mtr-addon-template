package cn.zbx1425.mtraddontemplate;

import mtr.CreativeModeTabs;
import mtr.RegistryObject;
import mtr.mappings.BlockEntityMapper;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public interface RegistriesWrapper {

    void registerBlock(String id, RegistryObject<Block> block);

    void registerItem(String id, RegistryObject<Item> item, CreativeModeTabs.Wrapper tab);

    void registerBlockAndItem(String id, RegistryObject<Block> block, CreativeModeTabs.Wrapper tab);

    void registerBlockEntityType(String id, RegistryObject<? extends BlockEntityType<? extends BlockEntityMapper>> blockEntityType);

    void registerEntityType(String id, RegistryObject<? extends EntityType<? extends Entity>> entityType);

    void registerSoundEvent(String id, SoundEvent soundEvent);

}
