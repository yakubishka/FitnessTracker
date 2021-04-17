package tracker.utils.storage;

import java.io.File;

public interface PreferenceStorage {

  public File getStorageFile();
  public void setStorageFile(File file);

}
