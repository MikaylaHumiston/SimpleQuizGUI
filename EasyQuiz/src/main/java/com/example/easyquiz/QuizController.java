package com.example.easyquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuizController {

    @FXML
    public Label question;

    @FXML
    public Button op1, op2, op3, op4;

    int counter = 0;
    static int correct = 0;
    static int wrong = 0;

    @FXML
    private void initialize(){
        loadQuestions();
    }

    @FXML
    private void loadQuestions() {
        if(counter == 0){
            question.setText("1. What is the sum of 5 + 3?");
            op1.setText("6");
            op2.setText("8");
            op3.setText("10");
            op4.setText("12");
        }
        else if(counter ==1){
            question.setText("2. How many sides does a square have?");
            op1.setText("2");
            op2.setText("3");
            op3.setText("4");
            op4.setText("5");
        }
        else if(counter ==2){
            question.setText("3. What is 6 times 4?");
            op1.setText("10");
            op2.setText("18");
            op3.setText("24");
            op4.setText("30");
        }
        else if(counter ==3){
            question.setText("4. What is the next number in the sequence: 2, 4, 6, 8, __?");
            op1.setText("10");
            op2.setText("11");
            op3.setText("12");
            op4.setText("14");
        }
        else if(counter ==4){
            question.setText("5. What is the difference between 10 and 4?");
            op1.setText("2");
            op2.setText("4");
            op3.setText("6");
            op4.setText("8");
        }
        else if(counter ==5){
            question.setText("6. Which shape has three sides?");
            op1.setText("Circle");
            op2.setText("Square");
            op3.setText("Triangle");
            op4.setText("Rectangle");
        }
        else if(counter ==6){
            question.setText("7. What is 15 divided by 3?");
            op1.setText("3");
            op2.setText("5");
            op3.setText("7");
            op4.setText("10");
        }
        else if(counter ==7){
            question.setText("8. How many inches are in a foot?");
            op1.setText("8");
            op2.setText("10");
            op3.setText("12");
            op4.setText("14");
        }
        else if(counter ==8){
            question.setText("9. Which number is the largest: 25, 35, 45, 55?");
            op1.setText("25");
            op2.setText("35");
            op3.setText("45");
            op4.setText("55");
        }
        else if(counter ==9){
            question.setText("10. What is the product of 7 multiplied by 2?");
            op1.setText("9");
            op2.setText("11");
            op3.setText("14");
            op4.setText("16");
        }
    }

    @FXML
    public void op1clicked(ActionEvent event) {
        opClicker(op1, event);
    }
    @FXML
    public void op2clicked(ActionEvent event) {
        opClicker(op2, event);
    }
    @FXML
    public void op3clicked(ActionEvent event) {
        opClicker(op3, event);
    }
    @FXML
    public void op4clicked(ActionEvent event) {
        opClicker(op4, event);
    }

    @FXML
    public void opClicker(Button op, ActionEvent event)
    {
        checkAnswer(op.getText().toString());
        if(checkAnswer(op.getText().toString())){
            correct++;
        }
        else{
            wrong++;
        }

        if(counter==9){
            try {
                Stage thisStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.TRANSPARENT);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public boolean checkAnswer(String answer) {
        String right = "";
        switch (counter) {
            case 0:
                right = "8";
                break;
            case 1:
                right = "4";
                break;
            case 2:
                right = "24";
                break;
            case 3:
                right = "10";
                break;
            case 4:
                right = "6";
                break;
            case 5:
                right = "Triangle";
                break;
            case 6:
                right = "5";
                break;
            case 7:
                right = "12";
                break;
            case 8:
                right = "55";
                break;
            case 9:
                right = "14";
                break;
        }
        if(answer.equals(right)){
            return true;
        }else{
            return false;
        }
    }
}
