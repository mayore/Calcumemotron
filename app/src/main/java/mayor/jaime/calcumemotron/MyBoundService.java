package mayor.jaime.calcumemotron;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;
import java.io.IOException;

public class MyBoundService extends Service{
    private final IBinder binder = new MyBinder();

    MediaPlayer mediaPlayer;
    File sdCard;
    File song;
    boolean stop = false;

    public void playPause() throws IOException {
        if (stop){
            stop = false;
            restart();
        }
        else {
            if (mediaPlayer.isPlaying()) mediaPlayer.pause();
            else mediaPlayer.start();
        }
    }

    public void stop() throws IOException {
        if (!stop){
            stop = true;
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        sdCard = Environment.getExternalStorageDirectory();
        song = new File(sdCard.getAbsolutePath() + "/Music/Song.mp3");
    }

    public void restart() throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(song.getAbsolutePath());
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            restart();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class MyBinder extends Binder {
        public MyBoundService getService(){
            return MyBoundService.this;
        }
    }
}

