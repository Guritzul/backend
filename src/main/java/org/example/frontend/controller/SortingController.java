package org.example.frontend.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.example.frontend.MainApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingController {

    @FXML
    private HBox arrayContainer;

    @FXML
    private Slider speedSlider;

    @FXML
    private Slider elementsSlider;

    @FXML
    private Label algorithmNameLabel;

    @FXML
    private Label algorithmDescriptionLabel;

    @FXML
    private TextArea commentsTextArea;

    private int[] array;
    private Rectangle[] rectangles;
    private List<KeyFrame> keyFrames;

    @FXML
    public void initialize() {
        generateArray((int) elementsSlider.getValue());
        elementsSlider.valueProperty().addListener((obs, oldVal, newVal) -> generateArray(newVal.intValue()));
    }

    private void generateArray(int size) {
        arrayContainer.getChildren().clear();
        array = new int[size];
        rectangles = new Rectangle[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) + 1;
            rectangles[i] = new Rectangle(30, array[i] * 3, Color.BLUE);
            arrayContainer.getChildren().add(rectangles[i]);
        }
    }

    @FXML
    private void startSorting() {
        double speed = speedSlider.getValue();
        keyFrames = new ArrayList<>();
        String algorithm = algorithmNameLabel.getText();
        if ("Quick Sort".equals(algorithm)) {
            quickSort(0, array.length - 1, speed);
        } else if ("Bubble Sort".equals(algorithm)) {
            bubbleSort(speed);
        }
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(keyFrames);
        timeline.play();
    }

    private void quickSort(int low, int high, double speed) {
        if (low < high) {
            int pi = partition(low, high, speed);
            quickSort(low, pi - 1, speed);
            quickSort(pi + 1, high, speed);
        }
    }

    private int partition(int low, int high, double speed) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                addKeyFrame(i, j, speed);
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        addKeyFrame(i + 1, high, speed);
        return i + 1;
    }

    private void bubbleSort(double speed) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    addKeyFrame(j, j + 1, speed);
                }
            }
        }
    }

    private void addKeyFrame(int i, int j, double speed) {
        keyFrames.add(new KeyFrame(Duration.seconds(0.5 / speed), e -> {
            rectangles[i].setHeight(array[i] * 3);
            rectangles[j].setHeight(array[j] * 3);
        }));
    }

    @FXML
    private void submitComment() {
        String comment = commentsTextArea.getText();
        if (!comment.isEmpty()) {
            System.out.println("Comment submitted: " + comment);
            commentsTextArea.clear();
        }
    }

    @FXML
    private void goBackToDashboard() {
        try {
            MainApp.showDashboardView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}