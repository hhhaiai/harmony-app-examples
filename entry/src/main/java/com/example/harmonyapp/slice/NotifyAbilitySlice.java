package com.example.harmonyapp.slice;

import com.example.harmonyapp.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.ComponentProvider;
import ohos.agp.utils.Color;
import ohos.event.notification.NotificationHelper;
import ohos.event.notification.NotificationRequest;

public class NotifyAbilitySlice extends AbilitySlice {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_slice_notify);

        Button verticalListBtn = (Button) findComponentById(ResourceTable.Id_custom_notify_btn);
        verticalListBtn.setClickedListener(component -> {

            NotificationRequest request = new NotificationRequest(1001);

            ComponentProvider remoteView = new ComponentProvider(ResourceTable.Layout_notify_projection, this.getContext());
            remoteView.setTextColor(ResourceTable.Id_me_text, Color.BLUE);
            remoteView.setFloat(ResourceTable.Id_me_text, "setTextSize", 20);
            remoteView.setString(ResourceTable.Id_me_text, "setText", "自定义通知");

            NotificationRequest.NotificationNormalContent content = new NotificationRequest.NotificationNormalContent();
            content.setTitle("投屏").setText("投屏中");
            NotificationRequest.NotificationContent notificationContent = new NotificationRequest.NotificationContent(content);
            request.setContent(notificationContent).setCustomView(remoteView);

            try {
                NotificationHelper.publishNotification(request);
            }catch (Exception e){
            }
        });
    }
}
