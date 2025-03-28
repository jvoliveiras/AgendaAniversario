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
        
        System.out.println("PROGRAMA DESENVOLVIDO POR JOÃO VICTOR OLIVEIRA E NICOLAS.");
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

                case '3':
                    break;
                case '4':
                    break;
                case '5':
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
                System.out.println("Informe a data de aniversário (Ex: 10/2): ");
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

