package com.Acmegrade.onlineshopping.ui.accountinformation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.Acmegrade.onlineshopping.R;
import com.Acmegrade.onlineshopping.databinding.FragmentAccountInformationBinding;

public class AccountInformationFragment extends Fragment {

    private FragmentAccountInformationBinding binding;

    TextView txt_name, txt_email, txt_NAME, txt_EMAIL;
    String USERNAME;
    AccountInformationViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        AccountInformationViewModel accountInformationViewModel =
//                new ViewModelProvider(this).get(AccountInformationViewModel.class);
//
//        binding = FragmentAccountInformationBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
          View view = inflater.inflate(R.layout.fragment_account_information,container,false);
          txt_NAME = view.findViewById(R.id.user_NAME);
          txt_EMAIL = view.findViewById(R.id.user_EMAIL);
          txt_name = view.findViewById(R.id.user_name);
          txt_email = view.findViewById(R.id.user_email);
//        Bundle bundle = getArguments();
//
//
//            USERNAME = bundle.getString("username");
//            txt_name.setText(USERNAME);


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        txt_name.setText(sharedPreferences.getString("username",""));
        txt_NAME.setText(sharedPreferences.getString("username",""));
        txt_email.setText(sharedPreferences.getString("email",""));
        txt_EMAIL.setText(sharedPreferences.getString("email",""));

        return view;
//
//
//
//        //final TextView textView = binding.textAccountInformation;
//        //accountInformationViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
       // return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        viewModel = new ViewModelProvider(requireActivity()).get(AccountInformationViewModel.class);
//        txt_name = view.findViewById(R.id.user_NAME);
//        TextView textView = view.findViewById(R.id.account_name);
//        viewModel.setData(textView.getText().toString());

        Button btn = view.findViewById(R.id.back_to_home);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
