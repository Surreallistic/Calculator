package core.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    //        currentResult = currentResult.replaceAll("\\D+",""); // get number, delete any other sign
    private boolean statusClearResultField = true;
    private boolean statusPerformCalcOperation = false;

    public Button closeButton;

    public TextField displayFieldResult;
    public TextField displayFieldMemory;

    private String bufferMemoryField;
    private String bufferResultField;
    private String tempValue;
    private String lastUsedSymbol;
    private String lastResultField;

    public void handleCloseWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleDigitalNumber(ActionEvent actionEvent) {
        if(!statusClearResultField) {
            displayFieldResult.setText("");
            statusClearResultField = true;
            statusPerformCalcOperation = true;
        } // reset result textField and perform action
        if(getUsedSymbol(actionEvent).equals(Symbol.ONE)) {
            displayFieldResult.setText("0");
        } else {
            tempValue = displayFieldResult.getText() + getUsedSymbol(actionEvent);
            bufferResultField =  tempValue;
            displayFieldResult.setText(bufferResultField);
        }

    }

    public void handleCalcOperation(ActionEvent actionEvent) {
        if(statusPerformCalcOperation) { prepareOperation(); }
        lastResultField = bufferResultField;
        tempValue = bufferResultField + " " + getUsedSymbol(actionEvent) + " ";
        if(bufferMemoryField == null) { bufferMemoryField = tempValue; } else { bufferMemoryField += tempValue; }
        lastUsedSymbol = getUsedSymbol(actionEvent);
        displayFieldMemory.setText(bufferMemoryField);
        statusClearResultField = false;
    }

    private String getUsedSymbol(ActionEvent event) {
        return ((Button)event.getSource()).getText();
    }

    private void prepareOperation() {
        bufferResultField = Integer.toString(performOperation());
        displayFieldResult.setText(bufferResultField);
    }

    private int performOperation() {
        int temp1 = Integer.parseInt(bufferResultField);
        int temp2 = Integer.parseInt(lastResultField);
        int result = 0;

        switch (lastUsedSymbol) {
            case Symbol.PLUS:
                result = temp1 + temp2;
                break;
            case Symbol.MINUS:
                result = temp1 - temp2;
                break;
            case Symbol.DIVIDE:
                result = temp1 / temp2;
                break;
            case Symbol.MULTIPLY:
                result = temp1 * temp2;
                break;
        }

        return result;
    }

    public void handleEqualOperation(ActionEvent actionEvent) {
        bufferResultField = Integer.toString(performOperation());
        displayFieldResult.setText(bufferResultField);
    }

    public void handleClearCalc(ActionEvent actionEvent) {
        displayFieldMemory.setText("");
        displayFieldResult.setText("0");
        bufferMemoryField = "";
        bufferResultField = "";
        lastResultField = "0";
    }
}
