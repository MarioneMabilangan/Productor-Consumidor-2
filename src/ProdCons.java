public class ProdCons {
    public static void main(String[] args) {
        PilaMissatges pila = new PilaMissatges();

        for (int i = 0; i < 3; i++) {
            Thread prod = new Thread(new Productor(i, pila));
            prod.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread cons = new Thread(new Consumidor(i, pila));
            cons.start();
        }
    }
}