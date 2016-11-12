package Calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    public TextField displayField;
    public Button closeButton;
    private String prevValue;
    private String nextValue;

    public void handleDigitalNumber(ActionEvent actionEvent) {
        String digtNumb = getUsedSymbol(actionEvent);

        displayField.setText(getUsedSymbol(actionEvent));
    }

    public void handleCalcOperation(ActionEvent actionEvent) {
        displayField.setText(getUsedSymbol(actionEvent));
    }

    public void handleCloseWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    private String getUsedSymbol(ActionEvent event) {
        return ((Button)event.getSource()).getText();
    }

}
