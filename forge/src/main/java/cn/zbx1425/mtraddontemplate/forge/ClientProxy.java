package cn.zbx1425.mtraddontemplate.forge;

import cn.zbx1425.mtraddontemplate.MainClient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy {

    public static class ModEventBusListener {

        @SubscribeEvent
        public static void onClientSetupEvent(FMLClientSetupEvent event) {
            MainClient.init();
        }

    }

    public static class ForgeEventBusListener {

    }
}