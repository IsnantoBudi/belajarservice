package com.gmail.isnantobudi0.belajarservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public MyService() {
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //  TODO 1. method untuk mengambil data dari raw
        public void onCreate(){
        mediaPlayer = MediaPlayer.create(this, R.raw.nandemonaiya);
        mediaPlayer.setLooping(true);
    }
    // TODO 2. method untuk memainkan musik
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }
    // TODO 3. method untuk menghentikan musik
    public void onDestroy(){
        mediaPlayer.stop();
    }
}
