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
public class ComandanteModel {
    
    
    private int CodigoCom;
    private String NombreCom;
    private String ApellidosCom;
    private int AniosCom;
    private String EscuelaCom;
    private String FechaCom;
    
    public ComandanteModel(int CodigoCom, String NombreCom, String ApellidosCom, int AniosCom, String EscuelaCom, String FechaCom){
        this.CodigoCom= CodigoCom;
        this.NombreCom=NombreCom;
        this.ApellidosCom=ApellidosCom;
        this.AniosCom=AniosCom;
        this.EscuelaCom=EscuelaCom;
        this.FechaCom=FechaCom;
        
    }

    /**
     * @return the CodigoCom
     */
    public int getCodigoCom() {
        return CodigoCom;
    }

    /**
     * @return the NombreCom
     */
    public String getNombreCom() {
        return NombreCom;
    }

    /**
     * @return the ApellidosCom
     */
    public String getApellidosCom() {
        return ApellidosCom;
    }

    /**
     * @return the AniosCom
     */
    public int getAniosCom() {
        return AniosCom;
    }

    /**
     * @return the EscuelaCom
     */
    public String getEscuelaCom() {
        return EscuelaCom;
    }

    /**
     * @return the FechaCom
     */
    public String getFechaCom() {
        return FechaCom;
    }

    
        
    }
    
    

