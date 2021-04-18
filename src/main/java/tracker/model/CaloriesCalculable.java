package tracker.model;

import tracker.utils.StringRes;

public abstract class CaloriesCalculable {

  public enum ActivityType {

    SWIM(StringRes.SWIMMING_TITLE),
    RUN(StringRes.RUNNING_TITLE),
    BICYCLE(StringRes.BICYCLE_TITLE);

    ActivityType(String activityTitle) {
      this.activityTitle = activityTitle;
    }

    private final String activityTitle;
  }

  abstract protected double getCaloriesLossPerSecond();
  abstract protected ActivityType getActivityType();

  public int currentTimer = 0;

  public double calculateCaloriesLoss(long time) {
    return time * getCaloriesLossPerSecond();
  }

  @Override
  public String toString() {
    return getActivityType().activityTitle;
  }

}
