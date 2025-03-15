class Counter extends Thread {
    private String taskName;
    private int delay;

    Counter(String taskName, int delay) {
        this.taskName = taskName;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
            }
        }
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        Counter task1 = new Counter("Task 1", 500);
        Counter task2 = new Counter("Task 2", 700);

        task1.start();
        task2.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Main Thread interrupted.");
            }
        }
    }
}
