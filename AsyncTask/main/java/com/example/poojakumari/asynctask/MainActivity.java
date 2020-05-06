package com.example.poojakumari.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb;
    Button bt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressBar);
        bt = findViewById(R.id.button);
        tv = findViewById(R.id.textview);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(200);

            }
        });


    }
    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {



        int time=1000;
        @Override
        protected String doInBackground(Integer... integers) {
            publishProgress(integers[0]*1000);

            try {
                for(int i=1;i<=10;i++){
                    Thread.sleep(time);
                    pb.setProgress(i*10);
                }

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            tv.setText("Completed");

        }

        @Override
        protected void onPreExecute() {
          //  tv.setText("Starting...");
        }

        @Override
        protected void onProgressUpdate(Integer...integers) {
            tv.setText("Loading...");
        }


    }
}
