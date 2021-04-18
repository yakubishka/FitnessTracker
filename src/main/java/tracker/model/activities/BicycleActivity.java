package tracker.model.activities;

import tracker.model.CaloriesCalculable;

public class BicycleActivity extends CaloriesCalculable {
  @Override
  protected double getCaloriesLossPerSecond() {
    return 12;
  }

  @Override
  protected ActivityType getActivityType() {
    return ActivityType.BICYCLE;
  }
}
