package main.java.gui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class LoginController {

    @FXML private StackPane stackPane;
    @FXML private Rectangle rect;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Button button;

    @FXML
    public void initialize() {
        Background background = new Background(new BackgroundFill(Colors.BACKGROUND, CornerRadii.EMPTY, Insets.EMPTY));
        stackPane.setBackground(background);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(6.0);
        dropShadow2.setOffsetY(4.0);

        rect.setEffect(dropShadow2);
        button.setOnAction(e -> printText());
    }

    public void printText() {
        System.out.println(username.getText());
        System.out.println(password.getText());
    }
}