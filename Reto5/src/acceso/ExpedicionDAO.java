
package acceso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import modelo.ExpedicionModel;
import utils.ConnectionDB;

public class ExpedicionDAO {
    
    private Connection conect=null;
    public ArrayList<ExpedicionModel>TodasExpedicones2(){
         ArrayList<ExpedicionModel>expedicion= new ArrayList();
         try{
             if(conect == null)
                conect = ConnectionDB.getConnection();
             String base = "SELECT codigo, nombre, millas,combustible, id_comandante_fk FROM expediciones;";
             Statement statement = conect.createStatement();
             ResultSet resultado = statement.executeQuery(base);
             
             while(resultado.next()){
                 ExpedicionModel expediciones = new ExpedicionModel(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4),resultado.getInt(5));
                 expedicion.add(expediciones);                                                   
             }
         }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código1 : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
         }
         return expedicion;
    }
    
    public ArrayList<ExpedicionModel>TodasExpedicones(){
         ArrayList<ExpedicionModel>expedicion= new ArrayList();
         try{
             if(conect == null)
                conect = ConnectionDB.getConnection();
             String base = "SELECT expediciones.codigo AS Codigo_Exp, expediciones.nombre AS Nombre_Exp, \n" +
                            "planetas.nombres AS Nombre_Plan, comandante.nombr AS Nombre_Coman, comandante.apellidos AS Apellidos_com,\n" +
                            "expediciones.combustible AS Combustible_Utilizado,expediciones.millas AS Millas_Recorridas,\n" +
                            "planetas.habitabilidad AS Habitabilidad\n" +
                            "FROM visita\n" +
                            "JOIN expediciones on visita.id_expediciones_fk=expediciones.codigo\n" +
                            "JOIN planetas on visita.id_planeta_fk = planetas.id_planeta\n" +
                            "JOIN comandante on expediciones.id_comandante_fk= comandante.codigo\n" +
                            "ORDER BY expediciones.nombre;";
             Statement statement = conect.createStatement();
             ResultSet resultado = statement.executeQuery(base);
             
             while(resultado.next()){
                 ExpedicionModel expediciones = new ExpedicionModel(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getInt(6),resultado.getDouble(7),resultado.getString(8));
                 expedicion.add(expediciones);                                                   
             }
         }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código1 : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
         }
         return expedicion;
    
    
    }
    public ArrayList<ExpedicionModel>FiltroExpediciones(int idexp, int idPlaneta, String ExpNombre){
        ArrayList<ExpedicionModel> expedicion = new ArrayList();
        int casos = -1;
        try{
            if(conect == null)
                conect = ConnectionDB.getConnection();
            String base = "SELECT expediciones.codigo AS Codigo_Exp, expediciones.nombre AS Nombre_Exp, \n" +
                            "planetas.nombres AS Nombre_Plan, comandante.nombr AS Nombre_Coman, comandante.apellidos AS Apellidos_com,\n" +
                            "expediciones.combustible AS Combustible_Utilizado,expediciones.millas AS Millas_Recorridas,\n" +
                            " planetas.habitabilidad AS Habitabilidad\n" +
                            "FROM visita\n" +
                            "JOIN expediciones on visita.id_expediciones_fk=expediciones.codigo\n" +
                            "JOIN planetas on visita.id_planeta_fk = planetas.id_planeta\n" +
                            "JOIN comandante on expediciones.id_comandante_fk= comandante.codigo\n" +
                            "WHERE expediciones.nombre LIKE ?";
                            
            if(idexp !=-1){
                if(idPlaneta !=-1){
                    base+="AND expediciones.codigo=?;";
                    casos=1;
                }
                else{
                    base+="AND planetas.id_planeta=?;";
                    casos=2;
                }
            }
            
            
            System.out.println(casos);
            PreparedStatement statement = conect.prepareStatement(base);
            System.out.println(base);
            statement.setString(1, "%"+ExpNombre+"%");
            switch(casos){
                case 1:     statement.setInt(2, idexp);        break;
                case 2:     statement.setInt(2, idPlaneta);       break;
                //case 3:     statement.setBoolean(2, habitabilidad);   break;
            }
            System.out.println(statement.toString());
            ResultSet result=statement.executeQuery();
            while(result.next()){
                ExpedicionModel expediciones= new ExpedicionModel(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getInt(6),result.getDouble(7),result.getString(8));
                expedicion.add(expediciones);               
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código21 : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return expedicion;
    
      }
    public void InsertarExpedicion(ExpedicionModel expedicion){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "INSERT INTO expediciones(codigo, nombre, millas, combustible, id_comandante_fk) "
                    + "     VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setInt(1,expedicion.getCodigoExp() );
            statement.setString(2,expedicion.getNombreExp());
            statement.setDouble(3,expedicion.getMillasExp());
            statement.setInt(4,expedicion.getCombustibleExp());
            statement.setInt(5,expedicion.getIdComanFk());
            
            
            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código3 : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    public void ActualizarExpedicion(ExpedicionModel expedicion){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "UPDATE expediciones SET nombre=?, millas=?, combustible=? WHERE codigo=?; ";
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setString(1,expedicion.getNombreExp());
            statement.setDouble(2,expedicion.getMillasExp());
            statement.setInt(3,expedicion.getCombustibleExp());

            int rowsInserted = statement.executeUpdate();
             if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizadp exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código4 : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
     public void EliminarExpedicion(int CodigoExp){
        try{
            if(conect == null)
                conect= ConnectionDB.getConnection();
            
            String base = "DELETE expediciones WHERE codigo=?; ";
            PreparedStatement statement=conect.prepareStatement(base);
            statement.setInt(1,CodigoExp);

            int rowsDeleted = statement.executeUpdate();
             if(rowsDeleted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código5 : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    
    
}
    
    
