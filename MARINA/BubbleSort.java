public class BubbleSort {

    // Troca dois elementos no array
    void trocar(int[] vetor, int posicao1, int posicao2) {
        int auxiliar = vetor[posicao1];
        vetor[posicao1] = vetor[posicao2];
        vetor[posicao2] = auxiliar;
    }

    // Ordenação por bolha
    void ordenarBolha(int[] vetor) {
        int tamanho = vetor.length;
        boolean trocou;

        for (int i = 0; i < tamanho - 1; i++) {
            trocou = false;

            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    trocar(vetor, j, j + 1);
                    trocou = true;
                }
            }

            // Se não houve troca, o vetor já está ordenado
            if (!trocou) {
                break;
            }
        }
    }
}
