package com.example.poojakumari.fragmentlab;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentOne extends Fragment {

    public ArrayList<String> list;
    private ListView lv;
    private View view;
    private Intent in;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_fragment_one,container,false);
        lv= view.findViewById(R.id.listView);
        list = new ArrayList<String>();

        for(int i=0;i<20;i++)
        {
            list.add("Student id "+i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,list);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                Toast.makeText(getActivity(),""+selectedItem,Toast.LENGTH_LONG).show();
               in = new Intent(container.getContext(),ThirdActivity.class);

                in.putExtra("data",""+selectedItem);
                getActivity().startActivity(in);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(),"on activity create",Toast.LENGTH_LONG).show();
    }
}
