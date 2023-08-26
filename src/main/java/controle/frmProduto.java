package controle;

import conexao.Conexao; // importar do package a classe
import javax.swing.JOptionPane; // importação biblioteca para caixas de diálogo
import javax.swing.table.DefaultTableModel; // para reconhecimento da Jtable
import java.sql.*; // para reconhecimento dos comandos SQL

public class frmProduto extends javax.swing.JInternalFrame {

    Conexao con_cliente;
    
    public frmProduto() {
        initComponents();
        con_cliente = new Conexao(); // inicialização do objeto como instância
        con_cliente.conecta(); // chama o método que conecta 
        con_cliente.executaSQL("select * from produtos order by id");
        preencherTabela();
        posicionarRegistro();
        tbl_Prod.setAutoCreateRowSorter(true); // ativa a classificação ordenada da tabela
    }

    public void preencherTabela(){
  
      tbl_Prod.getColumnModel().getColumn(0).setPreferredWidth(14);
      tbl_Prod.getColumnModel().getColumn(1).setPreferredWidth(100);
      tbl_Prod.getColumnModel().getColumn(2).setPreferredWidth(100);
      tbl_Prod.getColumnModel().getColumn(3).setPreferredWidth(100);
      tbl_Prod.getColumnModel().getColumn(4).setPreferredWidth(100);
      tbl_Prod.getColumnModel().getColumn(5).setPreferredWidth(100);
      tbl_Prod.getColumnModel().getColumn(6).setPreferredWidth(100);
      tbl_Prod.getColumnModel().getColumn(7).setPreferredWidth(100);

      DefaultTableModel modelo = (DefaultTableModel) tbl_Prod.getModel();
      modelo.setNumRows(0);

      try{
          con_cliente.resultset.beforeFirst();
          while(con_cliente.resultset.next()){
              modelo.addRow(new Object[]{
                  con_cliente.resultset.getString("id"),con_cliente.resultset.getString("descricao"),con_cliente.resultset.getString("qtd"),con_cliente.resultset.getString("validade"),con_cliente.resultset.getString("marca"),con_cliente.resultset.getString("esp"),con_cliente.resultset.getString("categoria"),con_cliente.resultset.getString("preco_custo")
              });
          }
      }catch(SQLException erro){
          JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
}
}

    private void posicionarRegistro() {
        try {
          con_cliente.resultset.first(); // posiciona no 1° registro da tabela
          mostrar_Dados(); // chama o método que irá buscar o dado da tabela
          }catch(SQLException erro) {
          JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
}

      public void mostrar_Dados(){ 
      try {
          txt_id.setText(con_cliente.resultset.getString("id")); // Associar a caixa de texto ao campo cod
          txt_desc.setText(con_cliente.resultset.getString("descricao")); // Associar a caixa de texto ao campo nome
          txt_qtd.setText(con_cliente.resultset.getString("qtd")); // Associar a caixa de texto ao campo nome
          //spinner_qtd.setModel(con_cliente.resultset.get("qtd")); // Associar a caixa de texto ao campo dt_nasc
          txt_val.setText(con_cliente.resultset.getString("validade")); // Associar a caixa de texto ao campo telefone
          txt_marca.setText(con_cliente.resultset.getString("marca")); // Associar a caixa de texto ao campo telefone
          txt_esp.setText(con_cliente.resultset.getString("esp")); // Associar a caixa de texto ao campo telefone
          txt_cat.setText(con_cliente.resultset.getString("categoria")); // Associar a caixa de texto ao campo telefone
          txt_custo.setText(con_cliente.resultset.getString("preco_custo")); // Associar a caixa de texto ao campo email
          }catch(SQLException erro) {
          JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
}  
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_qtd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_val = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_custo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_esp = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        txt_pesq = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Prod = new javax.swing.JTable();
        btn_ultimoregistro = new javax.swing.JButton();
        btn_primeiroregistro = new javax.swing.JButton();
        btn_proximo1 = new javax.swing.JButton();
        btn_anteriot = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();

        setTitle("Produtos ");
        setRequestFocusEnabled(false);

        jScrollPane4.setBackground(new java.awt.Color(204, 0, 0));

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Produtos"));

        jLabel6.setText("ID:");

        jLabel1.setText("Descrição:");

        jLabel2.setText("QTD:");

        jLabel7.setText("Validade:");

        jLabel8.setText("Marca:");

        jLabel3.setText("Preço (custo):");

        jLabel10.setText("ID Categoria:");

        jLabel9.setText("Especificações:");

        txt_esp.setColumns(20);
        txt_esp.setRows(5);
        jScrollPane2.setViewportView(txt_esp);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txt_val, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel8))
                            .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_cat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_custo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_custo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Produtos"));

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

        jLabel5.setText("Nome do Produto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultas"));

        tbl_Prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIÇÃO", "QTD", "VAL", "MARCA", "ESPECIFICAÇÕES", "ID CATEGORIA", "PREÇO (CUSTO)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProdMouseClicked(evt);
            }
        });
        tbl_Prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_ProdKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Prod);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_anteriot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_proximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ultimoregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_anteriot, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_proximo1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_primeiroregistro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ultimoregistro, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_editar.setText("Alterar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_registrar.setText("Gravar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        btn_limpar.setText("Novo Registro");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar)
                        .addGap(285, 285, 285)
                        .addComponent(btn_voltar))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_registrar)
                    .addComponent(btn_limpar))
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(150, 15, 709, 601);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
         // Ação do botão Novo Registro / Limpar
        txt_id.setText(""); // limpa a acaixa de texto em questão
        txt_desc.setText("");
        txt_qtd.setText("");
         //spinner_qtd.setModel(SpinnerNumberModel 1,2,3);
        txt_val.setText("");
        txt_marca.setText("");
        txt_esp.setText("");
        txt_cat.setText("");
        txt_custo.setText("");
        txt_id.requestFocus(); // posiciona o cursor neste campo para digitação 
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        // Ação do botão Gravar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String descricao = txt_desc.getText(); 
        String qtd = txt_qtd.getText();
        //String qtd = spinner_qtd.getNumberModel();
        String validade = txt_val.getText();
        String marca = txt_marca.getText();
        String esp = txt_esp.getText();
        String categoria = txt_cat.getText();
        String preco_custo = txt_custo.getText();

       try {
         // define o comando SQL de inserção, onde são informados nome da tabela, campos, e, na sequência as variáveis resultantes das caixas de texto, respectivamente.
         String insert_sql="insert into produtos(descricao, qtd, validade, marca, esp, categoria, preco_custo) values ('" + descricao + "','" + qtd + "','" + validade + "','" + marca + "','"  + esp + "','" + categoria + "','" + preco_custo + "')";
         con_cliente.statement.executeUpdate(insert_sql); //  executa (no ambiente Java - virtualmente) o comando de inserção.
         JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        
        // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
        con_cliente.executaSQL("select * from produtos order by id");
        // executa o método “preencherTabela”, responsável por apresentar dados atualizados na Jtable.
        preencherTabela();
   
        }catch(SQLException errosql) {
           JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void txt_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesqActionPerformed

    }//GEN-LAST:event_txt_pesqActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        // Ação do Botão Excluir
        String sql="";
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
            if (resposta==0){
                // executa (no ambiente Java - virtualmente) o comando de deletar registros, onde o parâmetro para o filtro de registros será o conteúdo da caixa de texto do código.
                sql = "delete from produtos where id = " + txt_id.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir==1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from produtos order by id");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch (SQLException excecao){
            JOptionPane.showMessageDialog(null,"Erro na exclusão: "+excecao,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Ação do Botão Alterar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String descricao = txt_desc.getText(); 
        String qtd = txt_qtd.getText();
        //String qtd = spinner_qtd.getNumberModel();
        String validade = txt_val.getText();
        String marca = txt_marca.getText();
        String esp = txt_esp.getText();
        String categoria = txt_cat.getText();
        String preco_custo = txt_custo.getText();
        String sql;
        String msg="";

        try {
            // possui um if porque se o usuário não digitar nenhum código na caixa de texto, então este botão fará uma inclusão e não alteração.
            if(txt_id.getText().equals("")){
                sql="insert into produtos(descricao, qtd, validade, marca, esp, categoria, preco_custo) values ('" + descricao + "','" + qtd + "','" + validade + "','" + marca + "','"  + esp + "','" + categoria + "','" + preco_custo + "',)";
                msg="Gravação de um novo registro";
            }else{
                // define o comando SQL de alteração, onde é informado o nome da tabela, e, após o “set” estão sendo feitas atribuições para cada campo com sua respectiva variável, extraída das caixas de texto. É nesta hora que os atributos passam a ter o novo valor.
                sql="update produtos set descricao='" + descricao + "',qtd='" + qtd + "',validade ='" + validade + "',marca='" + marca + "',esp='"  + esp + "',categoria='" + categoria + "',preco_custo='" + preco_custo + "'where id = " + txt_id.getText();
                msg="Alteração de registro";
            }

            // executa (no ambiente Java - virtualmente) o comando de inserção e/ou alteração.
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from produtos order by id");
            // executa o método “preencherTabela”, responsável por apresentar dados na Jtable.
            preencherTabela();

        }catch(SQLException errosql) {
            JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void tbl_ProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_ProdKeyPressed
       int linha_selecionada = tbl_Prod.getSelectedRow();
       txt_id.setText(tbl_Prod.getValueAt(linha_selecionada,0).toString());
       txt_desc.setText(tbl_Prod.getValueAt(linha_selecionada,1).toString());
       txt_qtd.setText(tbl_Prod.getValueAt(linha_selecionada,2).toString());
       txt_val.setText(tbl_Prod.getValueAt(linha_selecionada,3).toString());
       txt_marca.setText(tbl_Prod.getValueAt(linha_selecionada,4).toString());
       txt_esp.setText(tbl_Prod.getValueAt(linha_selecionada,5).toString());
       txt_cat.setText(tbl_Prod.getValueAt(linha_selecionada,6).toString());
       txt_custo.setText(tbl_Prod.getValueAt(linha_selecionada,7).toString());
    }//GEN-LAST:event_tbl_ProdKeyPressed

    private void tbl_ProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProdMouseClicked
       int linha_selecionada = tbl_Prod.getSelectedRow();
       txt_id.setText(tbl_Prod.getValueAt(linha_selecionada,0).toString());
       txt_desc.setText(tbl_Prod.getValueAt(linha_selecionada,1).toString());
       txt_qtd.setText(tbl_Prod.getValueAt(linha_selecionada,2).toString());
       txt_val.setText(tbl_Prod.getValueAt(linha_selecionada,3).toString());
       txt_marca.setText(tbl_Prod.getValueAt(linha_selecionada,4).toString());
       txt_esp.setText(tbl_Prod.getValueAt(linha_selecionada,5).toString());
       txt_cat.setText(tbl_Prod.getValueAt(linha_selecionada,6).toString());
       txt_custo.setText(tbl_Prod.getValueAt(linha_selecionada,7).toString());
    }//GEN-LAST:event_tbl_ProdMouseClicked

    private void txt_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesqKeyReleased
             // Ação da função Pesquisar
       try{
          String pesquisa = "select * from produtos where descricao like '" + txt_pesq.getText() + "%'";
          // where nome like '" + txt_pesquisa.getText() + "%'"; -> executa o código sempre que um novo caractere for digitado. Então a cada letra teclada a pesquisa na tabela é feita através do filtro
          // "%'"; -> O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”
          con_cliente.executaSQL(pesquisa);

          if(con_cliente.resultset.first()){
              preencherTabela();
          }
          else{
             JOptionPane.showMessageDialog(null,"\n Não existe dados com este paramêtro!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
          }
          }catch(SQLException errosql) {
             JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_txt_pesqKeyReleased

    private void btn_anteriotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriotActionPerformed
        // posicionar registro anterior
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o registro anterior: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_anteriotActionPerformed

    private void btn_proximo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximo1ActionPerformed
        // posicionar próximo registro
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o próximo registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_proximo1ActionPerformed

    private void btn_primeiroregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primeiroregistroActionPerformed
        // posicionar o primeiro registro
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_primeiroregistroActionPerformed

    private void btn_ultimoregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoregistroActionPerformed
        // posicionar o último registro
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar o último registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ultimoregistroActionPerformed


     public void btn_registrarActionPerformed2(java.awt.event.ActionEvent evt) {                                              
        // Ação do botão Gravar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String descricao = txt_desc.getText(); 
        String qtd = txt_qtd.getText();
        //String qtd = spinner_qtd.getNumberModel();
        String validade = txt_val.getText();
        String marca = txt_marca.getText();
        String esp = txt_esp.getText();
        String categoria = txt_cat.getText();
        String preco_custo = txt_custo.getText();

       try {
         // define o comando SQL de inserção, onde são informados nome da tabela, campos, e, na sequência as variáveis resultantes das caixas de texto, respectivamente.
         String insert_sql="insert into produtos(descricao, qtd, validade, marca, esp, categoria, preco_custo) values ('" + descricao + "','" + qtd + "','" + validade + "','" + marca + "','"  + esp + "','" + categoria + "','" + preco_custo + "')";
         con_cliente.statement.executeUpdate(insert_sql); //  executa (no ambiente Java - virtualmente) o comando de inserção.
         JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        
        // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
        con_cliente.executaSQL("select * from produtos order by id");
        // executa o método “preencherTabela”, responsável por apresentar dados atualizados na Jtable.
        preencherTabela();
   
        }catch(SQLException errosql) {
           JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }                                             

                                         

    public void btn_excluirActionPerformed2(java.awt.event.ActionEvent evt) {                                            
        // Ação do Botão Excluir
        String sql="";
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
            if (resposta==0){
                // executa (no ambiente Java - virtualmente) o comando de deletar registros, onde o parâmetro para o filtro de registros será o conteúdo da caixa de texto do código.
                sql = "delete from produtos where id = " + txt_id.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir==1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from produtos order by id");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch (SQLException excecao){
            JOptionPane.showMessageDialog(null,"Erro na exclusão: "+excecao,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }                                           

    public void btn_editarActionPerformed2(java.awt.event.ActionEvent evt) {                                           
        // Ação do Botão Alterar
        // declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String descricao = txt_desc.getText(); 
        String qtd = txt_qtd.getText();
        //String qtd = spinner_qtd.getNumberModel();
        String validade = txt_val.getText();
        String marca = txt_marca.getText();
        String esp = txt_esp.getText();
        String categoria = txt_cat.getText();
        String preco_custo = txt_custo.getText();
        String sql;
        String msg="";

        try {
            // possui um if porque se o usuário não digitar nenhum código na caixa de texto, então este botão fará uma inclusão e não alteração.
            if(txt_id.getText().equals("")){
                sql="insert into produtos(descricao, qtd, validade, marca, esp, categoria, preco_custo) values ('" + descricao + "','" + qtd + "','" + validade + "','" + marca + "','"  + esp + "','" + categoria + "','" + preco_custo + "',)";
                msg="Gravação de um novo registro";
            }else{
                // define o comando SQL de alteração, onde é informado o nome da tabela, e, após o “set” estão sendo feitas atribuições para cada campo com sua respectiva variável, extraída das caixas de texto. É nesta hora que os atributos passam a ter o novo valor.
                sql="update produtos set descricao='" + descricao + "',qtd='" + qtd + "',validade ='" + validade + "',marca='" + marca + "',esp='"  + esp + "',categoria='" + categoria + "',preco_custo='" + preco_custo + "'where id = " + txt_id.getText();
                msg="Alteração de registro";
            }

            // executa (no ambiente Java - virtualmente) o comando de inserção e/ou alteração.
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

            // executa (no ambiente Java - virtualmente) o comando de seleção dos dados da tabela.
            con_cliente.executaSQL("select * from produtos order by id");
            // executa o método “preencherTabela”, responsável por apresentar dados na Jtable.
            preencherTabela();

        }catch(SQLException errosql) {
            JOptionPane.showMessageDialog(null,"\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    
     public void txt_pesqKeyReleased2(java.awt.event.KeyEvent evt) {                                     
             // Ação da função Pesquisar
       try{
          String pesquisa = "select * from produtos where descricao like '" + txt_pesq.getText() + "%'";
          // where nome like '" + txt_pesquisa.getText() + "%'"; -> executa o código sempre que um novo caractere for digitado. Então a cada letra teclada a pesquisa na tabela é feita através do filtro
          // "%'"; -> O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”
          con_cliente.executaSQL(pesquisa);

          if(con_cliente.resultset.first()){
              preencherTabela();
          }
          else{
             JOptionPane.showMessageDialog(null,"\n Não existe dados com este paramêtro!!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
          }
          }catch(SQLException errosql) {
             JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
         }
    } 
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anteriot;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_primeiroregistro;
    private javax.swing.JButton btn_proximo1;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_ultimoregistro;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_Prod;
    public javax.swing.JTextField txt_cat;
    public javax.swing.JTextField txt_custo;
    public javax.swing.JTextField txt_desc;
    public javax.swing.JTextArea txt_esp;
    public javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_marca;
    public javax.swing.JTextField txt_pesq;
    public javax.swing.JTextField txt_qtd;
    public javax.swing.JTextField txt_val;
    // End of variables declaration//GEN-END:variables
}
