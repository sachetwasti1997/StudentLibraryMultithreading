import java.util.Random;

public class Student implements Runnable{

    private final int id;
    private final Random random;
    private final Book[] books;

    public Student(int id, Book[] books) {
        this.id = id;
        random = new Random();
        this.books = books;
    }

    @Override
    public void run() {
        while (true) {
            int bookId = random.nextInt(0, Constants.NUM_OF_BOOKS);
            try {
                books[bookId].readBook(this);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
