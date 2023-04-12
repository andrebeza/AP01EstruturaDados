import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Version2 {
    public static void main(String[] args) {
        long comecoTimer = new Date().getTime();

        System.out.println("""
                Primeira Avaliação Parcial de Estrutura de Dados.
                Componentes: João André e Rául.
                Professor: Ramon Lummertz
                Ulbra-Torres/2023-1
                """);

        int matrizDesejada = 100;
        int[][] matriz = new int[matrizDesejada][matrizDesejada];

        //long comecoTimer = new Date().getTime();

        //preencher
        for(int l = 0; l <matriz.length-1;l++){
            for(int c = 0; c < matriz[0].length-1;c++){
                matriz[l][c] = (int) (Math.random()*2);
            }
        }
        //imprimir matriz
        for(int l = 0; l <matriz.length-1;l++){
            for(int c = 0; c < matriz[0].length;c++){
                System.out.print(matriz[l][c]+" ");
            }
            System.out.println();
        }

        List<padraoLocal> local = findPattern(matriz);

        if(local.size() > 0) {
            System.out.println("Número de padrões encontrados: "+ local.size());

            for (padraoLocal location : local) {
                int linha = location.getLinha();
                int coluna = location.getColuna();
                System.out.println("\nPadrão encontrado na linha: "+linha+"\nColuna:"+coluna);
            }
        } else {
            System.out.println("Nenhum padrão encontrado.");
        }
        //TimeUnit.SECONDS.sleep(1); (delay para começar o timer)
        long fimTempo = new Date().getTime();
        long tempoGasto = fimTempo - comecoTimer;
        System.out.println("\nCronômetro em mil/segundos:"+tempoGasto);
        System.out.println("Cronômetro em segundos:" +tempoGasto/1000);
    }
    /*1 | 1
      1 | 0
      0 | 1
      padrão a ser encontrado <Busca do Padrão>*/
    public static List<padraoLocal> findPattern(int[][] matriz){
        List<padraoLocal> local = new ArrayList<>();

        for (int l = 0; l < matriz.length -2; l++){
            for (int c=0; c< matriz[0].length-1; c++){
                if (matriz[l][c] == 1 && matriz[l][c+1] == 1
                        && matriz[l+1][c]==1 && matriz[l+1][c+1] ==0
                        && matriz[l+2][c]==0 && matriz[l+2][c+1]==1){
                    local.add(new padraoLocal(l,c));
                }
            }
        }
        return local;
    }
}

record padraoLocal(int getLinha, int getColuna){
}


/*
class PatternLocation {
    private final int linha;
    private final int coluna;

    public PatternLocation(int linha, int coluna){
        this.linha=linha;
        this.coluna=coluna;
    }

    public int getLinha(){
        return linha;
    }

    public int getColuna(){
        return coluna;
    }
}
*/