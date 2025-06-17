public class Main {

    public static void main(String[] args) {

        // Caminhos dos arquivos
        String[] caminhoArquivos = {
                "conjuntos/aleatorio_100.csv",
                "conjuntos/aleatorio_1000.csv",
                "conjuntos/aleatorio_10000.csv",
                "conjuntos/crescente_100.csv",
                "conjuntos/crescente_1000.csv",
                "conjuntos/crescente_10000.csv",
                "conjuntos/decrescente_100.csv",
                "conjuntos/decrescente_1000.csv",
                "conjuntos/decrescente_10000.csv"
        };

        System.out.println("TESTE DE ALGORITMOS DE ORDENAÇÃO\n");

        for (String arquivo : caminhoArquivos) {
            System.out.println("Testando arquivo: " + arquivo);

            // Lê os dados do arquivo
            int[] dadosOriginais = LeitorArquivo.lerArquivoCSV(arquivo);

            if (dadosOriginais.length == 0) {
                System.out.println("  Arquivo vazio ou com erro. Pulando...\n");
                continue;
            }

            // BUBBLE SORT
            int[] dadosBubble = copiarVetor(dadosOriginais);
            BubbleSort bubbleSort = new BubbleSort();

            long tempoInicio = System.nanoTime();
            bubbleSort.ordenarBolha(dadosBubble);
            long tempoFim = System.nanoTime();
            long tempoBubble = tempoFim - tempoInicio;

            System.out.println("  Bubble Sort: " + tempoBubble + " nanossegundos");

            // INSERTION SORT
            int[] dadosInsercao = copiarVetor(dadosOriginais);
            InsertionSort insertionSort = new InsertionSort();

            tempoInicio = System.nanoTime();
            insertionSort.ordenarInsercao(dadosInsercao);
            tempoFim = System.nanoTime();
            long tempoInsercao = tempoFim - tempoInicio;

            System.out.println("  Insertion Sort: " + tempoInsercao + " nanossegundos");

            // QUICK SORT
            int[] dadosRapido = copiarVetor(dadosOriginais);
            QuickSort quickSort = new QuickSort();

            tempoInicio = System.nanoTime();
            quickSort.ordenarRapido(dadosRapido, 0, dadosRapido.length - 1);
            tempoFim = System.nanoTime();
            long tempoRapido = tempoFim - tempoInicio;

            System.out.println("  Quick Sort: " + tempoRapido + " nanossegundos");
            System.out.println();
        }
    }

    // Copia um vetor para outro
    private static int[] copiarVetor(int[] vetorOriginal) {
        int[] copia = new int[vetorOriginal.length];

        for (int i = 0; i < vetorOriginal.length; i++) {
            copia[i] = vetorOriginal[i];
        }

        return copia;
    }
}