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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DisplayResultsScreenController  {
	
	VotingMachine votingMachine = VotingMachine.getInstance();

    @FXML
    private Button AdminView;
    
    @FXML
    private TableColumn<Candidate, String> CNIC;

    @FXML
    private TableColumn<Candidate, String> Name;

    @FXML
    private TableColumn<Candidate, String> PartyName;

    @FXML
    private TableView<Candidate> Result;

    @FXML
    private TableColumn<Candidate, Integer> Votes;
    
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
    void PartyButtonPressed(ActionEvent event) {
    	try {
			AnchorPane PartyView = (AnchorPane)FXMLLoader.load(getClass().getResource("PartyResultsScreen.fxml"));
			Scene scene = new Scene(PartyView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void initialize() {
    	CNIC.setCellValueFactory(CellDataFeatures -> new ReadOnlyStringWrapper(CellDataFeatures.getValue().getCNIC()));
    	Name.setCellValueFactory(CellDataFeatures -> new ReadOnlyStringWrapper(CellDataFeatures.getValue().getName()));
    	PartyName.setCellValueFactory(CellDataFeatures -> new ReadOnlyStringWrapper(CellDataFeatures.getValue().getPartyName()));
    	Votes.setCellValueFactory(CellDataFeatures -> new ReadOnlyObjectWrapper<Integer>(CellDataFeatures.getValue().getVotes()));
    	ObservableList<Candidate> candidates = votingMachine.dbHandler.getCandidatesRecords();
    	Result.setItems(candidates);    
    }

}
