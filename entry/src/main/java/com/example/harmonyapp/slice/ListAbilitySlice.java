package com.example.harmonyapp.slice;

import com.example.harmonyapp.ResourceTable;
import com.example.harmonyapp.slicelist.VerticalListAbilitySlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;

public class ListAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_slice_list);

        Button verticalListBtn = (Button) findComponentById(ResourceTable.Id_vertical_list_btn);
        verticalListBtn.setClickedListener(component -> {
            present(new VerticalListAbilitySlice(), new Intent());
        });
    }
}
