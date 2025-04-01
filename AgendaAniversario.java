import src.Data;
import src.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaAniversario {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Pessoa>  arrayPessoas = new ArrayList<>();

    

    public static void main(String[] args) {

        //Descomentar se quiser testar com pessoas já cadastradas!
        arrayPessoas.add(new Pessoa("Joao", "27999416725", "teste@gmail.com", new Data(10, 01)));
        arrayPessoas.add(new Pessoa("Marcelo", "27999416725", "teste@gmail.com", new Data(10, 01)));
        arrayPessoas.add(new Pessoa("Pedro", "27999416724", "teste@gmail.com", new Data(20, 02)));
        arrayPessoas.add(new Pessoa("Julio", "27999416724", "teste@gmail.com", new Data(10, 02)));
        arrayPessoas.add(new Pessoa("Marcos", "27999416724", "teste@gmail.com", new Data(20, 05)));

        char opcao = 0;
        
        System.out.println("PROGRAMA DESENVOLVIDO POR JOÃO VICTOR OLIVEIRA E NICOLAS LIMA.");
        do {
            System.out.println("\n MENU - Agenda de Aniversário:"+
            "\n1 - Adicionar nova pessoa."+
            "\n2 - Remover alguma pessoa."+
            "\n3 - Pesquisar pessoa pelo nome."+
            "\n4 - Pesquisar pessoa pela data de aniversário."+
            "\n5 - Pesquisar pessoa pelo mês do aniversário."+
            "\n6 - Exibir toda a agenda."+
            "\n7 - Sair."+
            "\n>>> Opção:");
            opcao = scan.next().charAt(0);
    
            switch (opcao) {
                case '1':
                    menuAdicionarPessoa();
                    break;
                case '2':
                    menuRemoverPessoa();
                    break;
                case '3':
                    menuPesquisarPorNome();    
                    break;
                case '4':
                    menuPesquisarDiaMes();    
                    break;
                case '5':
                    menuPesquisarMes();    
                    break;
                case '6':
                    exibeLista();
                    break;
                case '7':
                    System.out.println("\nEncerrando o programa...");
                    break;
                default:
                    System.out.println("\nDigite uma das opções disponíveis.");
                    break;
            }
        } while (opcao != '7');
    }

    static void menuAdicionarPessoa(){
        String nome, telefone, email;
        int dia, mes;

        try {
            while(true){
                System.out.println("Informe o nome da pessoa: ");
                nome = scan.next();

                if (validaNome(nome)) {
                    break;
                } 
            }

            System.out.println("Informe o telefone: ");
            telefone = scan.next();

            System.out.println("Informe o email: ");
            email = scan.next();

            while (true) {
                System.out.println("Informe a data de aniversário (Ex: 20/5): ");
                String dataInput = scan.next();

                if(Data.validaData(dataInput)){
                    String[] partes = dataInput.split("/");
                    dia = Integer.parseInt(partes[0]);
                    mes = Integer.parseInt(partes[1]);
                    break;
                }
            }

            arrayPessoas.add(new Pessoa(nome, telefone, email, new Data(dia, mes)));

            System.out.println("\nPessoa inserida com sucesso!!!");
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }
    }

    static void menuRemoverPessoa() {
        try {
            System.out.println("Informe o nome da pessoa a remover: ");
            String nome = scan.next();
    
            for (Pessoa p : arrayPessoas) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    arrayPessoas.remove(p);
                    System.out.println("\nPessoa removida com sucesso!");
                    Thread.sleep(2000);
                    return;
                }
            }

            System.out.println("\nNome não encontrado nos nossos registros!");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }

    }

    static void menuPesquisarPorNome() {
        try {
            System.out.println("Informe o nome da pessoa: ");
            String nome = scan.next();
    
            for (Pessoa p : arrayPessoas) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    System.out.println("\n" + p);
                    Thread.sleep(2000);
                    return;
                }
            }

            System.out.println("\nNome não encontrado nos nossos registros!");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }
    }

    static void menuPesquisarDiaMes() {
        try {
            System.out.println("Informe o dia e mês do aniversário (Ex: 20/5): ");
            String dataInput = scan.next();
            String[] partes = dataInput.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
    
            boolean encontrado = false;
            for (Pessoa p : arrayPessoas) {
                if (p.getDataDeAniversario().getDia() == dia && p.getDataDeAniversario().getMes() == mes) {
                    if(!encontrado) System.out.println("\nAniversariantes neste dia: ");
                    System.out.println(p.getNome());
                    encontrado = true;
                }
            }
            if (!encontrado) System.out.println("\nNenhum aniversariante neste dia!");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }
    }

    static void menuPesquisarMes() {
        try {
            System.out.println("Informe o mês do aniversário: ");
            int mes = scan.nextInt();
    
            boolean encontrado = false;
            for (Pessoa p : arrayPessoas) {
                if (p.getDataDeAniversario().getMes() == mes) {
                    if(!encontrado) System.out.println("\nAniversariantes no mês informado: ");
    
                    System.out.println(p.getNome() + " - " + p.getDataDeAniversario());
                    encontrado = true;
                }
            }
            if (!encontrado) System.out.println("\nNenhum aniversariante neste mês!");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }
    }

    static boolean validaNome(String nome) {
        try {
            for (int i = 0; i < arrayPessoas.size(); i++) {
                Pessoa tempPessoa = arrayPessoas.get(i);
                
                if (tempPessoa.getNome().equalsIgnoreCase(nome)) {
                    System.err.println("\nNome já existe! Insira um nome diferente.");
                    Thread.sleep(2000);
                    return false;
                }
            }
            return true;

        }  catch (Exception e) {
            System.out.println("\nErro:" + e);
            return false;
        }
    }

    static void exibeLista(){
        try {
            for (int i = 0; i < arrayPessoas.size(); i++) {
                System.out.println(arrayPessoas.get(i));
            }

            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }

    }
}
