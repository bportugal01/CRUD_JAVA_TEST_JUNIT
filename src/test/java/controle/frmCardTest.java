/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bruno
 */
public class frmCardTest {

    public frmCardTest() {
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

    //TESTE DO CRUD
    /**
     * Test of preencherTabela method, of class frmCard.
     */
    @Test
    public void testPreencherTabela() {
        System.out.println("preencherTabela");
        frmCard instance = new frmCard();
        instance.preencherTabela();
        // TODO review the generated test code and remove the default call to fail.
        //    fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar_Dados method, of class frmCard.
     */
    @Test
    public void testMostrar_Dados() {
        System.out.println("mostrar_Dados");
        frmCard instance = new frmCard();
        instance.mostrar_Dados();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testBtnAlterarActionPerformed() {
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        frmCard instance = new frmCard();

        // Configura os valores necessários para os campos de texto
        instance.txt_nome.setText("NovoNome");
        instance.txt_desc.setText("NovaDescricao");
        instance.txt_preco.setText("100.00");
        instance.txt_codtipo.setText("");
        instance.txt_custo.setText("50.00");
        instance.txt_cod.setText("1");

        // Chame o método que deseja testar
        instance.btn_alterarActionPerformed2(evt);
    }

    @Test
    public void testBtnExcluirActionPerformed2() {
        // Crie uma instância simulada da interface DatabaseConnection
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Simular o clique do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_excluirActionPerformed2(evt);
    }

    @Test
    public void testBtnGravarActionPerformed2() {
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Configure os campos de texto como necessário para o teste
        instance.txt_nome.setText("NomeSimulado");
        instance.txt_desc.setText("DescricaoSimulada");
        instance.txt_preco.setText("100.00");
        instance.txt_codtipo.setText("");
        instance.txt_custo.setText("50.00");

        // Simule o clique do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_gravarActionPerformed2(evt);
    }

    @Test
    public void testTxtPesqKeyReleased() {
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();
        // Configure o campo de pesquisa
        instance.txt_pesq.setText("PesquisaSimulada");

        // Simule a tecla pressionada para ativar o método
        KeyEvent evt = new KeyEvent(instance.txt_pesq, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, KeyEvent.CHAR_UNDEFINED);
        instance.txt_pesqKeyReleased2(evt);

    }

    // TESTE DE NAVEGAÇÃO
    @Test
    public void testBtnAnteriotActionPerformed() {
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Simule um registro anterior no resultset (se necessário)
        // Simule o evento do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_anteriotActionPerformed2(evt);
    }

    @Test
    public void testBtnProximo1ActionPerformed() {
        // Crie uma instância simulada da interface DatabaseConnection
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Simule um registro próximo no resultset (se necessário)
        // Simule o evento do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_proximo1ActionPerformed2(evt);
    }

    @Test
    public void testBtnPrimeiroRegistroActionPerformed() {
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Simule um registro no início do resultset (se necessário)
        // ...
        // Simule o evento do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_primeiroregistroActionPerformed2(evt);
    }

    @Test
    public void testBtnUltimoRegistroActionPerformed() {
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Simule um registro no final do resultset (se necessário)
        // ...
        // Simule o evento do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_ultimoregistroActionPerformed2(evt);
    }
}
