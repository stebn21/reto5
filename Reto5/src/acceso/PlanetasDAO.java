
package acceso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import modelo.PlanetasModel;
import utils.ConnectionDB;

public class PlanetasDAO {
    private Connection conect=null;
    
    public ArrayList<PlanetasModel>TodosPlanetas(){
         ArrayList<PlanetasModel>planeta= new ArrayList();
         try{
             if(conect == null)
                conect = ConnectionDB.getConnection();
             String base = "SELECT id_planeta, nombres, poblacion, nivel_oxigeno, habitabilidad FROM planetas;";
             Statement statement = conect.createStatement();
             ResultSet resultado = statement.executeQuery(base);
             
             while(resultado.next()){
                 PlanetasModel planetas = new PlanetasModel(resultado.getInt(1),resultado.getString(2),
                                                            resultado.getInt(3), resultado.getDouble(4),
                                                            resultado.getBoolean(5));
                 planeta.add(planetas);                                                   
             }
         }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
         }
         return planeta;
    }
         

     public ArrayList <PlanetasModel> UnPlaneta (int CodigoPlan){
        ArrayList<PlanetasModel> planeta = new ArrayList();
        try {
            if(conect == null)
                conect = ConnectionDB.getConnection();
            String base = "SELECT nombre, poblacion, nivel_oxigeno, habitabilidad FROM planetas WHERE id_planeta=?;";
            PreparedStatement statement = conect.prepareStatement(base);
            statement.setInt(1,CodigoPlan);
            ResultSet result = statement.executeQuery(base);
            
            while (result.next()){
                PlanetasModel planetas = new PlanetasModel (result.getString(1), result.getInt(2),result.getDouble(3),result.getBoolean(4));
                planeta.add(planetas);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    return planeta;
    }
     
     
       public void InsertarPlaneta(PlanetasModel Planeta){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "INSERT INTO planetas(nombres, poblacion, nivel_oxigeno, habitabilidad) "
                    + "     VALUES (?, ?, ?, ?);";
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setString(1,Planeta.getNombrePlanetas());
            statement.setInt(2,Planeta.getPoblacionPlanetas());
            statement.setDouble(3,Planeta.getNivelOxigeno());
            statement.setBoolean(4,Planeta.isHabitabilidadPlaneta());
          
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
     public void ActualizarPlaneta(PlanetasModel Planeta){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "UPDATE planetas SET nombres, poblacion, nivel_oxigeno, habitabilidad WHERE id_planeta=?";
                   
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setString(1,Planeta.getNombrePlanetas());
            statement.setInt(2,Planeta.getPoblacionPlanetas());
            statement.setDouble(3,Planeta.getNivelOxigeno());
            statement.setBoolean(4,Planeta.isHabitabilidadPlaneta());
          
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
     public void BorrarPlaneta(int CodigoPlan){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "DELETE FROM planetas WHERE id_planeta=?";
                   
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setInt(CodigoPlan,1);
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
}

