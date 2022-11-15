package com.example.cuoi_ki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.cuoi_ki.Adapter.ListViewAdapter;
import com.example.cuoi_ki.Model.Police;

import java.util.ArrayList;
import java.util.List;

public class ListInformationPolice extends AppCompatActivity {
    ListView listView;
    private ListViewAdapter adapter;
    private List<Police> list;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_information_police);


        init();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    logout();
            }
        });
    }

    private void init(){
        listView=findViewById(R.id.listView);
        imgBack=findViewById(R.id.imgBack);


        list = new ArrayList<>();
        getData();
        adapter = new ListViewAdapter(list,this,R.layout.item_police);
        listView.setAdapter(adapter);

    }
    private void logout(){
        Intent i = new Intent(ListInformationPolice.this,MainActivity.class);
        startActivity(i);
    }
    private void getData(){
        list.add(new Police(1,"Nguyễn Vân Anh","Đà nẵng","Việt Nam",4,R.drawable.police_avatar_1,"Thượng sĩ"));
        list.add(new Police(2,"Nguyễn Hồng Nhung","TP HCM","Việt Nam",1,R.drawable.police_avatar_2,"Đại tá"));
        list.add(new Police(3,"Nguyễn Thu Uyên","Nha Trang","Việt Nam",2,R.drawable.police_avatar_3,"Đại úy"));
        list.add(new Police(4,"Nguyễn Yến Nhi","Đà nẵng","Việt Nam",3,R.drawable.police_avatar_4,"Trung úy"));
        list.add(new Police(5,"Nguyễn Trà My","Đăk Nông","Việt Nam",5,R.drawable.police_avatar_5,"Thiếu tá"));
        list.add(new Police(6,"Nguyễn Thanh Thư","Đà nẵng","Việt Nam",2,R.drawable.police_avatar_6,"Thượng sĩ"));

    }
}