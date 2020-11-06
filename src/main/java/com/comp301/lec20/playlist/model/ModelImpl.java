package com.comp301.lec20.playlist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelImpl implements Model {
  private List<Song> songs;
  private List<ModelObserver> observers;

  public ModelImpl(List<Song> songs) {
    this.songs = new ArrayList<>(songs);
    this.observers = new ArrayList<>();
  }

  public ModelImpl() {
    this.songs = new ArrayList<>();
    this.observers = new ArrayList<>();
  }

  @Override
  public Song getSong(int index) {
    return songs.get(index);
  }

  @Override
  public void addSong(Song song) {
    songs.add(song);
    notifyObservers();
  }

  @Override
  public void removeSong(int index) {
    songs.remove(index);
    notifyObservers();
  }

  @Override
  public void moveSong(int oldIndex, int newIndex) {
    Song song = songs.remove(oldIndex);
    songs.add(newIndex, song);
    notifyObservers();
  }

  @Override
  public void shuffleSongs() {
    Collections.shuffle(songs);
    notifyObservers();
  }

  @Override
  public int getNumSongs() {
    return songs.size();
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (ModelObserver observer : observers) {
      observer.update(this);
    }
  }
}
