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
public class VisitaModel {
    private int IdVisita;
    private String FechaHoraVisita;
    private int IdPlanetaFk;
    private int IdExpedicionesFk;
    
    public VisitaModel(String FechaHoraVisita, int IdPlanteaFk, int IdExpedicionesFk ){
        this.FechaHoraVisita= FechaHoraVisita;
        this.IdPlanetaFk=IdPlanteaFk;
        this.IdExpedicionesFk=IdExpedicionesFk;
        
    }

    /**
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @return the FechaHoraVisita
     */
    public String getFechaHoraVisita() {
        return FechaHoraVisita;
    }

    /**
     * @return the IdPlanetaFk
     */
    public int getIdPlanetaFk() {
        return IdPlanetaFk;
    }

    /**
     * @return the IdExpedicionesFk
     */
    public int getIdExpedicionesFk() {
        return IdExpedicionesFk;
    }
}
