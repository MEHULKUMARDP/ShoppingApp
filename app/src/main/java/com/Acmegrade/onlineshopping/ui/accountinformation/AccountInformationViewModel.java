package com.Acmegrade.onlineshopping.ui.accountinformation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountInformationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AccountInformationViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is account information fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
