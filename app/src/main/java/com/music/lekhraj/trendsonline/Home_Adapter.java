package com.music.lekhraj.trendsonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.music.lekhraj.trendsonline.Models.Products_detilas;

import java.util.List;

public class Home_Adapter extends  RecyclerView.Adapter<Home_Adapter.CustomViewHolder> {

private List<Products_detilas> dataList;
private Context context;

public Home_Adapter(Context context,List<Products_detilas> dataList){
        this.context = context;
        this.dataList = dataList;
        }

class CustomViewHolder extends RecyclerView.ViewHolder {

    public final View mView;

    TextView txtTitle;
    private ImageView coverImage;

    CustomViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        txtTitle = mView.findViewById(R.id.item_name);
        //coverImage = mView.findViewById(R.id.coverImage);
    }
}

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.home_child_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getName());

       /* Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);*/

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
