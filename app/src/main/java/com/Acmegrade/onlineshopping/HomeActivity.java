package com.Acmegrade.onlineshopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.Acmegrade.onlineshopping.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent= getIntent();


        NavigationView navigationview = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationview.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.account_name);
        TextView navUseremail = (TextView) headerView.findViewById(R.id.account_email);

        //from LoginActivity
        navUsername.setText(intent.getStringExtra("Name"));
        navUseremail.setText(intent.getStringExtra("Email"));


//        String n = intent.getStringExtra("Name");
//        Bundle bundle = new Bundle();
//        bundle.putString("username", n);
//        AccountInformationFragment fragment = new AccountInformationFragment();
//        fragment.setArguments(bundle);

//        txt = (TextView) findViewById(R.id.user_NAME);
//        viewModel = new ViewModelProvider(this).get(AccountInformationViewModel.class);
//        viewModel.getSelectedItem().observe(this, item ->{
//            txt.setText(item);
//        });


        //For NAME and EMAIL in AccountInformationFragment
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("username",intent.getStringExtra("Name"));
        myEdit.putString("email",intent.getStringExtra("Email"));
        myEdit.apply();


        setSupportActionBar(binding.appBarHome.toolbar);


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account_information, R.id.nav_cart, R.id.nav_sign_out)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}






