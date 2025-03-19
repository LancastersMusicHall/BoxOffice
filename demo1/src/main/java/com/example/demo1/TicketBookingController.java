package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class TicketBookingController {

    @FXML
    protected void onConfirmBooking(ActionEvent event) {
        System.out.println("Booking confirmed!"); // Debugging output
        // You can add logic to save the booking to a database here
    }

    @FXML
    protected void onBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booking-view.fxml"));
            Parent root = fxmlLoader.load();

            // Get current stage from event source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Load main menu
            Scene scene = new Scene(root, 800, 600);
            stage.setScene(scene);
            stage.setTitle("Booking System");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
