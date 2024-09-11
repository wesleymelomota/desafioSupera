package desafioSupera.desafio.snail;

import java.util.ArrayList;
import java.util.List;

public class MatrizCaracol {

    public static List<Integer> ordenarMatrizSentidoCaracol(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return resultado;
        }

        int topo = 0, baixo = matriz.length - 1;
        int esquerda = 0, direita = matriz[0].length - 1;

        while (topo <= baixo && esquerda <= direita) {
            // Percorrer da esquerda para a direita ao longo da linha superior
            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[topo][i]);
            }
            topo++;

            // Percorrer de cima para baixo ao longo da coluna direita
            for (int i = topo; i <= baixo; i++) {
                resultado.add(matriz[i][direita]);
            }
            direita--;

            // Percorrer da direita para a esquerda ao longo da linha inferior
            if (topo <= baixo) {
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[baixo][i]);
                }
                baixo--;
            }

            // Percorrer de baixo para cima ao longo da coluna esquerda
            if (esquerda <= direita) {
                for (int i = baixo; i >= topo; i--) {
                    resultado.add(matriz[i][esquerda]);
                }
                esquerda++;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> resultado = ordenarMatrizSentidoCaracol(matriz);
        System.out.println(resultado); 

        int[][] matrizVazia = {};
        List<Integer> resultadoVazia = ordenarMatrizSentidoCaracol(matrizVazia);
        System.out.println(resultadoVazia);

        int[][] matriz4x4 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int[][] matriz5x5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
            };

        List<Integer> resultado4x4 = ordenarMatrizSentidoCaracol(matriz4x4);
        System.out.println(resultado4x4);
        List<Integer> resultado5x5 = ordenarMatrizSentidoCaracol(matriz5x5);
        System.out.println(resultado5x5);
    }
}
