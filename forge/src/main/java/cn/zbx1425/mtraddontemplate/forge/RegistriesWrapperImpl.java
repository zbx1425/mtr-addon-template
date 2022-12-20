package cn.zbx1425.mtraddontemplate.forge;

import cn.zbx1425.mtraddontemplate.Main;
import cn.zbx1425.mtraddontemplate.RegistriesWrapper;
import cn.zbx1425.mtraddontemplate.mappings.ForgeUtilities;
import mtr.CreativeModeTabs;
import mtr.Registry;
import mtr.RegistryObject;
import mtr.item.ItemWithCreativeTabBase;
import mtr.mappings.BlockEntityMapper;
import mtr.mappings.DeferredRegisterHolder;
import mtr.mappings.RegistryUtilities;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class RegistriesWrapperImpl implements RegistriesWrapper {

    private static final DeferredRegisterHolder<Item> ITEMS = new DeferredRegisterHolder<>(Main.MOD_ID, ForgeUtilities.registryGetItem());
    private static final DeferredRegisterHolder<Block> BLOCKS = new DeferredRegisterHolder<>(Main.MOD_ID, ForgeUtilities.registryGetBlock());
    private static final DeferredRegisterHolder<BlockEntityType<?>> BLOCK_ENTITY_TYPES = new DeferredRegisterHolder<>(Main.MOD_ID, ForgeUtilities.registryGetBlockEntityType());
    private static final DeferredRegisterHolder<EntityType<?>> ENTITY_TYPES = new DeferredRegisterHolder<>(Main.MOD_ID, ForgeUtilities.registryGetEntityType());
    private static final DeferredRegisterHolder<SoundEvent> SOUND_EVENTS = new DeferredRegisterHolder<>(Main.MOD_ID, ForgeUtilities.registryGetSoundEvent());

    @Override
    public void registerBlock(String id, RegistryObject<Block> block) {
        BLOCKS.register(id, block::get);
    }

    @Override
    public void registerBlockAndItem(String id, RegistryObject<Block> block, CreativeModeTabs.Wrapper tab) {
        BLOCKS.register(id, block::get);
        ITEMS.register(id, () -> {
            final BlockItem blockItem = new BlockItem(block.get(), RegistryUtilities.createItemProperties(tab::get));
            Registry.registerCreativeModeTab(tab.resourceLocation, blockItem);
            return blockItem;
        });
    }

    @Override
    public void registerItem(String id, RegistryObject<Item> item, CreativeModeTabs.Wrapper tab) {
        ITEMS.register(id, () -> {
            final Item itemObject = item.get();
            if (itemObject instanceof ItemWithCreativeTabBase) {
                Registry.registerCreativeModeTab(((ItemWithCreativeTabBase) itemObject).creativeModeTab.resourceLocation, itemObject);
            } else if (itemObject instanceof ItemWithCreativeTabBase.ItemPlaceOnWater) {
                Registry.registerCreativeModeTab(((ItemWithCreativeTabBase.ItemPlaceOnWater) itemObject).creativeModeTab.resourceLocation, itemObject);
            }
            return itemObject;
        });
    }

    @Override
    public void registerBlockEntityType(String id, RegistryObject<? extends BlockEntityType<? extends BlockEntityMapper>> blockEntityType) {
        BLOCK_ENTITY_TYPES.register(id, blockEntityType::get);
    }

    @Override
    public void registerEntityType(String id, RegistryObject<? extends EntityType<? extends Entity>> entityType) {
        ENTITY_TYPES.register(id, entityType::get);
    }

    @Override
    public void registerSoundEvent(String id, SoundEvent soundEvent) {
        SOUND_EVENTS.register(id, () -> soundEvent);
    }

    public void registerAllDeferred() {
        ITEMS.register();
        BLOCKS.register();
        BLOCK_ENTITY_TYPES.register();
        ENTITY_TYPES.register();
        SOUND_EVENTS.register();
    }
}
