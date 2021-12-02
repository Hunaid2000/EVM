package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VoterScreenController {

	VotingMachine votingMachine = VotingMachine.getInstance();
	
	@FXML
    private TextField CNIC;
	
    @FXML
    private TextField Address;

    @FXML
    private TextField Age;

    @FXML
    private Button BackToHome;

    @FXML
    private TextField Contact;

    @FXML
    private TextField Name;

    @FXML
    private Button Submit;
    
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
    void SubmitButtonPressed(ActionEvent event) {
    	Voter voter = new Voter(CNIC.getText(), Name.getText(), Contact.getText(), Address.getText(), 0);
    	ObservableList<Voter> voters = votingMachine.dbHandler.getVotersRecords();
    	boolean nextscene = true;
    	for(int i=0;i<voters.size();i++) {
    		if(voters.get(i).getCNIC().equals(CNIC.getText())) {
    			System.out.println("Invalid Input!");
    			nextscene = false;
    		}
    	}
    	if(nextscene) {
    		votingMachine.addNewVoter(voter);
        	try {
    			Thread.sleep(500);
    		} catch (InterruptedException e1) {
    			e1.printStackTrace();
    		}
        	try {
    			AnchorPane CastVoteView = (AnchorPane)FXMLLoader.load(getClass().getResource("CastVoteScreen.fxml"));
    			Scene scene = new Scene(CastVoteView,350,350);			
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(scene);
    			stage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    }

}
