/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.nio.charset.CodingErrorAction;

/**
 *
 * @author Esteban
 */
public class ExpedicionModel {
    private int CodigoExp;
    private String NombreExp;
    private double MillasExp;
    private int CombustibleExp;
    private int IdComanFk;
    private String NombrePlaneta;
    private String NombreCom;
    private String ApellidosCom;
    private String HoraFechaVisita;
    
    
    public ExpedicionModel(int CodigoExp, String NombreExp, double MillasExp, int CombustibleExp, int IdComanFk){
        this.CodigoExp=CodigoExp;
        this.NombreCom=NombreExp;
        this.MillasExp=MillasExp;
        this.CombustibleExp=CombustibleExp;
        this.IdComanFk=IdComanFk;
    }
    
    public ExpedicionModel(int CodigoExp, String NombreExp, String NombrePlaneta, String NombreCom, String ApellidoCom,
                           int CombustibleExp, double MillasExp, String HoraFecha ){
        
        this.CodigoExp=CodigoExp;
        this.NombreExp=NombreExp;
        this.NombrePlaneta=NombrePlaneta;
        this.NombreCom=NombreCom;
        this.ApellidosCom=ApellidoCom;
        this.CombustibleExp=CombustibleExp;
        this.MillasExp=MillasExp;
        this.HoraFechaVisita=HoraFecha;
        
    }

    /**
     * @return the CodigoExp
     */
    public int getCodigoExp() {
        return CodigoExp;
    }

    /**
     * @return the NombreExp
     */
    public String getNombreExp() {
        return NombreExp;
    }

    /**
     * @return the MillasExp
     */
    public double getMillasExp() {
        return MillasExp;
    }

    /**
     * @return the CombustibleExp
     */
    public int getCombustibleExp() {
        return CombustibleExp;
    }

    /**
     * @return the IdComanFk
     */
    public int getIdComanFk() {
        return IdComanFk;
    }

    /**
     * @return the NombrePlaneta
     */
    public String getNombrePlaneta() {
        return NombrePlaneta;
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
    

    @Override
    public String toString(){
        return this.NombreExp;
    }
    
    public Object toArray(){
        Object[] Lista = {CodigoExp, NombreExp, NombrePlaneta, NombreCom, ApellidosCom, CombustibleExp, MillasExp, HoraFechaVisita };
        return Lista;
    }
    
}
