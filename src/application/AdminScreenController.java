package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminScreenController {

    @FXML
    private Button AddNewCandidate;

    @FXML
    private Button AddNewParty;

    @FXML
    private Button BackToHome;

    @FXML
    private Button DisplayResults;
    
    @FXML
    public void HomeButtonPressed(ActionEvent event) {
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
    
    @FXML
    public void AddNewPartyButtonPressed(ActionEvent event) {
    	try {
			AnchorPane AddNewPartyView = (AnchorPane)FXMLLoader.load(getClass().getResource("AddNewPartyScreen.fxml"));
			Scene scene = new Scene(AddNewPartyView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    public void AddNewCandidateButtonPressed(ActionEvent event) {
    	try {
			AnchorPane AddNewPartyView = (AnchorPane)FXMLLoader.load(getClass().getResource("AddNewCandidateScreen.fxml"));
			Scene scene = new Scene(AddNewPartyView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    public void DisplayResultsButtonPressed(ActionEvent event) {
    	try {
			AnchorPane DisplayResultsView = (AnchorPane)FXMLLoader.load(getClass().getResource("DisplayResultsScreen.fxml"));
			Scene scene = new Scene(DisplayResultsView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
