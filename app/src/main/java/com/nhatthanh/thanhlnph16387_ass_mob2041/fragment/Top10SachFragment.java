package com.nhatthanh.thanhlnph16387_ass_mob2041.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhatthanh.thanhlnph16387_ass_mob2041.R;
import com.nhatthanh.thanhlnph16387_ass_mob2041.adapter.Top10SachAdapter;
import com.nhatthanh.thanhlnph16387_ass_mob2041.dao.ThongKeDao;
import com.nhatthanh.thanhlnph16387_ass_mob2041.model.Top;

import java.util.ArrayList;
import java.util.List;

public class Top10SachFragment extends Fragment {
    private List<Top> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private Top10SachAdapter adapter;
    private ThongKeDao thongKeDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top10_sach, container, false);
        thongKeDao=new ThongKeDao(getContext());
        list=thongKeDao.getTop();
        recyclerView=view.findViewById(R.id.rv_data_top10sach);
        adapter=new Top10SachAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
}