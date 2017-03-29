package com.chachapps.baselibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chachapps.initialclasses.rx.RxEventBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class HomeActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         compositeDisposable = new CompositeDisposable();

        Button button = (Button) findViewById(R.id.btn);
        final TextView textView = (TextView) findViewById(R.id.home_textview);

        compositeDisposable.add(RxEventBus.getInstance().toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {

                        String msg = (String) o;

                        textView.setText(msg);
                    }
                }));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxEventBus.getInstance().send("Adioooos mundo crueeel!");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear(); // Do not send event after activity has been destroyed

    }
}
