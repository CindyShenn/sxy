package com.example.myproject;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class GroupListFragment extends Fragment {
    private FragmentManager fManager;
    private ArrayList<Group> groups;
    private ListView list_group;
    private ImageButton like;
    private int flag=0;

    private MyAdapter<Group> myAdapter=null;
    private List<Group> mData= null;

    public GroupListFragment(FragmentManager fManager,ArrayList<Group> groups){
        this.fManager = fManager;
        this.groups = groups;
    }

    public GroupListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_grouplist, container, false);
        //View View1 = inflater.inflate(R.layout.item_one, container, false);
        list_group=(ListView) view.findViewById(R.id.list_group);
        //like = (ImageButton)getActivity().findViewById(R.id.Like);
        init();
        return view;
    }

    private  void init(){
        //数据初始化
        mData = new ArrayList<Group>();
        mData.add(new Group("Tag","TestName","TestAddress","TestTag1","TestTag2",R.drawable.img3));
        //Adapter初始化
        myAdapter = new MyAdapter<Group>((ArrayList)mData,R.layout.item_one) {
            @Override
            public void bindView(ViewHolder holder, Group obj) {
                //like = (ImageButton) LayoutInflater.from(MainActivity.this).inflate(R.layout.item_one, null).findViewById(R.id.Like);
                //like = (ImageButton)getActivity().findViewById(R.id.Like);;
                like = holder.getView(R.id.Like);
                holder.setImageResource(R.id.Group_image,obj.getaImage());
                holder.setText(R.id.Group_name,obj.getaName());
                holder.setText(R.id.Group_address,obj.getaAddress());
                holder.setText(R.id.Group_type,obj.getaType());
                holder.setText(R.id.Group_tag1,obj.getaTag1());
                holder.setText(R.id.Group_tag2,obj.getaTag2());
                holder.setOnClickListener(R.id.Group_image, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent1 = new Intent();
                                //创建组件，通过组件来响应
                                ComponentName component = new ComponentName(getActivity(), DetailActivity.class);
                                intent1.setComponent(component);
                                startActivity(intent1);
                            }
                        });
                holder.setOnClickListener(R.id.Like, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(flag==1)
                        {
                            like.setBackgroundResource(R.drawable.ic_star1);
                            flag=0;
                        }
                        else
                        {
                            like.setBackgroundResource(R.drawable.ic_star2);
                            flag=1;
                        }
                    }
                });
            }
        };
        //ListView设置下Adapter
        list_group.setAdapter(myAdapter);

    }

}
