/*
 * Esta classe será responsável pela conexão com o MySql e terá 3 métodos:
 * - abertura da conexão
 * - fechamento da conexão
 * - e execução de comandos SQL
 */
package conexao;

import javax.swing.JOptionPane; // importação biblioteca para caixas de diálogo
import java.sql.*; // para execução de comandos SQL no ambiente Java

public class Conexao {

    final private String driver = "com.mysql.cj.jdbc.Driver"; // definição do driver Mysql para acesso aos dados
    final private String url = "jdbc:mysql://127.0.0.1/bd_restaurante"; // acesso ao bd clientes no servidor
    final private String usuario = "root"; // usuário do Mysql - Xamp
    final private String senha = ""; // senha do MySql - Xamp
    private Connection conexao; // variável que armazenará a conexão aberta
    public Statement statement; // variável para execução dos comandos SQL dentro do ambiente Java
    public ResultSet resultset; // variável que armazenará o resultado da execução de um comando SQL

    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão estabelecida", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado" + Driver, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada" + Fonte, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        return result;
    }

    public void desconecta() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão com o Banco Fechada");
            }
        } catch (SQLException e) {
            // Lide com a exceção de fechamento de conexão de forma apropriada
            System.err.println("Erro ao fechar a conexão com o banco: " + e.getMessage());
        }
    }

    public void executaSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n ERRO" + excecao, "Mensagem Do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
