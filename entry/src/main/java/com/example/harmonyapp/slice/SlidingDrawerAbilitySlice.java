package com.example.harmonyapp.slice;

import com.bigpeach.ability.JAbilitySlice;
import com.bigpeach.components.ListItemProvider;
import com.bigpeach.components.SlidingDrawerLayout;
import com.bigpeach.components.viewholder.AbilityHolder;
import com.bigpeach.components.viewholder.ItemViewHolder;
import com.bigpeach.components.viewholder.datamodel.ItemDataModel;
import com.example.harmonyapp.ResourceTable;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;
import java.util.List;

public class SlidingDrawerAbilitySlice extends JAbilitySlice {


    private ListContainer listContainer;
    private SlidingDrawerLayout slidingDrawer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_slice_sliding_drawer);

        {
            listContainer = findComponent(ResourceTable.Id_list_container);
            List<TextInfo> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                data.add(new TextInfo("" + (i + 1)));
            }
            // @TODO error
//            listContainer.setFooterBoundarySwitch(false);
//            listContainer.setHeaderBoundarySwitch(false);
//            listContainer.setBoundarySwitch(true);
//            listContainer.setBoundaryColor(Color.WHITE);
//            listContainer.setBoundaryThickness(vp2px(8f));
            ListItemProvider<TextInfo> itemProvider = new ListItemProvider<>();
            itemProvider.setDataList(data);
            listContainer.setItemProvider(itemProvider);
        }
        {
            slidingDrawer = findComponent(ResourceTable.Id_sliding_drawer);
            Component drawerLayout = findComponent(ResourceTable.Id_drawer);
            drawerLayout.setMarginBottom(vp2px(-500f)); // 鸿蒙系统目前 ohos:bottom_margin="-500vp" 单位vp与px值相等的Bug
            slidingDrawer.setDrawer(drawerLayout, vp2px(60f), vp2px(500f));
            Component lineComponent = findComponent(ResourceTable.Id_line);
            ShapeElement shapeElement = new ShapeElement();
            shapeElement.setRgbColor(RgbColor.fromArgbInt(0xFFFFFFFF));
            shapeElement.setCornerRadius(10f);
            lineComponent.setBackground(shapeElement);
            Component contentLayout = findComponent(ResourceTable.Id_content);

            Button button = findComponent(ResourceTable.Id_button);
            ShapeElement shapeElement1 = new ShapeElement();
            shapeElement1.setRgbColor(RgbColor.fromArgbInt(0xFF00587a));
            shapeElement1.setCornerRadius(vp2px(60f));
            button.setBackground(shapeElement1);
            button.setClickedListener(component -> {
                if (slidingDrawer.isOpened()) {
                    slidingDrawer.close();
                } else {
                    slidingDrawer.open();
                }

            });
        }
    }

    /**
     * 数据
     */
    public static class TextInfo extends ItemDataModel {

        private String text;

        public TextInfo(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public int getLayoutId(int index) {
            return ResourceTable.Layout_item_text;
        }

        @Override
        public ItemViewHolder getViewHolder(AbilityHolder iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component component) {
            return new StringHolder(iAbility, listContainer, itemProvider, component);
        }
    }

    /**
     * view
     */
    public static class StringHolder extends ItemViewHolder<AbilityHolder, TextInfo> {

        Text text;

        public StringHolder(AbilityHolder iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component itemComponent) {
            super(iAbility, listContainer, itemProvider, itemComponent);
            text = findComponent(ResourceTable.Id_text);
            text.setMarginsLeftAndRight(vp2px(3f), vp2px(3f));
            ShapeElement shapeElement = new ShapeElement();
            shapeElement.setCornerRadius(10);
            shapeElement.setRgbColor(RgbColor.fromArgbInt(0xFFd7385e));
            text.setBackground(shapeElement);
            itemComponent.setClickedListener(component -> {
                new ToastDialog(getContext())
                        .setText("点我干啥？")
                        .setAlignment(LayoutAlignment.CENTER)
                        .show();
            });
        }

        @Override
        public void setContent(int index, TextInfo data) {
            text.setText(data.getText());
        }
    }
}