package com.comp301.lec20.playlist.view;

import com.comp301.lec20.playlist.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
  private final Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();

    // Controls view
    ControlsView controlsView = new ControlsView(controller);
    layout.getChildren().add(controlsView.render());

    // Playlist
    VBox playlist = new VBox();
    for (int i = 0; i < controller.getNumSongs(); i++) {
      SongView songView = new SongView(controller, i);
      playlist.getChildren().add(songView.render());
    }
    layout.getChildren().add(playlist);

    // Add song view
    AddSongView addSongView = new AddSongView(controller);
    layout.getChildren().add(addSongView.render());

    return layout;
  }
}
