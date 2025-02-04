package controller;

public class Endereco {
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    int idfk;

    public Endereco(String rua, String numero, String cidade, String estado, String cep, int idfk) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idfk = idfk;
    }

    public void cadastroSucesso() {
        System.out.println("Endereço criado com sucesso!");
    }

    public void cadastroErro() {
        System.out.println("Erro ao criar endereço!");
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public int getIdfk() {
        return idfk;
    }
}