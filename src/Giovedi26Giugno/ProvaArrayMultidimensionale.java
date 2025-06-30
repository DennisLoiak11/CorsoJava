import org.w3c.dom.ls.LSOutput;

public class ProvaArrayMultidimensionale {
    public static void main(String[] args) {
        int [][] getMatriceNumeri = new int[3][3];
        int [][] matriceNumeri = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for(int i = 0; i < matriceNumeri.length; i++){
            for(int j = 0; j < matriceNumeri[i].length; j++){
                System.out.print(matriceNumeri[i][j] + "\t");
            }
        }
    }
}