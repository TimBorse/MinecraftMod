package Mods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("MemeMod")
public class MemeMod {
	
	public static MemeMod instance;
	public static final String MODID = "MemeMod";
	
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public MemeMod() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void setup(final FMLCommonSetupEvent event	) {
		LOGGER.info("Setup aufgerufen");
	}
	
	public void clientRegistries(final FMLCommonSetupEvent event	) {
		LOGGER.info("Client Registries aufgerufen");
	}
}
