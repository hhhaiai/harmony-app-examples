package com.example.harmonyapp;

import com.example.harmonyapp.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Component;
import ohos.agp.utils.Color;
import ohos.agp.window.service.Window;
import ohos.agp.window.service.WindowManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbility extends Ability {

    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "lkr");

    @Override
    public void onStart(Intent intent) {
        Window window = getWindow();
        window.setStatusBarColor(Color.BLACK.getValue());
        window.setStatusBarVisibility(Component.VISIBLE);
        super.onStart(intent);
        HiLog.error(label, "MainAbility onStart()");
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
