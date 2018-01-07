package java.tutorials.zhadyrassyn.com.javatutorials.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.tutorials.zhadyrassyn.com.javatutorials.R;
import java.tutorials.zhadyrassyn.com.javatutorials.interfaces.RecyclerViewClickListener;
import java.tutorials.zhadyrassyn.com.javatutorials.models.Chapter;
import java.tutorials.zhadyrassyn.com.javatutorials.models.SubChapter;
import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder>{

    public static final String TAG = ChapterAdapter.class.getName();
    RecyclerViewClickListener mListener;

    Context context;
    List<Chapter> chapterList;

    public ChapterAdapter(List<Chapter> chapters, Context context, RecyclerViewClickListener mListener) {
        this.context = context;
        this.chapterList = chapters;
        this.mListener = mListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chapter, parent, false);
        return new MyViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Chapter chapter = chapterList.get(position);
        holder.chapterTitle.setText(chapter.name);
        holder.subChapterLayout.setVisibility(View.GONE);

        for (int i = 0; i < chapter.subChapterList.size(); i++) {
            final TextView tv = new TextView(context);

            SubChapter subChapter = chapter.subChapterList.get(i);

            tv.setText(subChapter.name);
            tv.setTextSize(16);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(30, 0, 0, 10); // llp.setMargins(left, top, right, bottom);
            tv.setLayoutParams(llp);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, tv.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });

            holder.subChapterLayout.addView(tv);


        }

    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView chapterTitle;
        public LinearLayout subChapterLayout;

        private RecyclerViewClickListener mListener;

        public MyViewHolder(View view, RecyclerViewClickListener mListener) {
            super(view);
            chapterTitle = (TextView) view.findViewById(R.id.chapter_title);
            subChapterLayout = (LinearLayout) view.findViewById(R.id.sub_chapter_layout);
            this.mListener = mListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition(), subChapterLayout);
        }
    }
}
