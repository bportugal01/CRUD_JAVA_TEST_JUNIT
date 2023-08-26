package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class frmIngredientes extends javax.swing.JInternalFrame {

    Conexao con_cliente;

    public frmIngredientes() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executaSQL("select * from ingredientes order by cod_ingrediente");
        preencherTabela();
        posicionarRegistro();
        tbl_ingrediente.setAutoCreateRowSorter(true);
    }

    public void preencherTabela() {
        tbl_ingrediente.getColumnModel().getColumn(0).setPreferredWidth(14);
        tbl_ingrediente.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_ingrediente.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_ingrediente.getColumnModel().getColumn(3).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) tbl_ingrediente.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod_ingrediente"), con_cliente.resultset.getString("cod_produto"), con_cliente.resultset.getString("cod_prato"), con_cliente.resultset.getString("qntd_receita")
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
            txt_cod.setText(con_cliente.resultset.getString("cod_ingrediente"));
            txt_codprod.setText(con_cliente.resultset.getString("cod_produto"));
            txt_codprato.setText(con_cliente.resultset.getString("cod_prato"));
            txt_quant.setText(con_cliente.resultset.getString("qntd_receita"));

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_codprod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codprato = new javax.swing.JTextField();
        txt_quant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ingrediente = new javax.swing.JTable();
        btn_primeiro = new javax.swing.JButton();
        btn_anterior = new javax.swing.JButton();
        btn_proximo = new javax.swing.JButton();
        btn_ultimo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txt_pesq = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_newregt = new javax.swing.JButton();
        btn_gravar = new javax.swing.JButton();
        btn_alterar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setTitle("Ingredientes");

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos Ingredientes"));
        jPanel1.setLayout(null);

        txt_codprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codprodActionPerformed(evt);
            }
        });
        jPanel1.add(txt_codprod);
        txt_codprod.setBounds(20, 100, 60, 30);

        jLabel2.setText("Código do Produto:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 92, 20);
        jPanel1.add(txt_cod);
        txt_cod.setBounds(20, 40, 60, 30);

        jLabel1.setText("Código Ingrediente :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 110, 20);

        jLabel4.setText("Código do Prato:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 20, 79, 20);

        txt_codprato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codpratoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_codprato);
        txt_codprato.setBounds(150, 40, 60, 30);
        jPanel1.add(txt_quant);
        txt_quant.setBounds(150, 100, 187, 30);

        jLabel3.setText("Quantidade da Receita:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 80, 140, 20);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Pratos"));

        tbl_ingrediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Ingrediente", "Código Produto", "Código Prato", "Quantidade da Receita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ingrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ingredienteMouseClicked(evt);
            }
        });
        tbl_ingrediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_ingredienteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ingrediente);

        btn_primeiro.setText("Primeiro ");
        btn_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primeiroActionPerformed(evt);
            }
        });

        btn_anterior.setText("Anterior ");
        btn_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorActionPerformed(evt);
            }
        });

        btn_proximo.setText("Próximo");
        btn_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximoActionPerformed(evt);
            }
        });

        btn_ultimo.setText("Último ");
        btn_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_primeiro)
                        .addGap(18, 18, 18)
                        .addComponent(btn_anterior)
                        .addGap(18, 18, 18)
                        .addComponent(btn_proximo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ultimo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_primeiro)
                    .addComponent(btn_anterior)
                    .addComponent(btn_proximo)
                    .addComponent(btn_ultimo))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Ingredientes de cada Prato"));

        txt_pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesqKeyReleased(evt);
            }
        });

        jLabel6.setText("Pesquisar Ingredientes com Código do Prato:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_newregt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_voltar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_newregt)
                    .addComponent(btn_gravar)
                    .addComponent(btn_alterar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_voltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(150, 15, 688, 613);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed
        String codproduto = txt_codprod.getText();
        String codprato = txt_codprato.getText();
        String qntdreceita = txt_quant.getText();
        String sql;
        String msg = "";

        try {
            if (txt_cod.getText().equals("")) {
                sql = "insert into ingredientes(cod_produto, cod_prato, qntd_receita) values ('" + codproduto + "','" + codprato + "','" + qntdreceita + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update ingredientes set cod_produto='" + codproduto + "',cod_prato='" + codprato + "',qntd_receita='" + qntdreceita + "'where cod_ingrediente=" + txt_cod.getText();
                msg = "Alteração de registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from ingredientes order by cod_ingrediente");
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
                sql = "delete from ingredientes where cod_ingrediente = " + txt_cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from ingredientes order by cod_ingrediente");
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

    private void tbl_ingredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ingredienteMouseClicked
        int linha_selecionada = tbl_ingrediente.getSelectedRow();
        txt_cod.setText(tbl_ingrediente.getValueAt(linha_selecionada, 0).toString());
        txt_codprod.setText(tbl_ingrediente.getValueAt(linha_selecionada, 1).toString());
        txt_codprato.setText(tbl_ingrediente.getValueAt(linha_selecionada, 2).toString());
        txt_quant.setText(tbl_ingrediente.getValueAt(linha_selecionada, 3).toString());
    }//GEN-LAST:event_tbl_ingredienteMouseClicked

    private void tbl_ingredienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_ingredienteKeyPressed
        int linha_selecionada = tbl_ingrediente.getSelectedRow();
        txt_cod.setText(tbl_ingrediente.getValueAt(linha_selecionada, 0).toString());
        txt_codprod.setText(tbl_ingrediente.getValueAt(linha_selecionada, 1).toString());
        txt_codprato.setText(tbl_ingrediente.getValueAt(linha_selecionada, 2).toString());
        txt_quant.setText(tbl_ingrediente.getValueAt(linha_selecionada, 3).toString());
    }//GEN-LAST:event_tbl_ingredienteKeyPressed

    private void btn_newregtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newregtActionPerformed
        txt_cod.setText("");
        txt_codprod.setText("");
        txt_codprato.setText("");
        txt_quant.setText("");
        txt_cod.requestFocus();
    }//GEN-LAST:event_btn_newregtActionPerformed

    private void btn_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gravarActionPerformed
        String cod_prod = txt_codprod.getText();
        String cod_prato = txt_codprato.getText();
        String qntd_receita = txt_quant.getText();

        try {
            String insert_sql = "insert into ingredientes (cod_produto,cod_prato,qntd_receita) values ('" + cod_prod + "','" + cod_prato + "','" + qntd_receita + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravacao realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from ingredientes order by cod_produto");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_gravarActionPerformed

    private void txt_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesqKeyReleased
        try {
            String pesquisa = "select * from ingredientes where cod_prato like '" + txt_pesq.getText() + "%'";
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

    private void btn_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorActionPerformed
        // posicionar registro anterior
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o registro anterior: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_anteriorActionPerformed

    private void btn_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximoActionPerformed
        // posicionar próximo registro
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o próximo registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_proximoActionPerformed

    private void btn_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primeiroActionPerformed
        // posicionar o primeiro registro
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_primeiroActionPerformed

    private void btn_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoActionPerformed
        // posicionar o último registro
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o último registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ultimoActionPerformed

    private void txt_codpratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codpratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codpratoActionPerformed

    private void txt_codprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codprodActionPerformed

    
    
    // CRUD PUBLIC
    public void btn_alterarActionPerformed2(java.awt.event.ActionEvent evt) {
        String codproduto = txt_codprod.getText();
        String codprato = txt_codprato.getText();
        String qntdreceita = txt_quant.getText();
        String sql;
        String msg = "";

        try {
            if (txt_cod.getText().equals("")) {
                sql = "insert into ingredientes(cod_produto, cod_prato, qntd_receita) values ('" + codproduto + "','" + codprato + "','" + qntdreceita + "')";
                msg = "Gravação de um novo registro";
            } else {
                sql = "update ingredientes set cod_produto='" + codproduto + "',cod_prato='" + codprato + "',qntd_receita='" + qntdreceita + "'where cod_ingrediente=" + txt_cod.getText();
                msg = "Alteração de registro";
            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from ingredientes order by cod_ingrediente");
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
                sql = "delete from ingredientes where cod_ingrediente = " + txt_cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from ingredientes order by cod_ingrediente");
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
        String cod_prod = txt_codprod.getText();
        String cod_prato = txt_codprato.getText();
        String qntd_receita = txt_quant.getText();

        try {
            String insert_sql = "insert into ingredientes (cod_produto,cod_prato,qntd_receita) values ('" + cod_prod + "','" + cod_prato + "','" + qntd_receita + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravacao realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from ingredientes order by cod_produto");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void txt_pesqKeyReleased2(java.awt.event.KeyEvent evt) {
        try {
            String pesquisa = "select * from ingredientes where cod_prato like '" + txt_pesq.getText() + "%'";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_gravar;
    private javax.swing.JButton btn_newregt;
    private javax.swing.JButton btn_primeiro;
    private javax.swing.JButton btn_proximo;
    private javax.swing.JButton btn_ultimo;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_ingrediente;
    public javax.swing.JTextField txt_cod;
    public javax.swing.JTextField txt_codprato;
    public javax.swing.JTextField txt_codprod;
    public javax.swing.JTextField txt_pesq;
    public javax.swing.JTextField txt_quant;
    // End of variables declaration//GEN-END:variables
}
