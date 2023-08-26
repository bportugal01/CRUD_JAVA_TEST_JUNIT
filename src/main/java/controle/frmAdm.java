package controle;

import conexao.Conexao; // importar do package a classe
import javax.swing.JOptionPane; // importação biblioteca para caixas de diálogo
import javax.swing.table.DefaultTableModel; // para reconhecimento da Jtable
import java.sql.*; // para reconhecimento dos comandos SQL

public class frmAdm extends javax.swing.JInternalFrame {

    Conexao con_cliente;

    public frmAdm() {
        initComponents();
        con_cliente = new Conexao(); // inicialização do objeto como instância
        con_cliente.conecta(); // chama o método que conecta 
        con_cliente.executaSQL("select * from login order by id");
        preencherTabela();
        posicionarRegistro();
        tbl_Adm.setAutoCreateRowSorter(true); // ativa a classificação ordenada da tabela
    }

    public void preencherTabela() {

        tbl_Adm.getColumnModel().getColumn(0).setPreferredWidth(14);
        tbl_Adm.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(5).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(6).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(7).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(8).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(9).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(10).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(11).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(12).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(13).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(14).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(15).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(16).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(17).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(18).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(19).setPreferredWidth(100);
        tbl_Adm.getColumnModel().getColumn(20).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) tbl_Adm.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("id"), con_cliente.resultset.getString("nome"), con_cliente.resultset.getString("sobrenome"), con_cliente.resultset.getString("cpf"), con_cliente.resultset.getString("rg"), con_cliente.resultset.getString("cargo"), con_cliente.resultset.getString("nasc"), con_cliente.resultset.getString("sexo"), con_cliente.resultset.getString("user"), con_cliente.resultset.getString("senha"), con_cliente.resultset.getString("acesso"), con_cliente.resultset.getString("email"), con_cliente.resultset.getString("cel"), con_cliente.resultset.getString("tel"), con_cliente.resultset.getString("cep"), con_cliente.resultset.getString("rua"), con_cliente.resultset.getString("num"), con_cliente.resultset.getString("comp"), con_cliente.resultset.getString("bairro"), con_cliente.resultset.getString("city"), con_cliente.resultset.getString("est")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void posicionarRegistro() {
        try {
            con_cliente.resultset.first(); // posiciona no 1° registro da tabela
            mostrar_Dados(); // chama o método que irá buscar o dado da tabela
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        try {
            txt_id.setText(con_cliente.resultset.getString("id")); // Associar a caixa de texto ao campo cod
            txt_nome.setText(con_cliente.resultset.getString("nome")); // Associar a caixa de texto ao campo nome
            txt_sob.setText(con_cliente.resultset.getString("sobrenome")); // Associar a caixa de texto ao campo dt_nasc
            txt_cpf.setText(con_cliente.resultset.getString("cpf")); // Associar a caixa de texto ao campo nome 
            txt_rg.setText(con_cliente.resultset.getString("rg")); // Associar a caixa de texto ao campo nome
            txt_cargo.setText(con_cliente.resultset.getString("cargo")); // Associar a caixa de texto ao campo nome
            txt_nasc.setText(con_cliente.resultset.getString("nasc")); // Associar a caixa de texto ao campo nome
            txt_sexo.setText(con_cliente.resultset.getString("sexo")); // Associar a caixa de texto ao campo nome
            txt_user.setText(con_cliente.resultset.getString("user")); // Associar a caixa de texto ao campo telefone
            txt_senha.setText(con_cliente.resultset.getString("senha")); // Associar a caixa de texto ao campo telefone
            txt_acesso.setText(con_cliente.resultset.getString("acesso")); // Associar a caixa de texto ao campo nome
            txt_email.setText(con_cliente.resultset.getString("email")); // Associar a caixa de texto ao campo email
            txt_cel.setText(con_cliente.resultset.getString("cel")); // Associar a caixa de texto ao campo nome
            txt_tel.setText(con_cliente.resultset.getString("tel")); // Associar a caixa de texto ao campo nome
            txt_cep.setText(con_cliente.resultset.getString("cep")); // Associar a caixa de texto ao campo nome
            txt_rua.setText(con_cliente.resultset.getString("rua")); // Associar a caixa de texto ao campo nome
            txt_num.setText(con_cliente.resultset.getString("num")); // Associar a caixa de texto ao campo nome
            txt_compl.setText(con_cliente.resultset.getString("comp")); // Associar a caixa de texto ao campo nome
            txt_bairro.setText(con_cliente.resultset.getString("bairro")); // Associar a caixa de texto ao campo nome
            txt_city.setText(con_cliente.resultset.getString("city")); // Associar a caixa de texto ao campo nome
            txt_est.setText(con_cliente.resultset.getString("est")); // Associar a caixa de texto ao campo nome
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Btn_Novo_Registro = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txt_cep = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_compl = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_rua = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        txt_num = new javax.swing.JTextField();
        txt_est = new javax.swing.JTextField();
        Pnl_Contatos = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_cel = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        Pnl_Dados_Pessoais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_sob = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_nasc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_sexo = new javax.swing.JTextField();
        txt_cpf = new javax.swing.JTextField();
        txt_rg = new javax.swing.JTextField();
        Pnl_Consultas = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        btn_excluir = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pnl_Cadastro_Usuario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_acesso = new javax.swing.JTextField();
        btn_ultimoregistro = new javax.swing.JButton();
        btn_primeiroregistro = new javax.swing.JButton();
        btn_proximo = new javax.swing.JButton();
        btn_anteriot = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Adm = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Administradores");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(885, 600));
        setVisible(true);

        jScrollPane4.setBackground(new java.awt.Color(204, 0, 0));

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        Btn_Novo_Registro.setText("Novo Registro");
        Btn_Novo_Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Novo_RegistroActionPerformed(evt);
            }
        });

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_registrar.setText("Gravar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));

        jLabel22.setText("CEP:");

        txt_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cepActionPerformed(evt);
            }
        });

        jLabel23.setText("Complemento:");

        jLabel24.setText("Rua:");

        jLabel25.setText("Bairro:");

        jLabel26.setText("Cidade:");

        jLabel27.setText("Estado:");

        jLabel28.setText("Número:");

        txt_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel24)
                        .addGap(250, 250, 250)
                        .addComponent(jLabel28))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_compl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txt_est, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_compl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Pnl_Contatos.setBackground(new java.awt.Color(255, 255, 204));
        Pnl_Contatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Contatos"));

        jLabel19.setText("Email:");

        jLabel20.setText("Celular:");

        jLabel21.setText("Telefone (fixo):");

        javax.swing.GroupLayout Pnl_ContatosLayout = new javax.swing.GroupLayout(Pnl_Contatos);
        Pnl_Contatos.setLayout(Pnl_ContatosLayout);
        Pnl_ContatosLayout.setHorizontalGroup(
            Pnl_ContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ContatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ContatosLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(259, 259, 259)
                        .addComponent(jLabel20)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel21))
                    .addGroup(Pnl_ContatosLayout.createSequentialGroup()
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        Pnl_ContatosLayout.setVerticalGroup(
            Pnl_ContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ContatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ContatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Pnl_Dados_Pessoais.setBackground(new java.awt.Color(255, 255, 204));
        Pnl_Dados_Pessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));
        Pnl_Dados_Pessoais.setPreferredSize(new java.awt.Dimension(200, 175));

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Sexo:");

        jLabel10.setText("RG:");

        txt_sob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sobActionPerformed(evt);
            }
        });

        jLabel11.setText("Sobrenome:");

        jLabel12.setText("Cargo:");

        jLabel13.setText("Nascimento:");

        jLabel5.setText("ID:");

        javax.swing.GroupLayout Pnl_Dados_PessoaisLayout = new javax.swing.GroupLayout(Pnl_Dados_Pessoais);
        Pnl_Dados_Pessoais.setLayout(Pnl_Dados_PessoaisLayout);
        Pnl_Dados_PessoaisLayout.setHorizontalGroup(
            Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_Dados_PessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Pnl_Dados_PessoaisLayout.createSequentialGroup()
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sob, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(Pnl_Dados_PessoaisLayout.createSequentialGroup()
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txt_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txt_cargo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_Dados_PessoaisLayout.setVerticalGroup(
            Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Dados_PessoaisLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Dados_PessoaisLayout.createSequentialGroup()
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel11))
                            .addComponent(jLabel13))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_sob, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txt_id, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nasc)
                    .addComponent(txt_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Pnl_Dados_PessoaisLayout.createSequentialGroup()
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_cpf)
                            .addComponent(txt_rg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Pnl_Dados_PessoaisLayout.createSequentialGroup()
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Pnl_Dados_PessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(txt_sexo))))
                .addGap(48, 48, 48))
        );

        Pnl_Consultas.setBackground(new java.awt.Color(255, 255, 204));
        Pnl_Consultas.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Administradores"));

        jLabel8.setText("Buscar por nome:");

        txt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisaActionPerformed(evt);
            }
        });
        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout Pnl_ConsultasLayout = new javax.swing.GroupLayout(Pnl_Consultas);
        Pnl_Consultas.setLayout(Pnl_ConsultasLayout);
        Pnl_ConsultasLayout.setHorizontalGroup(
            Pnl_ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ConsultasLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_ConsultasLayout.setVerticalGroup(
            Pnl_ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ConsultasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(Pnl_ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_editar.setText("Alterar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        Pnl_Cadastro_Usuario.setBackground(new java.awt.Color(255, 255, 204));
        Pnl_Cadastro_Usuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar"));

        jLabel14.setText("Os campos abaixo só serão preenchidos para os funcionários que terão acesso ao sistema. ");

        jLabel17.setText("Nome de Usuário:");

        jLabel6.setText("Senha:");

        jLabel18.setText("Grau de Acesso:");

        jLabel29.setText(" Ao preencher algum campo, todos os outros serão obrigatórios!");

        btn_ultimoregistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-último-30.png"))); // NOI18N
        btn_ultimoregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoregistroActionPerformed(evt);
            }
        });

        btn_primeiroregistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-primeiro-30.png"))); // NOI18N
        btn_primeiroregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primeiroregistroActionPerformed(evt);
            }
        });

        btn_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-a-direita-30.png"))); // NOI18N
        btn_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximoActionPerformed(evt);
            }
        });

        btn_anteriot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-esquerda-30.png"))); // NOI18N
        btn_anteriot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriotActionPerformed(evt);
            }
        });

        tbl_Adm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "SOBRENOME", "CPF", "RG", "CARGO", "NASC.", "SEXO", "USUÁRIO", "SENHA", "ACESSO", "EMAIL", "CEL.", "TEL.", "CEP", "RUA", "NUM", "COMP", "BAIRRO", "CITY", "EST"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_AdmMouseClicked(evt);
            }
        });
        tbl_Adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_AdmKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Adm);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout Pnl_Cadastro_UsuarioLayout = new javax.swing.GroupLayout(Pnl_Cadastro_Usuario);
        Pnl_Cadastro_Usuario.setLayout(Pnl_Cadastro_UsuarioLayout);
        Pnl_Cadastro_UsuarioLayout.setHorizontalGroup(
            Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_Cadastro_UsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_Cadastro_UsuarioLayout.createSequentialGroup()
                        .addComponent(btn_anteriot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ultimoregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_Cadastro_UsuarioLayout.createSequentialGroup()
                        .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txt_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_Cadastro_UsuarioLayout.setVerticalGroup(
            Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_Cadastro_UsuarioLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_anteriot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_proximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ultimoregistro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_Cadastro_UsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pnl_Cadastro_UsuarioLayout.createSequentialGroup()
                        .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_Cadastro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(Pnl_Cadastro_Usuario);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/logo(1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Pnl_Consultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Pnl_Contatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Pnl_Dados_Pessoais, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
                        .addGap(88, 88, 88)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_Novo_Registro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_voltar)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Pnl_Dados_Pessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pnl_Contatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pnl_Consultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Novo_Registro)
                    .addComponent(btn_registrar)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_voltar))
                .addGap(0, 0, 0))
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setBounds(150, 15, 722, 592);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Ação do Botão Alterar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome = txt_nome.getText();
        String sobrenome = txt_sob.getText();
        String cpf = txt_cpf.getText(); // Associar a caixa de texto ao campo nome 
        String rg = txt_rg.getText();// Associar a caixa de texto ao campo nome
        String cargo = txt_cargo.getText(); // Associar a caixa de texto ao campo nome
        String nasc = txt_nasc.getText(); // Associar a caixa de texto ao campo nome
        String sexo = txt_sexo.getText(); // Associar a caixa de texto ao campo nome
        String user = txt_user.getText();
        String senha = txt_senha.getText();
        String acesso = txt_acesso.getText(); // Associar a caixa de texto ao campo nome
        String email = txt_email.getText();
        String cel = txt_cel.getText(); // Associar a caixa de texto ao campo nome
        String tel = txt_tel.getText(); // Associar a caixa de texto ao campo nome
        String cep = txt_cep.getText(); // Associar a caixa de texto ao campo nome
        String rua = txt_rua.getText(); // Associar a caixa de texto ao campo nome
        String num = txt_num.getText(); // Associar a caixa de texto ao campo nome
        String comp = txt_compl.getText(); // Associar a caixa de texto ao campo nome
        String bairro = txt_bairro.getText(); // Associar a caixa de texto ao campo nome
        String city = txt_city.getText(); // Associar a caixa de texto ao campo nome
        String est = txt_est.getText(); // Associar a caixa de texto ao campo nome
        String sql;
        String msg = "";

        try {
            // possui um if porque se o usuário não digitar nenhum código na caixa de texto, então este botão fará uma inclusão e não alteração.
            if (txt_id.getText().equals("")) {
                sql = "insert into login (nome, sobrenome, cpf, rg, cargo, nasc, sexo,  user, senha, acesso, email, cel, tel, cep, rua, num, comp, bairro, city, est) values ('" + nome + "', '" + sobrenome + "','" + cpf + "','" + rg + "','" + cargo + "','" + nasc + "','" + sexo + "','" + user + "','" + senha + "','" + acesso + "','" + email + "','" + cel + "','" + tel + "','" + cep + "','" + rua + "','" + num + "','" + comp + "','" + bairro + "','" + city + "','" + est + "')";
                msg = "Gravação de um novo registro";
            } else {
                // define o comando SQL de alteração, onde é informado o nome da tabela, e, após o “set” estão sendo feitas atribuições para cada campo com sua respectiva variável, extraída das caixas de texto. É nesta hora que os atributos passam a ter o novo valor.
                sql = "update login set nome='" + nome + "',sobrenome ='" + sobrenome + "',cpf ='" + cpf + "',rg='" + rg + "',cargo='" + cargo + "',nasc='" + nasc + "',sexo='" + sexo + "',user='" + user + "',senha='" + senha + "', acesso='" + acesso + "',email='" + email + "',cel='" + cel + "',tel='" + tel + "',cep='" + cep + "',rua='" + rua + "',num='" + num + "',comp='" + comp + "',bairro='" + bairro + "',city='" + city + "',est='" + est + "'where id = " + txt_id.getText();
                msg = "Alteração de registro";
            }

            // executa (no ambiente Java - virtualmente) o comando de inserção e/ou alteração.
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from login order by id");
            // executa o método “preencherTabela”, responsável por apresentar dados na Jtable.
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // Ação do Botão Excluir
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                // executa (no ambiente Java - virtualmente) o comando de deletar registros, onde o parâmetro para o filtro de registros será o conteúdo da caixa de texto do código.
                sql = "delete from login where id = " + txt_id.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from login order by id");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_excluirActionPerformed

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed

    }//GEN-LAST:event_txt_pesquisaActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        // Ação do botão Gravar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome = txt_nome.getText();
        String sobrenome = txt_sob.getText();
        String cpf = txt_cpf.getText(); // Associar a caixa de texto ao campo nome 
        String rg = txt_rg.getText();// Associar a caixa de texto ao campo nome
        String cargo = txt_cargo.getText(); // Associar a caixa de texto ao campo nome
        String nasc = txt_nasc.getText(); // Associar a caixa de texto ao campo nome
        String sexo = txt_sexo.getText(); // Associar a caixa de texto ao campo nome
        String user = txt_user.getText();
        String senha = txt_senha.getText();
        String acesso = txt_acesso.getText(); // Associar a caixa de texto ao campo nome
        String email = txt_email.getText();
        String cel = txt_cel.getText(); // Associar a caixa de texto ao campo nome
        String tel = txt_tel.getText(); // Associar a caixa de texto ao campo nome
        String cep = txt_cep.getText(); // Associar a caixa de texto ao campo nome
        String rua = txt_rua.getText(); // Associar a caixa de texto ao campo nome
        String num = txt_num.getText(); // Associar a caixa de texto ao campo nome
        String comp = txt_compl.getText(); // Associar a caixa de texto ao campo nome
        String bairro = txt_bairro.getText(); // Associar a caixa de texto ao campo nome
        String city = txt_city.getText(); // Associar a caixa de texto ao campo nome
        String est = txt_est.getText(); // Associar a caixa de texto ao campo nome

        try {
            // define o comando SQL de inserção, onde são informados nome da tabela, campos, e, na sequência as variáveis resultantes das caixas de texto, respectivamente.
            String insert_sql = "insert into login (nome, sobrenome, cpf, rg, cargo, nasc, sexo,  user, senha, acesso, email, cel, tel, cep, rua, num, comp, bairro, city, est) values ('" + nome + "', '" + sobrenome + "','" + cpf + "','" + rg + "','" + cargo + "','" + nasc + "','" + sexo + "','" + user + "','" + senha + "','" + acesso + "','" + email + "','" + cel + "','" + tel + "','" + cep + "','" + rua + "','" + num + "','" + comp + "','" + bairro + "','" + city + "','" + est + "')";
            con_cliente.statement.executeUpdate(insert_sql); //  executa (no ambiente Java - virtualmente) o comando de inserção.
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from login order by id");
            // executa o método “preencherTabela”, responsável por apresentar dados atualizados na Jtable.
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        // Ação da função Pesquisar
        try {
            String pesquisa = "select * from login where nome like '" + txt_pesquisa.getText() + "%'";
            // where nome like '" + txt_pesquisa.getText() + "%'"; -> executa o código sempre que um novo caractere for digitado. Então a cada letra teclada a pesquisa na tabela é feita através do filtro
            // "%'"; -> O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void txt_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numActionPerformed

    private void btn_ultimoregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoregistroActionPerformed
        // posicionar o último registro
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o último registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ultimoregistroActionPerformed

    private void btn_primeiroregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primeiroregistroActionPerformed
        // posicionar o primeiro registro
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_primeiroregistroActionPerformed

    private void btn_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximoActionPerformed
        // posicionar próximo registro
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_proximoActionPerformed

    private void btn_anteriotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriotActionPerformed
        // posicionar registro anterior
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o registro anterior: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_anteriotActionPerformed

    private void Btn_Novo_RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Novo_RegistroActionPerformed
        txt_id.setText("");
        txt_nome.setText("");
        txt_sob.setText("");
        txt_cpf.setText("");
        txt_rg.setText("");
        txt_cargo.setText("");
        txt_nasc.setText("");
        txt_sexo.setText("");
        txt_user.setText("");
        txt_senha.setText("");
        txt_acesso.setText("");
        txt_email.setText("");
        txt_cel.setText("");
        txt_tel.setText("");
        txt_cep.setText("");
        txt_rua.setText("");
        txt_num.setText("");
        txt_compl.setText("");
        txt_bairro.setText("");
        txt_city.setText("");
        txt_est.setText("");
        txt_id.requestFocus();
    }//GEN-LAST:event_Btn_Novo_RegistroActionPerformed

    private void txt_sobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sobActionPerformed

    private void tbl_AdmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_AdmKeyPressed
        // evento que sincroniza a grid com as setas do teclado
        int linha_selecionada = tbl_Adm.getSelectedRow();
        txt_id.setText(tbl_Adm.getValueAt(linha_selecionada, 0).toString());
        txt_nome.setText(tbl_Adm.getValueAt(linha_selecionada, 1).toString());
        txt_sob.setText(tbl_Adm.getValueAt(linha_selecionada, 2).toString());
        txt_cpf.setText(tbl_Adm.getValueAt(linha_selecionada, 3).toString());
        txt_rg.setText(tbl_Adm.getValueAt(linha_selecionada, 4).toString());
        txt_cargo.setText(tbl_Adm.getValueAt(linha_selecionada, 5).toString());
        txt_nasc.setText(tbl_Adm.getValueAt(linha_selecionada, 6).toString());
        txt_sexo.setText(tbl_Adm.getValueAt(linha_selecionada, 7).toString());
        txt_user.setText(tbl_Adm.getValueAt(linha_selecionada, 8).toString());
        txt_senha.setText(tbl_Adm.getValueAt(linha_selecionada, 9).toString());
        txt_acesso.setText(tbl_Adm.getValueAt(linha_selecionada, 10).toString());
        txt_email.setText(tbl_Adm.getValueAt(linha_selecionada, 11).toString());
        txt_cel.setText(tbl_Adm.getValueAt(linha_selecionada, 12).toString());
        txt_tel.setText(tbl_Adm.getValueAt(linha_selecionada, 13).toString());
        txt_cep.setText(tbl_Adm.getValueAt(linha_selecionada, 14).toString());
        txt_rua.setText(tbl_Adm.getValueAt(linha_selecionada, 15).toString());
        txt_num.setText(tbl_Adm.getValueAt(linha_selecionada, 16).toString());
        txt_compl.setText(tbl_Adm.getValueAt(linha_selecionada, 17).toString());
        txt_bairro.setText(tbl_Adm.getValueAt(linha_selecionada, 18).toString());
        txt_city.setText(tbl_Adm.getValueAt(linha_selecionada, 19).toString());
        txt_est.setText(tbl_Adm.getValueAt(linha_selecionada, 20).toString());
    }//GEN-LAST:event_tbl_AdmKeyPressed

    private void tbl_AdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AdmMouseClicked
        // evento que sincroniza a grid com os clicks do mouse
        int linha_selecionada = tbl_Adm.getSelectedRow();
        txt_id.setText(tbl_Adm.getValueAt(linha_selecionada, 0).toString());
        txt_nome.setText(tbl_Adm.getValueAt(linha_selecionada, 1).toString());
        txt_sob.setText(tbl_Adm.getValueAt(linha_selecionada, 2).toString());
        txt_cpf.setText(tbl_Adm.getValueAt(linha_selecionada, 3).toString());
        txt_rg.setText(tbl_Adm.getValueAt(linha_selecionada, 4).toString());
        txt_cargo.setText(tbl_Adm.getValueAt(linha_selecionada, 5).toString());
        txt_nasc.setText(tbl_Adm.getValueAt(linha_selecionada, 6).toString());
        txt_sexo.setText(tbl_Adm.getValueAt(linha_selecionada, 7).toString());
        txt_user.setText(tbl_Adm.getValueAt(linha_selecionada, 8).toString());
        txt_senha.setText(tbl_Adm.getValueAt(linha_selecionada, 9).toString());
        txt_acesso.setText(tbl_Adm.getValueAt(linha_selecionada, 10).toString());
        txt_email.setText(tbl_Adm.getValueAt(linha_selecionada, 11).toString());
        txt_cel.setText(tbl_Adm.getValueAt(linha_selecionada, 12).toString());
        txt_tel.setText(tbl_Adm.getValueAt(linha_selecionada, 13).toString());
        txt_cep.setText(tbl_Adm.getValueAt(linha_selecionada, 14).toString());
        txt_rua.setText(tbl_Adm.getValueAt(linha_selecionada, 15).toString());
        txt_num.setText(tbl_Adm.getValueAt(linha_selecionada, 16).toString());
        txt_compl.setText(tbl_Adm.getValueAt(linha_selecionada, 17).toString());
        txt_bairro.setText(tbl_Adm.getValueAt(linha_selecionada, 18).toString());
        txt_city.setText(tbl_Adm.getValueAt(linha_selecionada, 19).toString());
        txt_est.setText(tbl_Adm.getValueAt(linha_selecionada, 20).toString());
    }//GEN-LAST:event_tbl_AdmMouseClicked

    private void txt_cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cepActionPerformed

    public void btn_editarActionPerformed2(java.awt.event.ActionEvent evt) {
        // Ação do Botão Alterar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome = txt_nome.getText();
        String sobrenome = txt_sob.getText();
        String cpf = txt_cpf.getText(); // Associar a caixa de texto ao campo nome 
        String rg = txt_rg.getText();// Associar a caixa de texto ao campo nome
        String cargo = txt_cargo.getText(); // Associar a caixa de texto ao campo nome
        String nasc = txt_nasc.getText(); // Associar a caixa de texto ao campo nome
        String sexo = txt_sexo.getText(); // Associar a caixa de texto ao campo nome
        String user = txt_user.getText();
        String senha = txt_senha.getText();
        String acesso = txt_acesso.getText(); // Associar a caixa de texto ao campo nome
        String email = txt_email.getText();
        String cel = txt_cel.getText(); // Associar a caixa de texto ao campo nome
        String tel = txt_tel.getText(); // Associar a caixa de texto ao campo nome
        String cep = txt_cep.getText(); // Associar a caixa de texto ao campo nome
        String rua = txt_rua.getText(); // Associar a caixa de texto ao campo nome
        String num = txt_num.getText(); // Associar a caixa de texto ao campo nome
        String comp = txt_compl.getText(); // Associar a caixa de texto ao campo nome
        String bairro = txt_bairro.getText(); // Associar a caixa de texto ao campo nome
        String city = txt_city.getText(); // Associar a caixa de texto ao campo nome
        String est = txt_est.getText(); // Associar a caixa de texto ao campo nome
        String sql;
        String msg = "";

        try {
            // possui um if porque se o usuário não digitar nenhum código na caixa de texto, então este botão fará uma inclusão e não alteração.
            if (txt_id.getText().equals("")) {
                sql = "insert into login (nome, sobrenome, cpf, rg, cargo, nasc, sexo,  user, senha, acesso, email, cel, tel, cep, rua, num, comp, bairro, city, est) values ('" + nome + "', '" + sobrenome + "','" + cpf + "','" + rg + "','" + cargo + "','" + nasc + "','" + sexo + "','" + user + "','" + senha + "','" + acesso + "','" + email + "','" + cel + "','" + tel + "','" + cep + "','" + rua + "','" + num + "','" + comp + "','" + bairro + "','" + city + "','" + est + "')";
                msg = "Gravação de um novo registro";
            } else {
                // define o comando SQL de alteração, onde é informado o nome da tabela, e, após o “set” estão sendo feitas atribuições para cada campo com sua respectiva variável, extraída das caixas de texto. É nesta hora que os atributos passam a ter o novo valor.
                sql = "update login set nome='" + nome + "',sobrenome ='" + sobrenome + "',cpf ='" + cpf + "',rg='" + rg + "',cargo='" + cargo + "',nasc='" + nasc + "',sexo='" + sexo + "',user='" + user + "',senha='" + senha + "', acesso='" + acesso + "',email='" + email + "',cel='" + cel + "',tel='" + tel + "',cep='" + cep + "',rua='" + rua + "',num='" + num + "',comp='" + comp + "',bairro='" + bairro + "',city='" + city + "',est='" + est + "'where id = " + txt_id.getText();
                msg = "Alteração de registro";
            }

            // executa (no ambiente Java - virtualmente) o comando de inserção e/ou alteração.
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from login order by id");
            // executa o método “preencherTabela”, responsável por apresentar dados na Jtable.
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void btn_excluirActionPerformed2(java.awt.event.ActionEvent evt) {
        // Ação do Botão Excluir
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                // executa (no ambiente Java - virtualmente) o comando de deletar registros, onde o parâmetro para o filtro de registros será o conteúdo da caixa de texto do código.
                sql = "delete from login where id = " + txt_id.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from login order by id");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void txt_pesquisaKeyReleased2(java.awt.event.KeyEvent evt) {
        // Ação da função Pesquisar
        try {
            String pesquisa = "select * from login where nome like '" + txt_pesquisa.getText() + "%'";
            // where nome like '" + txt_pesquisa.getText() + "%'"; -> executa o código sempre que um novo caractere for digitado. Então a cada letra teclada a pesquisa na tabela é feita através do filtro
            // "%'"; -> O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void btn_registrarActionPerformed2(java.awt.event.ActionEvent evt) {
        // Ação do botão Gravar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome = txt_nome.getText();
        String sobrenome = txt_sob.getText();
        String cpf = txt_cpf.getText(); // Associar a caixa de texto ao campo nome 
        String rg = txt_rg.getText();// Associar a caixa de texto ao campo nome
        String cargo = txt_cargo.getText(); // Associar a caixa de texto ao campo nome
        String nasc = txt_nasc.getText(); // Associar a caixa de texto ao campo nome
        String sexo = txt_sexo.getText(); // Associar a caixa de texto ao campo nome
        String user = txt_user.getText();
        String senha = txt_senha.getText();
        String acesso = txt_acesso.getText(); // Associar a caixa de texto ao campo nome
        String email = txt_email.getText();
        String cel = txt_cel.getText(); // Associar a caixa de texto ao campo nome
        String tel = txt_tel.getText(); // Associar a caixa de texto ao campo nome
        String cep = txt_cep.getText(); // Associar a caixa de texto ao campo nome
        String rua = txt_rua.getText(); // Associar a caixa de texto ao campo nome
        String num = txt_num.getText(); // Associar a caixa de texto ao campo nome
        String comp = txt_compl.getText(); // Associar a caixa de texto ao campo nome
        String bairro = txt_bairro.getText(); // Associar a caixa de texto ao campo nome
        String city = txt_city.getText(); // Associar a caixa de texto ao campo nome
        String est = txt_est.getText(); // Associar a caixa de texto ao campo nome

        try {
            // define o comando SQL de inserção, onde são informados nome da tabela, campos, e, na sequência as variáveis resultantes das caixas de texto, respectivamente.
            String insert_sql = "insert into login (nome, sobrenome, cpf, rg, cargo, nasc, sexo,  user, senha, acesso, email, cel, tel, cep, rua, num, comp, bairro, city, est) values ('" + nome + "', '" + sobrenome + "','" + cpf + "','" + rg + "','" + cargo + "','" + nasc + "','" + sexo + "','" + user + "','" + senha + "','" + acesso + "','" + email + "','" + cel + "','" + tel + "','" + cep + "','" + rua + "','" + num + "','" + comp + "','" + bairro + "','" + city + "','" + est + "')";
            con_cliente.statement.executeUpdate(insert_sql); //  executa (no ambiente Java - virtualmente) o comando de inserção.
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from login order by id");
            // executa o método “preencherTabela”, responsável por apresentar dados atualizados na Jtable.
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Novo_Registro;
    private javax.swing.JPanel Pnl_Cadastro_Usuario;
    private javax.swing.JPanel Pnl_Consultas;
    private javax.swing.JPanel Pnl_Contatos;
    private javax.swing.JPanel Pnl_Dados_Pessoais;
    private javax.swing.JButton btn_anteriot;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_primeiroregistro;
    private javax.swing.JButton btn_proximo;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_ultimoregistro;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_Adm;
    public javax.swing.JTextField txt_acesso;
    public javax.swing.JTextField txt_bairro;
    public javax.swing.JTextField txt_cargo;
    public javax.swing.JTextField txt_cel;
    public javax.swing.JFormattedTextField txt_cep;
    public javax.swing.JTextField txt_city;
    public javax.swing.JTextField txt_compl;
    public javax.swing.JTextField txt_cpf;
    public javax.swing.JTextField txt_email;
    public javax.swing.JTextField txt_est;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_nasc;
    public javax.swing.JTextField txt_nome;
    public javax.swing.JTextField txt_num;
    public javax.swing.JTextField txt_pesquisa;
    public javax.swing.JTextField txt_rg;
    public javax.swing.JTextField txt_rua;
    public javax.swing.JPasswordField txt_senha;
    public javax.swing.JTextField txt_sexo;
    public javax.swing.JTextField txt_sob;
    public javax.swing.JTextField txt_tel;
    public javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
