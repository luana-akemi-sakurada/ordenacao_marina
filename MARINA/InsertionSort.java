public class InsertionSort {

    void ordenarInsercao(int[] vetor) {
        int tamanho = vetor.length;

        for (int i = 1; i < tamanho; i++) {
            int j = i;

            // Enquanto o elemento anterior for maior, troca
            while (j > 0 && vetor[j - 1] > vetor[j]) {
                int temp = vetor[j];
                vetor[j] = vetor[j - 1];
                vetor[j - 1] = temp;
                j--;
            }
        }
    }
}