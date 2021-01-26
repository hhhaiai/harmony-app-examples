package com.bigpeach.ability;

import ohos.aafwk.ability.AbilitySlice;
import ohos.agp.components.AttrHelper;
import ohos.agp.components.Component;

public class JAbilitySlice extends AbilitySlice {

    public <T extends Component> T findComponent(int id) {
        return (T) findComponentById(id);
    }

    public <T extends Component> T findComponent(Component component, int id) {
        return (T) component.findComponentById(id);
    }

    public int vp2px(float value) {
        return AttrHelper.vp2px(value, this.getContext());
    }
}
