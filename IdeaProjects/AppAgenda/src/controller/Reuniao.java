package controller;

public class Reuniao {
    private String link;
    private String data;
    private String hora;

    public Reuniao(String data, String hora, String link) {
        this.link = link;
        this.data = data;
        this.hora = hora;
    }

    public void cadastroSucesso() {
        System.out.println("Reunião criada com sucesso!");
    }

    public void cadastroErro() {
        System.out.println("Erro ao criar reunião!");
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
