package com.example.zhaoxia.camera;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public android.hardware.Camera camera;
    public CameraManager cameraManager;
    public Parameters parameters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        flashlight();
    }

    public void flashlight(){
        //6.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            try {
                cameraManager.setTorchMode("1",true);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }else {
            camera = Camera.open();
            parameters = camera.getParameters();
            parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
            camera.startPreview();
        }

    }

}
