/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JFrame;

/**
 *
 * @author Esteban
 */
public class MainWindow extends JFrame{
    
    public MainWindow(){
        initComponents();
        
    }
    
    private void initComponents(){
        setTitle("Bitacora - MVC");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        PanelResultados resultsPanel = new PanelResultados();
        setContentPane(resultsPanel);
        add(new PanelControl(resultsPanel));
        
        setSize(1040, 720);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    
}
