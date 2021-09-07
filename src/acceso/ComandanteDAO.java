
 
package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import modelo.ComandanteModel;
import utils.ConnectionDB;


public class ComandanteDAO {
    private Connection conect=null;
    
    public ArrayList<ComandanteModel>TodosComandantes(){
         ArrayList<ComandanteModel>comandante= new ArrayList();
         try{
             if(conect == null)
                conect = ConnectionDB.getConnection();
             String base = "SELECT codigo, nombr, apellidos, anios, escuela, fecha FROM comandante;";
             Statement statement = conect.createStatement();
             ResultSet resultado = statement.executeQuery(base);
             
             while(resultado.next()){
                 ComandanteModel comandantes = new ComandanteModel(resultado.getInt(1), resultado.getString(2),
                                                                   resultado.getString(3), resultado.getInt(4),
                                                                   resultado.getString(5), resultado.getString(6));
                 comandante.add(comandantes);                                                   
             }
         }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
         }
         return comandante;
}
    public ComandanteModel UnComandante (int CodigoCom){
        ComandanteModel comandante = null;
        try {
            if(conect == null)
                conect = ConnectionDB.getConnection();
            String base = "SELECT nombr, apellidos, anios, escuela, fecha FROM comandante WHERE nombr=?;";
            PreparedStatement statement = conect.prepareStatement(base);
            statement.setInt(1,CodigoCom);
            ResultSet result = statement.executeQuery(base);
            
            while (result.next()){
                comandante = new ComandanteModel(CodigoCom, result.getString(1), result.getString(2),result.getInt(3),result.getString(4), result.getString(5) );
                break;
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    return comandante;
    }
    
    
    public void InsertarComandante(ComandanteModel comandante){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "INSERT INTO comandante(codigo, nombr, apellidos, anios, escuela, fecha) "
                    + "     VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setInt(1, comandante.getCodigoCom());
            statement.setString(2,comandante.getNombreCom());
            statement.setString(3,comandante.getApellidosCom());
            statement.setInt(4,comandante.getAniosCom());
            statement.setString(5,comandante.getEscuelaCom());
            statement.setString(6, comandante.getFechaCom());
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void ActualizarComandante(ComandanteModel comandante){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "UPDATE comandante SET nombr=?, apellidos=?, anios=?, escuela=?, fecha=? WHERE codigo=?;";   
            
                     
            PreparedStatement statement=conect.prepareStatement(base);
  
            statement.setString(1,comandante.getNombreCom());
            statement.setString(2,comandante.getApellidosCom());
            statement.setInt(3,comandante.getAniosCom());
            statement.setString(4,comandante.getEscuelaCom());
            statement.setString(5, comandante.getFechaCom());
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public void BorrarComandante(int CodigoCom){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "DELETE FROM comandante WHERE codigo=?;";  
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setInt(CodigoCom, 1);
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    
    
    
    
    
    
}

    
    
    
    

