package com.turtle.evolution;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;



public class TurtleEvolution implements ModInitializer {
	public static final String MOD_ID = "turtle-evolution";
	private static final Set<UUID> turtleHelmetPlayers = new HashSet<>();
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			server.getPlayerList().getPlayers().forEach(player -> {
				var helmet = player.getItemBySlot(EquipmentSlot.HEAD);

				if (helmet.getItem() == Items.TURTLE_HELMET) {
					player.addEffect(
							new MobEffectInstance(
									MobEffects.NIGHT_VISION,
									10000,
									2
							)
					);
				}
				
			});
		});
	}
}