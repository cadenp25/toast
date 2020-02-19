package com.phillipscaden.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView t1 = findViewById(R.id.text1);
        final TextView t2 = findViewById(R.id.text2);
        final TextView t3 = findViewById(R.id.text3);
        final TextView t4 = findViewById(R.id.text4);
        SeekBar seek = findViewById(R.id.seek);
        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t = (TextView) v;
                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                Context context = getApplicationContext();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String id = (String) t.getText();
                int d = sharedPreferences.getInt(id, 0) + 1;
                editor.putInt(id, d);
                editor.apply();
                Toast toast = Toast.makeText(context, id + ":" + d, Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        t1.setOnClickListener(click);
        t2.setOnClickListener(click);
        t3.setOnClickListener(click);
        t4.setOnClickListener(click);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                t1.setTextSize(Float.valueOf(progress));
                t2.setTextSize(Float.valueOf(progress));
                t3.setTextSize(Float.valueOf(progress));
                t4.setTextSize(Float.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
