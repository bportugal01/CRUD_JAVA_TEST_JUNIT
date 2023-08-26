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
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bruno
 */
public class frmProdutoTest {

    public frmProdutoTest() {
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
     * Test of preencherTabela method, of class frmProduto.
     */
    @Test
    public void testPreencherTabela() {
        System.out.println("preencherTabela");
        frmProduto instance = new frmProduto();
        instance.preencherTabela();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar_Dados method, of class frmProduto.
     */
    @Test
    public void testMostrar_Dados() {
        System.out.println("mostrar_Dados");
        frmProduto instance = new frmProduto();
        instance.mostrar_Dados();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of btn_registrarActionPerformed2 method, of class frmProduto.
     */
    @Test
    public void testBtn_registrarActionPerformed2() {
        System.out.println("btn_registrarActionPerformed2");
        ActionEvent evt = null;
        frmProduto instance = new frmProduto();
        instance.btn_registrarActionPerformed2(evt);

        instance.txt_id.setText("1");
        instance.txt_desc.setText("Salame Italiano");
        instance.txt_qtd.setText("1 kg");
        instance.txt_val.setText("01/10/2023");
        instance.txt_marca.setText("Seara Gourmet");
        instance.txt_esp.setText("Frios e Laticínios");
        instance.txt_cat.setText("10");
        instance.txt_custo.setText("R$ 46,52 por Kilo");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of btn_excluirActionPerformed2 method, of class frmProduto.
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

    /**
     * Test of btn_editarActionPerformed2 method, of class frmProduto.
     */
    @Test
    public void testBtn_editarActionPerformed2() {
        System.out.println("btn_editarActionPerformed2");
        ActionEvent evt = null;
        frmProduto instance = new frmProduto();
        instance.btn_editarActionPerformed2(evt);

        instance.txt_id.setText("1");
        instance.txt_desc.setText("Salame Italiano");
        instance.txt_qtd.setText("1 kg");
        instance.txt_val.setText("01/10/2023");
        instance.txt_marca.setText("Seara Gourmet");
        instance.txt_esp.setText("Frios e Laticínios");
        instance.txt_cat.setText("10");
        instance.txt_custo.setText("R$ 46,52 por Kilo");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of txt_pesqKeyReleased2 method, of class frmProduto.
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
}
