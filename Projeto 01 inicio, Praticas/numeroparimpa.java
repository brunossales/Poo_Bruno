public class numeroparimpa{
    public static void main(String[] args) {
        int i;
        for(i=1; i<20; i++){
            if(i % 2 == 0){
                System.out.println("Esse numero é par -> ");
                System.out.println(i);
            }
            else if(i % 2 != 0 || i == 1){
                System.out.println("Esse numero é impar -> ");
                System.out.println(i);
            }
        }
        
    }
}