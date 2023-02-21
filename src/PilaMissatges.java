import java.util.concurrent.Semaphore;

public class PilaMissatges {
    private String[] pila;
    public int last;

    public PilaMissatges() {
        pila = new String[10];
        last = -1;
    }

    public synchronized void push(String msg, int prodId) {
        while (last == 9) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        last++;
        pila[last] = "Productor (" + prodId + ") " + msg;
        System.out.println("msg[" + last + "]: " + pila[last]);
        notifyAll();
    }

    public synchronized String pop() {
        while (last == -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String msg = pila[last];
        pila[last] = null;
        last--;
        System.out.println("msg[" + (last + 1) + "]: null");
        notifyAll();
        return msg;
    }
}
