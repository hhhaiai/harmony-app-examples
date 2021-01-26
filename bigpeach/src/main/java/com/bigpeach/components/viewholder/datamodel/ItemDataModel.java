package com.bigpeach.components.viewholder.datamodel;

import com.bigpeach.components.ListItemProvider;
import com.bigpeach.components.viewholder.AbilityHolder;
import com.bigpeach.components.viewholder.ItemViewHolder;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

public abstract class ItemDataModel {

    public int getComponentType() {
        return 0;
    }

    public abstract int getLayoutId(int index);

    public abstract ItemViewHolder getViewHolder(AbilityHolder iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component component);
}
