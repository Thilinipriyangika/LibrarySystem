package library.librarysystem.ControllerMainUI;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import library.librarysystem.LibraryApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class MainUIController implements Initializable {

    @FXML
    private AnchorPane loadpagepane;


    @FXML
    private JFXButton logOutBtn;

    Pane home;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadChildPage();

    }


    private void setNode (Node node){
        loadpagepane.getChildren().clear();
        loadpagepane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(800));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void loadChildPage(){
        try {
           home = FXMLLoader.load(LibraryApp.class.getResource("MainUI_Home.fxml"));
            setNode(home);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void loadAdmin(ActionEvent event) {
        try {
            home = FXMLLoader.load(LibraryApp.class.getResource("AdminLogin.fxml"));
            setNode(home);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void loadHome(ActionEvent event) {
        try {
            home = FXMLLoader.load(LibraryApp.class.getResource("MainUI_Home.fxml"));
            setNode(home);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void loadManage(ActionEvent event) {
        try {
            home = FXMLLoader.load(LibraryApp.class.getResource("MainUI_Manage.fxml"));
            setNode(home);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        logOutBtn.getScene().getWindow().hide();

        Stage loginPage = new Stage();
        Parent root = FXMLLoader.load(LibraryApp.class.getResource("LoginMain.fxml"));
        Scene scene = new Scene(root);
        loginPage.setScene(scene);
        loginPage.show();
        loginPage.setResizable(false);
        loginPage.setMaximized(true);
    }

}
