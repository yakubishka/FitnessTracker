package tracker.app;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogStageHelper {

  private final Pane pane;
  private final String title;
  private final Stage owner;

  private DialogStageHelper(Pane pane, String title, Stage owner) {
    this.pane = pane;
    this.title = title;
    this.owner = owner;
  }

  public Stage createDialogStage() {
    Stage dialogStage = new Stage();
    Scene scene = new Scene(pane);
    dialogStage.setScene(scene);
    dialogStage.setTitle(title);
    dialogStage.initModality(Modality.WINDOW_MODAL);
    dialogStage.initOwner(owner);
    return dialogStage;
  }

  public static class Builder {

    private Pane pane;
    private String title;
    private Stage owner;

    public Builder(MainApp app) {
      owner = app.getPrimaryStage();
    }

    public Builder setPane(Pane pane) {
      this.pane = pane;
      return this;
    }

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setOwner(Stage owner) {
      this.owner = owner;
      return this;
    }

    public DialogStageHelper build() {
      return new DialogStageHelper(pane, title, owner);
    }

  }

}
