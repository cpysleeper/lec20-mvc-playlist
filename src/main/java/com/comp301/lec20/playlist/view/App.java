package com.comp301.lec20.playlist.view;

import com.comp301.lec20.playlist.InitialPlaylist;
import com.comp301.lec20.playlist.controller.Controller;
import com.comp301.lec20.playlist.controller.ControllerImpl;
import com.comp301.lec20.playlist.model.Model;
import com.comp301.lec20.playlist.model.ModelImpl;
import com.comp301.lec20.playlist.model.Song;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage stage) {
    // Model
    List<Song> songs = InitialPlaylist.create();
    Model model = new ModelImpl(songs);

    // Controller
    Controller controller = new ControllerImpl(model);

    // View
    View view = new View(controller);

    // Make scene
    stage.setScene(new Scene(view.render()));

    // Refresh view when model changes
    model.addObserver((Model m) -> {
      stage.setScene(new Scene(view.render()));
    });

    // Show the stage
    stage.setTitle("Playlist View Example");
    stage.show();
  }
}
