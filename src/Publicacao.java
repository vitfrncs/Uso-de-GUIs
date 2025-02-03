abstract class Publicacao {
    protected String titulo;
    protected int ano;

    public Publicacao (String t, int a){
        this.titulo = t;
        this.ano = a;
    }

    //Força overwriting do metodo toString para que os dados sejam impressos no formato contido no .docx
    public abstract String toString();

    //getters e setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
