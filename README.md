# harmony-app-examples

#### 介绍
鸿蒙应用示例

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



#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
