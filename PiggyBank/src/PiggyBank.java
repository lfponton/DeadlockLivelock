import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PiggyBank
{
  private double balance;
  private String name;
  private Lock lock = new ReentrantLock();

  public PiggyBank(String name)
  {
    this.name = name;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public Lock getLock()
  {
    return lock;
  }

  public void transfer(PiggyBank to, double amount)
  {
    boolean success = false;
    while (!success) {
      if (lock.tryLock()) {
        if (to.getLock().tryLock())
        {
        withdraw(amount);
        to.deposit(amount);
        to.getLock().unlock();
        System.out.println("Transfer from " + name + " to " + to.getName());
        success = true;
      }
      lock.unlock();
    }
    try
    {
      Thread.sleep(1);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }}

  public String getName()
  {
    return name;
  }
}
