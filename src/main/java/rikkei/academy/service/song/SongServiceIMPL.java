package rikkei.academy.service.song;

import rikkei.academy.model.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceIMPL implements ISongService {

    private static Map<Integer, Song> songs = new HashMap<>();
    private static int lastId = 0;

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songs.values());
    }

    @Override
    public void save(Song song) {
        song.setId(++lastId);
        songs.put(song.getId(), song);
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void update(int id, Song song) {
        songs.put(id, song);
    }

    @Override
    public void remove(int id) {
        songs.remove(id);
    }
}