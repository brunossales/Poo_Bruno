import java.util.Scanner;

public class Enum{
    public static void main(String[] args) {
        Shot bebida  = new Shot(5);
        Scanner ler = new Scanner(System.in);
        while(true){
            System.out.println("Digite 'tomar' e a bebida que deseja comprar para tomar uma doze dela");
            System.out.println("Digite 'mostrar', caso queira saber o quanto está devendo");
            System.out.println("Digite 'cardapio', caso não saiba o preço e as bebidas que tem");
            System.out.println("Digite 'sair', para sair da execução");
            String Op = ler.nextLine();
            String[] queb = Op.split(" ");
            if(queb[0].equals("tomar")){
                if(queb[1].equalsIgnoreCase(Bebidas.PITU.toString())){
                    bebida.TomarShot(Bebidas.PITU);
                }
                else if(queb[1].equalsIgnoreCase(Bebidas.MONTILA.toString())){
                    bebida.TomarShot(Bebidas.MONTILA);
                }
                else if(queb[1].equalsIgnoreCase(Bebidas.SKOL.toString())){
                    bebida.TomarShot(Bebidas.SKOL);
                }
                else if(queb[1].equalsIgnoreCase(Bebidas.SLOVA.toString())){
                    bebida.TomarShot(Bebidas.SLOVA);
                }
                else if(queb[1].equalsIgnoreCase(Bebidas.GIN.toString())){
                    bebida.TomarShot(Bebidas.GIN);
                }
                else
                    System.out.println("Bebida invalida!");
            }
            if(queb[0].equals("cardapio")){
                System.out.println("Bebida: " + Bebidas.PITU + ", Preço: " + Bebidas.PITU.getValor());
                System.out.println("Bebida: " + Bebidas.MONTILA + ", Preço: " + Bebidas.MONTILA.getValor());
                System.out.println("Bebida: " + Bebidas.SKOL + ", Preço: " + Bebidas.SKOL.getValor());
                System.out.println("Bebida: " + Bebidas.SLOVA + ", Preço: " + Bebidas.SLOVA.getValor());
                System.out.println("Bebida: " + Bebidas.GIN + ", Preço: " + Bebidas.GIN.getValor());
            }
            if(queb[0].equals("mostrar")){
                System.out.println(bebida);
            }
            if(queb[0].equals("sair")){
                System.out.println("Já vai embora né pé inchado");
                System.out.println(bebida);
                break;
            }
            System.out.println("");
        }
        ler.close();
    }
}