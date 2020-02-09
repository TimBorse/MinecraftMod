package Mods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Lists.BlockList;
import Lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
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

	public void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("Setup aufgerufen");
		ForgeRegistries.BIOMES.getValues().forEach(biome -> {
			biome.addFeature(Decoration.UNDERGROUND_ORES,
					Biome.createDecoratedFeature(Feature.ORE,
							new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockList.tom_ore.getDefaultState(), 12),
							Placement.RANDOM_COUNT_RANGE, new CountRangeConfig(20, 0, 0, 256)));
		});
	}

	public void clientRegistries(final FMLCommonSetupEvent event) {
		LOGGER.info("Client Registries aufgerufen");
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvent {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry()
					.registerAll(
							ItemList.dildo_item = new SwordItem(ItemTier.WOOD, 1336, 1333f,
									new Item.Properties().defaultMaxDamage(1337).maxDamage(1337)
											.group(ItemGroup.COMBAT)).setRegistryName(location("dildo_item")),
							ItemList.tom_ore = new BlockItem(BlockList.tom_ore,
									new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
											.setRegistryName(BlockList.tom_ore.getRegistryName()));
		}

		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			event.getRegistry()
					.registerAll(BlockList.tom_ore = new Block(Block.Properties.create(Material.IRON)
							.hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE))
									.setRegistryName(location("tom_ore")));
		}

		public static ResourceLocation location(String name) {
			return new ResourceLocation(MODID, name);
		}
	}
}
