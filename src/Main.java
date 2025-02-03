import java.util.ArrayList;

public class Main {
    //public static ArrayList<Publicacao> publicacoes = new ArrayList<>(); // usa static :(
    public static void main (String [] args){
        ArrayList <Publicacao> publicacoes = new ArrayList<>();
        //único jeito que consegui fazer a lista publicacoes ser acessivel em to-do o programa foi passar ela como argumento para as classes
        //cria um objeto JLivro, que vai ser a primeira janela a aparecer
        new JLivro(publicacoes);
    }
}