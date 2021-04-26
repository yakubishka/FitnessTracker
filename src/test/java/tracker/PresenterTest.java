package tracker;

import org.junit.jupiter.api.Test;
import tracker.model.User;
import tracker.model.activities.BicycleActivity;
import tracker.model.activities.RunActivity;
import tracker.model.activities.SwimActivity;
import tracker.scenes.timer.TimerPresenter;

import static org.junit.jupiter.api.Assertions.*;

public class PresenterTest {

  @Test
  public void testBicycleCaloriesCalculation() {
    BicycleActivity activity = new BicycleActivity();
    activity.currentTimer += 2;
    assertEquals(activity.calculateCaloriesLoss(), 24);
  }

  @Test
  public void testRubCaloriesCalculation() {
    RunActivity activity = new RunActivity();
    activity.currentTimer += 2;
    assertEquals(activity.calculateCaloriesLoss(), 10);
  }

  @Test
  public void testSwimCaloriesCalculation() {
    SwimActivity activity = new SwimActivity();
    activity.currentTimer += 2;
    assertEquals(activity.calculateCaloriesLoss(), 30);
  }


  @Test
  public void isUserEmpty() {
    User user = new User();
    assertTrue(user.isEmpty());
  }


}
