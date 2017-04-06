package paul.develops.ta.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import paul.develops.ta.Activity.AnggotaKeluarga.ListKeluargaActivity;
import paul.develops.ta.Activity.ListTempatActivity;
import paul.develops.ta.Activity.MainActivity;
import paul.develops.ta.Activity.TubuhActivity;
import paul.develops.ta.Activity.TumbuhanActivity;
import paul.develops.ta.Models.MainDetail;
import paul.develops.ta.R;


/**
 * Created by paulms on 12/6/2016.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<MainDetail> mainList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public MainAdapter(Context mContext, List<MainDetail> mainList) {
        this.mContext = mContext;
        this.mainList = mainList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_title, parent, false);
        itemView.setBackgroundResource(R.color.colorPrimary);

        //animationforimg
        TranslateAnimation animation = new TranslateAnimation(0.0f, 15.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(1000);  // animation duration
        animation.setRepeatCount(Animation.INFINITE);  // animation repeat count
        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        itemView.startAnimation(animation);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MainDetail main = mainList.get(position);
        holder.title.setText(main.getName());
        // loading album cover using Glide library
        Glide.with(mContext).load(main.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, holder.title.getText(), Toast.LENGTH_SHORT).show();
                if(holder.title.getText().equals("Hewan")){
                    Intent hewanIntent = new Intent(mContext, ListTempatActivity.class);
                    mContext.startActivity(hewanIntent);
                }
                if(holder.title.getText().equals("Tanaman")){
                    Intent hewanIntent = new Intent(mContext, TumbuhanActivity.class);
                    mContext.startActivity(hewanIntent);
                }
                if(holder.title.getText().equals("Anggota Tubuh")){
                    Intent hewanIntent = new Intent(mContext, TubuhActivity.class);
                    mContext.startActivity(hewanIntent);
                }
                if(holder.title.getText().equals("Keluarga")){
                    Intent hewanIntent = new Intent(mContext, ListKeluargaActivity.class);
                    mContext.startActivity(hewanIntent);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return mainList.size();
    }


}
