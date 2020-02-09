package Mods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("mememod")
public class MemeMod {
	
	public static MemeMod instance;
	public static final String MODID = "mememod";
	
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public MemeMod() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void setup(final FMLCommonSetupEvent event	) {
		LOGGER.info("Setup aufgerufen");
//		ForgeRegistries.BIOMES.getValues().forEach(biome -> {
//			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(Blocks.AIR.getDefaultState(), null, 0), placementIn, placementConfig));
//		});
	}
	
	public void clientRegistries(final FMLCommonSetupEvent event	) {
		LOGGER.info("Client Registries aufgerufen");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvent{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {			
			event.getRegistry().registerAll(new SwordItem(ItemTier.WOOD, 1336, 1333f, new Item.Properties().defaultMaxDamage(1337).maxDamage(1337).group(ItemGroup.COMBAT)).setRegistryName(location("dildo_item")));
		}
		
		public static ResourceLocation location(String name) {
			return new ResourceLocation(MODID, name);
		}
	}
}
