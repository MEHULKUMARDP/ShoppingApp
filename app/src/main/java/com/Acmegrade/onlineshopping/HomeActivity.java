package com.Acmegrade.onlineshopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.Acmegrade.onlineshopping.ui.accountinformation.AccountInformationFragment;
import com.Acmegrade.onlineshopping.ui.accountinformation.AccountInformationViewModel;
import com.Acmegrade.onlineshopping.ui.cart.CartFragment;
import com.Acmegrade.onlineshopping.ui.home.HomeFragment;
import com.Acmegrade.onlineshopping.ui.signout.SignOutFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.Acmegrade.onlineshopping.databinding.ActivityHomeBinding;

import java.util.ArrayList;

//implements NavigationView.OnNavigationItemSelectedListener
public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    TextView txt;
    private AccountInformationViewModel viewModel;




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




//   ACMEGRADE
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("Home");
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_home);
//        actionBar.setDisplayHomeAsUpEnabled(true);







//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
//        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
//
//
//        navigationview.setNavigationItemSelectedListener(this);
//        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new HomeFragment());
//
//
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        if(savedInstanceState==null)
//        {
//            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new HomeFragment()).commit();
//            navigationview.setCheckedItem(R.id.nav_home);
//        }


//        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId())
//                {
//                    case R.id.nav_home:
//                        Toast.makeText(HomeActivity.this, "home open", Toast.LENGTH_SHORT).show();
//                        lv=(ListView) findViewById(R.id.listview);
//                        //Defining object
//                        arr=new ArrayList<CustomListPOJO>();
//
//                        arr.add(new CustomListPOJO(R.drawable.chess,"CELLO","Water bottles-4","Rs.1750"));
//                        arr.add(new CustomListPOJO(R.drawable.candy_crush,"CELLO","Water bottles-4","Rs.1750"));
//                        arr.add(new CustomListPOJO(R.drawable.cricket,"CELLO","Water bottles-4","Rs.1750"));
//                        adapter = new CustomListAdapter(arr,HomeActivity.this);
//                        lv.setAdapter(adapter);
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                    case R.id.nav_account_information:
//                        Toast.makeText(HomeActivity.this, "account information open", Toast.LENGTH_SHORT).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                    case R.id.nav_cart:
//                        Toast.makeText(HomeActivity.this, "cart open", Toast.LENGTH_SHORT).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                    case R.id.nav_sign_out:
//                        Toast.makeText(HomeActivity.this, "sign out open", Toast.LENGTH_SHORT).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                }
//                return true;
//            }
//        });
    }


    /*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_home:


                ListView lv;
                CustomListAdapter adapter;
                ArrayList<CustomListPOJO> arr;

                lv=(ListView) findViewById(R.id.listview);
                //Defining object
                arr=new ArrayList<CustomListPOJO>();

                arr.add(new CustomListPOJO(R.drawable.chess,"CELLO","Water bottles-4","Rs.1750"));
                arr.add(new CustomListPOJO(R.drawable.candy_crush,"CELLO","Water bottles-4","Rs.1750"));
                arr.add(new CustomListPOJO(R.drawable.cricket,"CELLO","Water bottles-4","Rs.1750"));
                adapter = new CustomListAdapter(arr,HomeActivity.this);
                lv.setAdapter(adapter);


                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new HomeFragment()).commit();
                break;

            case R.id.nav_account_information:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new AccountInformationFragment()).commit();
                break;

            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new CartFragment()).commit();
                break;

            case R.id.nav_sign_out:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_home,new SignOutFragment()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/


    //   ACMEGRADE
 //   @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_home_drawer,menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    //   ACMEGRADE
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id=item.getItemId();
//
//        if(id==R.id.nav_home)
//        {
//
//        } else if (id==R.id.nav_account_information) {
//            Intent accountIntent = new Intent(HomeActivity.this,AccountInformationFragment.class);
//            startActivity(accountIntent);
//        } else if (id==R.id.nav_cart) {
//            Intent cartIntent = new Intent(HomeActivity.this,CartFragment.class);
//            startActivity(cartIntent);
//        } else if (id==R.id.nav_sign_out) {
//            Intent signoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
//        signoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(signoutIntent);
//
//        }
//
//        DrawerLayout drawerLayout1 = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawerLayout1.closeDrawer(GravityCompat.START);
//        return true;
//    }
}






