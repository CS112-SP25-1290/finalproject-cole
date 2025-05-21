package edu.miracosta.cs112.finalproject.finalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageDisplayExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Print the current working directory
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        // Load the image from the resources folder
        Image image = new Image(getClass().getResourceAsStream("/PokemonImages/Charizard.png"));

        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);

        // Optional: Resize or scale the image if needed
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        // Add image to layout
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 400, 400); // Window size

        // Set up the stage
        primaryStage.setTitle("JavaFX Image Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
