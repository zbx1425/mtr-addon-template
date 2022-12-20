package cn.zbx1425.mtraddontemplate.forge;

import cn.zbx1425.mtraddontemplate.Main;
import cn.zbx1425.mtraddontemplate.mappings.ForgeUtilities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class MainForge {

	private static final RegistriesWrapperImpl registries = new RegistriesWrapperImpl();

	static {
		Main.init(registries);
	}

	public MainForge() {

		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ForgeUtilities.registerModEventBus(Main.MOD_ID, eventBus);

		registries.registerAllDeferred();

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.register(ClientProxy.ModEventBusListener.class);
			MinecraftForge.EVENT_BUS.register(ClientProxy.ForgeEventBusListener.class);
		});
	}

}
