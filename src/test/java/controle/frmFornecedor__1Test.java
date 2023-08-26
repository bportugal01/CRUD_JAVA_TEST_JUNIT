/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controle;

import conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author bruno
 */
public class frmFornecedor__1Test {

    public frmFornecedor__1Test() {
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
     * Test of preencherTabela method, of class frmFornecedor__1.
     */
    @Test
    public void testPreencherTabela() {
        System.out.println("preencherTabela");
        frmFornecedor__1 instance = new frmFornecedor__1();
        instance.preencherTabela();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of posicionarRegistro method, of class frmFornecedor__1.
     */
    @Test
    public void testPosicionarRegistro() {
        System.out.println("posicionarRegistro");
        frmFornecedor__1 instance = new frmFornecedor__1();
        instance.posicionarRegistro();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar_Dados method, of class frmFornecedor__1.
     */
    @Test
    public void testMostrar_Dados() {
        System.out.println("mostrar_Dados");
        frmFornecedor__1 instance = new frmFornecedor__1();
        instance.mostrar_Dados();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of btn_editarActionPerformed2 method, of class frmFornecedor__1.
     */
    @Test
    public void testBtn_editarActionPerformed2() {
        System.out.println("btn_gravarActionPerformed2");
        frmFornecedor__1 instance = new frmFornecedor__1();

        instance.txt_cod.setText("1 ");
        instance.txt_nome.setText("Monteiro");
        instance.txt_end.setText("R.Samaritá, 37 - São Paulo - SP");
        instance.txt_cnpj.setText("37.579.551/0001-61 ");
        instance.txt_entrega.setText("Retirada no local");

        // Simule o clique do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_editarActionPerformed2(evt);
    }

    /**
     * Test of txt_pesqKeyReleased2 method, of class frmFornecedor__1.
     */
    @Test
    public void testTxt_pesqKeyReleased2() {
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();
        // Configure o campo de pesquisa
        instance.txt_pesq.setText("PesquisaSimulada");

        // Simule a tecla pressionada para ativar o método
        KeyEvent evt = new KeyEvent(instance.txt_pesq, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, KeyEvent.CHAR_UNDEFINED);
        instance.txt_pesqKeyReleased2(evt);
    }

    /**
     * Test of btn_gravarActionPerformed2 method, of class frmFornecedor__1.
     */
    @Test
    public void testBtn_gravarActionPerformed2() {
        System.out.println("btn_gravarActionPerformed2");
        frmFornecedor__1 instance = new frmFornecedor__1();

        instance.txt_cod.setText("1 ");
        instance.txt_nome.setText("Monteiro");
        instance.txt_end.setText("R.Samaritá, 37 - São Paulo - SP");
        instance.txt_cnpj.setText("37.579.551/0001-61 ");
        instance.txt_entrega.setText("Retirada no local");

        // Simule o clique do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_gravarActionPerformed2(evt);
    }

    /**
     * Test of btn_excluirActionPerformed2 method, of class frmFornecedor__1.
     */
    @Test
    public void testBtn_excluirActionPerformed2() {
        // Crie uma instância simulada da interface DatabaseConnection
        Conexao testConnection = new Conexao();
        // Crie uma instância de FrmCard usando a conexão simulada
        frmCard instance = new frmCard();

        // Simular o clique do botão para ativar o método
        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        instance.btn_excluirActionPerformed2(evt);
    }

}
