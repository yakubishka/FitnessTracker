package tracker.scenes.userchanges;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tracker.app.MainApp;
import tracker.utils.StringRes;

public class ChangeUserDialogController {

  @FXML
  private TextField firstNameTextField;

  @FXML
  private TextField lastNameTextField;

  private Stage controllerStage;

  @FXML
  private void initialize() { }

  @FXML
  private void onSaveClick() {
    controllerStage.close();
  }

  @FXML void onCancelClick() {
    controllerStage.close();
  }

  public static void showAsDialog(MainApp app, boolean isEdit) {
    FXMLLoader loader = app.createLoader("ChangeUserDialogLayout.fxml");
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);
    System.out.println(dialogLayout + " ");
    ((ChangeUserDialogController) loader.getController()).controllerStage = app.getPrimaryStage();

    Stage dialogStage = new Stage();

    Scene scene = new Scene(dialogLayout);
    dialogStage.setScene(scene);

    String title = StringRes.ADD_USER;
    if (isEdit) title = StringRes.EDIT_USER;
    dialogStage.setTitle(title);
    dialogStage.initModality(Modality.WINDOW_MODAL);
    dialogStage.initOwner(app.getPrimaryStage());
    dialogStage.showAndWait();
  }

}
