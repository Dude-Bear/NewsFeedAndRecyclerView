package com.example.android.newsfeedandrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context mContext;
    private List<News> newsList;
    private NewsAdapter mAdapter;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, author, section, date;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
            section = (TextView) view.findViewById(R.id.section);
            date = (TextView) view.findViewById(R.id.date);
        }
    }


    public NewsAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.author.setText(news.getAuthor());
        holder.section.setText(news.getSection());
        holder.date.setText(news.getDate());




//        mAdapter = new NewsAdapter(new ArrayList<News>(), new NewsAdapter.OnItemClickListener() {
//            @Override public void onItemClick(News news) {
//                String url = news.getUrl();
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });

//        holder.title.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String url = news.getUrl();
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
    }



    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
