package tracker.scenes.users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tracker.model.User;

import java.util.List;

public class UsersListPresenter {

  private final ObservableList<User> users = FXCollections.observableArrayList();

  public UsersListPresenter(){ }

  public ObservableList<User> getUsers() {
    return users;
  }

  public void deleteUserByIndex(int index) {
    users.remove(index);
  }

  public void addToList(User user) {
    users.add(user);
  }

  public void addAllToList(List<User> users) {
    this.users.addAll(users);
  }

}
