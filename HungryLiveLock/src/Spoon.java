public class Spoon
{
  private HungryFriend owner;

  public HungryFriend getOwner()
  {
    return owner;
  }

  public synchronized void setOwner(HungryFriend owner)
  {
    this.owner = owner;
  }

  public synchronized void use() {
    System.out.println(owner.getName() + " is eating");
  }
}
