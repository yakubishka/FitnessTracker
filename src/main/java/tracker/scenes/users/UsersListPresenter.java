package tracker.scenes.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tracker.model.User;

public class UsersListPresenter {

  private ObservableList<User> users = FXCollections.observableArrayList();

  public UsersListPresenter() {
    users.add(new User(0,"Petr", "Stepanov"));
    users.add(new User(1, "Stepan", "Fedorov"));
  }

  public ObservableList<User> getUsers() {
    return users;
  }

}
