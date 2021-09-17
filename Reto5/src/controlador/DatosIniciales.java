
package controlador;

import java.util.ArrayList;
import modelo.ComandanteModel;
import modelo.ExpedicionModel;
import modelo.PlanetasModel;
import modelo.VisitaModel;

import acceso.ComandanteDAO;
import acceso.ExpedicionDAO;
import acceso.PlanetasDAO;



public class DatosIniciales {
    
    private ArrayList<ExpedicionModel> expedicion=null;
    private ArrayList<PlanetasModel> planetas=null;
    private ArrayList<ComandanteModel> comandante=null;
    
    public DatosIniciales(){
        ComandanteDAO comandanteDAO = new ComandanteDAO();
        this.comandante=comandanteDAO.TodosComandantes();
        this.comandante.add(0,new ComandanteModel(-1,"Todos los Comandantes",null,-1,null,null));
       
        ExpedicionDAO expedicionDAO = new ExpedicionDAO();
        this.expedicion=expedicionDAO.TodasExpedicones();
        this.expedicion.add(0,new ExpedicionModel(-1, "Todas las Expediciones", null,null,null,-1, -1,null));
                        
        PlanetasDAO planetasDAO= new PlanetasDAO();
        this.planetas=planetasDAO.TodosPlanetas();
        this.planetas.add(0,new PlanetasModel("Todos los Planetas",-1,-1,true));
       
    }

  
    /**
     * @return the expedicion
     */
    public ArrayList<ExpedicionModel> getExpedicion() {
        return expedicion;
    }

    /**
     * @return the planetas
     */
    public ArrayList<PlanetasModel> getPlanetas() {
        return planetas;
    }
 /**
     * @return the expedicion
     */
    public ArrayList<ComandanteModel> getComandante() {
        return comandante;
    }
    
    
    
}
