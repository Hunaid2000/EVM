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

public class PartyResultsScreenController  {
	
	VotingMachine votingMachine = VotingMachine.getInstance();

	@FXML
    private Button Back;

    @FXML
    private TableColumn<Party, String> PartyName;

    @FXML
    private TableColumn<Party, Integer> PartyVotes;

    @FXML
    private TableView<Party> Result;
    
    @FXML
    void BackButtonPressed(ActionEvent event) {
    	try {
			AnchorPane DisplayResultsScreenView = (AnchorPane)FXMLLoader.load(getClass().getResource("DisplayResultsScreen.fxml"));
			Scene scene = new Scene(DisplayResultsScreenView,350,350);			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    public void initialize() {
    	PartyName.setCellValueFactory(CellDataFeatures -> new ReadOnlyStringWrapper(CellDataFeatures.getValue().getName()));
    	PartyVotes.setCellValueFactory(CellDataFeatures -> new ReadOnlyObjectWrapper<Integer>(CellDataFeatures.getValue().getVotes()));
    	ObservableList<Party> parties = votingMachine.dbHandler.getPartyRecords();
    	Result.setItems(parties);    
    }

}
