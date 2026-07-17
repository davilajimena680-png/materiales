package utng.gtid.jdj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        System.out.println(
                App.class.getResource("/utng/gtid/jdj/MaterialDanado.fxml")
        );

        FXMLLoader loader = new FXMLLoader(
                App.class.getResource(
                        "/utng/gtid/jdj/MaterialDanado.fxml"
                )
        );

        AnchorPane root = loader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Gestión de Materiales - Materiales Dañados");

        stage.setScene(scene);

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}