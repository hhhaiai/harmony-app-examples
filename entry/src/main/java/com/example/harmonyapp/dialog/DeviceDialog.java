package com.example.harmonyapp.dialog;

import com.example.harmonyapp.ResourceTable;
import ohos.agp.components.*;
import ohos.agp.window.dialog.CommonDialog;
import ohos.app.Context;
import ohos.distributedschedule.interwork.DeviceInfo;
import ohos.distributedschedule.interwork.DeviceManager;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.List;

public class DeviceDialog extends CommonDialog {

    static final HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, "dialog");

    private ItemProvider mItemProvider;

    public DeviceDialog(Context context) {
        super(context);
        Component component = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_dialog_device, null, true);
        setContentCustomComponent(component);
        setAutoClosable(true);
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        Component component = getContentCustomComponent();
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_list_container);
        mItemProvider = new ItemProvider();
        listContainer.setItemProvider(mItemProvider);
//        List<DeviceInfo> onlineDevices = DeviceManager.getDeviceList(DeviceInfo.FLAG_GET_ONLINE_DEVICE);
//        mItemProvider.setDeviceList(onlineDevices);
    }

    public class ItemProvider extends RecycleItemProvider {
        private List<DeviceInfo> itemList;

        public void setDeviceList(List<DeviceInfo> itemList) {
            this.itemList = itemList;
        }

        @Override
        public int getCount() {
            return itemList == null ? 0 : itemList.size();
        }

        @Override
        public Object getItem(int index) {
            return itemList == null ? null : itemList.get(index);
        }

        @Override
        public long getItemId(int index) {
            return index;
        }

        @Override
        public Component getComponent(int index, Component component, ComponentContainer componentContainer) {
            Text textTitle;
            if (component == null) {
                component = LayoutScatter.getInstance(componentContainer.getContext())
                        .parse(ResourceTable.Layout_dialog_device_item, componentContainer, false);
            }
            textTitle = (Text) component.findComponentById(ResourceTable.Id_text_title);

            DeviceInfo deviceInfo = (DeviceInfo) getItem(index);
            textTitle.setText(deviceInfo.getDeviceName());

            return component;
        }
    }
}
