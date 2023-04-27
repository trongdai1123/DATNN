package com.example.appbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appbanhang.R;
import com.example.appbanhang.model.Item;
import com.example.appbanhang.utils.Utils;

import org.w3c.dom.Text;

import java.util.List;

public class ChitietAdapter extends RecyclerView.Adapter<ChitietAdapter.MyviewHolder> {
    Context context;
    List<Item> itemList;

    public ChitietAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;

    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chitiet,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.txtten.setText(item.getTensp());
        holder.txtsoluong.setText("Số Lượng: "+item.getSoluong());
        holder.txtgia.setText("Giá: "+item.getGia());
        if (item.getHinhanh().contains("http")){
            Glide.with(context).load(item.getHinhanh()).into(holder.imageChitiet);
        }else {
            String hinh = Utils.BASE_URL+"images/" + item.getHinhanh();
            Glide.with(context).load(hinh).into(holder.imageChitiet);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        ImageView imageChitiet;
        TextView txtten, txtsoluong, txtgia;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageChitiet = itemView.findViewById(R.id.item_imgchitiet);
            txtten = itemView.findViewById(R.id.item_tenspchitiet);
            txtsoluong = itemView.findViewById(R.id.item_soluongchitiet);
            txtgia = itemView.findViewById(R.id.item_giachitiet);
        }
    }
}
