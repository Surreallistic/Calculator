package core.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    public Button closeButton;

    public TextField memoryField; // textField on the bottom
    public TextField computeField; // textField on the top

    private String memoryValue;
    private String computeValue;
    private String lastUsedSymbol;
    private String buffComputeValue; // buffer for computeValue

    private boolean statusClearResultField = true;
    private boolean statusPerformCalcOperation = false;

    public void handleCloseWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleDigitalNumber(ActionEvent actionEvent) {
        handleDigitalNumberRestrictions();
        String newValue = computeField.getText() + getUsedSymbol(actionEvent);
        computeValue = newValue;
        computeField.setText(computeValue);
    }
    
    private void handleDigitalNumberRestrictions() {
        if (computeField.getText().equals(Symbol.ZERO)) {
            computeField.setText(Symbol.NONE);
        } // handle printing multiple zeros on the computeField
    }

    public void handleCalcOperation(ActionEvent actionEvent) {
        if(checkLastUsedSymbol(actionEvent)) {
            lastUsedSymbol = getUsedSymbol(actionEvent);
        }


    }

    private boolean checkLastUsedSymbol(ActionEvent actionEvent) {
        if(getUsedSymbol(actionEvent) != lastUsedSymbol) {
            return false;
        } else {
            return true;
        }
    }

    private void getResultFromCalcOperation() {

    }

    public void handleEqualOperation(ActionEvent actionEvent) {

    }

    public void handleClearCalc(ActionEvent actionEvent) {
        memoryField.setText("");
        computeField.setText("0");
        memoryValue = "";
        computeValue = "";
    }

    private void prepareOperation() {
        computeValue = Integer.toString(performOperation());
        computeField.setText(computeValue);
    }

    private int performOperation() {
        int temp1 = Integer.parseInt(computeValue);
        int temp2 = Integer.parseInt(buffComputeValue);
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

    private String getUsedSymbol(ActionEvent event) {
        return ((Button) event.getSource()).getText();
    }

}
