public class Tarefa {
    private int id;
    private String titulo;
    private String Descricao;
    private String status;

    public Tarefa() {
        
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
