public class Materia
{
    private String nome;
    private int voto;
    private int crediti;

    public Materia(String nome, int crediti)
    {
        this.nome = nome;
        this.crediti = crediti;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getVoto() { return voto; }
    public void setVoto(int voto) { this.voto = voto; }
    public int getCrediti() { return crediti; }
    public void setCrediti(int crediti) { this.crediti = crediti; }
}
