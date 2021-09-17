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
import modelo.VisitaModel;
import vista.PanelControl;
import acceso.PlanetasDAO;

/**
 *
 * @author Esteban
 */
public class Eventocambio implements ActionListener {

    private PanelControl panelcontrol;
    public Eventocambio (PanelControl panelcontrol){
        this.panelcontrol=panelcontrol;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionevent) {
        if(actionevent.getSource()==this.panelcontrol.getListaplanetas()){
            PlanetasDAO planetasDAO = new PlanetasDAO();
            ArrayList<PlanetasModel> planetas =null;
            
            int planetaid =((PlanetasModel)this.panelcontrol.getListaplanetas().getSelectedItem()).getIdPlanetas();
            if(planetaid==-1){
                planetas=planetasDAO.TodosPlanetas();
                planetas.add(0,new PlanetasModel("Todos los Planetas",-1,-1,false));   
            } else{
                planetas=planetasDAO.UnPlaneta(planetaid);
                planetas.add(0,new PlanetasModel("Todos los Planetas",-1,-1,false));
                
                
            }
                
            
            this.panelcontrol.setListaplanetas(planetas);
                
            }
            
        }
}
    

