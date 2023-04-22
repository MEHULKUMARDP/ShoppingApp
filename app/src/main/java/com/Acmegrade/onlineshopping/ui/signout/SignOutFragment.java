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

        Intent intent = new Intent(getContext(), LoginActivity.class);
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


