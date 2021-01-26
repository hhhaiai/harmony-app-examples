package com.bigpeach.components;

import com.bigpeach.components.viewholder.AbilityHolder;
import com.bigpeach.components.viewholder.ItemViewHolder;
import com.bigpeach.components.viewholder.datamodel.ItemDataModel;
import ohos.agp.components.*;

import java.util.List;

public class ListItemProvider<T extends ItemDataModel> extends RecycleItemProvider {

    private AbilityHolder iAbility;
    private List<T> dataList;
    private int typeCount = 1;

    public ListItemProvider() {
        this.iAbility = null;
        this.typeCount = 1;
    }

    public ListItemProvider(AbilityHolder iAbility) {
        this.iAbility = iAbility;
        this.typeCount = 1;
    }

    public ListItemProvider(AbilityHolder iAbility, int typeCount) {
        this.iAbility = iAbility;
        this.typeCount = typeCount;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        this.notifyDataInvalidated();
    }

    public void addDataList(List<T> dataList) {
        this.dataList.addAll(dataList);
        this.notifyDataChanged();
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public ItemDataModel getItem(int index) {
        return dataList == null ? null : dataList.get(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public int getItemComponentType(int position) {
        return getItem(position).getComponentType();
    }

    @Override
    public int getComponentTypeCount() {
        return typeCount;
    }

    @Override
    public Component getComponent(int index, Component component, ComponentContainer componentContainer) {
        Component itemComponent = component;
        ItemViewHolder viewHolder;
        ItemDataModel dataModel = getItem(index);
        if (itemComponent == null) {
            itemComponent = LayoutScatter.getInstance(componentContainer.getContext())
                    .parse(dataModel.getLayoutId(index), componentContainer, false);
        }
        viewHolder = dataModel.getViewHolder(iAbility, (ListContainer) componentContainer, ListItemProvider.this, itemComponent);
        viewHolder.setContent(index, dataModel);

        return itemComponent;
    }
}
