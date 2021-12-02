package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HowtoVoteScreenController {

    @FXML
    private Button CastVote;
    
    @FXML
    public void CastVoteButtonPressed(ActionEvent event) {
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
