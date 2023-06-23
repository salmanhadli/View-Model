package com.example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private int counter = 0;

    private MutableLiveData<Integer> counteLiveData = new MutableLiveData<Integer>();

    public MutableLiveData<Integer> getCounter() {
        counteLiveData.setValue(counter);
        return counteLiveData;
    }

    public void incrementCounter() {
        counter++;
        counteLiveData.setValue(counter);
    }
}
