package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class frmCard extends javax.swing.JInternalFrame {

    Conexao con_cliente;

    public frmCard() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executaSQL("select * from cardapio order by cod_prato");
        preencherTabela();
        posicionarRegistro();
        tbl_cardapio.setAutoCreateRowSorter(true);
    }

    public void preencherTabela() {
        tbl_cardapio.getColumnModel().getColumn(0).setPreferredWidth(14);
        tbl_cardapio.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_cardapio.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl_cardapio.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl_cardapio.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl_cardapio.getColumnModel().getColumn(5).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) tbl_cardapio.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod_prato"), con_cliente.resultset.getString("nome_prato"), con_cliente.resultset.getString("desc_prato"), con_cliente.resultset.getString("preco_prato"), con_cliente.resultset.getString("cod_tipoprato"), con_cliente.resultset.getString("custo_prato")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void posicionarRegistro() {
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel posicionar no primeiro registro:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        try {
            txt_cod.setText(con_cliente.resultset.getString("cod_prato"));
            txt_nome.setText(con_cliente.resultset.getString("nome_prato"));
            txt_desc.setText(con_cliente.resultset.getString("desc_prato"));
            txt_preco.setText(con_cliente.resultset.getString("preco_prato"));
            txt_codtipo.setText(con_cliente.resultset.getString("cod_tipoprato"));
            txt_custo.setText(con_cliente.resultset.getString("custo_prato"));

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_preco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_codtipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_custo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_desc = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_pesq = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cardapio = new javax.swing.JTable();
        btn_ultimoregistro = new javax.swing.JButton();
        btn_primeiroregistro = new javax.swing.JButton();
        btn_proximo1 = new javax.swing.JButton();
        btn_anteriot = new javax.swing.JButton();
        btn_newregt = new javax.swing.JButton();
        btn_gravar = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setTitle("Cardápio");
        setPreferredSize(new java.awt.Dimension(898, 609));

        jScrollPane3.setBackground(new java.awt.Color(204, 0, 0));

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos Pratos"));

        jLabel4.setText("Preço:");

        jLabel3.setText("Tipo do Prato:");

        jLabel2.setText("Nome:");

        txt_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel5.setText("Custo:");

        jLabel7.setText("Descrição:");

        txt_desc.setColumns(20);
        txt_desc.setRows(5);
        jScrollPane2.setViewportView(txt_desc);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_custo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_codtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_custo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Pratos"));

        jLabel6.setText("Pesquisar por nome do Prato :");

        txt_pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesqActionPerformed(evt);
            }
        });
        txt_pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesqKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Pratos"));

        tbl_cardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PRATO", "DESCRIÇÃO", "PREÇO", "TIPO DE PRATO", "CUSTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_cardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cardapioMouseClicked(evt);
            }
        });
        tbl_cardapio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_cardapioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cardapio);

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

        btn_proximo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-a-direita-30.png"))); // NOI18N
        btn_proximo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximo1ActionPerformed(evt);
            }
        });

        btn_anteriot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-esquerda-30.png"))); // NOI18N
        btn_anteriot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_anteriot, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_proximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ultimoregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(227, 227, 227))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ultimoregistro)
                    .addComponent(btn_primeiroregistro)
                    .addComponent(btn_proximo1)
                    .addComponent(btn_anteriot))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_newregt.setText("Novo Registro ");
        btn_newregt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newregtActionPerformed(evt);
            }
        });

        btn_gravar.setText("Gravar");
        btn_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gravarActionPerformed(evt);
            }
        });

        btn_alterar.setText("Alterar ");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_newregt)
                        .addGap(18, 18, 18)
                        .addComponent(btn_gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_voltar)))
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_gravar)
                    .addComponent(btn_newregt)
                    .addComponent(btn_alterar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_voltar))
                .addGap(10, 10, 10))
        );

        jScrollPane3.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(150, 15, 727, 636);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        String nome_prato = txt_nome.getText();
        String desc_prato = txt_desc.getText();
        String preco_prato = txt_preco.getText();
        String cod_tipoprato = txt_codtipo.getText();
        String custo_prato = txt_custo.getText();
        String sql;
        String msg = "";

        try {
            if (txt_cod.getText().equals("")) {
                sql = "insert into cardapio(nome_prato, desc_prato, preco_prato, cod_tipoprato, custo_prato) values ('" + nome_prato + "','" + desc_prato + "','" + preco_prato + "','" + cod_tipoprato + "','" + custo_prato + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update cardapio set nome_prato='" + nome_prato + "',desc_prato='" + desc_prato + "',preco_prato='" + preco_prato + "',cod_tipoprato='" + cod_tipoprato + "',custo_prato='" + custo_prato + "'where cod_prato=" + txt_cod.getText();
                msg = "Alteração de registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from cardapio order by cod_prato");
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, " \n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_alterarActionPerformed


    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        String sql = "";

        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from cardapio where cod_prato = " + txt_cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from cardapio order by cod_prato");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuario", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void tbl_cardapioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cardapioMouseClicked
        int linha_selecionada = tbl_cardapio.getSelectedRow();
        txt_cod.setText(tbl_cardapio.getValueAt(linha_selecionada, 0).toString());
        txt_nome.setText(tbl_cardapio.getValueAt(linha_selecionada, 1).toString());
        txt_desc.setText(tbl_cardapio.getValueAt(linha_selecionada, 2).toString());
        txt_preco.setText(tbl_cardapio.getValueAt(linha_selecionada, 3).toString());
        txt_codtipo.setText(tbl_cardapio.getValueAt(linha_selecionada, 4).toString());
        txt_custo.setText(tbl_cardapio.getValueAt(linha_selecionada, 5).toString());
    }//GEN-LAST:event_tbl_cardapioMouseClicked

    private void tbl_cardapioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_cardapioKeyPressed
        int linha_selecionada = tbl_cardapio.getSelectedRow();
        txt_cod.setText(tbl_cardapio.getValueAt(linha_selecionada, 0).toString());
        txt_nome.setText(tbl_cardapio.getValueAt(linha_selecionada, 1).toString());
        txt_desc.setText(tbl_cardapio.getValueAt(linha_selecionada, 2).toString());
        txt_preco.setText(tbl_cardapio.getValueAt(linha_selecionada, 3).toString());
        txt_codtipo.setText(tbl_cardapio.getValueAt(linha_selecionada, 4).toString());
        txt_custo.setText(tbl_cardapio.getValueAt(linha_selecionada, 5).toString());
    }//GEN-LAST:event_tbl_cardapioKeyPressed

    private void btn_newregtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newregtActionPerformed
        txt_cod.setText("");
        txt_nome.setText("");
        txt_preco.setText("");
        txt_codtipo.setText("");
        txt_desc.setText("");
        txt_custo.setText("");
        txt_cod.requestFocus();
    }//GEN-LAST:event_btn_newregtActionPerformed

    private void btn_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gravarActionPerformed
        String nome_prato = txt_nome.getText();
        String desc_prato = txt_desc.getText();
        String preco_prato = txt_preco.getText();
        String cod_tipoprato = txt_codtipo.getText();
        String custo_prato = txt_codtipo.getText();

        try {
            String insert_sql = "insert into cardapio (nome_prato,desc_prato,preco_prato,cod_tipoprato,custo_prato) values ('" + nome_prato + "','" + desc_prato + "','" + preco_prato + "','" + cod_tipoprato + "','" + custo_prato + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravacao realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from cardapio order by cod_prato");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_gravarActionPerformed

    private void txt_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesqActionPerformed

    private void txt_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesqKeyReleased
        try {
            String pesquisa = "select * from cardapio where nome_prato like '" + txt_pesq.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este parametro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados: \n" + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_pesqKeyReleased

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_anteriotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriotActionPerformed
        // posicionar registro anterior
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o registro anterior: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_anteriotActionPerformed

    private void btn_proximo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximo1ActionPerformed
        // posicionar próximo registro
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_proximo1ActionPerformed

    private void btn_primeiroregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primeiroregistroActionPerformed
        // posicionar o primeiro registro
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_primeiroregistroActionPerformed

    private void btn_ultimoregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoregistroActionPerformed
        // posicionar o último registro
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o último registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ultimoregistroActionPerformed

    private void txt_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codActionPerformed
  
    // CRUD PUBLIC
    
    public void btn_alterarActionPerformed2(java.awt.event.ActionEvent evt) {                                            
        String nome_prato = txt_nome.getText();
        String desc_prato = txt_desc.getText();
        String preco_prato = txt_preco.getText();
        String cod_tipoprato = txt_codtipo.getText();
        String custo_prato = txt_custo.getText();
        String sql;
        String msg = "";

        try {
            if (txt_cod.getText().equals("")) {
                sql = "insert into cardapio(nome_prato, desc_prato, preco_prato, cod_tipoprato, custo_prato) values ('" + nome_prato + "','" + desc_prato + "','" + preco_prato + "','" + cod_tipoprato + "','" + custo_prato + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update cardapio set nome_prato='" + nome_prato + "',desc_prato='" + desc_prato + "',preco_prato='" + preco_prato + "',cod_tipoprato='" + cod_tipoprato + "',custo_prato='" + custo_prato + "'where cod_prato=" + txt_cod.getText();
                msg = "Alteração de registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from cardapio order by cod_prato");
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, " \n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }  

     public void btn_excluirActionPerformed2(java.awt.event.ActionEvent evt) {                                            
        String sql = "";

        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from cardapio where cod_prato = " + txt_cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from cardapio order by cod_prato");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuario", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
     
      public void btn_gravarActionPerformed2(java.awt.event.ActionEvent evt) {                                           
        String nome_prato = txt_nome.getText();
        String desc_prato = txt_desc.getText();
        String preco_prato = txt_preco.getText();
        String cod_tipoprato = txt_codtipo.getText();
        String custo_prato = txt_codtipo.getText();

        try {
            String insert_sql = "insert into cardapio (nome_prato,desc_prato,preco_prato,cod_tipoprato,custo_prato) values ('" + nome_prato + "','" + desc_prato + "','" + preco_prato + "','" + cod_tipoprato + "','" + custo_prato + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravacao realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from cardapio order by cod_prato");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }

    } 
      
       public void txt_pesqKeyReleased2(java.awt.event.KeyEvent evt) {                                     
        try {
            String pesquisa = "select * from cardapio where nome_prato like '" + txt_pesq.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este parametro!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados: \n" + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }  
       
       
       // TESTE DE NAVEGAÇÃO
       
       public void btn_anteriotActionPerformed2(java.awt.event.ActionEvent evt) {                                             
        // posicionar registro anterior
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o registro anterior: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
       
       
           public void btn_proximo1ActionPerformed2(java.awt.event.ActionEvent evt) {                                             
        // posicionar próximo registro
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                            

    public void btn_primeiroregistroActionPerformed2(java.awt.event.ActionEvent evt) {                                                     
        // posicionar o primeiro registro
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                                    

    public void btn_ultimoregistroActionPerformed2(java.awt.event.ActionEvent evt) {                                                   
        // posicionar o último registro
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o último registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                                  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_anteriot;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_gravar;
    private javax.swing.JButton btn_newregt;
    private javax.swing.JButton btn_primeiroregistro;
    private javax.swing.JButton btn_proximo1;
    private javax.swing.JButton btn_ultimoregistro;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_cardapio;
    public javax.swing.JTextField txt_cod;
    public javax.swing.JTextField txt_codtipo;
    public javax.swing.JTextField txt_custo;
    public javax.swing.JTextArea txt_desc;
    public javax.swing.JTextField txt_nome;
    public javax.swing.JTextField txt_pesq;
    public javax.swing.JTextField txt_preco;
    // End of variables declaration//GEN-END:variables


}
