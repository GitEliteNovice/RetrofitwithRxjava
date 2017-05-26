package com.demotrying.lannet.retrofitwithrxjava;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.demotrying.lannet.retrofitwithrxjava.adapter.DataAdapter;
import com.demotrying.lannet.retrofitwithrxjava.adapter.MyReportAdapter;
import com.demotrying.lannet.retrofitwithrxjava.model.Fixtures;
import com.demotrying.lannet.retrofitwithrxjava.network.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
String BASE_URL="http://api.football-data.org/";
    private CompositeDisposable mCompositeDisposable;
    MyReportAdapter reportAdapter;
    ListView listview;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=(ListView)findViewById(R.id.listview);
        mCompositeDisposable = new CompositeDisposable();
        reportAdapter=new MyReportAdapter(MainActivity.this,R.layout.fixturelayout);
        listview.setAdapter(reportAdapter);
        loadJSON();
    }

    private void loadJSON() {
       pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("loading");
        pd.show();

        Gson gson = new GsonBuilder().registerTypeAdapter(List.class, new DataAdapter(MainActivity.this)).create();
        RequestInterface requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(RequestInterface.class);

        mCompositeDisposable.add(requestInterface.fixtures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(List<Fixtures> dataList) {
pd.dismiss();
        for (Fixtures data : dataList) {
            reportAdapter.add(data);
        }

    }

    private void handleError(Throwable error) {
   pd.dismiss();
        Toast.makeText(this, "Error "+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }


}
