package com.example.kca_student_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kca_student_app.StudentModel.StudentModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {


    Context context;
    List<StudentModel> studentModelList;

    //comstractor

    public StudentAdapter(Context context, List<StudentModel> studentModelList) {
        this.context = context;
        this.studentModelList = studentModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.desgin_row_for_recyclerview,parent);

        //design row connectivity here

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // here we will bind it

        StudentModel studentModel = studentModelList.get(position);
        holder.tvFirst.setText("First Name=" + studentModel.getFirstName());
        holder.tvLast.setText("Last Name=" + studentModel.getLastName());

        String imageUri =null;
        imageUri=studentModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //here declare design
        ImageView imageView;
        TextView tvFirst,tvLast;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_recyclerview_id);
            tvFirst = itemView.findViewById(R.id.tvFirstName_recyclerview_id);
            tvLast = itemView.findViewById(R.id.tvLastNmae_recyclerview_id);
        }
    }
}
