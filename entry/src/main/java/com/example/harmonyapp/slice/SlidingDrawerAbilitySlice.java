package com.example.harmonyapp.slice;

import com.bigpeach.ability.JAbilitySlice;
import com.bigpeach.components.SlidingDrawerLayout;
import com.example.harmonyapp.ResourceTable;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;

public class SlidingDrawerAbilitySlice extends JAbilitySlice {


    SlidingDrawerLayout slidingDrawer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_slice_sliding_drawer);

        slidingDrawer = findComponent(ResourceTable.Id_sliding_drawer);
        Component drawerLayout = findComponent(ResourceTable.Id_drawer);
        drawerLayout.setMarginBottom(vp2px(-500f)); // 鸿蒙系统目前 ohos:bottom_margin="-500vp" 单位vp与px值相等的Bug
        slidingDrawer.setChild(drawerLayout, vp2px(80f), vp2px(500f));
        Component handleLayout = findComponent(ResourceTable.Id_handle);
        Component contentLayout = findComponent(ResourceTable.Id_content);
    }
}
