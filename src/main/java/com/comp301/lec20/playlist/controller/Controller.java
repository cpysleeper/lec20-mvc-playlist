package com.comp301.lec20.playlist.controller;

import com.comp301.lec20.playlist.model.Song;

public interface Controller {
  Song getSong(int index);

  int getNumSongs();

  void moveSongUp(int index);

  void moveSongDown(int index);

  void addSong(String title, String artist, int rating);

  void removeSong(int index);

  void shuffleSongs();
}
