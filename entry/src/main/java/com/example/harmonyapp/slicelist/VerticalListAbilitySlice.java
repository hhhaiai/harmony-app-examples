package com.example.harmonyapp.slicelist;

import com.bigpeach.ability.JAbilityHolder;
import com.bigpeach.ability.JAbilitySlice;
import com.bigpeach.components.ListItemProvider;
import com.bigpeach.components.viewholder.AbilityHolder;
import com.bigpeach.components.viewholder.ItemViewHolder;
import com.bigpeach.components.viewholder.datamodel.ItemDataModel;
import com.example.harmonyapp.ResourceTable;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;

import java.util.ArrayList;
import java.util.List;

public class VerticalListAbilitySlice extends JAbilitySlice implements JAbilityHolder {

    ListContainer listContainer;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_slice_list_vertical);
        listContainer = findComponent(ResourceTable.Id_list_container);

        List<TextInfo> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new TextInfo("" + (i + 1)));
        }
        ListItemProvider<TextInfo> itemProvider = new ListItemProvider<>(this);
        itemProvider.setDataList(data);
        listContainer.setItemProvider(itemProvider);

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
            return new StringHolder((JAbilityHolder) iAbility, listContainer, itemProvider, component);
        }
    }

    /**
     * view
     */
    public static class StringHolder extends ItemViewHolder<JAbilityHolder, TextInfo> {

        Text text;

        public StringHolder(JAbilityHolder iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component itemComponent) {
            super(iAbility, listContainer, itemProvider, itemComponent);
            text = findComponent(ResourceTable.Id_text);
            itemComponent.setClickedListener(component -> {
                iAbility.terminate();
            });
        }

        @Override
        public void setContent(int index, TextInfo data) {
            text.setText(data.getText());
        }
    }
}
