package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VoteDoneScreenController {

    @FXML
    private Button BackToHome;

    @FXML
    void HomeButtonPressed(ActionEvent event) {
    	try {
			AnchorPane HomeView = (AnchorPane)FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
			Scene scene = new Scene(HomeView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
