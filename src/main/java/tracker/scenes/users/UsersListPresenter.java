package tracker.scenes.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tracker.model.User;

public class UsersListPresenter {

  private final ObservableList<User> users = FXCollections.observableArrayList();

  public UsersListPresenter() {
    users.add(new User("Petr", "Stepanov", 24, 20, 12));
    users.add(new User("Stepan", "Fedorov"));
  }

  public ObservableList<User> getUsers() {
    return users;
  }

  public void deleteUserByIndex(int index) {
    users.remove(index);
  }

  public void addToList(User user) {
    users.add(user);
  }

}
