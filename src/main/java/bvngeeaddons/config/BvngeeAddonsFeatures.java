package bvngeeaddons.config;

import bvngeeaddons.config.listEntries.BossBarRenderMode;
import bvngeeaddons.config.listEntries.ShownBossBarTypes;
import bvngeeaddons.config.options.*;
import bvngeeaddons.gui.BvngeeAddonsConfigGui;

public class BvngeeAddonsFeatures {


    //----------------FIXES-----------------

    @Config(type = Config.Type.GENERIC, category = Config.Category.FIXES)
    public static final BvngeeAddonsConfigBoolean creativeInteractCauldronFix = new BvngeeAddonsConfigBoolean("creativeInteractCauldronFix", false);


    //---------------FEATURES---------------

    @Config(type = Config.Type.GENERIC, category = Config.Category.FEATURES)
    public static final BvngeeAddonsConfigBoolean removeAutoJumpButton = new BvngeeAddonsConfigBoolean("removeAutoJumpButton", false);

    @Config(type = Config.Type.GENERIC, category = Config.Category.FEATURES)
    public static final BvngeeAddonsConfigOptionList bossBarRenderMode = new BvngeeAddonsConfigOptionList("bossBarRenderMode", BossBarRenderMode.DEFAULT);

    @Config(type = Config.Type.GENERIC, category = Config.Category.FEATURES)
    public static final BvngeeAddonsConfigOptionList shownBossBarTypes = new BvngeeAddonsConfigOptionList("shownBossBarType", ShownBossBarTypes.BOTH);

    @Config(type = Config.Type.GENERIC, category = Config.Category.FEATURES)
    public static final BvngeeAddonsConfigBoolean separateBossBarsWithNames = new BvngeeAddonsConfigBoolean("separateBossesWithNames", false);

    @Config(type = Config.Type.GENERIC, category = Config.Category.FEATURES)
    public static final BvngeeAddonsConfigDouble bossBarScale = new BvngeeAddonsConfigDouble("bossBarScale", 1);


    //---------------SETTINGS----------------

    @Config(type = Config.Type.HOTKEY, category = Config.Category.SETTINGS)
    public static final BvngeeAddonsConfigHotkey bvngeeAddonsOpenGui = new BvngeeAddonsConfigHotkey("openBvngeeAddonsGui", "B,C");


    //move to handler? not sure yet
    public static void initCallbacks(){

        //Hotkeys
        bvngeeAddonsOpenGui.getKeybind().setCallback(BvngeeAddonsConfigGui::onOpenGui);

    }

}
