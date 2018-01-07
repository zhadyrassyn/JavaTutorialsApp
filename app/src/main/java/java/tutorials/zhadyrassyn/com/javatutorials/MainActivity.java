package java.tutorials.zhadyrassyn.com.javatutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.tutorials.zhadyrassyn.com.javatutorials.adapters.ChapterAdapter;
import java.tutorials.zhadyrassyn.com.javatutorials.interfaces.RecyclerViewClickListener;
import java.tutorials.zhadyrassyn.com.javatutorials.models.Chapter;
import java.tutorials.zhadyrassyn.com.javatutorials.models.SubChapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Chapter> chapterList = new ArrayList<>();
    AtomicInteger chapterCounter = new AtomicInteger();
    AtomicInteger subChapterCounter = new AtomicInteger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position, LinearLayout subChapterLayout) {
                if(subChapterLayout.getVisibility() == View.GONE) {
                    subChapterLayout.setVisibility(View.VISIBLE);
                } else {
                    subChapterLayout.setVisibility(View.GONE);
                }
            }
        };
        ChapterAdapter adapter = new ChapterAdapter(chapterList, this, listener);
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        Chapter chapter1 = new Chapter();
        chapter1.id = chapterCounter.incrementAndGet();
        chapter1.name = String.format("Chapter %d: Introduction to Java", chapter1.id);

        SubChapter subChapter11 = new SubChapter();
        subChapter11.id = subChapterCounter.incrementAndGet();
        subChapter11.name = "Data types";
        SubChapter subChapter12 = new SubChapter();
        subChapter12.id = subChapterCounter.incrementAndGet();
        subChapter12.name = "Variables";

        chapter1.subChapterList.add(subChapter11);
        chapter1.subChapterList.add(subChapter12);

        chapterList.add(chapter1);


        Chapter chapter2 = new Chapter();
        chapter2.id = chapterCounter.incrementAndGet();
        chapter2.name = String.format("Chapter %d. Objects and classes", 2);

        SubChapter subChapter21 = new SubChapter();
        subChapter21.id = subChapterCounter.incrementAndGet();
        subChapter21.name = "Intro to OOP";
        SubChapter subChapter22 = new SubChapter();
        subChapter22.id = subChapterCounter.incrementAndGet();
        subChapter22.name = "Classes";
        SubChapter subChapter23 = new SubChapter();
        subChapter23.id = subChapterCounter.incrementAndGet();
        subChapter23.name = "Static fields and methods";

        chapter2.subChapterList.add(subChapter21);
        chapter2.subChapterList.add(subChapter22);
        chapter2.subChapterList.add(subChapter23);

        chapterList.add(chapter2);
    }
}
