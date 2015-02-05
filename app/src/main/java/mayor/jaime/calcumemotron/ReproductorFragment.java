package mayor.jaime.calcumemotron;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;


public class ReproductorFragment extends Fragment {
    MyBoundService bService;
    Button bstart;
    boolean bound = false;
        private ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName className, IBinder s) {
                MyBoundService.MyBinder binder = (MyBoundService.MyBinder) s;
                bService = binder.getService();
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
    View.OnClickListener lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonStartPause: {
                    try {
                        playpause(v);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

        public void playpause(View v) throws IOException {
            if(bound) bService.playPause();
        }

        public void stop(View v) throws IOException {

            bService.stop();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.reproductor, container, false);
            getActivity().setTitle("Reproductor");
            Intent intent = new Intent("BOUNDSERVICE");
            bstart = (Button) rootView.findViewById(R.id.buttonStartPause);
            bstart.setOnClickListener(lis);
            getActivity().startService(intent);
            getActivity().bindService(intent, connection, Context.BIND_AUTO_CREATE);
            return rootView;
        }
    }

