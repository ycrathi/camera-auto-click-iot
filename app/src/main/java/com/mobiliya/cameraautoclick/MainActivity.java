package com.mobiliya.cameraautoclick;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    KeyEvent keyEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mailAccessabilityIntent = new Intent(getApplicationContext(), AccessTest.class);
        startService(mailAccessabilityIntent);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                Log.d("Yogesh", "down event fired");

              /*  final KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_VOLUME_DOWN);
                BaseInputConnection  mInputConnection = new BaseInputConnection( getWindow().getDecorView().getRootView(), true);
                mInputConnection.sendKeyEvent(keyEvent);

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Instrumentation inst = new Instrumentation();
                            inst.sendKeyDownUpSync(keyEvent.getKeyCode());
                        } catch (Exception e) {
                            //Log.e("Exception when sendKeyDownUpSync", e.toString());
                        }
                    }

                }.start();*/

                //Log.d("Yogesh", "down event fired " +wmbinder);
                //IWindowManager m_WndManager = IWindowManager.Stub.asInterface( wmbinder );

                //IBinder imBinder = ServiceManager.getService("input");
/*
                InputManager im = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    im = (InputManager) getSystemService(INPUT_SERVICE);
                }


                //KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_VOLUME_DOWN);

                Class[] paramTypes = new Class[2];
                paramTypes[0] = InputEvent.class;
                paramTypes[1] = Integer.TYPE;

                Object[] params = new Object[2];
                params[0] = keyEvent;
                params[1] = 2;

                try {
                    Method hiddenMethod = im.getClass().getMethod("injectInputEvent", paramTypes);
                    hiddenMethod.invoke(im, params);
                } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                */

              /*  Instrumentation instrumentation = new Instrumentation();
                instrumentation.sendKeySync(
                        new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_FOCUS));
                instrumentation.sendCharacterSync(KeyEvent.KEYCODE_CAMERA);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
*/



/*
                MediaActionSound sound = new MediaActionSound();
                sound.play(MediaActionSound.SHUTTER_CLICK);
*/

/*

                android.hardware.Camera.ShutterCallback shutterCallback = new android.hardware.Camera.ShutterCallback() {
                    @Override
                    public void onShutter() {
                        Log.d("Yogesh","Shoot");
                    }
                };


                shutterCallback.onShutter();


                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                startActivityForResult(intent, 1);
*/

/*
                Intent cameraButtonActionIntent = new Intent(Intent.ACTION_CAMERA_BUTTON);
                getApplication().sendBroadcast(cameraButtonActionIntent);
*/


                //   KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_VOLUME_DOWN);
                //  getWindow().getDecorView().getRootView().dispatchKeyEvent(keyEvent);
                // view.dispatchKeyEvent(keyEvent);
                //getWindow().getDecorView().getRootView().dispatchKeyEvent(keyEvent);
                //mcontroller.dispatchKeyEvent(keyEvent);
                handler.postDelayed(this, 5000);
            }
        }, 10000);


        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        String x = takePictureIntent.resolveActivity(getPackageManager()).getClassName();

        Log.d("Yogesh","Package name "+x);
    }
}
