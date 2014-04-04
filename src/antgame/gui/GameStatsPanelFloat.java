/*
 */

package antgame.gui;

/**
 *
 * @author jay-to-the-dee <jay-to-the-dee@users.noreply.github.com>
 */
public class GameStatsPanelFloat extends javax.swing.JPanel
{

    /**
     * Creates new form GameStatsPanel
     */
    public GameStatsPanelFloat()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        blackLabel = new javax.swing.JLabel();
        redLabel = new javax.swing.JLabel();
        foodBlackLabel = new javax.swing.JLabel();
        aliveAntsBlackLabel = new javax.swing.JLabel();
        restingBlackLabel = new javax.swing.JLabel();
        foodRedLabel = new javax.swing.JLabel();
        aliveAntsRedLabel = new javax.swing.JLabel();
        restingRedLabel = new javax.swing.JLabel();
        blackFoodCount = new javax.swing.JLabel();
        redAliveAntsCount = new javax.swing.JLabel();
        redRestingCount = new javax.swing.JLabel();
        blackRestingCount = new javax.swing.JLabel();
        blackAliveAntsCount = new javax.swing.JLabel();
        redFoodCount = new javax.swing.JLabel();

        setName("Game Stats"); // NOI18N
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 10, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        setLayout(layout);

        blackLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        blackLabel.setText("Black");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        add(blackLabel, gridBagConstraints);

        redLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        redLabel.setForeground(new java.awt.Color(255, 0, 0));
        redLabel.setText("Red");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        add(redLabel, gridBagConstraints);

        foodBlackLabel.setText("Food");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(foodBlackLabel, gridBagConstraints);

        aliveAntsBlackLabel.setText("Alive ants");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(aliveAntsBlackLabel, gridBagConstraints);

        restingBlackLabel.setText("Resting");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(restingBlackLabel, gridBagConstraints);

        foodRedLabel.setText("Food");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(foodRedLabel, gridBagConstraints);

        aliveAntsRedLabel.setText("Alive ants");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(aliveAntsRedLabel, gridBagConstraints);

        restingRedLabel.setText("Resting");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(restingRedLabel, gridBagConstraints);

        blackFoodCount.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(blackFoodCount, gridBagConstraints);

        redAliveAntsCount.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        add(redAliveAntsCount, gridBagConstraints);

        redRestingCount.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        add(redRestingCount, gridBagConstraints);

        blackRestingCount.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(blackRestingCount, gridBagConstraints);

        blackAliveAntsCount.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(blackAliveAntsCount, gridBagConstraints);

        redFoodCount.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(redFoodCount, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aliveAntsBlackLabel;
    private javax.swing.JLabel aliveAntsRedLabel;
    private javax.swing.JLabel blackAliveAntsCount;
    private javax.swing.JLabel blackFoodCount;
    private javax.swing.JLabel blackLabel;
    private javax.swing.JLabel blackRestingCount;
    private javax.swing.JLabel foodBlackLabel;
    private javax.swing.JLabel foodRedLabel;
    private javax.swing.JLabel redAliveAntsCount;
    private javax.swing.JLabel redFoodCount;
    private javax.swing.JLabel redLabel;
    private javax.swing.JLabel redRestingCount;
    private javax.swing.JLabel restingBlackLabel;
    private javax.swing.JLabel restingRedLabel;
    // End of variables declaration//GEN-END:variables
}
