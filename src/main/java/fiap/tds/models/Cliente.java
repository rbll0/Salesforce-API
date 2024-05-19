package fiap.tds.models;

public class Cliente {
    private int cd_cliente;
    private String nome_cliente;
    private String email_corporativo;
    private String endereco;
    private String pais_cliente;
    private String comentarios;

    // Construtor padrão (vazio)
    public Cliente() {
    }

    // Construtor com todos os atributos
    public Cliente(int cd_cliente, String nome_cliente, String email_corporativo, String endereco, String pais_cliente, String comentarios) {
        this.cd_cliente = cd_cliente;
        this.nome_cliente = nome_cliente;
        this.email_corporativo = email_corporativo;
        this.endereco = endereco;
        this.pais_cliente = pais_cliente;
        this.comentarios = comentarios;
    }

    // Métodos getters e setters
    public int getCd_cliente() {
        return cd_cliente;
    }

    public void setCd_cliente(int cd_cliente) {
        this.cd_cliente = cd_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEmail_corporativo() {
        return email_corporativo;
    }

    public void setEmail_corporativo(String email_corporativo) {
        this.email_corporativo = email_corporativo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPais_cliente() {
        return pais_cliente;
    }

    public void setPais_cliente(String pais_cliente) {
        this.pais_cliente = pais_cliente;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    // Método toString para imprimir informações do cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "cd_cliente=" + cd_cliente +
                ", nome_cliente='" + nome_cliente + '\'' +
                ", email_corporativo='" + email_corporativo + '\'' +
                ", endereco='" + endereco + '\'' +
                ", pais_cliente='" + pais_cliente + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
