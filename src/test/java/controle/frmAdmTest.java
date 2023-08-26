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
public class frmAdmTest {

    public frmAdmTest() {
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
     * Test of preencherTabela method, of class frmAdm.
     */
    @Test
    public void testPreencherTabela() {
        System.out.println("preencherTabela");
        frmAdm instance = new frmAdm();
        instance.preencherTabela();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar_Dados method, of class frmAdm.
     */
    @Test
    public void testMostrar_Dados() {
        System.out.println("mostrar_Dados");
        frmAdm instance = new frmAdm();
        instance.mostrar_Dados();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of btn_editarActionPerformed2 method, of class frmAdm.
     */
    @Test
    public void testBtn_editarActionPerformed2() {
        System.out.println("btn_editarActionPerformed2");
        ActionEvent evt = null;
        frmAdm instance = new frmAdm();
        instance.btn_editarActionPerformed2(evt);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        instance.txt_id.setText("12345");
        instance.txt_nome.setText("João da Silva");
        instance.txt_sob.setText("Silveira");
        instance.txt_cpf.setText("123.456.789-00");
        instance.txt_rg.setText("12.345.678-9");
        instance.txt_cargo.setText("Desenvolvedor de Software");
        instance.txt_nasc.setText("01/01/1990");
        instance.txt_sexo.setText("Masculino");
        instance.txt_user.setText("joao.silva");
        instance.txt_senha.setText("senha123");
        instance.txt_acesso.setText("Nível 3");
        instance.txt_email.setText("joao.silva@example.com");
        instance.txt_cel.setText("(12) 3456-7890");
        instance.txt_tel.setText("(12) 9876-5432");
        instance.txt_cep.setText("12345-678");
        instance.txt_rua.setText("Rua dos Exemplos");
        instance.txt_num.setText("123");
        instance.txt_compl.setText("Ap. 456");
        instance.txt_bairro.setText("Centro");
        instance.txt_city.setText("Cidade Exemplo");
        instance.txt_est.setText("Estado Exemplo");

    }

    /**
     * Test of btn_excluirActionPerformed2 method, of class frmAdm.
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
     * Test of txt_pesquisaKeyReleased2 method, of class frmAdm.
     */
    @Test
    public void testTxt_pesquisaKeyReleased2() {
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
     * Test of btn_registrarActionPerformed2 method, of class frmAdm.
     */
    @Test
    public void testBtn_registrarActionPerformed2() {
        System.out.println("btn_registrarActionPerformed2");
        ActionEvent evt = null;
        frmAdm instance = new frmAdm();
        instance.btn_registrarActionPerformed2(evt);
        
        instance.txt_id.setText("12345");
        instance.txt_nome.setText("João da Silva");
        instance.txt_sob.setText("Silveira");
        instance.txt_cpf.setText("123.456.789-00");
        instance.txt_rg.setText("12.345.678-9");
        instance.txt_cargo.setText("Desenvolvedor de Software");
        instance.txt_nasc.setText("01/01/1990");
        instance.txt_sexo.setText("Masculino");
        instance.txt_user.setText("joao.silva");
        instance.txt_senha.setText("senha123");
        instance.txt_acesso.setText("Nível 3");
        instance.txt_email.setText("joao.silva@example.com");
        instance.txt_cel.setText("(12) 3456-7890");
        instance.txt_tel.setText("(12) 9876-5432");
        instance.txt_cep.setText("12345-678");
        instance.txt_rua.setText("Rua dos Exemplos");
        instance.txt_num.setText("123");
        instance.txt_compl.setText("Ap. 456");
        instance.txt_bairro.setText("Centro");
        instance.txt_city.setText("Cidade Exemplo");
        instance.txt_est.setText("Estado Exemplo");

    }

}
