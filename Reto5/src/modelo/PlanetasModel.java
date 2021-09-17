/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Esteban
 */
public class PlanetasModel {
    
    private int IdPlanetas;
    private String NombrePlanetas;
    private int PoblacionPlanetas;
    private double NivelOxigeno;
    private boolean HabitabilidadPlaneta;
    
    public PlanetasModel (String NombrePlanetas, int PoblacionPlanetas, double NivelOxigeno, boolean HabitabilidadPlaneta){
        this.NombrePlanetas=NombrePlanetas;
        this.PoblacionPlanetas=PoblacionPlanetas;
        this.NivelOxigeno=NivelOxigeno;
        this.HabitabilidadPlaneta=HabitabilidadPlaneta;
        
        
    }
    public PlanetasModel (int IdPlanetas,String NombrePlanetas, int PoblacionPlanetas, double NivelOxigeno, boolean HabitabilidadPlaneta){
        this.NombrePlanetas=NombrePlanetas;
        this.PoblacionPlanetas=PoblacionPlanetas;
        this.NivelOxigeno=NivelOxigeno;
        this.HabitabilidadPlaneta=HabitabilidadPlaneta;
    }
    /**
     * @return the IdPlanetas
     */
    public int getIdPlanetas() {
        return IdPlanetas;
    }

    /**
     * @return the NombrePlanetas
     */
    public String getNombrePlanetas() {
        return NombrePlanetas;
    }

    /**
     * @return the PoblacionPlanetas
     */
    public int getPoblacionPlanetas() {
        return PoblacionPlanetas;
    }

    /**
     * @return the NivelOxigeno
     */
    public double getNivelOxigeno() {
        return NivelOxigeno;
    }

    /**
     * @return the HabitabilidadPlaneta
     */
    public boolean isHabitabilidadPlaneta() {
        return HabitabilidadPlaneta;
    }
    
    @Override
    public String toString(){
        return this.NombrePlanetas;
       
    }
    
}
