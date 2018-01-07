package java.tutorials.zhadyrassyn.com.javatutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.tutorials.zhadyrassyn.com.javatutorials.adapters.ChapterAdapter;
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

        ChapterAdapter adapter = new ChapterAdapter(chapterList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
    }
}
