package tracker.architecture;

import tracker.app.MainApp;

public abstract class BaseViewController {

  protected MainApp app;

  public void setMainApp(MainApp app) {
    this.app = app;
  }

}
