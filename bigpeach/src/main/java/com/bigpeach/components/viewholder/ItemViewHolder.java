package com.bigpeach.components.viewholder;

import com.bigpeach.components.ListItemProvider;
import com.bigpeach.components.viewholder.datamodel.ItemDataModel;
import ohos.agp.components.AttrHelper;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.app.Context;

public abstract class ItemViewHolder<H extends AbilityHolder, D extends ItemDataModel> {

    protected H iAbility;
    protected Context context;
    protected Component itemComponent;
    protected ListItemProvider itemProvider;
    protected ListContainer listContainer;

    public ItemViewHolder(H iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component itemComponent) {
        this.iAbility = iAbility;
        this.itemProvider = itemProvider;
        this.listContainer = listContainer;
        this.itemComponent = itemComponent;
        this.context = listContainer.getContext();
    }

    public abstract void setContent(int index, D data);

    public Context getContext() {
        return context;
    }

    public <T extends Component> T findComponent(int id) {
        return (T) itemComponent.findComponentById(id);
    }

    public <T extends Component> T findComponent(Component component, int id) {
        return (T) component.findComponentById(id);
    }

    public int vp2px(float value) {
        return AttrHelper.vp2px(value, this.getContext());
    }

}