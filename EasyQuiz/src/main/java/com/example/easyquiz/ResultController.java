package com.example.easyquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class ResultController {
    @FXML
    public Label resultTitle, remark, score, scoreText, correctText, wrongText;

    @FXML
    public ProgressIndicator correctProgress, wrongProgress;

    @FXML
    private void initialize(){
        resultTitle.setText("Result");

        score.setText(QuizController.correct + " / 10");
        scoreText.setText(QuizController.correct + " Points Out of 10");
        correctText.setText("Correct Answers: "+ QuizController.correct);
        wrongText.setText("Wrong Answers: "+ QuizController.wrong);

        double correctf = (double) QuizController.correct / 10;
        correctProgress.setProgress(correctf);

        double wrongf = (double) QuizController.wrong /10;
        wrongProgress.setProgress(wrongf);

        switch (QuizController.correct){
            case 10:
                remark.setText("Congratulations! You earned an A+");
                break;
            case 9:
                remark.setText("Great work! You earned an A");
                break;
            case 8:
                remark.setText("Good work! You earned a B");
                break;
            case 7:
                remark.setText("You passed! You earned a C");
                break;
            default:
                remark.setText("Failed. Almost there! Keep Practicing!");
                break;
        }
    }
}
