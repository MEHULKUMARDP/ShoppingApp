package com.Acmegrade.onlineshopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Acmegrade.onlineshopping.CustomListAdapter;
import com.Acmegrade.onlineshopping.CustomListPOJO;
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

        arr.add(new CustomListPOJO(R.drawable.kent,"KENT","Hand Blender 300 W","Rs.1,249"));
        arr.add(new CustomListPOJO(R.drawable.bajaj,"BAJAJ","DX-6 1000W Dry Iron","Rs.625"));
        arr.add(new CustomListPOJO(R.drawable.zexer,"ZEXER","Men Compression T-shirt","Rs.339"));
        arr.add(new CustomListPOJO(R.drawable.titan,"TITAN","White Wall Clock","Rs.1,294"));
        arr.add(new CustomListPOJO(R.drawable.jaico,"JAICO","The Theory Of Everything","Rs.169"));
        arr.add(new CustomListPOJO(R.drawable.havells,"HAVELLS","1200mm Ambrose Energy Saving Ceiling Fan","Rs.2,325"));
        arr.add(new CustomListPOJO(R.drawable.butterfly,"BUTTERFLY","Smart Glass 3 Burner Gas Stove, Black","Rs.3,099"));
        arr.add(new CustomListPOJO(R.drawable.mark_louiis,"MARK LOUIIS","Men's Regular Fit Track pants","Rs.616"));
        arr.add(new CustomListPOJO(R.drawable.boat,"BOAT","Wave Lite Smartwatch","Rs.1,499"));
        arr.add(new CustomListPOJO(R.drawable.apple,"APPLE","iPhone 14 Pro (128 GB) - Deep Purple","Rs.1,19,999"));

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