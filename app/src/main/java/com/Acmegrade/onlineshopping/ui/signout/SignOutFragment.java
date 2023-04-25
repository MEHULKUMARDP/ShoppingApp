package com.Acmegrade.onlineshopping.ui.signout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.Acmegrade.onlineshopping.LoginActivity;
import com.Acmegrade.onlineshopping.databinding.FragmentSignOutBinding;

public class SignOutFragment extends Fragment {

    private FragmentSignOutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        SignOutViewModel signOutViewModel =
//                new ViewModelProvider(this).get(SignOutViewModel.class);
//
        binding = FragmentSignOutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//
//        final TextView textView = binding.textSignOut;
//        signOutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //sign out and go to Login page or LoginActivity
        Intent intent = new Intent(getContext(), LoginActivity.class);

        //It is used to configure an intent that launches a new activity and clears any existing activities on the back stack.
        //Intent.FLAG_ACTIVITY_NEW_TASK - This flag is used to create a new task for the activity.
        //Intent.FLAG_ACTIVITY_CLEAR_TASK - This flag is used to clear any existing activities on the task before launching the new activity.
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


