package tracker.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

  private final StringProperty firstName;
  private final StringProperty lastName;
  private final IntegerProperty swimmingCaloriesLoss;
  private final IntegerProperty runningCaloriesLoss;
  private final IntegerProperty bicycleCaloriesLoss;

  public User(String firstName, String lastName) {
    this(firstName, lastName, 0, 0, 0);
  }

  public User(String firstName, String lastName, int swimmingCaloriesLoss, int runningCaloriesLoss, int bicycleCaloriesLoss) {
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
    this.swimmingCaloriesLoss = new SimpleIntegerProperty(swimmingCaloriesLoss);
    this.runningCaloriesLoss = new SimpleIntegerProperty(runningCaloriesLoss);
    this.bicycleCaloriesLoss = new SimpleIntegerProperty(bicycleCaloriesLoss);
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

  public int getSwimmingCaloriesLoss() {
    return swimmingCaloriesLoss.get();
  }

  public IntegerProperty swimmingCaloriesLossProperty() {
    return swimmingCaloriesLoss;
  }

  public void setSwimmingCaloriesLoss(int swimmingCaloriesLoss) {
    this.swimmingCaloriesLoss.set(swimmingCaloriesLoss);
  }

  public int getRunningCaloriesLoss() {
    return runningCaloriesLoss.get();
  }

  public IntegerProperty runningCaloriesLossProperty() {
    return runningCaloriesLoss;
  }

  public void setRunningCaloriesLoss(int runningCaloriesLoss) {
    this.runningCaloriesLoss.set(runningCaloriesLoss);
  }

  public int getBicycleCaloriesLoss() {
    return bicycleCaloriesLoss.get();
  }

  public IntegerProperty bicycleCaloriesLossProperty() {
    return bicycleCaloriesLoss;
  }

  public void setBicycleCaloriesLoss(int bicycleCaloriesLoss) {
    this.bicycleCaloriesLoss.set(bicycleCaloriesLoss);
  }

  public boolean isEmpty() {
    return firstName.isEmpty().get() && lastName.isEmpty().get();
  }

}
