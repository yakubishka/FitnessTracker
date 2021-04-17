package tracker.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tracker.utils.StringRes;
import java.io.IOException;

public class MainApp extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle(StringRes.APP_NAME);
    createRootView();
    showUserListView();
  }

  private void createRootView() {
    rootLayout = createPaneFromLayout("RootLayout.fxml");
    if (rootLayout != null)
      primaryStage.setScene(new Scene(rootLayout));
    primaryStage.show();
  }

  private void showUserListView() {
    AnchorPane usersListLayout = createPaneFromLayout("UsersListLayout.fxml");
    if (usersListLayout != null) {
      rootLayout.setCenter(usersListLayout);
    }
  }

  public <T extends Pane> T createPaneFromLayout(String layoutFileName) {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("/layout/" + layoutFileName));
      return loader.load();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

}
