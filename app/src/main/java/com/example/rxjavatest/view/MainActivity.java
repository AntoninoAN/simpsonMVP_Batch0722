package com.example.rxjavatest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.rxjavatest.R;
import com.example.rxjavatest.model.SimpsonCharacter;
import com.example.rxjavatest.presenter.Presenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewContract{
    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        onBindPresenter();
    }

    @Override
    public void onBindPresenter() {
        presenter = new Presenter();
        presenter.onBindView(this);
        presenter.initNetworkCall();
    }

    @Override
    public void initUI() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
        customAdapter = new CustomAdapter(this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onDataPopulated(ArrayList<SimpsonCharacter> data) {
        Log.d(TAG, "onDataPopulated: "+data.size());
        customAdapter.setDataset(data);
    }

    @Override
    public void onErrorMessage(String message) {
        Log.d(TAG, "onErrorMessage: "+message);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
