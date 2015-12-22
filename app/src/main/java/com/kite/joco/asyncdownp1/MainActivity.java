package com.kite.joco.asyncdownp1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kite.joco.asyncdownp1.db.Partner;
import com.kite.joco.asyncdownp1.rest.ServiceGen;
import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbLetolt;
    TextView tvElsoment, tvUtolsoment;
    private ProgressDialog progressDialog;
    //private Handler progressBarHandler = new Handler() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //pbLetolt = (ProgressBar) findViewById(R.id.pbLetolt);
        tvElsoment = (TextView) findViewById(R.id.tvElsoment);
        tvUtolsoment = (TextView) findViewById(R.id.tvUtolsoment);

    }

    public void letoltClck(View v) {
        // new AsnycLetolt().execute(0);
        download();
    }

    private void download() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Partnerek letöltése");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(true);
        int max = 800000;
        int k = 0;
        progressDialog.setMax(max);
        progressDialog.show();

        while (k < max) {
            Log.i(" A K értéke", " " + k);
            k += 10;
            progressDialog.setProgress(k);
        }
        Log.i("LOGTAG","Most kell kilépnie");
        //progressDialog.dismiss();


        /*final Thread t = new Thread() {
            @Override
            public void run() {
                int jumptime = 0;
                int totalProgressTime = 500;
                while (jumptime < totalProgressTime) {
                    try {
                        sleep(200);
                        jumptime += 5;
                        progressDialog.setProgress(jumptime);
                        Log.i("JUMPTIME:"," " +jumptime);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        };
                t.start();*/
    }


    class AsnycLetolt extends AsyncTask<Integer, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("LOGPREEXECUTE", "started");
            Calendar c = Calendar.getInstance(new Locale("HU"));
            Date d = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
            tvElsoment.setText("Az első mentése ideje: " + sdf.format(d));
        }


        @Override
        protected String doInBackground(Integer... params) {
            /*ServiceGen.get().getAsyncListofPartner(new Callback<List<Partner>>() {
                @Override
                public void success(List<Partner> partners, Response response) {
                    int i = 0;
                    //SugarRecord.saveInTx(partners);
                    for (Partner p : partners) {
                        p.save();
                        publishProgress(i);
                        i++;
                    }
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });*/

            List<Partner> partners = ServiceGen.get().getSyncListOfPartner();

            SugarRecord.saveInTx(partners);
            //pbLetolt.setMax(partners.size());
            for (int i = 0; i < partners.size(); i++) {
                publishProgress(i);
            }

            return "";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
//        pbLetolt.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("LOGPOSTEXECUTE", "started");
            Calendar c = Calendar.getInstance(new Locale("HU"));
            Date d = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
            tvUtolsoment.setText("Az utolsó mentése ideje: " + sdf.format(d));
        }
    }

}