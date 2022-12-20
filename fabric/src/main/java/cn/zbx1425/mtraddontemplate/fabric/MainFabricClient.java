package cn.zbx1425.mtraddontemplate.fabric;

import cn.zbx1425.mtraddontemplate.MainClient;
import net.fabricmc.api.ClientModInitializer;

public class MainFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		MainClient.init();
	}

}