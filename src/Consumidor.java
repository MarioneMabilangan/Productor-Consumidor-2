public class Consumidor extends Thread {
    private int id;
    private PilaMissatges pila;

    public Consumidor(int id, PilaMissatges pila) {
        this.id = id;
        this.pila = pila;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int)(Math.random()*300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pila.pop();
        }
    }
}