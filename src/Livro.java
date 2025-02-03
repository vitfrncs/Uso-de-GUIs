public class Livro extends Publicacao {
    private String autor;

    public Livro (String t, int a, String autor){
        super(t, a);
        this.autor = autor;
    }

    public String toString (){
        return "Livro: " + titulo + " Autor: " + autor + " Ano: " + ano;
    }

    //getters e setters

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}