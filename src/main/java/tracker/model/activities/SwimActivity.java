package tracker.model.activities;

import tracker.model.CaloriesCalculable;

public class SwimActivity extends CaloriesCalculable {

  @Override
  protected double getCaloriesLossPerSecond() {
    return 15;
  }

  @Override
  protected ActivityType getActivityType() {
    return ActivityType.SWIM;
  }
}
