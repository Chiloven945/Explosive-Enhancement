package net.superkat.explosiveenhancement;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExplosiveEnhancement implements ModInitializer {
	public static final String MOD_ID = "explosiveenhancement";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final DefaultParticleType BOOM = FabricParticleTypes.simple();
	public static final DefaultParticleType BIG_EXPLOSION = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		Registry.register(Registries.PARTICLE_TYPE, new Identifier("explosiveenhancement", "boom"), BOOM);
		Registry.register(Registries.PARTICLE_TYPE, new Identifier("explosiveenhancement", "big_explosion"), BIG_EXPLOSION);
		LOGGER.info("Hello Fabric world!");
	}
}