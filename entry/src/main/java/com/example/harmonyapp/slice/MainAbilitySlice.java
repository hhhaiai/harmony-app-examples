package com.example.harmonyapp.slice;

import com.example.harmonyapp.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;

public class MainAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button listBtn = (Button) findComponentById(ResourceTable.Id_list_btn);
        listBtn.setClickedListener(component -> {
            present(new ListAbilitySlice(), new Intent());
        });

        Button dialogBtn = (Button) findComponentById(ResourceTable.Id_dialog_btn);
        dialogBtn.setClickedListener(component -> {

        });

        Button notifyBtn = (Button) findComponentById(ResourceTable.Id_notify_btn);
        notifyBtn.setClickedListener(component -> {
            present(new NotifyAbilitySlice(), new Intent());
        });

        Button slidingDrawerBtn = (Button) findComponentById(ResourceTable.Id_sliding_drawer_btn);
        slidingDrawerBtn.setClickedListener(component -> {
            present(new SlidingDrawerAbilitySlice(), new Intent());
        });


    }
}
