package tracker.utils;

import java.io.File;
import java.util.prefs.Preferences;

public class UsersPreferences {

  private static final String PREFERENCES_KEY = "UserData";

  public static File getPreferencesFilePath(Class<?> nodeClass) {
    Preferences preferences = Preferences.userNodeForPackage(nodeClass);
    String filePath = preferences.get(PREFERENCES_KEY, null);
    if (filePath != null)
      return new File(filePath);
    else
      return null;
  }

}
