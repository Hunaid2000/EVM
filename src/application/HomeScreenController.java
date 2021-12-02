package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeScreenController {

	VotingMachine votingMachine = VotingMachine.getInstance();
	
    @FXML
    private Button AdminButton;

    @FXML
    private Button VoterButton;
    
    @FXML
    public void AdminButtonPressed(ActionEvent event) {
    	try {
			AnchorPane AdminView = (AnchorPane)FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
			Scene scene = new Scene(AdminView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    public void VoterButtonPressed(ActionEvent event) {
    	try {
			AnchorPane VoterView = (AnchorPane)FXMLLoader.load(getClass().getResource("VoterScreen.fxml"));
			Scene scene = new Scene(VoterView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
