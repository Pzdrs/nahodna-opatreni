package sample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Timer;

public class Main extends Application {
    public static DataSet data;
    public static final Timer timer = new Timer();

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadData();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Vládní opatření v0.1 - by Pzdrs");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void loadData() {
        try {
            JsonElement element = JsonParser.parseReader(new FileReader(new File("src/sample/data.json")));
            JsonObject object = element.getAsJsonObject();

            JsonArray authors = object.getAsJsonArray("authors");
            JsonArray opatreni = object.getAsJsonArray("opatreni");

            data = new DataSet(opatreni, authors);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
    }
}
