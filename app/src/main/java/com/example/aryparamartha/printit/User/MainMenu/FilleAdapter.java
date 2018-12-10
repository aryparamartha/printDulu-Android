package com.example.aryparamartha.printit.User.MainMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.UserTrans;

import java.util.List;

public class FilleAdapter extends RecyclerView.Adapter<FilleAdapter.ViewHolder> {
    private Context context;
    private List<UserTrans> transList;
    private OnClickListener onClickListener;


    public interface OnClickListener{
        void onClick(int position);
    }

    public FilleAdapter(Context context, List<UserTrans> transList) {
        this.context = context;
        this.transList = transList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.file_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        UserTrans userTrans = transList.get(i);
        viewHolder.bind(userTrans);
    }

    @Override
    public int getItemCount() {
        return transList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextView1 = itemView.findViewById(R.id.nama_file);
            mTextView2 = itemView.findViewById(R.id.detail_file);
            if (onClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onClick(getAdapterPosition());
                    }
                });
            }
        }

        public void bind(UserTrans userTrans) {
            mTextView1.setText(userTrans.getNamaFile());
            mTextView2.setText(userTrans.getFormatFile());
            mImageView.setImageResource(R.drawable.file);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}
