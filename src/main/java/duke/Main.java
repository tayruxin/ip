package duke;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Duke duke = new Duke("./duke.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("Muddy");
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);

            Gui gui = new Gui(fxmlLoader.<MainWindow>getController());
            duke.setGui(gui);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
