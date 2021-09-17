/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class PanelResultados extends JPanel {
    
    private JTable      resultados;
    private JScrollPane scroll;
    
    public PanelResultados(){
        initComponents();
    }
    
    private void initComponents(){
        this.resultados = new JTable();
        this.resultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        this.scroll = new JScrollPane(this.resultados);
        add(scroll, BorderLayout.CENTER);
        setPreferredSize(new Dimension(800,800));
    }

    /**
     * @return the tblResults
     */
    public JTable getresultados() {
        return resultados;
    }

    
    /**
     * @param tblResults the tblResults to set
     */
    public void setresultados(JTable tblResults) {
        this.resultados = tblResults;
    }
}


