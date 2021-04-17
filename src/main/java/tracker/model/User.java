package tracker.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

  private IntegerProperty index;
  private StringProperty firstName;
  private StringProperty lastName;

  public User(int index, String firstName, String lastName) {
    this.index = new SimpleIntegerProperty(index);
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
  }

  public int getIndex() {
    return index.get();
  }

  public IntegerProperty indexProperty() {
    return index;
  }

  public void setIndex(int index) {
    this.index.set(index);
  }

  public String getFirstName() {
    return firstName.get();
  }

  public StringProperty firstNameProperty() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName.set(firstName);
  }

  public String getLastName() {
    return lastName.get();
  }

  public StringProperty lastNameProperty() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName.set(lastName);
  }

}
