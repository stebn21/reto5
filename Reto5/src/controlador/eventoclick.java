/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import acceso.ExpedicionDAO;
import modelo.ComandanteModel;
import modelo.ExpedicionModel;
import modelo.PlanetasModel;
import vista.PanelControl;
import vista.AñadirComandante;
import vista.EliminarComandante;

public class eventoclick implements ActionListener{
    
    private PanelControl panelcontrol;
    
    public eventoclick(PanelControl panelcontrol){
        this.panelcontrol=panelcontrol;
    }

    @Override
    public void actionPerformed(ActionEvent actionevent) {
        if(actionevent.getSource()== this.panelcontrol.getBuscar()){
            int expedicionesid=((ExpedicionModel)this.panelcontrol.getListaexp().getSelectedItem()).getCodigoExp();
            int Planetasid=((PlanetasModel)this.panelcontrol.getListaplanetas().getSelectedItem()).getIdPlanetas();
           // Boolean habita=((PlanetasModel)this.panelcontrol.gethabitabilidad().getSelectedItem()).isHabitabilidadPlaneta();
            String nombre =(String)this.panelcontrol.getTxtexp().getText();
            
            ExpedicionDAO expedicionDAO = new ExpedicionDAO();
            ArrayList <ExpedicionModel> expediciones= expedicionDAO.FiltroExpediciones(expedicionesid, Planetasid,nombre);
            this.panelcontrol.setResultados(expediciones);
            
    }else if (actionevent.getSource()==this.panelcontrol.getBotoncom()){
             AñadirComandante comandante= new AñadirComandante();
                comandante.setVisible(true);     
    }else if (actionevent.getSource()==this.panelcontrol.getBotonEli()){
            EliminarComandante comandante= new EliminarComandante();
                comandante.setVisible(true);
    }
        
    }
    
}
