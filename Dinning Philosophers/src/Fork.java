public class Fork
{
  private boolean isInUse = false;
  private int forkNum;

  public Fork(int forkNum) {
    this.forkNum = forkNum;
  }

  public synchronized void pickUp() {
    while (isInUse) {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    isInUse = true;
  }

  public synchronized void putDown() {
    isInUse = false;
    notifyAll();
  }

  public int getForkNum()
  {
    return forkNum;
  }
}
