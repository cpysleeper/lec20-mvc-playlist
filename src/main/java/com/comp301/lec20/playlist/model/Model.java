package com.comp301.lec20.playlist.model;

public interface Model {
  Song getSong(int index);
  void addSong(Song song);
  void removeSong(int index);
  void moveSong(int oldIndex, int newIndex);
  void shuffleSongs();

  int getNumSongs();

  void addObserver(ModelObserver observer);
  void removeObserver(ModelObserver observer);
}
