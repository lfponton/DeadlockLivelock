import java.util.Random;

public class Philosopher implements Runnable
{
  private Fork f1, f2;
  private String name;

  public Philosopher(Fork f1, Fork f2, String name)
  {
    this.f1 = f1;
    this.f2 = f2;
    this.name = name;
  }

  @Override public void run()
  {
    Random random = new Random();
    while (true) {
      int eat = random.nextInt(2);
      if (eat == 0) {
        System.out.println(name + " wants to eat");
        f1.pickUp();
        System.out.println(name + " picked up fork " + f1.getForkNum());
        f2.pickUp();
        System.out.println(name + " picked up fork " + f2.getForkNum());
        System.out.println(name + " is now eating");
        try
        {
          Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        f1.putDown();
        System.out.println(name + " put down fork " + f1.getForkNum());
        f2.putDown();
        System.out.println(name + " put down fork " + f2.getForkNum());
      }
      else {
        System.out.println(name + " is thinking");
        try
        {
          Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
