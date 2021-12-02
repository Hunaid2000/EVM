package application;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class CastVoteScreenController {
	
	VotingMachine votingMachine = VotingMachine.getInstance();
	
	@FXML
    private Button Vote;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private Button BackToHome;

    @FXML
    private Button Help;
    
    @FXML
    private ObservableList<String> candidatechoices;
    
    @FXML
    public void initialize() {    	
    	candidatechoices = votingMachine.dbHandler.getCandidateschoices();
    	choice.setItems(candidatechoices);
    }
    
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
    public void HelpPressed(ActionEvent event) {
    	try {
			AnchorPane HelpView = (AnchorPane)FXMLLoader.load(getClass().getResource("HowtoVoteScreen.fxml"));
			Scene scene = new Scene(HelpView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    public void VoteButtonPressed(ActionEvent event) {
    	AudioClip audio = new AudioClip(this.getClass().getResource("clicksound.wav").toString());
		audio.play();
    	String str = choice.getValue();
    	String[] strings = str.split("-");
    	String pname = strings[0];
    	String cnic = strings[1];
    	String name = strings[2];
    	for(int i=0;i<votingMachine.getParties().size();i++) {
			if(votingMachine.getParties().elementAt(i).getName().equals(pname)) {
				for(int j=0;j<votingMachine.getParties().elementAt(i).getCandidates().size();j++) {
					if(votingMachine.getParties().elementAt(i).getCandidates().elementAt(j).getCNIC().equals(cnic) && votingMachine.getParties().elementAt(i).getCandidates().elementAt(j).getName().equals(name)) {
						votingMachine.CastVote(votingMachine.getParties().elementAt(i).getCandidates().elementAt(j));
						break;
					}
				}
			}
		}
    	try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	try {
			AnchorPane VoteDoneView = (AnchorPane)FXMLLoader.load(getClass().getResource("VoteDoneScreen.fxml"));
			Scene scene = new Scene(VoteDoneView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}    	    	
	}

}
