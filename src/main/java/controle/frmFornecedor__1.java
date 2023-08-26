package controle;

import conexao.Conexao;   // importar do package a classe
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;   // para reconhecimento da JTable
import java.sql.*;  // para reconhecimento dos comandos SQL

public class frmFornecedor__1 extends javax.swing.JInternalFrame {

    Conexao con_cliente;

    public frmFornecedor__1() {
        initComponents();
        con_cliente = new Conexao(); //inicialização do objeto como instância
        con_cliente.conecta();  // chama o método que conecta
        con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
        preencherTabela();
        posicionarRegistro();
        tbl_fornecedor.setAutoCreateRowSorter(true); // ativa a classificação ordenada da tabela
    }

    @SuppressWarnings("unchecked")

    public void preencherTabela() {
        tbl_fornecedor.getColumnModel().getColumn(0).setPreferredWidth(14);
        tbl_fornecedor.getColumnModel().getColumn(1).setPreferredWidth(100);
        DefaultTableModel modelo = (DefaultTableModel) tbl_fornecedor.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod_fornecedores"), con_cliente.resultset.getString("nome_fornecedor"), con_cliente.resultset.getString("cnpj"), con_cliente.resultset.getString("endereco"), con_cliente.resultset.getString("forma_entrega")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void posicionarRegistro() {
        try {
            con_cliente.resultset.first(); // posiciona no 1° registro da tabela
            mostrar_Dados(); // chama o método que irá buscar o dado da tabela
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        try {
            txt_cod.setText(con_cliente.resultset.getString("cod_fornecedores")); // Associar a caixa de texto ao campo cod
            txt_nome.setText(con_cliente.resultset.getString("nome_fornecedor")); // Associar a caixa de texto ao campo nome
            txt_cnpj.setText(con_cliente.resultset.getString("cnpj")); // Associar a caixa de texto ao campo cnpj
            txt_end.setText(con_cliente.resultset.getString("endereco")); // Associar a caixa de texto ao campo endereço
            txt_entrega.setText(con_cliente.resultset.getString("forma_entrega")); // Associar a caixa de texto ao campo entrega
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_cod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_entrega = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cnpj = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_end = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_pesq = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_fornecedor = new javax.swing.JTable();
        btn_anteriot = new javax.swing.JButton();
        btn_proximo = new javax.swing.JButton();
        btn_primeiroregistro = new javax.swing.JButton();
        btn_ultimoregistro = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_gravar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setTitle("Fornecedores");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(882, 566));

        jScrollPane2.setBackground(new java.awt.Color(204, 0, 0));

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados dos Fornecedores"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel5.setText("Forma  de Entrega:");

        jLabel4.setText("CNPJ:");

        jLabel3.setText("Endereço:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Fornecedores"));

        jLabel6.setText("Buscar por nome:");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        tbl_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "NOME", "CNPJ", "ENDEREÇO", "ENTREGA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_fornecedorMouseClicked(evt);
            }
        });
        tbl_fornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_fornecedorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_fornecedor);

        btn_anteriot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-esquerda-30.png"))); // NOI18N
        btn_anteriot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriotActionPerformed(evt);
            }
        });

        btn_proximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/controle/icons8-ordenar-para-a-direita-30.png"))); // NOI18N
        btn_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximoActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_anteriot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ultimoregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_proximo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_anteriot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ultimoregistro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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

        btn_gravar.setText("Gravar");
        btn_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gravarActionPerformed(evt);
            }
        });

        btn_editar.setText("Alterar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Novo Registro");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_gravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_voltar)))
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_gravar)
                    .addComponent(btn_cancelar))
                .addGap(1, 1, 1))
        );

        jScrollPane2.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(150, 15, 690, 658);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gravarActionPerformed
        // Ação do botão Gravar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome_fornecedor = txt_nome.getText();
        String cnpj = txt_cnpj.getText();
        String endereco = txt_end.getText();
        String entrega = txt_entrega.getText();

        try {
            // define o comando SQL de inserção, onde são informados nome da tabela, campos, e, na sequência as variáveis resultantes das caixas de texto, respectivamente.
            String insert_sql = "insert into fornecedores(nome_fornecedor , cnpj, endereco, forma_entrega) values ('" + nome_fornecedor + "', '" + cnpj + "','" + endereco + "','" + entrega + "')";
            con_cliente.statement.executeUpdate(insert_sql); //  executa (no ambiente Java - virtualmente) o comando de inserção.
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
            // executa o método “preencherTabela”, responsável por apresentar dados atualizados na Jtable.
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_gravarActionPerformed

    private void tbl_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_fornecedorMouseClicked
        // evento que sincroniza a grid com os clicks do mouse
        int linha_selecionada = tbl_fornecedor.getSelectedRow();
        txt_cod.setText(tbl_fornecedor.getValueAt(linha_selecionada, 0).toString());
        txt_nome.setText(tbl_fornecedor.getValueAt(linha_selecionada, 1).toString());
        txt_cnpj.setText(tbl_fornecedor.getValueAt(linha_selecionada, 2).toString());
        txt_end.setText(tbl_fornecedor.getValueAt(linha_selecionada, 3).toString());
        txt_entrega.setText(tbl_fornecedor.getValueAt(linha_selecionada, 4).toString());
    }//GEN-LAST:event_tbl_fornecedorMouseClicked

    private void tbl_fornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_fornecedorKeyPressed

        // evento que sincroniza a grid com as setas do teclado
        int linha_selecionada = tbl_fornecedor.getSelectedRow();
        txt_cod.setText(tbl_fornecedor.getValueAt(linha_selecionada, 0).toString());
        txt_nome.setText(tbl_fornecedor.getValueAt(linha_selecionada, 1).toString());
        txt_cnpj.setText(tbl_fornecedor.getValueAt(linha_selecionada, 2).toString());
        txt_end.setText(tbl_fornecedor.getValueAt(linha_selecionada, 3).toString());
        txt_entrega.setText(tbl_fornecedor.getValueAt(linha_selecionada, 4).toString());


    }//GEN-LAST:event_tbl_fornecedorKeyPressed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        txt_cod.setText("");
        txt_nome.setText("");
        txt_cnpj.setText("");
        txt_end.setText("");
        txt_entrega.setText("");
        txt_cod.requestFocus();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Ação do Botão Alterar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome_fornecedor = txt_nome.getText();
        String cnpj = txt_cnpj.getText();
        String endereco = txt_end.getText();
        String entrega = txt_entrega.getText();
        String sql;
        String msg = "";

        try {
            // possui um if porque se o usuário não digitar nenhum código na caixa de texto, então este botão fará uma inclusão e não alteração.
            if (txt_cod.getText().equals("")) {
                sql = "insert into fornecedores (nome_fornecedor, cnpj, endereco, forma_entrega) values ('" + nome_fornecedor + "', '" + cnpj + "','" + endereco + "','" + entrega + "')";
                msg = "Gravação de um novo registro";
            } else {
                // define o comando SQL de alteração, onde é informado o nome da tabela, e, após o “set” estão sendo feitas atribuições para cada campo com sua respectiva variável, extraída das caixas de texto. É nesta hora que os atributos passam a ter o novo valor.
                sql = "update fornecedores set nome_fornecedor='" + nome_fornecedor + "',cnpj ='" + cnpj + "',endereco ='" + endereco + "',forma_entrega='" + entrega + "'where cod_fornecedores = " + txt_cod.getText();
                msg = "Alteração de registro";
            }

            // executa (no ambiente Java - virtualmente) o comando de inserção e/ou alteração.
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
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
                sql = "delete from fornecedores where cod_fornecedores = " + txt_cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
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

    private void txt_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesqActionPerformed

    }//GEN-LAST:event_txt_pesqActionPerformed

    private void txt_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesqKeyReleased
        // Ação da função Pesquisar
        try {
            String pesquisa = "select * from fornecedores where nome_fornecedor like '" + txt_pesq.getText() + "%'";
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
    }//GEN-LAST:event_txt_pesqKeyReleased

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

    //CRUD PUBLIC
    public void btn_editarActionPerformed2(java.awt.event.ActionEvent evt) {
        // Ação do Botão Alterar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome_fornecedor = txt_nome.getText();
        String cnpj = txt_cnpj.getText();
        String endereco = txt_end.getText();
        String entrega = txt_entrega.getText();
        String sql;
        String msg = "";

        try {
            // possui um if porque se o usuário não digitar nenhum código na caixa de texto, então este botão fará uma inclusão e não alteração.
            if (txt_cod.getText().equals("")) {
                sql = "insert into fornecedores (nome_fornecedor, cnpj, endereco, forma_entrega) values ('" + nome_fornecedor + "', '" + cnpj + "','" + endereco + "','" + entrega + "')";
                msg = "Gravação de um novo registro";
            } else {
                // define o comando SQL de alteração, onde é informado o nome da tabela, e, após o “set” estão sendo feitas atribuições para cada campo com sua respectiva variável, extraída das caixas de texto. É nesta hora que os atributos passam a ter o novo valor.
                sql = "update fornecedores set nome_fornecedor='" + nome_fornecedor + "',cnpj ='" + cnpj + "',endereco ='" + endereco + "',forma_entrega='" + entrega + "'where cod_fornecedores = " + txt_cod.getText();
                msg = "Alteração de registro";
            }

            // executa (no ambiente Java - virtualmente) o comando de inserção e/ou alteração.
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
            // executa o método “preencherTabela”, responsável por apresentar dados na Jtable.
            preencherTabela();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void txt_pesqKeyReleased2(java.awt.event.KeyEvent evt) {
        // Ação da função Pesquisar
        try {
            String pesquisa = "select * from fornecedores where nome_fornecedor like '" + txt_pesq.getText() + "%'";
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

    public void btn_gravarActionPerformed2(java.awt.event.ActionEvent evt) {
        // Ação do botão Gravar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome_fornecedor = txt_nome.getText();
        String cnpj = txt_cnpj.getText();
        String endereco = txt_end.getText();
        String entrega = txt_entrega.getText();

        try {
            // define o comando SQL de inserção, onde são informados nome da tabela, campos, e, na sequência as variáveis resultantes das caixas de texto, respectivamente.
            String insert_sql = "insert into fornecedores(nome_fornecedor , cnpj, endereco, forma_entrega) values ('" + nome_fornecedor + "', '" + cnpj + "','" + endereco + "','" + entrega + "')";
            con_cliente.statement.executeUpdate(insert_sql); //  executa (no ambiente Java - virtualmente) o comando de inserção.
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
            // executa o método “preencherTabela”, responsável por apresentar dados atualizados na Jtable.
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
                sql = "delete from fornecedores where cod_fornecedores = " + txt_cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from fornecedores order by cod_fornecedores");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anteriot;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_gravar;
    private javax.swing.JButton btn_primeiroregistro;
    private javax.swing.JButton btn_proximo;
    private javax.swing.JButton btn_ultimoregistro;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_fornecedor;
    public javax.swing.JTextField txt_cnpj;
    public javax.swing.JTextField txt_cod;
    public javax.swing.JTextField txt_end;
    public javax.swing.JTextField txt_entrega;
    public javax.swing.JTextField txt_nome;
    public javax.swing.JTextField txt_pesq;
    // End of variables declaration//GEN-END:variables

}
