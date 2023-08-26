package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class frmTelefone extends javax.swing.JInternalFrame {

    Conexao con_cliente;

    public frmTelefone() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executaSQL("select * from telefone order by cod_tel");
        preencherTabela();
        posicionarRegistro();
        tbl_telefone.setAutoCreateRowSorter(true);
    }

    public void preencherTabela() {
        tbl_telefone.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_telefone.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_telefone.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_telefone.getColumnModel().getColumn(3).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) tbl_telefone.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod_tel"), con_cliente.resultset.getString("numero_tel"), con_cliente.resultset.getString("cod_tipotel"), con_cliente.resultset.getString("cod_fornecedores")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
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
            txt_ident.setText(con_cliente.resultset.getString("cod_tel"));
            txt_num.setText(con_cliente.resultset.getString("numero_tel"));
            txt_fornec.setText(con_cliente.resultset.getString("cod_tipotel"));
            txt_tipo.setText(con_cliente.resultset.getString("cod_fornecedores"));

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_fornec = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_num = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_ident = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_pesq = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_telefone = new javax.swing.JTable();
        btn_anteriot = new javax.swing.JButton();
        btn_proximo1 = new javax.swing.JButton();
        btn_primeiroregistro = new javax.swing.JButton();
        btn_ultimoregistro = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_gravar = new javax.swing.JButton();
        btn_newregt = new javax.swing.JButton();

        setTitle("Telefone");

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos Telefones"));

        txt_fornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fornecActionPerformed(evt);
            }
        });

        jLabel4.setText("Fornecedor:");

        jLabel3.setText("Tipo:");

        jLabel2.setText("Número:");

        jLabel1.setText("Id:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_fornec, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_ident, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ident, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fornec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Telefones"));

        jLabel6.setText("Pesquisar por fornecedor:");

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
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar"));

        tbl_telefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NÚMERO", "TIPO", "FORNECEDOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_telefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_telefoneMouseClicked(evt);
            }
        });
        tbl_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_telefoneKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_telefone);

        btn_anteriot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-esquerda-30.png"))); // NOI18N
        btn_anteriot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriotActionPerformed(evt);
            }
        });

        btn_proximo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-a-direita-30.png"))); // NOI18N
        btn_proximo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximo1ActionPerformed(evt);
            }
        });

        btn_primeiroregistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-primeiro-30.png"))); // NOI18N
        btn_primeiroregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primeiroregistroActionPerformed(evt);
            }
        });

        btn_ultimoregistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-último-30.png"))); // NOI18N
        btn_ultimoregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoregistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_anteriot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_proximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ultimoregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_anteriot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_proximo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ultimoregistro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_alterar.setText("Alterar ");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });

        btn_gravar.setText("Gravar");
        btn_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gravarActionPerformed(evt);
            }
        });

        btn_newregt.setText("Novo Registro ");
        btn_newregt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newregtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_newregt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_voltar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar)
                    .addComponent(btn_newregt)
                    .addComponent(btn_gravar)
                    .addComponent(btn_alterar)
                    .addComponent(btn_excluir))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        setBounds(150, 15, 635, 771);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        String numero_tel = txt_num.getText();
        String cod_tipotel = txt_tipo.getText();
        String cod_fornecedores = txt_fornec.getText();
        String sql;
        String msg = "";
        try {
            if (txt_ident.getText().equals("")) {
                sql = "insert into telefone(numero_tel, cod_tipotel, cod_fornecedores) values ('" + numero_tel + "','" + cod_tipotel + "','" + cod_fornecedores + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update telefone set numero_tel='" + numero_tel + "',cod_tipotel='" + cod_tipotel + "', cod_fornecedores='" + cod_fornecedores + "'where cod_tel = " + txt_ident.getText();
                msg = "Alteração de Registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from telefone order by cod_tel");
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
                sql = "delete from telefone where cod_tel =" + txt_ident.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from telefone order by cod_tel");
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

    private void tbl_telefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_telefoneMouseClicked
        int linha_selecionada = tbl_telefone.getSelectedRow();
        txt_ident.setText(tbl_telefone.getValueAt(linha_selecionada, 0).toString());
        txt_num.setText(tbl_telefone.getValueAt(linha_selecionada, 1).toString());
        txt_fornec.setText(tbl_telefone.getValueAt(linha_selecionada, 2).toString());
        txt_tipo.setText(tbl_telefone.getValueAt(linha_selecionada, 3).toString());
    }//GEN-LAST:event_tbl_telefoneMouseClicked

    private void tbl_telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_telefoneKeyPressed
        int linha_selecionada = tbl_telefone.getSelectedRow();
        txt_ident.setText(tbl_telefone.getValueAt(linha_selecionada, 0).toString());
        txt_num.setText(tbl_telefone.getValueAt(linha_selecionada, 1).toString());
        txt_fornec.setText(tbl_telefone.getValueAt(linha_selecionada, 2).toString());
        txt_tipo.setText(tbl_telefone.getValueAt(linha_selecionada, 3).toString());
    }//GEN-LAST:event_tbl_telefoneKeyPressed

    private void btn_newregtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newregtActionPerformed
        txt_ident.setText("");
        txt_num.setText("");
        txt_fornec.setText("");
        txt_tipo.setText("");
        txt_ident.requestFocus();
    }//GEN-LAST:event_btn_newregtActionPerformed

    private void btn_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gravarActionPerformed
        String cod_tel = txt_ident.getText();
        String numero_tel = txt_num.getText();
        String cod_tipotel = txt_fornec.getText();
        String cod_fornecedores = txt_tipo.getText();

        try {
            String insert_sql = "insert into telefone(cod_tel,numero_tel,cod_tipotel,cod_fornecedores) values ('" + cod_tel + "','" + numero_tel + "','" + cod_tipotel + "','" + cod_fornecedores + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from telefone order by cod_tel");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_gravarActionPerformed

    private void txt_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesqActionPerformed

    }//GEN-LAST:event_txt_pesqActionPerformed

    private void txt_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesqKeyReleased
        try {
            String pesquisa = "select * from telefone where cod_fornecedores like '" + txt_pesq.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n" + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_pesqKeyReleased

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

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

    private void btn_proximo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximo1ActionPerformed
        // posicionar próximo registro
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_proximo1ActionPerformed

    private void btn_anteriotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriotActionPerformed
        // posicionar registro anterior
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o registro anterior: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_anteriotActionPerformed

    private void txt_fornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fornecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fornecActionPerformed

    public void btn_alterarActionPerformed2(java.awt.event.ActionEvent evt) {
        String numero_tel = txt_num.getText();
        String cod_tipotel = txt_tipo.getText();
        String cod_fornecedores = txt_fornec.getText();
        String sql;
        String msg = "";
        try {
            if (txt_ident.getText().equals("")) {
                sql = "insert into telefone(numero_tel, cod_tipotel, cod_fornecedores) values ('" + numero_tel + "','" + cod_tipotel + "','" + cod_fornecedores + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update telefone set numero_tel='" + numero_tel + "',cod_tipotel='" + cod_tipotel + "', cod_fornecedores='" + cod_fornecedores + "'where cod_tel = " + txt_ident.getText();
                msg = "Alteração de Registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from telefone order by cod_tel");
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
                sql = "delete from telefone where cod_tel =" + txt_ident.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from telefone order by cod_tel");
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

    public void txt_pesqKeyReleased2(java.awt.event.KeyEvent evt) {
        try {
            String pesquisa = "select * from telefone where cod_fornecedores like '" + txt_pesq.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n" + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void btn_gravarActionPerformed2(java.awt.event.ActionEvent evt) {
        String cod_tel = txt_ident.getText();
        String numero_tel = txt_num.getText();
        String cod_tipotel = txt_fornec.getText();
        String cod_fornecedores = txt_tipo.getText();

        try {
            String insert_sql = "insert into telefone(cod_tel,numero_tel,cod_tipotel,cod_fornecedores) values ('" + cod_tel + "','" + numero_tel + "','" + cod_tipotel + "','" + cod_fornecedores + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from telefone order by cod_tel");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_telefone;
    public javax.swing.JTextField txt_fornec;
    public javax.swing.JTextField txt_ident;
    public javax.swing.JTextField txt_num;
    public javax.swing.JTextField txt_pesq;
    public javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
