# 鸿蒙应用示例

# 简介
    鸿蒙系统应用开发中使用示例。


# 基础框架 bigpeach

## ListItemProvider 使用
ListItemProvider 是针对 ListContainer封装的列表适配器。与 `ItemDataModel` `ItemViewHolder` `AbilityHolder`配合使用。
- ItemDataModel 数据模型
- ItemViewHolder 视图样式
- AbilityHolder Holder能力

### AbilityHolder子类JAbilityHolder
```java
public interface JAbilityHolder extends AbilityHolder {
    void present(AbilitySlice targetSlice, Intent intent);
    // ... 部分代码
}
```
只要 Ability或AbilitySlice implements JAbilityHolder 通过ListItemProvider(AbilityHolder iAbility)构造函数传入，ViewHolder就能获取拥有者能力。


Demo示例
```java
public class VerticalListAbilitySlice extends JAbilitySlice {
    ListContainer listContainer;
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_slice_list_vertical);
        listContainer = findComponent(ResourceTable.Id_list_container);

        List<TextInfo> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {  data.add(new TextInfo("" + (i + 1))); }
        ListItemProvider<TextInfo> itemProvider = new ListItemProvider<>();
        itemProvider.setDataList(data);
        listContainer.setItemProvider(itemProvider);
    }
    // 数据
    public static class TextInfo extends ItemDataModel {
        private String text;
        public TextInfo(String text) { this.text = text; }
        public String getText() { return text; }
        @Override
        public int getLayoutId(int index) {
            return ResourceTable.Layout_item_text;
        }
        @Override
        public ItemViewHolder getViewHolder(AbilityHolder iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component component) {
            return new StringHolder(iAbility, listContainer, itemProvider, component);
        }
    }
    // 视图展示
    public static class StringHolder extends ItemViewHolder<AbilityHolder, TextInfo> {
        Text text;
        public StringHolder(AbilityHolder iAbility, ListContainer listContainer, ListItemProvider itemProvider, Component itemComponent) {
            super(iAbility, listContainer, itemProvider, itemComponent);
            text = findComponent(ResourceTable.Id_text);
        }
        @Override
        public void setContent(int index, TextInfo data) {
            text.setText(data.getText());
        }
    }
}
```

# 安装教程

# 使用说明


# 参与贡献



# 特技

