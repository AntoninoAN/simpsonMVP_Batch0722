package com.example.rxjavatest.view;

import com.example.rxjavatest.model.SimpsonCharacter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ViewContract {
    void onBindPresenter();
    void initUI();
    void onDataPopulated(ArrayList<SimpsonCharacter> data);
    void onErrorMessage(String message);
}
