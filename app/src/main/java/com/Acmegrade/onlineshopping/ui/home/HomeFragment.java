package com.Acmegrade.onlineshopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.Acmegrade.onlineshopping.CustomListAdapter;
import com.Acmegrade.onlineshopping.CustomListPOJO;
import com.Acmegrade.onlineshopping.HomeActivity;
import com.Acmegrade.onlineshopping.R;
import com.Acmegrade.onlineshopping.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    ListView lv;
    CustomListAdapter adapter;
    ArrayList<CustomListPOJO> arr;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        View view = inflater.inflate(R.layout.fragment_home, container, false);



        lv=view.findViewById(R.id.listview_home);
        //Defining object
        arr=new ArrayList<CustomListPOJO>();

        arr.add(new CustomListPOJO(R.drawable.chess,"LEVI'S","White women t-shirt","Rs.1050"));
        arr.add(new CustomListPOJO(R.drawable.candy_crush,"CELLO","Water bottles-4","Rs.1750"));
        arr.add(new CustomListPOJO(R.drawable.cricket,"CELLO","Water bottles-4","Rs.1750"));


        return view;

        //return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new CustomListAdapter(arr, getContext(), 0);
        lv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}