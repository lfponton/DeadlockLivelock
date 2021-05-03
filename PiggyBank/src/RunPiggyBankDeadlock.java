public class RunPiggyBankDeadlock
{
  public static void main(String[] args)
  {
    PiggyBank a = new PiggyBank("Kelly's bank");
    PiggyBank b = new PiggyBank("Roy's bank");
    (new Thread(new Child("Kelly", a, b))).start();
    (new Thread(new Child("Roy", b, a))).start();
  }
}
