package com.Acmegrade.onlineshopping.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.Acmegrade.onlineshopping.CustomListAdapter;
import com.Acmegrade.onlineshopping.CustomListPOJO;
import com.Acmegrade.onlineshopping.R;
import com.Acmegrade.onlineshopping.databinding.FragmentCartBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    int flag=1;
    ListView lv;
    CustomListAdapter adapter;
    public ArrayList<CustomListPOJO> arr;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        CartViewModel cartViewModel =
//                new ViewModelProvider(this).get(CartViewModel.class);
//
//        binding = FragmentCartBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        View view = inflater.inflate(R.layout.fragment_cart, container, false);



        arr=new ArrayList<CustomListPOJO>();
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        lv=view.findViewById(R.id.listview_cart);
//        //Defining object
//        arr=new ArrayList<CustomListPOJO>();
//
//        arr.add(new CustomListPOJO(R.drawable.chess,"LEVI'S","White women t-shirt","Rs.1050"));
//        arr.add(new CustomListPOJO(R.drawable.candy_crush,"CELLO","Water bottles-4","Rs.1750"));
//        arr.add(new CustomListPOJO(R.drawable.cricket,"CELLO","Water bottles-4","Rs.1750"));
//
        return view;

//        final TextView textView = binding.textCart;
//        cartViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        adapter = new CustomListAdapter(, getContext(),1);
//        lv.setAdapter(adapter);

        Button btn = view.findViewById(R.id.place_order);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Your order has successfully placed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
