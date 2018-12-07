package com.example.aryparamartha.printit.User.MainMenu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryparamartha.printit.R;

import java.util.ArrayList;

public class FileAdapter extends RecyclerView.Adapter <FileAdapter.FileViewHolder> {
    private ArrayList<FileItem> mFileList;
    private OnItemClickedListener mListener;

    public interface OnItemClickedListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickedListener listener){
        mListener = listener;
    }

    public static class FileViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public FileViewHolder(@NonNull View itemView, final OnItemClickedListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextView1 = itemView.findViewById(R.id.nama_file);
            mTextView2 = itemView.findViewById(R.id.detail_file);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public FileAdapter(ArrayList<FileItem> fileList){
        mFileList = fileList;
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.file_item, viewGroup, false);
        FileViewHolder fvh = new FileViewHolder(v, mListener);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder fileViewHolder, int i) {
        FileItem currentItem = mFileList.get(i);

        fileViewHolder.mImageView.setImageResource(R.drawable.file);
        fileViewHolder.mTextView1.setText(currentItem.getmNamaFile());
        fileViewHolder.mTextView2.setText(currentItem.getmDetailFile());
    }

    @Override
    public int getItemCount() {
        return mFileList.size();
    }
}
