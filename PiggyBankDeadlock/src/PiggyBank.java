public class PiggyBank
{
  private double balance;
  private String name;

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

  public void transfer(PiggyBank to, double amount)
  {
    System.out.println("Transfer from " + name + " to " + to.getName());
    synchronized (this) {
      synchronized (to) {
        withdraw(amount);
        to.deposit(amount);
      }
    }
  }

  public String getName()
  {
    return name;
  }
}
