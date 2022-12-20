package cn.zbx1425.mtraddontemplate.fabric;

import cn.zbx1425.mtraddontemplate.Main;
import net.fabricmc.api.ModInitializer;

public class MainFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		Main.init(new RegistriesWrapperImpl());
	}

}
