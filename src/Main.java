import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        TarefaDAO dao = new TarefaDAO();
        int opcao = 0;

        do {
            System.out.println("===SISTEMA DE TAREFAS (TO-DO LIST) ===");
            System.out.println("1 - Cadastrar uma tarefa");
            System.out.println("2 - Listar todas as tarefas");
            System.out.println();
            System.out.println("3 - Atualizar Status de uma tarefa");
            System.out.println("4 - Deletar uma tarefa");
            System.out.println("5 - Sair");
            System.out.println("Escolha uma dessas opções: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

                switch(opcao) {
                    case 1:
                        System.out.println("=== CADASTRO DE TAREFA === ");
                        System.out.println("Digite o titulo da tarefa: ");
                            String titulo = scanner.nextLine();
                        System.out.println("Digite a descrição da tarefa: ");
                            String descricao = scanner.nextLine();
                        
                            Tarefa novaTarefa = new Tarefa();

                            novaTarefa.settitulo(titulo);
                            novaTarefa.setDescricao(descricao);
                            novaTarefa.setStatus("Pendente");

                            dao.cadastrar(novaTarefa);
                            break;
                    case 2:
                        System.out.println("=== LISTA DAS TAREFAS CADASTRADAS ===");
                        dao.listar();
                        break;
                    case 3:
                        System.out.println("=== ATUALIZAR STATUS ===");
                        System.out.println("Digite o ID da tarefa que deseja atualizar: ");
                            int idAtualizar = scanner.nextInt();
                            scanner.nextLine();
                        System.out.println("Digite o novo Status: (ex: concluida)");
                        String novoStatus = scanner.nextLine();

                        

                        dao.AtualizarStatus(idAtualizar, novoStatus);
                        break;
                    case 4:
                        System.out.println("=== DELETAR TAREFA ===");
                        System.out.println("Digite o ID da tarefa que deseja excluir: ");
                            int idDel = scanner.nextInt();
                        
                            dao.deletar(idDel);
                            break;
                    case 5:
                        System.out.println("Saindo do sistema!");
                            break;
                    default:
                        System.out.println("Opção invalida!");


                }
        } while (opcao != 5);









        scanner.close();

    }
}
