public class ProvaArray {
    public static void main(String[] args) {
        int grandezza = 5;
        int[] arrayNumeri = new int[grandezza];
        for(int i = 0; i < arrayNumeri.length; i++){
            arrayNumeri[i] = i + 1;
        }
        for(int n : arrayNumeri){
            System.out.print(n + ", ");
        }
    }
}
