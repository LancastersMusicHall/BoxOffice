package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button bookTicketButton;
    @FXML
    private Button viewSalesButton;
    @FXML
    private Button exitButton;

    @FXML
    protected void onBookTicketClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ticket-booking.fxml"));
            Parent root = fxmlLoader.load();

            // Get current stage
            Stage stage = (Stage) bookTicketButton.getScene().getWindow();

            // Load new scene
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setTitle("Book a Ticket");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onViewSalesClick() {
        welcomeText.setText("Viewing Sales Data...");
        // Load sales management scene
    }

    @FXML
    protected void onExitClick() {
        System.exit(0); // Closes the application
    }
}
