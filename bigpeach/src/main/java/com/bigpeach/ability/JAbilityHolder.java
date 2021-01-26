package com.bigpeach.ability;

import com.bigpeach.components.viewholder.AbilityHolder;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public interface JAbilityHolder extends AbilityHolder {

    void present(AbilitySlice targetSlice, Intent intent);
}
