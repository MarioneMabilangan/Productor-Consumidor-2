public class Productor extends Thread {
    private int id;
    private PilaMissatges pila;

    public Productor(int id, PilaMissatges pila) {
        this.id = id;
        this.pila = pila;
    }

    public void run() {
        int msgCount = 1;
        while (true) {
            try {
                Thread.sleep((int)(Math.random()*300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String msg = "Missatge " + msgCount;
            pila.push(msg, id);
            System.out.println("msg[" + pila.last + "]: Productor (" + id + ") " + msg);
            msgCount++;
        }
    }
}
