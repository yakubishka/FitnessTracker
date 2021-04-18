package tracker.utils.storage;

import java.io.File;
import java.util.prefs.Preferences;

public class UsersPreferences implements PreferenceStorage {

  private static final String PREFERENCES_KEY = "UserData";
  private final Class<?> contextClass;

  public UsersPreferences(Class<?> contextClass) {
    this.contextClass = contextClass;
  }

  @Override
  public File getStorageFile() {
    Preferences preferences = Preferences.userNodeForPackage(contextClass);
    String filePath = preferences.get(PREFERENCES_KEY, null);
    if (filePath != null)
      return new File(filePath);
    else
      return null;
  }

  @Override
  public void setStorageFile(File file) {
    Preferences prefs = Preferences.userNodeForPackage(contextClass);
    if (file != null)
      prefs.put(PREFERENCES_KEY, file.getPath());
    else
      prefs.remove(PREFERENCES_KEY);
  }

}
