package Calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {


    //        currentResult = currentResult.replaceAll("\\D+",""); // get number, delete any other sign
    private boolean status = true;

    public Button closeButton;

    public TextField displayFieldResult;
    public TextField displayFieldMemory;

    private String bufferMemoryField;
    private String bufferResultField;
    private String tempValue;

    public void handleCloseWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleDigitalNumber(ActionEvent actionEvent) {
        if(!status) { displayFieldResult.setText(""); status=true; } // reset result textField
        tempValue = displayFieldResult.getText() + getUsedSymbol(actionEvent);
        bufferResultField =  tempValue;
        displayFieldResult.setText(bufferResultField);
    }

    public void handleCalcOperation(ActionEvent actionEvent) {
        tempValue = bufferResultField + " " + getUsedSymbol(actionEvent) + " ";
        if(bufferMemoryField == null) { bufferMemoryField = tempValue; } else { bufferMemoryField += tempValue; }

        displayFieldMemory.setText(bufferMemoryField);
        status = false;
    }

    private String getUsedSymbol(ActionEvent event) {
        return ((Button)event.getSource()).getText();
    }

}
