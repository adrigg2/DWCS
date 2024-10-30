import java.util.Iterator;

class Caja implements Iterable<Integer> {
    private int ancho;
    private int alto;
    private int profundidad;

    public Caja(int ancho, int alto, int profundidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundidad = profundidad;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public Iterator<Integer> iterator() {
        return new CajaIter();
    }

    private class CajaIter implements Iterator<Integer> {
        private int indice = 0;

        public boolean hasNext() {
            return indice < 3;
        }

        public Integer next() {
            int valor;
            switch (indice) {
                case 0:
                    valor = ancho;
                    break;
                case 1:
                    valor = alto;
                    break;
                case 2:
                    valor = profundidad;
                    break;
                default:
                    throw new IllegalStateException("Final");
            }
            indice++;
            return valor;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

public class Ej14_27 {
    public static void main(String[] args) {
        Caja caja = new Caja(10, 20, 30);
        System.out.println("Dimensiones de la caja:");
        for (int dimension : caja) {
            System.out.println(dimension);
        }
    }
}