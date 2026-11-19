import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarefaDAO {
    private final String URL = "jdbc:postgresql://localhost:5432/novo_projeto";
    private final String USUARIO = "postgres";
    private final String SENHA = "1234!@";

        public void cadastrar(Tarefa tarefa) { //cadastra a tarefa no banco
            String sql = "INSERT INTO tarefa (Titulo, Descricao, Status) VALUES (?, ?, ?)";

            try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                    PreparedStatement stmt = conexao.prepareStatement(sql)) {
                        stmt.setString(1, tarefa.getTitulo());
                        stmt.setString(2, tarefa.getDescricao());
                        stmt.setString(3, tarefa.getStatus());

                        stmt.executeUpdate();
                        System.out.println(" TAREFA CADASTRADA ");

                    }catch (SQLException e) {
                        System.out.println(" ERRO AO CADASTRAR A TAREFA " + e.getMessage());
                        e.printStackTrace();
                    }
        }

        public ArrayList<Tarefa> listar() { // adiciona tarefas na array
            ArrayList<Tarefa> lista = new ArrayList<>();
            String sql = "SELECT * FROM tarefa ORDER BY id ASC";
                
                try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA) ;
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {


                        while (rs.next()) {
                            Tarefa t = new Tarefa();
                            t.setId(rs.getInt("id"));
                            t.settitulo(rs.getString("titulo"));
                            t.setDescricao(rs.getString("descricao"));
                            t.setStatus(rs.getString("status"));

                            lista.add(t);
                        }
                    } catch (SQLException e) {
                        System.out.println(" Erro ao listar " + e.getMessage());
                        e.printStackTrace();
                    }
                    for (Tarefa t : lista) {
                        System.out.println("ID: " + t.getId() + " Titulo: " + t.getTitulo() + " Descrição: " + t.getDescricao() + " Status: " + t.getStatus());
                    }
                    return lista;
        }

        public void AtualizarStatus(int id, String novoStatus) {
            String sql = "UPDATE tarefa SET status = ? WHERE id = ?";

            try(Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

                    stmt.setInt(2, id);

                    stmt.setString(1, novoStatus);

                    int linhasAfetadas = stmt.executeUpdate();

                        if (linhasAfetadas > 0) {
                            System.out.println("Status mudado com sucesso!");

                        } else {
                            System.out.println("Nenhuma tarefa encontrada, verifique o ID digitado:" + id);
                        }
                } catch (SQLException e) {
                    System.out.println("Erro a executar a tarefa" + e.getMessage());
                    e.printStackTrace();
                }
        }

        public void deletar(int id) {
            String sql = "DELETE FROM tarefa WHERE id = ?";

                try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                    PreparedStatement stmt = conexao.prepareStatement(sql)) {

                        stmt.setInt(1, id);

                        int linhasAfetadas = stmt.executeUpdate();

                            if(linhasAfetadas > 0) {
                                System.out.println("Tarefa Deletada com sucesso");

                            } else {
                                System.out.println("Tarefa não encontrada, verifique novamente");

                            }
                    } catch (SQLException e) {
                        System.out.println("Erro ao deletar " + e.getMessage());
                        e.printStackTrace();
                    }
        }
    }

    


                    
                    