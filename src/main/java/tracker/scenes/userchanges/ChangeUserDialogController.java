package tracker.scenes.userchanges;

import com.sun.istack.NotNull;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tracker.app.DialogStageHelper;
import tracker.app.MainApp;
import tracker.model.User;
import tracker.utils.StringRes;

public class ChangeUserDialogController {

  @FXML
  private TextField firstNameTextField;

  @FXML
  private TextField lastNameTextField;

  private Stage dialogStage;

  private User user;

  @FXML
  private void initialize() { }

  @FXML
  private void onSaveClick() {
    if (isInputValid()) {

      String firstName = firstNameTextField.getText();
      String lastName = lastNameTextField.getText();

      user.setFirstName(firstName);
      user.setLastName(lastName);

      dialogStage.close();
    }
  }

  @FXML void onCancelClick() {
    dialogStage.close();
  }

  public void setUser(@NotNull User user) {
    this.user = user;
    if (!user.isEmpty()) {
      firstNameTextField.setText(user.getFirstName());
      lastNameTextField.setText(user.getLastName());
    }
  }

  public boolean isInputValid() {
    String errorMessage = "";

    if (firstNameTextField.getText() == null || firstNameTextField.getText().length() == 0)
      errorMessage += "No valid first name!\n";

    if (lastNameTextField.getText() == null || lastNameTextField.getText().length() == 0)
      errorMessage += "No valid last name!\n";

    if (errorMessage.length() == 0) {
      return true;
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.initOwner(dialogStage);
      alert.setTitle("Invalid Fields");
      alert.setHeaderText("Please correct invalid fields");
      alert.setContentText(errorMessage);
      alert.showAndWait();
      return false;
    }

  }

  public static void showAsDialog(MainApp app, @NotNull User user) {
    FXMLLoader loader = app.createLoader("ChangeUserDialogLayout.fxml");
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);

    ChangeUserDialogController controller = loader.getController();
    controller.setUser(user);

    String title = user.isEmpty() ? StringRes.ADD_USER : StringRes.EDIT_USER;
    Stage dialogStage = new DialogStageHelper.Builder(app)
        .setPane(dialogLayout)
        .setTitle(title)
        .build()
        .createDialogStage();

    controller.dialogStage = dialogStage;

    dialogStage.showAndWait();
  }

}
