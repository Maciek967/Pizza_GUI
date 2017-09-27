import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
public class PizzaOrder extends Application
{
    Stage window;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        window = primaryStage;
        window.setTitle("Domino's Pizza");
        
        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //Size label - constrains use (child, column, row)
        Label sizeLabel = new Label("Pizza size:");
        grid.setConstraints(sizeLabel, 0, 3);
        
        //Pizza size Combo box
        final ComboBox sizeBox = new ComboBox();
        sizeBox.getItems().addAll(  
        "Small",
        "Medium",
        "Large");
        grid.setConstraints(sizeBox, 1, 3);
        
        //Toppings label
        Label toppingsLabel = new Label("Toppings:");
        grid.setConstraints(toppingsLabel, 0, 4);
        
        //CheckBoxes to pick toppings
        CheckBox box1 = new CheckBox("Chicken");
        CheckBox box2 = new CheckBox("Bacon");
        CheckBox box3 = new CheckBox("Peppers");
        CheckBox box4 = new CheckBox("Mushrooms");
        grid.setConstraints(box1, 1, 4);
        grid.setConstraints(box2, 2, 4);
        grid.setConstraints(box3, 3, 4);
        grid.setConstraints(box4, 4, 4);
        
        //Drink label - constrains use (child, column, row)
        Label drinkLabel = new Label("Choose drink:");
        grid.setConstraints(drinkLabel, 0, 5);
        
        //Drink ComboBox
        final ComboBox drinkBox = new ComboBox();
        drinkBox.getItems().addAll(
        "No drink",
        "Coke",
        "Sprite",
        "Fanta");
        grid.setConstraints(drinkBox, 1, 5);
        
        //Side Label
        Label sideLabel = new Label("Sides");
        grid.setConstraints(sideLabel, 0, 6);
        
        //Check Boxes to pick sides
        CheckBox box5 = new CheckBox("Chicken Strippers");
        CheckBox box6 = new CheckBox("Wedgies");
        CheckBox box7 = new CheckBox("Garlic Bread");
        grid.setConstraints(box5, 1, 6);
        grid.setConstraints(box6, 2, 6);
        grid.setConstraints(box7, 3, 6);
        
        //Order Button
        Button orderButton = new Button("Order");
        grid.setConstraints(orderButton, 3, 8);
        
        //Quit Button
        Button quitButton = new Button("Quit");
        grid.setConstraints(quitButton, 4, 8);
        
        //Order Label
        Label order = new Label();
        grid.setConstraints(order, 4, 9);
        
        //React to button
        orderButton.setOnAction(e -> {
            order.setText("Pizza will be\nready soon!");
        });
        
        quitButton.setOnAction(e -> {
            primaryStage.close();
        });
        
        //Load image
        Image image = new Image("https://stocklogos.com/sites/default/files/dominonew_0.gif");
        //simple displays ImageView the image as is
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        //BorderPane pane = new BorderPane();
        VBox imageBox = new VBox();
        imageBox.getChildren().add(iv1);
        //pane.setBottom(imageBox);
        iv1.setFitHeight(60);
        iv1.setFitWidth(150);
        
        //Add everything to the grid
        grid.getChildren().addAll(sizeLabel, sizeBox, toppingsLabel, box1, box2, box3, box4);
        grid.getChildren().addAll(drinkLabel, drinkBox, sideLabel, box5, box6, box7);
        grid.getChildren().addAll(orderButton, quitButton, order, imageBox);
        grid.setStyle("-fx-background-color: white");
        Scene scene = new Scene(grid, 650, 300);
        window.setScene(scene);
        window.show();
    }
}
