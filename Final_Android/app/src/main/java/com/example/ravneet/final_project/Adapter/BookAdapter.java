package com.example.ravneet.final_project.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ravneet.final_project.Interface.OnItemClickListner;
import com.example.ravneet.final_project.Model.Book;
import com.example.ravneet.final_project.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ravneet on 9/7/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private Context context;
    private ArrayList<Book> booklist;
    private OnItemClickListner onItemClickListner;

    public void setOnItemClickListener(OnItemClickListner onItemClickListener) {
        this.onItemClickListner = onItemClickListener;
    }

    public BookAdapter(Context context,ArrayList<Book> booklist){
        this.booklist = booklist;
        this.context = context;
    }

    public void updateAlbum(ArrayList<Book> booklist){
        this.booklist = booklist;
        notifyDataSetChanged();
    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_view,parent,false);

        return new BookViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {

        final Book thisbook = booklist.get(position);
        holder.bookname.setText(thisbook.getBookname());
        holder.sellername.setText(thisbook.getSellername());
        holder.mobilenumber.setText(thisbook.getMobilenumber());
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListner != null){
                    onItemClickListner.onItemClick(thisbook.getBookid());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return booklist.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        TextView bookname,sellername,mobilenumber;
        View thisview;

        public BookViewHolder(View itemView) {
            super(itemView);

            thisview = itemView;
            bookname = (TextView) itemView.findViewById(R.id.tv_bookname);
            sellername = (TextView) itemView.findViewById(R.id.tv_seller);
            mobilenumber = (TextView) itemView.findViewById(R.id.tv_mobilenumber);

        }
    }
}
