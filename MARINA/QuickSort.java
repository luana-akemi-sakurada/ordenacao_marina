public class QuickSort {

    // Troca dois elementos no array
    void trocar(int[] vetor, int posicao1, int posicao2) {
        int auxiliar = vetor[posicao1];
        vetor[posicao1] = vetor[posicao2];
        vetor[posicao2] = auxiliar;
    }

    // Divide o array em duas partes
    int dividir(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int indiceMenor = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] < pivo) {
                indiceMenor++;
                trocar(vetor, indiceMenor, j);
            }
        }

        trocar(vetor, indiceMenor + 1, fim);
        return indiceMenor + 1;
    }

    // Ordenação rápida
    void ordenarRapido(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = dividir(vetor, inicio, fim);

            // Ordena as duas metades
            ordenarRapido(vetor, inicio, posicaoPivo - 1);
            ordenarRapido(vetor, posicaoPivo + 1, fim);
        }
    }
}