public class RunDinningPhilosophers
{
  public static void main(String[] args)
  {
    Fork f1 = new Fork(1);
    Fork f2 = new Fork(2);
    Fork f3 = new Fork(3);
    Fork f4 = new Fork(4);
    Fork f5 = new Fork(5);
    Philosopher[] philosophers = {
        // Let one philosopher be opposite handed to avoid Deadlock
        new Philosopher(f2, f1, "Socrates"),
        new Philosopher(f2, f3, "Plato"),
        new Philosopher(f3, f4, "Aristotle"),
        new Philosopher(f4, f5, "Protagoras"),
        new Philosopher(f5, f1, "Heraclitus"),
    };

    for (Philosopher philosopher : philosophers) {
      (new Thread(philosopher)).start();
    }
  }
}
