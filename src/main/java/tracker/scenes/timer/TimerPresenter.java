package tracker.scenes.timer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;
import tracker.model.CaloriesCalculable;
import tracker.model.User;
import tracker.model.activities.BicycleActivity;
import tracker.model.activities.RunActivity;
import tracker.model.activities.SwimActivity;
import tracker.utils.StringRes;

public class TimerPresenter {

  private final ObservableList<CaloriesCalculable> activities = FXCollections.observableArrayList();

  private User selectedUser;
  private boolean isStarted = false;   
  private OnTimerTickListener onTimerTickListener;
  private int selectedMenuIndex = 0;

  private final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
    if (!activities.isEmpty()) {
      activities.get(selectedMenuIndex).currentTimer++;
      onTimerTickListener.onTimeChange(createTimerText(activities.get(selectedMenuIndex).currentTimer));
    }
  }));

  public TimerPresenter(OnTimerTickListener onTimerTickListener) {
    this.onTimerTickListener = onTimerTickListener;
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.setAutoReverse(false);
    activities.add(new BicycleActivity());
    activities.add(new RunActivity());
    activities.add(new SwimActivity());
  }

  public String createTimerText(int pastSeconds) {
    int hours = (pastSeconds / 60 / 60);
    int minutes = (pastSeconds / 60) % 60;
    int seconds = pastSeconds % 60;
    return String.format(StringRes.TIMER_FORMAT, hours, minutes, seconds);
  }

  public ObservableList<CaloriesCalculable> getActivities() {
    return activities;
  }

  public void setSelectedUser(User selectedUser) {
    this.selectedUser = selectedUser;
  }

  public void startOrPauseTimer() {
    if (isStarted) {
      isStarted = false;
      timeline.stop();
    } else {
      isStarted = true;
      timeline.play();
    }
  }

  public String clearTimerAndGetInitText() {
    isStarted = false;
    activities.get(selectedMenuIndex).currentTimer = 0;
    timeline.stop();
    return createTimerText(activities.get(selectedMenuIndex).currentTimer);
  }

  public boolean isStarted() {
    return isStarted;
  }

  public void setSelectedMenuIndex(int selectedMenuIndex) {
    this.selectedMenuIndex = selectedMenuIndex;
  }
}
