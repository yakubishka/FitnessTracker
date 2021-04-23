package tracker.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tracker.architecture.BaseViewController;
import tracker.model.User;
import tracker.model.jaxb.UsersWrapper;
import tracker.resources.LayoutRes;
import tracker.resources.StringRes;
import tracker.resources.WindowConstants;
import tracker.utils.storage.JAXBConverter;
import tracker.utils.storage.UsersPreferences;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  private static final String STORAGE_FILE_NAME = "data.xml";
  private final UsersPreferences usersPreferences = new UsersPreferences(MainApp.class);

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    this.primaryStage.setWidth(WindowConstants.WINDOW_WIDTH);
    this.primaryStage.setHeight(WindowConstants.WINDOW_HEIGHT);
    this.primaryStage.setTitle(StringRes.APP_NAME);
    createRootView();
    showUserListView();
    if (usersPreferences.getStorageFile() == null)
      usersPreferences.setStorageFile(new File(STORAGE_FILE_NAME));

  }

  private void createRootView() {
    rootLayout = getPaneFromLoader(createLoader(LayoutRes.ROOT_LAYOUT));
    if (rootLayout != null)
      primaryStage.setScene(new Scene(rootLayout));
    primaryStage.show();
  }

  private void showUserListView() {
    FXMLLoader loader = createLoader(LayoutRes.USERS_LIST_LAYOUT);
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

  public void saveToFile(List<User> users) {
    File fileToSave = usersPreferences.getStorageFile();
    UsersWrapper usersWrapper = new UsersWrapper();
    usersWrapper.setUsers(users);
    if (fileToSave != null)
      JAXBConverter.saveToFile(fileToSave, UsersWrapper.class, usersWrapper);
  }

  public List<User> readFromFile() {
    File fileFromLoad = usersPreferences.getStorageFile();
    if (fileFromLoad != null) {
      Object usersWrapper = JAXBConverter.loadFromFile(fileFromLoad, UsersWrapper.class);
      if (usersWrapper instanceof UsersWrapper) {
        return ((UsersWrapper) usersWrapper).getUsers();
      }

    }
    return null;
  }

  public static void main(String[] args) {
    launch(args);
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
