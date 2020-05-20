import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;


public class Test extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestCircle");
        Group root = new Group(); // Pass in "root" to your draw methods
        Scene scene = new Scene(root, 500, 500); // Change window size here

        // TODO Put your calls to shapes here
        Square s = new Square(new Point(250, 250), 20);
        s.drawGrid(root, true, 3);
        System.out.println(s.toString());
        
               

        // Don't modify this
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
