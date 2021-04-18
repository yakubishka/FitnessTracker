package tracker.scenes.users;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tracker.architecture.BaseViewController;
import tracker.model.User;
import tracker.scenes.timer.TimerController;
import tracker.scenes.userchanges.ChangeUserDialogController;

public class UsersListLayoutController extends BaseViewController {

  private final UsersListPresenter presenter =  new UsersListPresenter();

  @FXML
  private TableView<User> userTableView;

  @FXML
  private TableColumn<User, String> firstNameColumn;

  @FXML
  private TableColumn<User, String> lastNameColumn;

  @FXML
  private Label bicycleLabel;

  @FXML
  private Label runLabel;

  @FXML
  private Label swimLabel;

  @FXML
  private void initialize() {
    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    userTableView.setItems(presenter.getUsers());
    userTableView.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> showStatistic(newValue)
    );
  }

  @FXML
  private void deleteUser() {
    int selectedUserIndex = userTableView.getSelectionModel().getSelectedIndex();
    presenter.deleteUserByIndex(selectedUserIndex);
  }

  @FXML
  private void showStatistic(User user) {
    bicycleLabel.setText(user.getBicycleCaloriesLoss() + "");
    runLabel.setText(user.getRunningCaloriesLoss() + "");
    swimLabel.setText(user.getSwimmingCaloriesLoss() + "");
  }

  @FXML
  private void editUser() {
    if (app != null)
      ChangeUserDialogController.showAsDialog(app, userTableView.getSelectionModel().getSelectedItem());
  }

  @FXML
  private void addUser() {
    if (app != null) {
      User userToAdd = new User("", "");
      ChangeUserDialogController.showAsDialog(app, userToAdd);
      presenter.addToList(userToAdd);
    }
  }

  @FXML
  private void startTraining() {
    if (app != null)
      TimerController.showAsDialog(app, userTableView.getSelectionModel().getSelectedItem());
  }

}
