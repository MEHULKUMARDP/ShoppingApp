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

//    private final MutableLiveData<String> selectedItem = new MutableLiveData<String>();
//
//    public void setData(String item)
//    {
//        selectedItem.setValue(item);
//    }
//
//    public LiveData<String> getSelectedItem(){
//        return selectedItem;
//    }
}
