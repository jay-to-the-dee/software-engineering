package antgame.gui;

import java.text.NumberFormat;
import org.jdesktop.beansbinding.Converter;

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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        gameSpeedToolbar = new javax.swing.JToolBar();
        roundPerSecondSetter = new javax.swing.JSlider();
        roundPerSecondDisplay = new javax.swing.JTextField();
        simulationOverallProgess = new javax.swing.JProgressBar();
        worldPanelPlaceHolder = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadWorldMenuItem = new javax.swing.JMenuItem();
        editWorldMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        loadBlackAntBrainMenuItem = new javax.swing.JMenuItem();
        loadRedAntBrainMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        simulationMenu = new javax.swing.JMenu();
        startMenuItem = new javax.swing.JMenuItem();
        pauseMenuItem = new javax.swing.JMenuItem();
        resetMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Up The Ante!");
        setMaximumSize(new java.awt.Dimension(5120, 3200));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("mainFrame"); // NOI18N

        gameSpeedToolbar.setName("Game Speed Toolbar"); // NOI18N

        roundPerSecondSetter.setMaximum(1000);
        roundPerSecondSetter.setToolTipText("Game rounds/second");
        roundPerSecondSetter.setValue(200);
        roundPerSecondSetter.setName("roundPerSecondSetter"); // NOI18N
        gameSpeedToolbar.add(roundPerSecondSetter);

        roundPerSecondDisplay.setEditable(false);
        roundPerSecondDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundPerSecondDisplay.setMaximumSize(getMinimumSize());
        roundPerSecondDisplay.setName("roundPerSecondDisplay"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, roundPerSecondSetter, org.jdesktop.beansbinding.ELProperty.create("${value} r/s"), roundPerSecondDisplay, org.jdesktop.beansbinding.BeanProperty.create("text"), "");
        bindingGroup.addBinding(binding);

        roundPerSecondDisplay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                roundPerSecondDisplayActionPerformed(evt);
            }
        });
        gameSpeedToolbar.add(roundPerSecondDisplay);

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
        gameSpeedToolbar.add(simulationOverallProgess);

        worldPanelPlaceHolder.setBackground(new java.awt.Color(204, 255, 102));
        worldPanelPlaceHolder.setToolTipText("DRAW HERE");

        javax.swing.GroupLayout worldPanelPlaceHolderLayout = new javax.swing.GroupLayout(worldPanelPlaceHolder);
        worldPanelPlaceHolder.setLayout(worldPanelPlaceHolderLayout);
        worldPanelPlaceHolderLayout.setHorizontalGroup(
            worldPanelPlaceHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        worldPanelPlaceHolderLayout.setVerticalGroup(
            worldPanelPlaceHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        fileMenu.setText("File");

        loadWorldMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        loadWorldMenuItem.setText("Load World");
        loadWorldMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadWorldMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadWorldMenuItem);

        editWorldMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        editWorldMenuItem.setText("Edit World");
        editWorldMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editWorldMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(editWorldMenuItem);
        fileMenu.add(jSeparator1);

        loadBlackAntBrainMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        loadBlackAntBrainMenuItem.setText("Load Black Ant Brain");
        loadBlackAntBrainMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadBlackAntBrainMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadBlackAntBrainMenuItem);

        loadRedAntBrainMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        loadRedAntBrainMenuItem.setText("Load Red Ant Brain");
        loadRedAntBrainMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadRedAntBrainMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadRedAntBrainMenuItem);
        fileMenu.add(jSeparator2);

        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitApplication(evt);
            }
        });
        fileMenu.add(jMenuItem5);

        mainMenuBar.add(fileMenu);

        simulationMenu.setText("Simulation");

        startMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        startMenuItem.setText("Start");
        startMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startMenuItemActionPerformed(evt);
            }
        });
        simulationMenu.add(startMenuItem);

        pauseMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        pauseMenuItem.setText("Pause");
        pauseMenuItem.setEnabled(false);
        pauseMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pauseMenuItemActionPerformed(evt);
            }
        });
        simulationMenu.add(pauseMenuItem);

        resetMenuItem.setText("Reset");
        resetMenuItem.setEnabled(false);
        simulationMenu.add(resetMenuItem);

        mainMenuBar.add(simulationMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameSpeedToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(worldPanelPlaceHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(worldPanelPlaceHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameSpeedToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

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

    private void startMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startMenuItemActionPerformed
    {//GEN-HEADEREND:event_startMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startMenuItemActionPerformed

    private void pauseMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_pauseMenuItemActionPerformed
    {//GEN-HEADEREND:event_pauseMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pauseMenuItemActionPerformed

    private void loadWorldMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadWorldMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadWorldMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadWorldMenuItemActionPerformed

    private void loadBlackAntBrainMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadBlackAntBrainMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadBlackAntBrainMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadBlackAntBrainMenuItemActionPerformed

    private void editWorldMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editWorldMenuItemActionPerformed
    {//GEN-HEADEREND:event_editWorldMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editWorldMenuItemActionPerformed

    private void loadRedAntBrainMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadRedAntBrainMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadRedAntBrainMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadRedAntBrainMenuItemActionPerformed

    private void exitApplication(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitApplication
    {//GEN-HEADEREND:event_exitApplication
        this.dispose();
    }//GEN-LAST:event_exitApplication

    private String simulationOverallProgessStringUpdate()
    {
        NumberFormat nf = NumberFormat.getInstance();

        //value / maximum
        return nf.format(simulationOverallProgess.getValue())
                + " / "
                + nf.format(simulationOverallProgess.getMaximum());
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
                System.out.println(info);
                if ("Windows".equals(info.getName()) || "Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //break;
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
    private javax.swing.JMenuItem editWorldMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JToolBar gameSpeedToolbar;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem loadBlackAntBrainMenuItem;
    private javax.swing.JMenuItem loadRedAntBrainMenuItem;
    private javax.swing.JMenuItem loadWorldMenuItem;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem pauseMenuItem;
    private javax.swing.JMenuItem resetMenuItem;
    private javax.swing.JTextField roundPerSecondDisplay;
    private javax.swing.JSlider roundPerSecondSetter;
    private javax.swing.JMenu simulationMenu;
    private javax.swing.JProgressBar simulationOverallProgess;
    private javax.swing.JMenuItem startMenuItem;
    private javax.swing.JPanel worldPanelPlaceHolder;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
