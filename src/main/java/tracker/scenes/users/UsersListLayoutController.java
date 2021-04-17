package tracker.scenes.users;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tracker.architecture.BaseViewController;
import tracker.model.User;
import tracker.scenes.userchanges.ChangeUserDialogController;

public class UsersListLayoutController extends BaseViewController {

  private UsersListPresenter presenter =  new UsersListPresenter();

  @FXML
  private TableView<User> userTableView;

  @FXML
  private TableColumn<User, String> firstNameColumn;

  @FXML
  private TableColumn<User, String> lastNameColumn;

  @FXML
  private void initialize() {
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    userTableView.setItems(presenter.getUsers());
  }

  @FXML
  private void deleteUser() {
    int selectedUserIndex = userTableView.getSelectionModel().getSelectedIndex();
    presenter.deleteUserByIndex(selectedUserIndex);
  }

  @FXML
  private void editUser() {
    if (app != null)
      ChangeUserDialogController.showAsDialog(app, true);
  }

  @FXML
  private void addUser() {
    if (app != null) {
      ChangeUserDialogController.showAsDialog(app, false);
      System.out.println("here");
    }
  }

}
