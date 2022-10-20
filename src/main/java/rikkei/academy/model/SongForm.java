package rikkei.academy.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SongForm {
    private int id;
    private String singer;
    private List<Integer> category;
    private MultipartFile song;

    public SongForm() {
    }

    public SongForm(int id, String singer, List<Integer> category, MultipartFile song) {
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

    public List<Integer> getCategory() {
        return category;
    }

    public void setCategory(List<Integer> category) {
        this.category = category;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "SongForm{" +
                "id=" + id +
                ", singer='" + singer + '\'' +
                ", category=" + category +
                ", song=" + song +
                '}';
    }
}