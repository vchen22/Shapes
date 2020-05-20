import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;


public class TestLines extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TestLines");
        Group root = new Group(); // Pass in "root" to your draw methods
        Scene scene = new Scene(root, 500, 500); // Change window size here

        // TODO Put your calls to shapes here
        Line8B l = new Line8B(new Point(0,0), new Point(500,500),"Maria");
        l.draw(root, Color.PINK, false);
        System.out.println(l.toString());
        
        l = new Line8B(new Point(0,500), new Point(500,0),"Jose");
        l.draw(root, Color.LIGHTBLUE, false);
        System.out.println(l.toString());
        
        l = new Line8B(new Point(125,125), new Point(375,125),"Chucky");
        l.draw(root, Color.RED, false);
        System.out.println(l.toString());
        
        l = new Line8B(new Point(125,375), new Point(375,375),"CJ");
        l.draw(root, Color.GREEN, false);
        System.out.println(l.toString());
        
        l = new Line8B(new Point(125,125), new Point(125,375),"John");
        l.draw(root, Color.YELLOW, false);
        System.out.println(l.toString());
        
        l = new Line8B(new Point(375,125), new Point(375,375),"Blueface");
        l.draw(root, Color.BLUE, false);
        System.out.println(l.toString());

        

        // Don't modify this
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
