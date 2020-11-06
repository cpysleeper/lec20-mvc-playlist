package com.comp301.lec20.playlist.view;

import com.comp301.lec20.playlist.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ControlsView implements FXComponent {
  private final Controller controller;

  public ControlsView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    StackPane layout = new StackPane();
    layout.setPadding(new Insets(10, 10, 10, 10));

    Button shuffleButton = new Button("Shuffle");
    shuffleButton.setOnAction((ActionEvent event) -> {
      controller.shuffleSongs();
    });
    layout.getChildren().add(shuffleButton);

    return layout;
  }
}
