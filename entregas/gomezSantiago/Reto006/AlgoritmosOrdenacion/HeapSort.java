package entregas.gomezSantiago.Reto006.AlgoritmosOrdenacion;

public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("+---------------------------------------------+");
            System.out.println("| Construyendo montículo desde el índice " + i);
            System.out.println("+---------------------------------------------+");
            heapify(array, n, i);
        }

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // llamar a la función de reducción del montículo en el montículo reducido
            System.out.println("+---------------------------------------------+");
            System.out.println("| Extrayendo el máximo elemento del montículo");
            System.out.println("+---------------------------------------------+");
            heapify(array, i, 0);
        }
    }

    // Para convertir un subarreglo en un montículo
    static void heapify(int array[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("+---------------------+");
        System.out.println("| Array original:");
        System.out.println("+---------------------+");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n\nPasos del algoritmo Heap Sort:");

        // Llamada inicial al método sort
        sort(array);

        System.out.println("\n+---------------------+");
        System.out.println("| Array ordenado:");
        System.out.println("+-----------------------+");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}