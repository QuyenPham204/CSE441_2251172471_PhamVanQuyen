package com.example.btth_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button buttonStartTask;
    private TextView textViewProgress;
    private static final String TAG = "BackgroundTaskDemo";
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buttonStartTask = findViewById(R.id.buttonStartTask);
    textViewProgress = findViewById(R.id.textViewProgress);

    buttonStartTask.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            String result = dowloaddate();
//            textViewProgress.setText(result);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String result = dowloaddate();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewProgress.setText(result);
                        }
                    });
                }
            });
        }
    });
}

    private String dowloaddate() {
        try{
            Thread.sleep(10000);
            return "OK";
        }
        catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }

}
