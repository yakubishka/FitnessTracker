package tracker.scenes.users;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tracker.model.User;

public class UsersListLayoutController {

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



}
