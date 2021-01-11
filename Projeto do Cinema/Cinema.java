import java.util.ArrayList;
import java.util.Collections;
public class Cinema{
    ArrayList<Cliente> cliente = new ArrayList<>();
        Cinema(int size){
            ArrayList<Cinema> cinema = new ArrayList<Cinema>(Collections.nCopies(size, null));
                show();
        }
        public void reservar(String id, String fone, int indice){
            if(cinema[indice] != null){
                System.out.println("Erro, já existem pessoa nessa cadeira");
                    return ;
            }
            for(int i = 0; i < cliente.size(); i++){
                if(cliente.id[i] == id){
                    System.out.println("Erro, já existe alguém com esse ID na sala de cinema");
                    return ;
                }
            }
            cinema.add(indice, fone + ":" + id);
            cliente.add(indice, id, fone);

        } 
        public boolean cancelar(String id){
            for(int i = 0; i < cliente.size(); i++){
                if(cliente.id[i] == id){
                    cliente.remove(i);
                        return true;
                }
            }
            return false;
        }
        public String show(){
            for(int i = 0; i < cinema.size(); i++){
                if(cinema[i] == null)
                    cinema.add(i, " - ");
            }
        }
}
