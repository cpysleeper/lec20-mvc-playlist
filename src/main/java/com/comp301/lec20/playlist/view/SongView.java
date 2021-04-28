package com.comp301.lec20.playlist.view;

import com.comp301.lec20.playlist.controller.Controller;
import com.comp301.lec20.playlist.model.Song;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SongView implements FXComponent {
  private final Controller controller;
  private final int songIndex;

  public SongView(Controller controller, int songIndex) {
    this.controller = controller;
    this.songIndex = songIndex;
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();
    layout.getStyleClass().add("song-layout");

    // Delete button
    Button deleteButton = new Button("\u274C");
    deleteButton.setOnAction((ActionEvent event) -> {
      controller.removeSong(songIndex);
    });
    layout.getChildren().add(deleteButton);

    // Up button
    Button upButton = new Button("\u25B2");
    upButton.setOnAction((ActionEvent event) -> {
      controller.moveSongUp(songIndex);
    });
    layout.getChildren().add(upButton);

    // Down button
    Button downButton = new Button("\u25BC");
    downButton.setOnAction((ActionEvent event) -> {
      controller.moveSongDown(songIndex);
    });
    layout.getChildren().add(downButton);

    // Title
    Label title = new Label(makeLabelString());
    layout.getChildren().add(title);

    return layout;
  }

  private String makeLabelString() {
    Song song = controller.getSong(songIndex);
    return song.getTitle() + " by " + song.getArtist() + " (" + makeRating() + ")";
  }

  private String makeRating() {
    Song song = controller.getSong(songIndex);
    int ratingInt = song.getRating();
    String ratingString = "";
    for (int i = 0; i < ratingInt; i++) {
      ratingString += "\u2605";
    }
    for (int i = ratingInt; i < 5; i++) {
      ratingString += "\u2606";
    }
    return ratingString;
  }
}
