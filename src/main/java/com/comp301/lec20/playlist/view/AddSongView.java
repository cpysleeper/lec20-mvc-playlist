package com.comp301.lec20.playlist.view;

import com.comp301.lec20.playlist.controller.Controller;
import com.comp301.lec20.playlist.model.Song;
import com.comp301.lec20.playlist.model.SongImpl;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddSongView implements FXComponent {
  private final Controller controller;
  private HBox layout;

  public AddSongView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    if (layout != null) {
      return layout;
    }

    layout = new HBox();
    layout.setSpacing(5);
    layout.setPadding(new Insets(10, 10, 10, 10));
    layout.setAlignment(Pos.CENTER);

    // Title
    TextField titleInput = new TextField();
    layout.getChildren().add(new Label("Song:"));
    layout.getChildren().add(titleInput);

    // Artist
    TextField artistInput = new TextField();
    layout.getChildren().add(new Label("Artist:"));
    layout.getChildren().add(artistInput);

    // Rating
    Slider ratingSlider = new Slider(0, 5, 5);
    ratingSlider.setShowTickMarks(true);
    ratingSlider.setShowTickLabels(true);
    ratingSlider.setMinorTickCount(0);
    ratingSlider.setMajorTickUnit(1);
    ratingSlider.setBlockIncrement(1);
    ratingSlider.setSnapToTicks(true);
    layout.getChildren().add(new Label("Rating:"));
    layout.getChildren().add(ratingSlider);

    // Add button
    Button addButton = new Button("\uff0b");
    addButton.setOnAction((ActionEvent event) -> {
      String title = titleInput.getText();
      String artist = artistInput.getText();
      int rating = (int) ratingSlider.getValue();
      controller.addSong(title, artist, rating);
      titleInput.setText("");
      artistInput.setText("");
    });
    layout.getChildren().add(addButton);

    return layout;
  }
}
