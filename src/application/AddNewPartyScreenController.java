package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddNewPartyScreenController {
	
	VotingMachine votingMachine = VotingMachine.getInstance();
	
    @FXML
    private Button AdminView;

    @FXML
    private TextField PartyName;

    @FXML
    private Button Submit;

    @FXML
    void AdminViewButtonPressed(ActionEvent event) {
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
    void SubmitButtonPressed(ActionEvent event) {
    	Party party = new Party(PartyName.getText());
    	votingMachine.addNewParty(party);
    }

}
