package com.gmail.isnantobudi0.belajarservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        EditText editWaktu;
        Button tombolMain, tombolStop;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// TODO 1. mengambil data dari Id yang ada di xml
        editWaktu = findViewById(R.id.et_waktu);
        tombolMain = findViewById(R.id.bt_play);
        tombolStop = findViewById(R.id.bt_stop);
        tombolMain.setOnClickListener(this);
        tombolStop.setOnClickListener(this);
    }


    @Override

    public void onClick(View view) {
        // TODO mengambil data ID
        switch (view.getId()){
            // TODO saat id = bt_play menjalankan method callPLay
            case R.id.bt_play:
                callPlay();
                break;
            // TODO saat id = bt_stop menjalankan method stopPlay
            case R.id.bt_stop:
                stopPlay();
                break;
        }
    }



    public void callPlay() {
            // TODO 2. mengambil data dari editWaktu dan dirubah ke string
            int detik =Integer.parseInt(editWaktu.getText().toString());
            Intent intent = new Intent(MainActivity.this, MyService.class);
            // TODO 3. fungsi untuk pending saat akan intent
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);
// TODO 4. Membuat alarm yang diambil dari angka(detik) yang di inputkan
        if(alarmManager !=null){
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()
            + (detik * 1000), pendingIntent);
            //TODO menampilkan tampilan toast berapa waktu delay yang di buat
            Toast.makeText(getApplicationContext(), "Song Play After"
            +detik+"second !", Toast.LENGTH_LONG).show();
        }
    }
    //TODO 5. method untuk menghentikan musik yang dimainkan
    public void stopPlay() {
        stopService(new Intent(MainActivity.this, MyService.class));
    }
}