package rikkei.academy.model;

import java.util.List;

public class Song {
    private int id;
    private String singer;
    private List<Category> category;
    private String song;

    public Song() {
    }

    public Song(int id, String singer, List<Category> category, String song) {
        this.id = id;
        this.singer = singer;
        this.category = category;
        this.song = song;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", singer='" + singer + '\'' +
                ", category=" + category +
                ", song='" + song + '\'' +
                '}';
    }
}