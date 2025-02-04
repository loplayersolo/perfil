package view;

import controller.Contato;
import controller.Endereco;
import controller.Lista;
import controller.Reuniao;
import model.ContatoDAO;
import model.ListaDAO;
import model.ReuniaoDAO;
import model.EnderecoDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        inputContato();
        int contatoID = contatoDAO.getUltimoIDInserido();
        System.out.println( "\nEscolha uma opçõa: \n 1-ADICIONAR ENDEREÇO" + "\n 2 - RETORNAR AO MENU") ;
        //Switch case
        int op =  Integer.parseInt(scanner.nextLine());

        switch (op) {

            case 1:

                inputEndereco(contatoID);

                break;

            case 2:

                break;
            default:
                System.out.println("Opção inválida");
                break;
        }





        //inputLista();
        //Encapsulamento!
        //inputReuniao();

    }

    private static ListaDAO listaDAO = new ListaDAO();
    private static Scanner scanner = new Scanner(System.in);
    private static ContatoDAO contatoDAO = new ContatoDAO();
    private static ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
    private static EnderecoDAO enderecoDAO = new EnderecoDAO();

    private static void inputLista() {
        System.out.println("------NOVA LISTA------");
        System.out.println("Digite o nome da lista: ");
        String nome = scanner.nextLine();

        if (nome.isEmpty()) {
            System.out.println("campo nome obrigatorio");
        } else {

            Lista lista = new Lista(nome);
            boolean sucesso = listaDAO.inserirLista(lista);

            if (sucesso) {
                lista.cadastroSucesso();
            } else {
                lista.cadastroErro();

            }
        }
    }
    private static void inputContato() {
        System.out.println("------NOVO CONTATO--------");
        System.out.println("Digite o nome do contato");
        String nome = scanner.nextLine();

        System.out.println("Digite o telefone :");
        String telefone = scanner.nextLine();

        Contato contato = new Contato(nome, telefone);
        boolean sucesso = contatoDAO.inserirContato(contato);

        if (sucesso) {
            contato.cadastroSucesso();
        } else {
            contato.cadastroErro();

        }



    }

    private static void inputReuniao() {
        System.out.println("------NOVA reuniao--------");
        System.out.println("Digite a data da reuniao(ano-mês-dia):");
        String data = scanner.nextLine();

        System.out.println("Digite a hora da reuniao (xx : xx) :");
        String hora = scanner.nextLine();

        System.out.println("Digite a data da reuniao (xx/xx/xxxx) :");
        String link = scanner.nextLine();

        Reuniao reuniao = new Reuniao(data, hora, link);
        boolean sucesso = reuniaoDAO.inserirReuniao(reuniao);

        if (sucesso) {
            reuniao.cadastroSucesso();
        } else {
            reuniao.cadastroErro();

        }
    }

    private static void inputEndereco( int idfk) {
        System.out.println("----- CRIAR NOVO ENDEREÇO -----");
        System.out.println("Digite a rua:");
        String rua = scanner.nextLine();
        System.out.println("Digite o número:");
        String numero = scanner.nextLine();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Digite o estado: ");
        String estado = scanner.nextLine();
        System.out.println("Digite o CEP: ");
        String cep = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, cidade, estado, cep, idfk);
        boolean sucesso = enderecoDAO.inserirEndereco(endereco);
        if (sucesso) {
            endereco.cadastroSucesso();
        } else {
            endereco.cadastroErro();
        }
    }
}