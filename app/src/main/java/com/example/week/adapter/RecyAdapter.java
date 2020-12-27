package com.example.week.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.week.R;
import com.example.week.data.ItemBean;

import java.util.ArrayList;

public class RecyAdapter extends DelegateAdapter.Adapter {

    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<ItemBean.DataDTO.TopicListDTO> topicList;

    public RecyAdapter(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<ItemBean.DataDTO.TopicListDTO> topicList) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.topicList = topicList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_recy, null, false);
        return new RecyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyViewHolder recyViewHolder = (RecyViewHolder) holder;

        recyViewHolder.recycler.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        com.example.week.adapter.RecyclAdapter adapter = new com.example.week.adapter.RecyclAdapter(context, topicList);
        recyViewHolder.recycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class RecyViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView recycler;
        public RecyViewHolder(View view) {
            super(view);
            recycler = itemView.findViewById(R.id.recyclerview_hor);
        }
    }
}
