import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private final int id;
    private final Lock lock;

    public Book(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public void readBook(Student student) throws InterruptedException {
        try {
            if (lock.tryLock(10, TimeUnit.MINUTES)) {
                System.out.println(student+" has started reading "+this);
                Thread.sleep(2000);
            }
        } finally {
            lock.unlock();
            System.out.println(student+" has just finished reading "+this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                '}';
    }
}
