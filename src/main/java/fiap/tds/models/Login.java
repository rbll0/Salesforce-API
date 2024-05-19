package fiap.tds.models;

public class Login {
    private String email_log;
    private String senha_log;
    private int fk_Cliente_cd_cliente; // Chave estrangeira referenciando Cliente

    // Construtor padrão (vazio)
    public Login() {
    }

    // Construtor com todos os atributos
    public Login(String email_log, String senha_log, int fk_Cliente_cd_cliente) {
        this.email_log = email_log;
        this.senha_log = senha_log;
        this.fk_Cliente_cd_cliente = fk_Cliente_cd_cliente;
    }

    // Métodos getters e setters
    public String getEmail_log() {
        return email_log;
    }

    public void setEmail_log(String email_log) {
        this.email_log = email_log;
    }

    public String getSenha_log() {
        return senha_log;
    }

    public void setSenha_log(String senha_log) {
        this.senha_log = senha_log;
    }

    public int getFk_Cliente_cd_cliente() {
        return fk_Cliente_cd_cliente;
    }

    public void setFk_Cliente_cd_cliente(int fk_Cliente_cd_cliente) {
        this.fk_Cliente_cd_cliente = fk_Cliente_cd_cliente;
    }

    // Método toString para imprimir informações do login
    @Override
    public String toString() {
        return "Login{" +
                "email_log='" + email_log + '\'' +
                ", senha_log='" + senha_log + '\'' +
                ", fk_Cliente_cd_cliente=" + fk_Cliente_cd_cliente +
                '}';
    }
}
