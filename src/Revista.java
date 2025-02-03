public class Revista extends Publicacao {
    private String organizacao;
    private int volume, numero;

    public Revista(String t, int a , String org, int v, int n){
        super(t, a);
        this.organizacao = org;
        this.volume = v;
        this.numero = n;
    }

    public String toString(){
        return "Revista: " + titulo + " Org.: " + organizacao + " Vol.: " + volume + " Nro.: " + numero + " Ano: " + ano;
    }

    //getters e setters

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}