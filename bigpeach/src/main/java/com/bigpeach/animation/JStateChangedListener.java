package com.bigpeach.animation;

import ohos.agp.animation.Animator;

public interface JStateChangedListener extends Animator.StateChangedListener {

    default void onStart(Animator animator) {
    }

    default void onStop(Animator animator) {
    }

    default void onCancel(Animator animator) {
    }

    default void onEnd(Animator animator) {
    }

    default void onPause(Animator animator) {
    }

    default void onResume(Animator animator) {
    }
}
