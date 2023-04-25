package com.Acmegrade.onlineshopping;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    ArrayList<CustomListPOJO> al;
    int i;

    //for 10 items, we take arraysize=10
    public static String[] ID = new String[10];
    List<CustomListPOJO> l;
    Context mcontext;
    int FLAG;

    public static ArrayList<CustomListPOJO> ar = new ArrayList<CustomListPOJO>();

    public CustomListAdapter(List<CustomListPOJO> l, Context context, int flag)
    {

        mcontext = context;
        this.l = l;
        this.al = new ArrayList<CustomListPOJO>();
        this.al.addAll(l);
        this.FLAG=flag;
    }



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


            //This is so that the changes are committed when we return to the home fragment from another fragment
            for(i=0;i<ID.length;i++)
            {
                if(Arrays.asList(ID).contains(String.valueOf(getItemId(position))))
                {
                    viewHolder.img2.setColorFilter(Color.GREEN);
                }
                else
                {
                    viewHolder.img2.setColorFilter(Color.RED);
                }
            }


                viewHolder.img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        ID[(int) getItemId(position)] = String.valueOf(getItemId(position));
//                        Toast.makeText(mcontext, String.valueOf(getItemId(position))+"", Toast.LENGTH_SHORT).show();

                        //for item will be add in Cart fragment
                        ar.add(new CustomListPOJO(l.get(position).getImage(),l.get(position).getCompany(),l.get(position).getItem(),l.get(position).getPrice()));
                        viewHolder.img2.setColorFilter(Color.GREEN);

                    }
                });

        }
        catch (Exception ex)
        {

        }
        return convertView;
    }

}
