package tracker.scenes.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tracker.model.User;

public class UsersListPresenter {

  private ObservableList<User> users = FXCollections.observableArrayList();

  public UsersListPresenter() {
    users.add(new User("Petr", "Stepanov"));
    users.add(new User("Stepan", "Fedorov"));
  }

  public ObservableList<User> getUsers() {
    return users;
  }

  public void deleteUserByIndex(int index) {
    users.remove(index);
  }

}
