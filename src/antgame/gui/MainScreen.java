package antgame.gui;

/**
 *
 * @author jd318
 */
public class MainScreen extends javax.swing.JFrame
{

    /**
     * Creates new form MainScreen
     */
    public MainScreen()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jToolBar1 = new javax.swing.JToolBar();
        roundPerSecondSetter = new javax.swing.JSlider();
        roundPerSecondDisplay = new javax.swing.JTextField();
        simulationOverallProgess = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ant Game");
        setMaximumSize(new java.awt.Dimension(5120, 3200));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("mainFrame"); // NOI18N

        jToolBar1.setRollover(true);

        roundPerSecondSetter.setToolTipText("Game rounds/second");
        roundPerSecondSetter.setName("roundPerSecondSetter"); // NOI18N
        jToolBar1.add(roundPerSecondSetter);

        roundPerSecondDisplay.setEditable(false);
        roundPerSecondDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundPerSecondDisplay.setText("200 r/s");
        roundPerSecondDisplay.setName("roundPerSecondDisplay"); // NOI18N
        roundPerSecondDisplay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                roundPerSecondDisplayActionPerformed(evt);
            }
        });
        jToolBar1.add(roundPerSecondDisplay);

        simulationOverallProgess.setMaximum(300000);
        simulationOverallProgess.setToolTipText("Current simulation progress");
        simulationOverallProgess.setName("simulationOverallProgess"); // NOI18N
        simulationOverallProgess.setString(simulationOverallProgessStringUpdate());
        simulationOverallProgess.setStringPainted(true);
        simulationOverallProgess.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                simulationOverallProgessStateChanged(evt);
            }
        });
        jToolBar1.add(simulationOverallProgess);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 575, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roundPerSecondDisplayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_roundPerSecondDisplayActionPerformed
    {//GEN-HEADEREND:event_roundPerSecondDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundPerSecondDisplayActionPerformed

    private void simulationOverallProgessStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_simulationOverallProgessStateChanged
    {//GEN-HEADEREND:event_simulationOverallProgessStateChanged
        simulationOverallProgess.setString(simulationOverallProgessStringUpdate());
    }//GEN-LAST:event_simulationOverallProgessStateChanged

    private String simulationOverallProgessStringUpdate()
    {
        //value / maximum
        return simulationOverallProgess.getValue() + " / " + simulationOverallProgess.getMaximum();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField roundPerSecondDisplay;
    private javax.swing.JSlider roundPerSecondSetter;
    private javax.swing.JProgressBar simulationOverallProgess;
    // End of variables declaration//GEN-END:variables
}
