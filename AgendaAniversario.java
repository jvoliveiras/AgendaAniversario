import src.Data;
import src.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaAniversario {
    static Scanner scan = new Scanner(System.in);
    ArrayList<Pessoa> arrayPessoas = new ArrayList<>();

    public static void main(String[] args) {
        AgendaAniversario agenda = new AgendaAniversario();
        char opcao = 0;
        
        System.out.println("PROGRAMA DESENVOLVIDO POR JOÃO VICTOR OLIVEIRA E NICOLAS LIMA.");
        do {
            System.out.println("\n MENU - Agenda de Aniversário:"+
            "\n1 - Adicionar nova pessoa."+
            "\n2 - Remover alguma pessoa."+
            "\n3 - Pesquisar pessoa pelo nome."+
            "\n4 - Pesquisar pessoa pela data de aniversário."+
            "\n5 - Pesquisar pessoa pelo mês do aniversário."+
            "\n6 - Sair."+
            "\n>>> Opção:");
            opcao = scan.next().charAt(0);
    
            switch (opcao) {
                case '1':
                    agenda.menuAdicionarPessoa();
                    break;
                case '2':
                    agenda.menuRemoverPessoa();
                case '3':
                    agenda.menuPesquisarPorNome();    
                break;
                case '4':
                    agenda.menuPesquisarDiaMes();    
                break;
                case '5':
                    agenda.menuPesquisarMes();    
                break;
                case '6':

                    break;
                default:
                    System.out.println("\nDigite uma das opções disponíveis.");
                    break;
            }
        } while (opcao != '6');
    }

    void menuAdicionarPessoa(){
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

            exibeLista();
        } catch (Exception e) {
            System.out.println("\nErro:" + e);
        }
    }
    void menuRemoverPessoa() {
        System.out.println("Informe o nome da pessoa a remover: ");
        String nome = scan.next();

        for (Pessoa p : arrayPessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                arrayPessoas.remove(p);
                System.out.println("Pessoa removida com sucesso!");
                return;
            }
        }
        System.out.println("NOME INEXISTENTE");
    }

    void menuPesquisarPorNome() {
        System.out.println("Informe o nome da pessoa: ");
        String nome = scan.next();

        for (Pessoa p : arrayPessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("NOME INEXISTENTE");
    }

    void menuPesquisarDiaMes() {
        System.out.println("Informe o dia e mês do aniversário (Ex: 20/5): ");
        String dataInput = scan.next();
        String[] partes = dataInput.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);

        boolean encontrado = false;
        for (Pessoa p : arrayPessoas) {
            if (p.getDataDeAniversario().getDia() == dia && p.getDataDeAniversario().getMes() == mes) {
                System.out.println(p.getNome());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("NENHUM ANIVERSARIANTE");
    }

    void menuPesquisarMes() {
        System.out.println("Informe o mês do aniversário: ");
        int mes = scan.nextInt();

        boolean encontrado = false;
        for (Pessoa p : arrayPessoas) {
            if (p.getDataDeAniversario().getMes() == mes) {
                System.out.println(p.getNome() + " - " + p.getDataDeAniversario());
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("NENHUM ANIVERSARIANTE");
    }
    boolean validaNome(String nome) {
        for (int i = 0; i < arrayPessoas.size(); i++) {
            Pessoa tempPessoa = arrayPessoas.get(i);
            
            if (tempPessoa.getNome().equalsIgnoreCase(nome)) {
                System.err.println("Nome já existe! Insira um nome diferente.");
                return false;
            }
        }
        return true;
    }

    void exibeLista(){
        for (int i = 0; i < arrayPessoas.size(); i++) {
            System.out.println(arrayPessoas.get(i));
        }
    }
}

