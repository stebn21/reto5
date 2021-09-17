
package vista;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import acceso.ComandanteDAO;
import controlador.Eventocambio;
import controlador.DatosIniciales;
import modelo.ComandanteModel;
import modelo.ExpedicionModel;
import modelo.PlanetasModel;

public class EliminarComandante extends JFrame implements ActionListener {
     private JLabel codigo;
     private JComboBox<ComandanteModel> idcodigo;
     private JButton boton;
     
     
    public EliminarComandante(){
        initComponents();
    }
    public void initComponents(){
        setTitle("Bitcora-EliminarComandante");
        setLayout(new GridLayout(8,2));
        DatosIniciales datos = new DatosIniciales();
        
        this.codigo=new JLabel("¿Que id desea eliminar?");
        add(this.codigo);
        
        this.idcodigo=new JComboBox();
        this.idcodigo.setModel(new DefaultComboBoxModel<>(datos.getComandante().toArray(new ComandanteModel[datos.getComandante().size()])));
        this.idcodigo.setSelectedIndex(0);
        add(this.idcodigo);
        
        this.boton = new JButton("Eliminar");
        add(this.boton);
        this.boton.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent actionevent) {
        if(actionevent.getSource()==this.boton){
            int id =((ComandanteModel)this.idcodigo.getSelectedItem()).getCodigoCom();
            ComandanteDAO com = new ComandanteDAO();
            com.BorrarComandante(id);
            
            
            
            
        }
    }
}
      
    
    

