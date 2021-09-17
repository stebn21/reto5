/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import modelo.VisitaModel;
import utils.ConnectionDB;

public class VisitaDAO {
  
    private Connection conect=null;
    
    public ArrayList<VisitaModel>TodosVisitas(){
         ArrayList<VisitaModel>visita= new ArrayList();
         try{
             if(conect == null)
                conect = ConnectionDB.getConnection();
             String base = "SELECT fecha_hora, id_plantea_fk, id_expediciones_fk FROM visita;";
             Statement statement = conect.createStatement();
             ResultSet resultado = statement.executeQuery(base);

              while(resultado.next()){
                 VisitaModel visitas = new VisitaModel(resultado.getString(1),
                                                      resultado.getInt(2), resultado.getInt(3));
                 visita.add(visitas);                                                 
             }
         }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
}
        return visita;
        
    
}
     public VisitaModel UnPlaneta (int CodigoVisita){
            VisitaModel visita = null;
        try {
            if(conect == null)
                conect = ConnectionDB.getConnection();
            String base = "SELECT fecha_hora, id_plantea_fk, id_expediciones_fk FROM visita WHERE id_visita=?;";
            PreparedStatement statement = conect.prepareStatement(base);
            statement.setInt(1,CodigoVisita);
            ResultSet result = statement.executeQuery(base);
            
            while (result.next()){
                visita = new VisitaModel (result.getString(1),result.getInt(2), result.getInt(3));                                    
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    return visita;
    }
      public void Insertarvisita(VisitaModel visita){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "INSERT INTO visita(fecha_hora, id_planetaa_fk, id_expediciones_fk) "
                    + "     VALUES (?, ?, ?);";
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setString(1,visita.getFechaHoraVisita());
            statement.setInt(2,visita.getIdPlanetaFk());
            statement.setDouble(3,visita.getIdExpedicionesFk());
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
      
      public void ActualizarVisita (VisitaModel visita){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "UPDATE visita SET fecha_hora, id_planetaa_fk, id_expediciones_fk WHERE id_visita=?; ";  
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setString(1,visita.getFechaHoraVisita());
            statement.setInt(2,visita.getIdPlanetaFk());
            statement.setDouble(3,visita.getIdExpedicionesFk());
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
        public void EliminarVisita (int CodigoVisita){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "DELETE visita WHERE id_visita=?; ";  
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setInt(CodigoVisita,1);
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        
        
    }
    
     
     
}
    