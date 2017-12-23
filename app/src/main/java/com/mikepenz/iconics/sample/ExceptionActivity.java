package com.mikepenz.iconics.sample;

import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.context.IconicsLayoutInflater2;

public class ExceptionActivity extends AppCompatActivity {

    private TextView normalTv;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new IconicsLayoutInflater2(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        ll = findViewById(R.id.clickme);
        normalTv = findViewById(R.id.normal_textview);

        normalTest();
        errorTest();
    }


    private void normalTest() {
        L(normalTv.getText().toString());
        normalTv.setText(GoogleMaterial.Icon.gmd_access_time.getFormattedName());
        L(normalTv.getText().toString());
        normalTv.setText(GoogleMaterial.Icon.gmd_3d_rotation.getFormattedName());
    }

    int index = 0;

    private void errorTest() {
        ll.setOnClickListener(view -> {
            switch (index) {
                case 0:
                    normalTv.setText(GoogleMaterial.Icon.gmd_access_time.getFormattedName());
                    break;
                case 1:
                    normalTv.setText(GoogleMaterial.Icon.gmd_3d_rotation.getFormattedName());
                    break;
                case 2:
                    normalTv.setText(GoogleMaterial.Icon.gmd_ac_unit.getFormattedName());
                    break;
                case 3:
                    normalTv.setText(GoogleMaterial.Icon.gmd_zoom_out_map.getFormattedName());
                    break;
            }
            index++;
        });
    }

    private void L(String str) {
        Log.e(">>>", str);
    }
}
