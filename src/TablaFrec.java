
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo Neftaly Garcia King (Lakej)
 */
public class TablaFrec extends javax.swing.JFrame {

    
    public static String num;
    public String data[] = new String[1000];
    public double r, k, numMax, numMin;
    public int n, c;
    
    
    
    public TablaFrec() {
        initComponents();
    }
    
    //Funcion booleana para determinar si un String es numerico o no
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
    
    
    //Calculo del Rango
    public void calculoRango(){
        
        this.numMax = numMax(data);
        this.numMin = numMin(data);
        
        this.r = numMax - numMin;
        
        
    }
    
    public void calculoSturges(){
        k = 1.0 + (3.322 * Math.log10(n));
    }
    
    //Funcion de calculo de numero maximo en un Array con busqueda lineal
    public double numMax(String[] data){
        
        //Obtiene el valor en la posicion 0 del Array "data" y lo convierte en tipo Double
        double numMax = Double.parseDouble(data[0]);
        
        //Ciclo que pasa posicion por posicion en el Array "datos"
        for (String dato : data) {
            
            //Condicion que establece si el Array en la poscion real es mayor a la variable "numMax" (valor maximo actual)
            if (Double.parseDouble(dato) > numMax) {
                
                //Reescribe el valor del numMax con el nuevo valor maximo en caso de encontrarlo
                numMax = Double.parseDouble(dato);
            }
        }
        
        //Retorna el valor maximo
        return numMax;
    }
    
    //Funcion de calculo de numero maximo en un Array con busqueda lineal
    public double numMin(String[] datos){
        
        //Crea variable con el primer valor del Array
        double numMin = Double.parseDouble(datos[0]);
        
        //Ciclo que pasa por todas las posiciones del Array
        for (String dato : datos) {
            
            //Condicional que establece que si el dato actual del Array es menor que la variable numMin Y diferente de -1
            if (Double.parseDouble(dato) < numMin && Double.parseDouble(dato) != -1) {
                
                //Reescribe el valor de numMin con el valor actual minimo diferente de -1 (valor rellenado)
                numMin = Double.parseDouble(dato);
            }
        }
        
        //Regresa el valor minimo
        return numMin;
    }
    
    //Inicializa con valor 0 por defecto en cada indice del arreglo
    public void initData(String[] data){
        
        //Ciclo que pasa posicion por posicion en el Array "data"
        for(int i = 0; i < data.length; i++){
            
            //Relleno de datos en la posicion "i"
            data[i] = "";
        }
    }
    
    //Se rellena los datos sobrantes con un -1 para no interferir con los rangos de calculo
    public void rellenoDatos(String[] data){
        
        //Ciclo que pasa posicion por posicion en el Array "data"
        for(int i = 0; i < data.length; i++){
            
            //Condicional que determina cuando el Array "data" en la posicion "i" esta vacio o no
            if("".equals(data[i])){
                
                //En caso de estar vacio rellena el espacio con un -1
                data[i] = "-1";
            }
        }
    }
    
    //Se traspasan los datos de la variable "num" a el Array "data" para tratarla como char
    public void capturarDatos(String num, String[] data){
        
        //Variable x para la posicion en el Array "data"
        int x = 0;
        
        //Repasamos uno por uno el String num y extraemos el valor de cada posicion tratando la cadena como char
        for(int i = 0; i < num.length(); i++){
            
            //En esta parte verificamos si es numerico la posicion "i" de num para guardarlo en el arreglo data
            if(isNumeric(String.valueOf(num.charAt(i)))){
                data[x] += num.charAt(i);
               
            //En caso que no sea numerico, se salta a la siguiente posicion del arreglo data
            }else{
                x += 1;
            }
        }
        
    }
    
    
    public void numeroDatos(String[] data){
        for (String data1 : data) {
            if (Double.valueOf(data1) != -1) {
                n += 1;
            }
        }
    }
    
    public void anchoClase(){
        c = (int) Math.ceil(r/k);
    }
    
    
    public void tablaDatos(String[] data){
        
        int inter1, inter2, frec = 0;
        
        
        String[] fila = new String[2];
        
        inter1 = (int) numMin;
        inter2 = (int) numMin + c - 1;
        
        fila[0] = String.valueOf(inter1) + " - " + String.valueOf(inter2);
        
        
        
        fila[1] = String.valueOf(frec);
        
        DefaultTableModel modelo = (DefaultTableModel)tblDatos.getModel();
        modelo.addRow(fila);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtRango = new javax.swing.JTextField();
        btnCalculos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSturges = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        txtDebug = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Tabla de Distribucion de Frecuencias");

        jButton1.setText("Ingresar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Rango");

        txtRango.setEditable(false);

        btnCalculos.setText("Calcular Parametros");
        btnCalculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Valor de Sturges");

        txtSturges.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ancho de Clase");

        txtAncho.setEditable(false);

        txtDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDebugActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intervalos", "Frecuencia (f)", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtRango, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSturges, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalculos)
                        .addGap(130, 130, 130))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtDebug, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(txtDebug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCalculos))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtSturges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistroDatos rd = new RegistroDatos();
        rd.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCalculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculosActionPerformed
        
        //Inicializamos el arreglo con valor de 0 para todas las posiciones (1000)
        initData(data);
        
        //Pasamos los datos capturados en la variable String "num" a un arreglo "data"
        capturarDatos(num, data);
        
        //Se rellenan los espacios en blanco restantes (son 1000 espacios en el arreglo) con -1 <------!!!
        rellenoDatos(data);
        numeroDatos(data);
        
        
        calculoRango();
        calculoSturges();
        
        anchoClase();
        
        txtRango.setText(String.valueOf(r));
        txtSturges.setText(String.valueOf(k));
        txtAncho.setText(String.valueOf(c));
        txtDebug.setText(String.valueOf(n));
        
        //tablaDatos(data);
        
        
        
    }//GEN-LAST:event_btnCalculosActionPerformed

    private void txtDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDebugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDebugActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TablaFrec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaFrec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaFrec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaFrec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaFrec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextField txtDebug;
    private javax.swing.JTextField txtRango;
    private javax.swing.JTextField txtSturges;
    // End of variables declaration//GEN-END:variables
}
