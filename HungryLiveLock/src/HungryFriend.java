public class HungryFriend
{
  private String name;
  private boolean isHungry;

  public HungryFriend(String name) {
    this.name = name;
    isHungry = true;
  }

  public String getName()
  {
    return name;
  }

  public boolean isHungry()
  {
    return isHungry;
  }

  public void eatWith(Spoon spoon, HungryFriend otherFriend)
  {
    while (isHungry) {
      if (spoon.getOwner() != this)
      {
        try
        {
          System.out.println(name + ": I don't have the spoon!");
          Thread.sleep(10);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        continue;
      }
      if (otherFriend.isHungry()) {
        System.out.println(name +
            ": You eat first my darling" +
            otherFriend.getName());
        spoon.setOwner(otherFriend);
        continue;
      }

      spoon.use();
      isHungry = false;
      System.out.println(name +
          ": I am stuffed, ,y darling " +
          otherFriend.getName());
      spoon.setOwner(otherFriend);
    }
  }
}
