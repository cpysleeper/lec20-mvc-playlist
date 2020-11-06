package com.comp301.lec20.playlist;

import com.comp301.lec20.playlist.model.Song;
import com.comp301.lec20.playlist.model.SongImpl;
import java.util.ArrayList;
import java.util.List;

public class InitialPlaylist {
  private static List<Song> playlist;

  public static List<Song> create() {
    if (playlist == null) {
      playlist = new ArrayList<>();
      playlist.add(new SongImpl("Icky Thump", "The White Stripes", 3));
      playlist.add(new SongImpl("Black Sun", "Death Cab For Cutie", 4));
      playlist.add(new SongImpl("Ocean Eyes", "Billie Eilish", 5));
      playlist.add(new SongImpl("Sic Transit Gloria ... Glory Fades", "Brand New", 4));
      playlist.add(new SongImpl("I'm Not Okay", "My Chemical Romance", 5));
    }
    return playlist;
  }
}
