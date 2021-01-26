package com.bigpeach.ability;

import ohos.aafwk.ability.Ability;
import ohos.agp.components.AttrHelper;
import ohos.agp.components.Component;

public class JAbility extends Ability {

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
