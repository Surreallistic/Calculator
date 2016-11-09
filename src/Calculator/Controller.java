package Calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    public TextField displayField;


    public void handleDigitalNumber(ActionEvent actionEvent) {
        displayField.setText(getUsedSymbol(actionEvent));
        System.out.println();
    }

    public void handleCalcOperation(ActionEvent actionEvent) {
        displayField.setText(getUsedSymbol(actionEvent));
    }

    private String getUsedSymbol(ActionEvent event) {
        return ((Button)event.getSource()).getText();
    }
}
