import java.util.Random;

public class Child implements Runnable
{
  private final String name;
  PiggyBank mine, notMine;

  public Child(String name, PiggyBank mine, PiggyBank notMine)
  {
    this.name = name;
    this.notMine = notMine;
    this.mine = mine;
  }

  @Override public void run()
  {
    Random random = new Random();
    while (true)
    {
      System.out.println(name + " wants to send money");
      mine.transfer(notMine, random.nextInt(4) + 1);
    }
  }
}
