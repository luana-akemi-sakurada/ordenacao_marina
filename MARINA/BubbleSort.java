public class BubbleSort {
    void ordenarBolha(int[] vetor) {
        // Chama a função recursiva para o vetor inteiro.
        ordenarBolhaRecursivo(vetor, vetor.length);
    }

    private void ordenarBolhaRecursivo(int[] vetor, int n) {
        // Caso base: se o array tem 1 ou menos elementos, já está ordenado.
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                // Utiliza a classe Swap para trocar os elementos.
                Swap.swap(vetor, i, i + 1);
            }
        }
        ordenarBolhaRecursivo(vetor, n - 1);
    }
}
