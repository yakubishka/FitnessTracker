package tracker.model;

public class Task {

  private long startDate;
  private long endDate;
  private int caloriesPerTime;

  public Task(long startDate, long endDate, int caloriesPerTime) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.caloriesPerTime = caloriesPerTime;
  }

  public long getStartDate() {
    return startDate;
  }

  public void setStartDate(long startDate) {
    this.startDate = startDate;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }

  public int getCaloriesPerTime() {
    return caloriesPerTime;
  }

  public void setCaloriesPerTime(int caloriesPerTime) {
    this.caloriesPerTime = caloriesPerTime;
  }
}
