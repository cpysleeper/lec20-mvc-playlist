package com.comp301.lec20.playlist.controller;

import com.comp301.lec20.playlist.model.Model;
import com.comp301.lec20.playlist.model.Song;
import com.comp301.lec20.playlist.model.SongImpl;

public class ControllerImpl implements Controller {
  private Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public Song getSong(int index) {
    return model.getSong(index);
  }

  @Override
  public int getNumSongs() {
    return model.getNumSongs();
  }

  @Override
  public void moveSongUp(int index) {
    if (index > 0) {
      model.moveSong(index, index - 1);
    }
  }

  @Override
  public void moveSongDown(int index) {
    if (index + 1 < model.getNumSongs()) {
      model.moveSong(index, index + 1);
    }
  }

  @Override
  public void addSong(String title, String artist, int rating) {
    if (rating >= 0 && rating <= 5) {
      model.addSong(new SongImpl(title, artist, rating));
    }
  }

  @Override
  public void removeSong(int index) {
    if (index >= 0 && index < model.getNumSongs()) {
      model.removeSong(index);
    }
  }

  @Override
  public void shuffleSongs() {
    model.shuffleSongs();
  }
}
