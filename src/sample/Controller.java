package sample;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class Controller implements Initializable {

    public Label author, opatreni;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> setup(Main.data));
            }
        }, 0, 5 * 1000);
    }

    private void setup(DataSet dataSet) {
        author.setText(dataSet.getRandomAuthor());
        opatreni.setText(dataSet.getRandomOpatreni());
    }
}
