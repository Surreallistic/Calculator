package core.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    //        currentResult = currentResult.replaceAll("\\D+",""); // get number, delete any other sign
    public Button closeButton;

    public TextField displayFieldResult;
    public TextField displayFieldMemory;

    private String memoryFieldValue;
    private String resultFieldValue;
    private String lastUsedSymbol;
    private String lastResultField;

    private boolean statusClearResultField = true;
    private boolean statusPerformCalcOperation = false;

    public void handleCloseWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void handleDigitalNumber(ActionEvent actionEvent) {
        handleDigitalNumberExceptions();
        String newValue = displayFieldResult.getText() + getUsedSymbol(actionEvent);
        resultFieldValue = newValue;
        displayFieldResult.setText(resultFieldValue);
    }

    private void handleDigitalNumberExceptions() {
        if (displayFieldResult.getText().equals(Symbol.ZERO)) {
            displayFieldResult.setText(Symbol.NONE);
        } // handle printing multiple zeros on the ResultTextField
    }

    public void handleCalcOperation(ActionEvent actionEvent) {

    }

    public void handleEqualOperation(ActionEvent actionEvent) {
        if (lastResultField != null && lastResultField != Symbol.ZERO) {
            resultFieldValue = Integer.toString(performOperation());
            displayFieldResult.setText(resultFieldValue);
        }
    }

    public void handleClearCalc(ActionEvent actionEvent) {
        displayFieldMemory.setText("");
        displayFieldResult.setText("0");
        lastResultField = "0";
        memoryFieldValue = "";
        resultFieldValue = "";
    }

    private void prepareOperation() {
        resultFieldValue = Integer.toString(performOperation());
        displayFieldResult.setText(resultFieldValue);
    }

    private int performOperation() {
        int temp1 = Integer.parseInt(resultFieldValue);
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

    private String getUsedSymbol(ActionEvent event) {
        return ((Button) event.getSource()).getText();
    }

}
