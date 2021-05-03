public class RunHungryLiveLock
{
  public static void main(String[] args)
  {
    HungryFriend hungryFriend1 = new HungryFriend("Terrance");
    HungryFriend hungryFriend2 = new HungryFriend("Phillip");
    Spoon spoon = new Spoon();
    hungryFriend1.eatWith(spoon, hungryFriend2);
    hungryFriend2.eatWith(spoon, hungryFriend1);
  }
}
