package controller.corelaucher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Used to launch the main Stage of the Application and load the correct fxml file.
 *
 */
public class CoreLauncher extends Application {
	
	private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
    	
    	Font.loadFont(getClass().getResourceAsStream("/assets/munro.ttf"), 10);
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/layout/mainMenu.fxml"));
    	
        Scene scene = new Scene(root, 900, 650 );               
        scene.getStylesheets().add(getClass().getResource("/assets/menuLayout.css").toExternalForm());
        stage.setTitle("Battle For Honor");
        stage.getIcons().add(new Image("images/icon.png"));
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        
        /*
         * Quick function to enable drag events on an undecorated Scene.
         */
        
        root.setOnMousePressed(pressEvent -> {
            root.setOnMouseDragged(dragEvent -> {
                stage.setX(dragEvent.getScreenX() - pressEvent.getSceneX());
                stage.setY(dragEvent.getScreenY() - pressEvent.getSceneY());
            });
        });
    }

}