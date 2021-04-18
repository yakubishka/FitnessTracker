package tracker.model.activities;

import tracker.model.CaloriesCalculable;

public class RunActivity extends CaloriesCalculable {
  @Override
  protected double getCaloriesLossPerSecond() {
    return 5;
  }

  @Override
  protected ActivityType getActivityType() {
    return ActivityType.RUN;
  }
}
