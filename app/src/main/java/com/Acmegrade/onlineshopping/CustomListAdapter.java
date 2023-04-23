package com.Acmegrade.onlineshopping;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.Acmegrade.onlineshopping.ui.home.HomeFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    ArrayList<CustomListPOJO> al;

  //  ArrayList<SecondCustomListPOJO> ar;

    int i;

    public static String[] ID = new String[10];
    List<CustomListPOJO> l;
    Context mcontext;
    int FLAG;

//    public static ArrayList<SecondCustomListPOJO> ar = new ArrayList<SecondCustomListPOJO>();
      public static ArrayList<CustomListPOJO> ar = new ArrayList<CustomListPOJO>();



    public CustomListAdapter(List<CustomListPOJO> l, Context context, int flag)
    {

        mcontext = context;
        this.l = l;
        this.al = new ArrayList<CustomListPOJO>();
        this.al.addAll(l);
        this.FLAG=flag;
    }

//    public CustomListAdapter()
//    {
//         ar=new ArrayList<SecondCustomListPOJO>();
//    }





    public class ViewHolder
    {
        ImageView img;

        ImageView img2;
        TextView txt1,txt2,txt3;

    }

    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int position) {
        return l.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        //It is ok if we not write if else....but sometime it's produce error nullpointerException because of it take some time to load
        if(convertView==null)
        {
            convertView= LayoutInflater.from(mcontext).inflate(R.layout.customlistviewlayout,null);
            viewHolder =new ViewHolder();
            viewHolder.img=(ImageView) convertView.findViewById(R.id.item_image);
            viewHolder.txt1=(TextView) convertView.findViewById(R.id.company_name);
            viewHolder.txt2=(TextView) convertView.findViewById(R.id.price);
            viewHolder.txt3=(TextView) convertView.findViewById(R.id.item_name);
            viewHolder.img2=(ImageView) convertView.findViewById(R.id.cart_image);


//            ListView listView1 = (ListView) convertView.findViewById(R.id.listview_home);
//
//            ListView listView2 = (ListView) convertView.findViewById(R.id.listview_cart);
//
//            ArrayAdapter<CustomListPOJO> adapter2 = new ArrayAdapter<CustomListPOJO>(mcontext, R.layout.customlistviewlayout);
//            listView2.setAdapter(adapter2);
//
//
//
//            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    // Get the data associated with the clicked item
//                    CustomListPOJO clickedItem = (CustomListPOJO) parent.getItemAtPosition(position);
//
//                    // Add the data to the adapter of the second ListView
//                    adapter2.add(clickedItem);
//
//                    // Refresh the second ListView to show the newly added data
//                    adapter2.notifyDataSetChanged();
//                }
//            });
//            setTag() is a flexible and useful method in Android Studio that allows you to attach custom data or metadata to a view, which can be useful in a variety of scenarios.
//            We can later retrieve this tag using the getTag() method.
            convertView.setTag(viewHolder);
        }

        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        try{
            int image = l.get(position).getImage();
            String cmp = l.get(position).getCompany();
            String prc = l.get(position).getPrice();
            String itm = l.get(position).getItem();


            if(FLAG==0)
            {
                viewHolder.img2.setVisibility(View.VISIBLE);
            }
            else
            {
                viewHolder.img2.setVisibility(View.GONE);
            }

            viewHolder.img.setImageResource(image);
            viewHolder.txt1.setText(cmp);
            viewHolder.txt2.setText(prc);
            viewHolder.txt3.setText(itm);




                viewHolder.img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            //Toast.makeText(mcontext, "You clicked on " + viewHolder.txt1.getText(), Toast.LENGTH_SHORT).show();
                            viewHolder.img2.setColorFilter(Color.GREEN);


                        //    ID[(int) getItemId(position)]= String.valueOf(getItemId(position));

                          //  Log.d("IDD", String.valueOf(getItem(position)));

                            ID[(int) getItemId(position)] = String.valueOf(getItemId(position));


                            Toast.makeText(mcontext, String.valueOf(getItemId(position))+"", Toast.LENGTH_SHORT).show();


                           ar.add(new CustomListPOJO(l.get(position).getImage(),l.get(position).getCompany(),l.get(position).getItem(),l.get(position).getPrice()));


                    }

                });

            for(i=0;i<ID.length;i++)
            {
                if(Arrays.asList(ID).contains(String.valueOf(getItemId(position))))
                {
                    viewHolder.img2.setColorFilter(Color.BLUE);

                }
            }



        }
        catch (Exception ex)
        {

        }
        return convertView;
    }



}
