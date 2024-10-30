
// Interfaz Iterator
import java.util.Iterator;

class Secuencia implements Iterable<Integer> {
    private int[] array;

    public Secuencia(int... array) {
        this.array = array;
    }

    public Iterator<Integer> iterator() {
        return new SecIter();
    }

    private class SecIter implements Iterator<Integer> {
        private int index;

        public boolean hasNext() {
            return index < array.length;
        }

        public Integer next() {
            return array[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

public class Ej14_26 {
    public static void main(String[] args) {
        Secuencia sec = new Secuencia(1, 2, 3, 4, 5);
        // for each usa internamente el iterador
        for (int num : sec) {
            System.out.print(num + " ");
        }
        System.out.print("\n");
        // uso directo del iterador
        Iterator<Integer> iter = sec.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}