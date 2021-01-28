package com.example.harmonyapp.slice;

import com.example.harmonyapp.ResourceTable;
import com.example.harmonyapp.slicelist.VerticalListAbilitySlice;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;

public class TestLayoutAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_slice_test_layout);
    }
}
