package Calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    public TextField displayField;
    private String prevValue;
    private String nextValue;

    public void handleDigitalNumber(ActionEvent actionEvent) {
        String digtNumb = getUsedSymbol(actionEvent);
    }

    public void handleCalcOperation(ActionEvent actionEvent) {
        displayField.setText(getUsedSymbol(actionEvent));
    }

    private String getUsedSymbol(ActionEvent event) {
        return ((Button)event.getSource()).getText();
    }

}
