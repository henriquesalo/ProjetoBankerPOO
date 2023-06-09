package listClasses;

import model.Cliente;
import model.Conta;
import model.Corrente;
import model.Login;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Clientes {
    private static final List<Cliente>clientes = new ArrayList<>();

    public static Cliente search(String cpf){
        for(Cliente c : clientes) {
            if(c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public static boolean add(Cliente a) {
        for(Cliente c : clientes) {
            if(c.getCpf().equals(a.getCpf())) {
                System.out.println("Erro! Cliente já cadastrado!");
                return false;
            }
        }
        clientes.add(a);
        System.out.println("Cliente cadastrado com sucesso!");
        return true;
    }

    public static Cliente search(Login usuario){
        for(Cliente c : clientes) {;
            if(c.getPassword().equals(usuario.getPassword()) && c.getUsuario().equals(usuario.getUsuario())) {
                System.out.println(usuario.getUsuario());
                System.out.println(usuario.getPassword());
                return c;
            }
        }
        return null;
    }

    public static Conta searchConta(String numero){
        for(Cliente c : clientes) {
            if(c.getPoupanca() != null && c.getPoupanca().getNumeroConta().equals(numero)) {
                System.out.println("Conta encontrada");
                return c.getPoupanca();
            }else if(c.getCorrente() != null && c.getCorrente().getNumeroConta().equals(numero)) {
                System.out.println("Conta encontrada");
                return c.getCorrente();
            }
        }
        return null;
    }

    public static boolean delete(String cpf) {
        for(Cliente c : clientes) {
            if(c.getCpf().equals(cpf)) {
                clientes.remove(c);
                System.out.println("Cliente removido com sucesso!");
                return true;
            }
        }
        return false;
    }

    public static void read() {
        System.out.println("\n **Clientes cadastrados:** \n");
        clientes.stream().peek(System.out::println).collect(Collectors.toList());
    }

    public static boolean update(String cpf) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        String novosDados;
        int op;
        for(Cliente c : clientes){
            if(c.getCpf().equals(cpf)){
                menuUpdate();
                op = scanner.nextInt();
                switch (op){
                    case 1:
                        System.out.println("Digite o Nome Correto:");
                        novosDados = scannerString.nextLine();
                        c.setNome(novosDados);
                        return true;
                    case 2:
                        System.out.println("Digite o CPF Correto:");
                        novosDados = scannerString.nextLine();
                        c.setCpf(novosDados);
                        return true;
                    case 3:
                        System.out.println("Digite o RG Correto:");
                        novosDados = scannerString.nextLine();
                        c.setRg(novosDados);
                        return true;
                    case 4:
                        System.out.println("Digite o Email Correto:");
                        novosDados = scannerString.nextLine();
                        c.setEmail(novosDados);
                    case 5:
                        System.out.println("Digite o Nome Correto:");
                        novosDados = scannerString.nextLine();
                        c.setNome(novosDados);
                        System.out.println("Digite o CPF Correto:");
                        novosDados = scannerString.nextLine();
                        c.setCpf(novosDados);
                        System.out.println("Digite o RG Correto:");
                        novosDados = scannerString.nextLine();
                        c.setRg(novosDados);
                        System.out.println("Digite o Email Correto:");
                        novosDados = scannerString.nextLine();
                        c.setEmail(novosDados);
                        return true;
                    default:
                        System.out.println("Opção Inválida");
                }
            }
        }
        return false;
    }

    public static void update(Cliente c, int i){//Update para os atributos da conta, i indica a conta corrente ou poupança
        for(Cliente cli: clientes) {
            if (cli == c) {
                switch (i) {
                    case 1: //Corrente
                        cli.setCorrente(c.getCorrente());
                        return;
                    case 2: //Poupança
                        cli.setPoupanca(c.getPoupanca());
                        return;
                    case 3:
                        cli.setPoupanca(c.getPoupanca());
                        cli.setCorrente(c.getCorrente());
                }
            }
        }
    }

    private static void menuUpdate(){
        System.out.println("Deseja corrigir qual dado? ");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - RG");
        System.out.println("4 - Email");
        System.out.println("10 - todos");
    }
}