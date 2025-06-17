import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {

    // Lê arquivo CSV e retorna array de números
    public static int[] lerArquivoCSV(String caminhoArquivo) {
        int[] vetorTemporario = new int[10000]; // Tamanho máximo
        int contador = 0;

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            // Pula a primeira linha (cabeçalho)
            leitor.readLine();

            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] numerosTexto = dividirTexto(linha, ',');

                for (int i = 0; i < numerosTexto.length; i++) {
                    String numeroTexto = limparTexto(numerosTexto[i]);

                    if (numeroTexto.length() > 0) {
                        try {
                            vetorTemporario[contador] = converterParaNumero(numeroTexto);
                            contador++;
                        } catch (NumberFormatException e) {
                            // Ignora erros de conversão
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + caminhoArquivo);
        }

        // Cria array do tamanho exato
        int[] vetorFinal = new int[contador];
        for (int i = 0; i < contador; i++) {
            vetorFinal[i] = vetorTemporario[i];
        }

        return vetorFinal;
    }

    // Converte texto para número
    private static int converterParaNumero(String texto) throws NumberFormatException {
        int numero = 0;
        int sinal = 1;
        int posicao = 0;
        int tamanho = texto.length();

        if (tamanho == 0) {
            throw new NumberFormatException("Texto vazio");
        }

        // Verifica sinal
        if (texto.charAt(0) == '-') {
            sinal = -1;
            posicao++;
        } else if (texto.charAt(0) == '+') {
            posicao++;
        }

        // Converte cada dígito
        while (posicao < tamanho) {
            char caractere = texto.charAt(posicao);

            if (caractere < '0' || caractere > '9') {
                throw new NumberFormatException("Caractere inválido: " + caractere);
            }

            numero = numero * 10 + (caractere - '0');
            posicao++;
        }

        return sinal * numero;
    }

    // Divide texto por delimitador
    private static String[] dividirTexto(String texto, char separador) {
        int contadorSeparadores = 0;

        // Conta quantos separadores existem
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == separador) {
                contadorSeparadores++;
            }
        }

        String[] resultado = new String[contadorSeparadores + 1];
        int ultimoIndice = 0;
        int indiceResultado = 0;

        // Divide o texto
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == separador) {
                resultado[indiceResultado] = texto.substring(ultimoIndice, i);
                ultimoIndice = i + 1;
                indiceResultado++;
            }
        }

        resultado[indiceResultado] = texto.substring(ultimoIndice);
        return resultado;
    }

    // Remove espaços em branco
    private static String limparTexto(String texto) {
        int inicio = 0;
        int fim = texto.length() - 1;

        // Remove espaços do início
        while (inicio <= fim && (texto.charAt(inicio) == ' ' || texto.charAt(inicio) == '\t')) {
            inicio++;
        }

        // Remove espaços do fim
        while (fim >= inicio && (texto.charAt(fim) == ' ' || texto.charAt(fim) == '\t')) {
            fim--;
        }

        if (inicio > fim) {
            return "";
        }

        return texto.substring(inicio, fim + 1);
    }
}