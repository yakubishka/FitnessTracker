package tracker.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tracker.architecture.BaseViewController;
import tracker.utils.StringRes;
import tracker.utils.WindowConstants;

import java.io.IOException;

public class MainApp extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    this.primaryStage.setWidth(WindowConstants.WINDOW_WIDTH);
    this.primaryStage.setHeight(WindowConstants.WINDOW_HEIGHT);
    this.primaryStage.setTitle(StringRes.APP_NAME);
    createRootView();
    showUserListView();
  }

  private void createRootView() {
    rootLayout = getPaneFromLoader(createLoader("RootLayout.fxml"));
    if (rootLayout != null)
      primaryStage.setScene(new Scene(rootLayout));
    primaryStage.show();
  }

  private void showUserListView() {
    FXMLLoader loader = createLoader("UsersListLayout.fxml");
    AnchorPane usersListLayout = getPaneFromLoader(loader);
    if (usersListLayout != null) {
      if (loader.getController() instanceof BaseViewController)
        ((BaseViewController) loader.getController()).setMainApp(this);
      rootLayout.setCenter(usersListLayout);
    }
  }

  public FXMLLoader createLoader(String layoutFileName) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainApp.class.getResource("/layout/" + layoutFileName));
    return loader;
  }

  public <T extends Pane> T getPaneFromLoader(FXMLLoader loader) {
    try {
      return loader.load();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
