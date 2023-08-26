/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import conexao.Conexao;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dti
 */
public class ConexaoTest {

    public ConexaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of conecta method, of class Conexao.
     */
    @Test
    public void testConecta() {
        System.out.println("testConecta");

        Conexao instance = new Conexao();
        boolean result = instance.conecta();
        assertTrue(result); // Verifique se o resultado é verdadeiro (true)
    }

    /**
     * Test of desconecta method, of class Conexao.
     */
    @Test
    public void testDesconecta() {
        System.out.println("testDesconecta");

        Conexao instance = new Conexao();
        instance.desconecta();

        System.out.println("Conexão com o Banco Fechada");
    }

    /**
     * Test of executaSQL method, of class Conexao.
     */
    @Test
    public void testExecutaSQL() {
        Conexao instance = new Conexao();
        System.out.println("testExecutaSQL");
        String sql = "SELECT * FROM cardapio";

        instance.conecta(); // Estabelece a conexão com o banco de dados
        instance.executaSQL(sql);
        instance.desconecta(); // Fecha a conexão com o banco de dados

        // Aqui, você pode adicionar asserções ou verificar o comportamento esperado após executar o SQL.
    }
}
