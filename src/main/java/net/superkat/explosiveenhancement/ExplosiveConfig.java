package net.superkat.explosiveenhancement;

import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.OptionGroup;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.config.ConfigEntry;
import dev.isxander.yacl.config.ConfigInstance;
import dev.isxander.yacl.config.GsonConfigInstance;
import dev.isxander.yacl.gui.controllers.BooleanController;
import dev.isxander.yacl.gui.controllers.slider.IntegerSliderController;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.nio.file.Path;

public class ExplosiveConfig {

    public static final ConfigInstance<ExplosiveConfig> INSTANCE = new GsonConfigInstance<>(ExplosiveConfig.class, Path.of("./config/explosive-config.json"));

    @ConfigEntry public static boolean showBlastWave = true;
    @ConfigEntry public static boolean showFireball = true;
    @ConfigEntry public static boolean showMushroomCloud = true;
    @ConfigEntry public static boolean showSparks = true;
    @ConfigEntry public static boolean showDefaultExplosion = false;
    @ConfigEntry public static boolean underwaterExplosions = true;
    @ConfigEntry public static boolean showShockwave = true;
    @ConfigEntry public static boolean showUnderwaterBlastWave = true;
    @ConfigEntry public static int bubbleAmount = 50;
    @ConfigEntry public static boolean showDefaultExplosionUnderwater = false;
    @ConfigEntry public static boolean debugLogs = false;
    @ConfigEntry public static boolean modEnabled = true;

    public static Screen makeScreen(Screen parent) {
        return YetAnotherConfigLib.create(INSTANCE, (defaults, config, builder) -> {
            //Default Explosion category
            var defaultCategoryBuilder = ConfigCategory.createBuilder()
                    .name(Text.translatable("explosiveenhancement.category.default"));

            //Explosion particles group
            var explosionGroup = OptionGroup.createBuilder()
                    .name(Text.translatable("explosiveenhancement.explosion.group"))
                    .tooltip(Text.translatable("explosiveenhancement.explosion.group.tooltip"));
            var showBlastWave = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.blastwave.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.blastwave.enabled.tooltip"))
                    .binding(
                            defaults.showBlastWave,
                            () -> config.showBlastWave,
                            val -> config.showBlastWave = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var showFireball = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.fireball.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.fireball.enabled.tooltip"))
                    .binding(
                            defaults.showFireball,
                            () -> config.showFireball,
                            val -> config.showFireball = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var showMushroomCloud = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.mushroomcloud.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.mushroomcloud.enabled.tooltip"))
                    .binding(
                            defaults.showMushroomCloud,
                            () -> config.showMushroomCloud,
                            val -> config.showMushroomCloud = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var showSparks = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.sparks.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.sparks.enabled.tooltip"))
                    .binding(
                            defaults.showSparks,
                            () -> config.showSparks,
                            val -> config.showSparks = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var showDefaultExplosion = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.default.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.default.enabled.tooltip"))
                    .binding(
                            defaults.showDefaultExplosion,
                            () -> config.showDefaultExplosion,
                            val -> config.showDefaultExplosion = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            explosionGroup.option(showBlastWave);
            explosionGroup.option(showFireball);
            explosionGroup.option(showMushroomCloud);
            explosionGroup.option(showSparks);
            explosionGroup.option(showDefaultExplosion);
            defaultCategoryBuilder.group(explosionGroup.build());

            var underwaterGroup = OptionGroup.createBuilder()
                    .name(Text.translatable("explosiveenhancement.underwater.group"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.group.tooltip"));

            var underwaterExplosions = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.underwater.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.enabled.tooltip"))
                    .binding(
                            defaults.underwaterExplosions,
                            () -> config.underwaterExplosions,
                            val -> config.underwaterExplosions = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var showShockwave = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.underwater.shockwave"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.shockwave.tooltip"))
                    .binding(
                            defaults.showShockwave,
                            () -> config.showShockwave,
                            val -> config.showShockwave = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var showUnderwaterBlast = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.underwater.blast"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.blast.tooltip"))
                    .binding(
                            defaults.showUnderwaterBlastWave,
                            () -> config.showUnderwaterBlastWave,
                            val -> config.showUnderwaterBlastWave = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            var bubbleAmount = Option.createBuilder(Integer.class)
                    .name(Text.translatable("explosiveenhancement.underwater.bubbleamount"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.bubbleamount.tooltip"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.bubbleamount.warningtooltip"))
                    .binding(
                            defaults.bubbleAmount,
                            () -> config.bubbleAmount,
                            val -> config.bubbleAmount = val
                    )
                    .controller(integerOption -> new <Number>IntegerSliderController(integerOption, 0, 500, 5))
                    .build();
            var showDefaultExplosionUnderwater = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.underwater.default"))
                    .tooltip(Text.translatable("explosiveenhancement.underwater.default.tooltip"))
                    .binding(
                            defaults.showDefaultExplosionUnderwater,
                            () -> config.showDefaultExplosionUnderwater,
                            val -> config.showDefaultExplosionUnderwater = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();

            underwaterGroup.option(underwaterExplosions);
            underwaterGroup.option(showShockwave);
            underwaterGroup.option(showUnderwaterBlast);
            underwaterGroup.option(bubbleAmount);
            underwaterGroup.option(showDefaultExplosionUnderwater);
            defaultCategoryBuilder.group(underwaterGroup.build());



            var extrasCategoryBuilder = ConfigCategory.createBuilder()
                    .name(Text.translatable("explosiveenhancement.category.extras"));

            var extrasGroup = OptionGroup.createBuilder()
                    .name(Text.translatable("explosiveenhancement.extras.group"))
                    .tooltip(Text.translatable("explosiveenhancement.extras.group.tooltip"));

            var debugLogs = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.extras.logs"))
                    .tooltip(Text.translatable("explosiveenhancement.extras.logs.tooltip"))
                    .tooltip(Text.translatable("explosiveenhancement.extras.logs.warningtooltip"))
                    .binding(
                            defaults.debugLogs,
                            () -> config.debugLogs,
                            val -> config.debugLogs = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();

            var modEnabled = Option.createBuilder(boolean.class)
                    .name(Text.translatable("explosiveenhancement.extras.enabled"))
                    .tooltip(Text.translatable("explosiveenhancement.extras.enabled.tooltip"))
                    .binding(
                            defaults.modEnabled,
                            () -> config.modEnabled,
                            val -> config.modEnabled = val
                    )
                    .controller(booleanOption -> new BooleanController(booleanOption, true))
                    .build();
            extrasGroup.option(debugLogs);
            extrasGroup.option(modEnabled);
            extrasCategoryBuilder.group(extrasGroup.build());

            return builder
                    .title(Text.translatable("explosiveenhancement.title"))
                    .category(defaultCategoryBuilder.build())
                    .category(extrasCategoryBuilder.build());
        }).generateScreen(parent);
    }

}
