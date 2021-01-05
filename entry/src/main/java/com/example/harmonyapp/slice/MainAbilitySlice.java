package com.example.harmonyapp.slice;

import com.example.harmonyapp.ResourceTable;
import com.example.harmonyapp.dialog.DeviceDialog;
import ohos.aafwk.ability.AbilityForm;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.OnClickListener;
import ohos.aafwk.ability.ViewsStatus;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.window.dialog.BaseDialog;
import ohos.agp.window.dialog.CommonDialog;
import ohos.agp.window.service.Window;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button button1 = (Button) findComponentById(ResourceTable.Id_button1);
        Button button2 = (Button) findComponentById(ResourceTable.Id_button2);
        button1.setClickedListener(component -> {

            DeviceDialog baseDialog=new DeviceDialog(this.getContext());
            baseDialog.show();

//            CommonDialog commonDialog=new CommonDialog(this.getContext());
//            commonDialog.setAutoClosable(true);
//            commonDialog.setContentText("设备");
//            commonDialog.show();

        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
