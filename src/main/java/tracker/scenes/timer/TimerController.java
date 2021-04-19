package tracker.scenes.timer;

import com.sun.istack.NotNull;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tracker.app.DialogStageHelper;
import tracker.app.MainApp;
import tracker.model.CaloriesCalculable;
import tracker.model.User;
import tracker.utils.StringRes;

public class TimerController {

  @FXML
  private ListView<CaloriesCalculable> activityListView;

  @FXML
  private Button startPauseButton;

  @FXML
  private Label timerLabel;

  private Stage dialogStage;

  private final TimerPresenter presenter = new TimerPresenter((timerText) -> {
    timerLabel.setText(timerText);
  });

  @FXML
  private void initialize() {
    activityListView.getSelectionModel().select(0);
    activityListView.setItems(presenter.getActivities());
    timerLabel.setText(presenter.clearTimerAndGetInitText());
    activityListView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
      startPauseButton.setText(StringRes.START);
      timerLabel.setText(presenter.resetNewActivityTimer((int)newValue));
    });
  }

  @FXML
  private void startOrPauseTimer() {
    presenter.startOrPauseTimer();
    if (presenter.isStarted())
      startPauseButton.setText(StringRes.PAUSE);
    else
      startPauseButton.setText(StringRes.START);
  }

  @FXML
  private void clearTimer() {
    timerLabel.setText(presenter.clearTimerAndGetInitText());
  }

  @FXML
  private void saveAndExitAction() {
    presenter.saveResults();
    dialogStage.close();
  }

  public void setUser(User user) {
    presenter.setSelectedUser(user);
  }

  public static void showAsDialog(MainApp app, @NotNull User user) {
    FXMLLoader loader = app.createLoader("TimerDialogLayout.fxml");
    AnchorPane dialogLayout = app.getPaneFromLoader(loader);
    TimerController controller = loader.getController();
    controller.setUser(user);

    Stage dialogStage = new DialogStageHelper.Builder(app)
        .setPane(dialogLayout)
        .setTitle(StringRes.ACTIVITY_DIALOG_TITLE)
        .build()
        .createDialogStage();

    controller.setDialogStage(dialogStage);
    dialogStage.showAndWait();
  }

  public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
  }
}
