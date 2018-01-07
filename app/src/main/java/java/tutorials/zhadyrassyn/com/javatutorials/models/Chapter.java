package java.tutorials.zhadyrassyn.com.javatutorials.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 07.01.2018.
 */

public class Chapter {
    public int id;
    public String name;
    public List<SubChapter> subChapterList = new ArrayList<>();

    public Chapter() {}

    public Chapter(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
