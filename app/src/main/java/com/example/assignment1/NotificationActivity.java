package com.example.assignment1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.LinkedList;

public class NotificationActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private AlertDialog.Builder builder ;
    private  AlertDialog alertDialog ;
    private EditText name , username , email , address , phone ;
private ImageView image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Nofitications");
        recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        LinkedList<NotificationItem>list = new LinkedList<>() ;
        list.add(new NotificationItem(R.drawable.pizza , new Date().toString() , new Date().toString() , "o " , "Tareq khanfar1"));
        list.add(new NotificationItem(R.drawable.pizza , new Date().toString() , new Date().toString() , "UnKnown " , "Tareq khanfar2"));
        list.add(new NotificationItem(R.drawable.pizza , new Date().toString() , new Date().toString() , "Computer2 " , "Tareq khanfar3"));
        list.add(new NotificationItem(R.drawable.pizza , new Date().toString() , new Date().toString() , "Computer3 " , "Tareq khanfar4"));
        list.add(new NotificationItem(R.drawable.pizza , new Date().toString() , new Date().toString() , "Computer4 " , "Tareq khanfar5"));
        list.add(new NotificationItem(R.drawable.pizza , new Date().toString() , new Date().toString() , "Computer5 " , "Tareq khanfar6"));

        MyAdapter adapter = new MyAdapter( list , this) ;
        recyclerView.setAdapter(adapter);
    }

    private void createPopUpForCustomerInfo() {
        builder = new AlertDialog.Builder(this) ;
        final View InfoPopUp = getLayoutInflater().inflate(R.layout.popup_info_customer, null) ;
        name = InfoPopUp.findViewById(R.id.EditName_info) ;
        username = InfoPopUp.findViewById(R.id.EditUserName_info) ;
        email = InfoPopUp.findViewById(R.id.EditEmail_info) ;
        address = InfoPopUp.findViewById(R.id.EditAddress_info) ;
        phone = InfoPopUp.findViewById(R.id.EditPhone_info) ;
       image = InfoPopUp.findViewById(R.id.image_info) ;

        builder.setView(InfoPopUp);
        alertDialog = builder.create() ;
        alertDialog.show();
        name.setText("Tareq khanfar");
        username.setText("tareq_99912");
        phone.setText("0595870228");
        image.setImageResource(R.drawable.image3);
        email.setText("tareqkhanfar29@gmail.com");
        address.setText("Ramallah - Birzeit");

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
        LinkedList<NotificationItem>list = new LinkedList<>() ;
        Context context ;

        public MyAdapter(LinkedList<NotificationItem> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.notification_item ,parent , false );
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.imageView.setImageResource(list.get(position).getImage());
            holder.nameProduct.setText("Product Name : "+list.get(position).getNameOfProduct());
            holder.nameCustomer.setText("Customer Name : "+list.get(position).getNameOfCustomer());
            holder.date.setText("Date : "+list.get(position).getDate());
            holder.time.setText("Time : "+list.get(position).getTime());


        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            CardView card ;
            ImageView imageView ;
            TextView nameCustomer , nameProduct , time , date;

            public Holder(@NonNull View itemView) {
                super(itemView);
                card = itemView.findViewById(R.id.card);
                imageView = itemView.findViewById(R.id.imageNotif) ;
                nameCustomer = itemView.findViewById(R.id.nameOfCustomer) ;
                nameProduct = itemView.findViewById(R.id.nameOfProduct) ;
                time = itemView.findViewById(R.id.time) ;
                date = itemView.findViewById(R.id.date) ;
     card.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             createPopUpForCustomerInfo();
         }
     });


            }
        }
    }

}
