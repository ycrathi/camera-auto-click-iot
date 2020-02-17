package com.mobiliya.cameraautoclick;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class AccessTest extends AccessibilityService {

    private final static String TAG = "Yogesh";


    @Override
    public void onCreate() {
        super.onCreate();
        //performGlobalAction(AccessibilityService.GLOBAL_ACTION_TAKE_SCREENSHOT);
        Log.d("Yogesh","I am started");

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "onServiceConnected");


      /*  AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT |
                AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS |
                AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS;

        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        info.packageNames = new String[]{"ru.androidtools.selfcliсker"};
        setServiceInfo(info);*/
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //performGlobalAction(GLOBAL_ACTION_TAKE_SCREENSHOT);


        Log.d(TAG, "ACC::onAccessibilityEvent: " + event.getEventType());

        //TYPE_WINDOW_STATE_CHANGED == 32
        if (AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED == event
                .getEventType()) {
            AccessibilityNodeInfo nodeInfo = event.getSource();

            if (nodeInfo == null) {
                return;
            }


            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


            String x = takePictureIntent.resolveActivity(getPackageManager()).getPackageName();

            Log.d("Yogesh","Package name " + x);


            List<AccessibilityNodeInfo> list1 = nodeInfo.findAccessibilityNodeInfosByText("Switch to front camera");

            for (AccessibilityNodeInfo node : list1) {
                Log.i(TAG, "ACC::onAccessibilityEvent: click " + node);
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }

            final List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("Take photo");


            final android.os.Handler handler = new android.os.Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    for (AccessibilityNodeInfo node : list) {
                        Log.i(TAG, "ACC::onAccessibilityEvent: click " + node);
                        node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    }
                    handler.postDelayed(this,5000);
                }
            },10000);

            for (AccessibilityNodeInfo node : list) {
                Log.i(TAG, "ACC::onAccessibilityEvent: click " + node);
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }

            Log.d(TAG,"Size " + list.size());
            Log.d(TAG,"Access " + list.toString());
            Log.d(TAG,"Access " + getAllChildNodeText(nodeInfo).toString());
            /*
            List<AccessibilityNodeInfo> list = nodeInfo
                    .findAccessibilityNodeInfosByViewId("com.android.settings:id/left_button");
            for (AccessibilityNodeInfo node : list) {
                Log.i(TAG, "ACC::onAccessibilityEvent: left_button " + node);
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }

            list = nodeInfo
                    .findAccessibilityNodeInfosByViewId("android:id/button1");
            for (AccessibilityNodeInfo node : list) {
                Log.i(TAG, "ACC::onAccessibilityEvent: button1 " + node);
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }*/
        }
    }



    private List<CharSequence> getAllChildNodeText(AccessibilityNodeInfo infoCompat) {
        List<CharSequence> contents = new ArrayList<>();
        if (infoCompat == null)
            return contents;
        if (infoCompat.getContentDescription() != null) {
            contents.add(infoCompat.getContentDescription().toString().isEmpty() ? "unlabelled" : infoCompat.getContentDescription());
        } else if (infoCompat.getText() != null) {
            contents.add(infoCompat.getText().toString().isEmpty() ? "unlabelled" : infoCompat.getText());
        } else {
            getTextInChildren(infoCompat, contents);
        }
        if (infoCompat.isClickable()) {
            if (infoCompat.getClassName().toString().contains(Button.class.getSimpleName())) {
                if (contents.size() == 0) {
                    contents.add("Unlabelled button");
                } else {
                    contents.add("button");
                }
            }
            contents.add("Double tap to activate");
        }
        return contents;
    }


    private void getTextInChildren(AccessibilityNodeInfo nodeInfoCompat, List<CharSequence> contents) {
        if (nodeInfoCompat == null)
            return;
        if (!nodeInfoCompat.isScrollable()) {
            if (nodeInfoCompat.getContentDescription() != null) {
                contents.add(nodeInfoCompat.getContentDescription());
            } else if (nodeInfoCompat.getText() != null) {
                contents.add(nodeInfoCompat.getText());
            }
            if (nodeInfoCompat.getChildCount() > 0) {
                for (int i = 0; i < nodeInfoCompat.getChildCount(); i++) {
                    if (nodeInfoCompat.getChild(i) != null) {
                        getTextInChildren(nodeInfoCompat.getChild(i), contents);
                    }
                }
            }
        }
    }



    @Override
    public void onInterrupt() {

    }
}


//R.id.donebutton -->
