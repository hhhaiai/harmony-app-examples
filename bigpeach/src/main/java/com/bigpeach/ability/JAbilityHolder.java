package com.bigpeach.ability;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public interface JAbilityHolder {

    void present(AbilitySlice targetSlice, Intent intent);
}
