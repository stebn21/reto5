
package vista;
    import controlador.DatosIniciales;
    import controlador.eventoclick;
    import controlador.Eventocambio;

    import java.awt.GridLayout;
    import java.util.ArrayList;
    import javax.swing.DefaultComboBoxModel;
    import javax.swing.JButton;
    import javax.swing.JComboBox;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JTable;
    import javax.swing.JTextField;
    import javax.swing.table.DefaultTableModel;
    
    import modelo.ComandanteModel;
    import modelo.ExpedicionModel;
    import modelo.PlanetasModel;
 


public class PanelControl extends JPanel {
    
    
    private JLabel ComCodigo;
    private JLabel Planeta;
    private JLabel Habitabilidad;
    private JComboBox<ExpedicionModel> listaExp;
    private JComboBox <PlanetasModel> listaplanetas;
    private JComboBox <PlanetasModel> habitabilidad;
    private JLabel nombreexp;
    private JTextField txtexp;
    private JButton buscar;
    private JTable resultadosT;
    private JButton botoncom;
    private JButton BotonEli;
    
    public PanelControl (PanelResultados resultados){
        this.resultadosT=resultados.getresultados();
        initComponents();
    }
    
    
    private void initComponents(){
        setLayout(new GridLayout(2,1));
        DatosIniciales datos = new DatosIniciales();
        this.setResultados(datos.getExpedicion());
        
        this.ComCodigo=new JLabel("Expediciones");
        add(this.getComCodigo());
        
        this.listaExp=new JComboBox();
        this.listaExp.setModel(new DefaultComboBoxModel<>(datos.getExpedicion().toArray(new ExpedicionModel[datos.getExpedicion().size()] )));
        this.listaExp.setSelectedIndex(0);
        add(this.getListaexp());
        
        Eventocambio Ecambio= new Eventocambio(this);
        this.getListaexp().addActionListener(Ecambio);
        //change event 
        /*
        this.Habitabilidad=new JLabel("Habitabilidad");
        add(this.getHabitabilidad());
        
        this.habitabilidad= new JComboBox();
        this.sethabitabilidad(datos.getPlanetas());
        add(this.gethabitabilidad());
        */
        this.Planeta=new JLabel("Planetas");
        add(this.getPlaneta());
        
        this.listaplanetas=new JComboBox();
        this.setListaplanetas(datos.getPlanetas());
        add(this.getListaplanetas());
        
        
        this.nombreexp=new JLabel("Nombre de la Expedicion");
        add(this.getNombreexp());
        this.txtexp=new JTextField();
        add(this.getTxtexp());
        
        
        this.buscar = new JButton("Buscar");
        add(this.buscar);
        
        
        eventoclick evento = new eventoclick(this);
        this.buscar.addActionListener(evento);
        
        this.botoncom = new JButton("Agregar Comandante");
        add(this.botoncom);
        this.getBotoncom().addActionListener(evento);
        
        this.BotonEli = new JButton("Eliminar Comandante");
        add(this.BotonEli);
        this.getBotonEli().addActionListener(evento);
            
 
        
        
        
    }

    /**
     * @return the ComCodigo
     */
    public JLabel getComCodigo() {
        return ComCodigo;
    }

    /**
     * @return the Planeta
     */
    public JLabel getPlaneta() {
        return Planeta;
    }

    /**
     * @return the Habitabilidad
     */
    public JLabel getHabitabilidad() {
        return Habitabilidad;
    }

  

    /**
     * @return the listaplanetas
     */
    public JComboBox <PlanetasModel> getListaplanetas() {
        return listaplanetas;
    }
/*
    
    public JComboBox <PlanetasModel> gethabitabilidad() {
        return habitabilidad;
    }
*/
    /**
     * @return the nombreexp
     */
    public JLabel getNombreexp() {
        return nombreexp;
    }

    /**
     * @return the txtexp
     */
    public JTextField getTxtexp() {
        return txtexp;
    }

    /**
     * @return the buscar
     */
    public JButton getBuscar() {
        return buscar;
    }

    /**
     * @return the resultados
     */
    public JTable getResultados() {
        return resultadosT;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(ArrayList<ExpedicionModel> expediciones) {
        String[] encabezado={"ID", "Nombre","Nombre Planeta", "Nombre Comandante", "Apellido Comandante","Combustible", "Millas", "Habitabilidad"};
        this.resultadosT.removeAll();
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.setColumnIdentifiers(encabezado);
        this.resultadosT.setModel(modelo);
        for(int i=0; i<expediciones.size(); i++){
            modelo.addRow((Object[]) expediciones.get(i).toArray());
                }
        
    }

    /**
     * @param listaplanetas the listaplanetas to set
     */
    public void setListaplanetas(ArrayList<PlanetasModel> planetas) {
        this.listaplanetas.setModel(new DefaultComboBoxModel<>(planetas.toArray(new PlanetasModel[planetas.size()])));
        this.getListaplanetas().setSelectedIndex(0);
    }
    
    /*
    
    public void sethabitabilidad(ArrayList<PlanetasModel> habitabilidad) {
        this.listaplanetas.setModel((new DefaultComboBoxModel<>(habitabilidad.toArray(new PlanetasModel[habitabilidad.size()]))));
        this.gethabitabilidad();
    }
*/
    /**
     * @return the listaComandante
     */
    public JComboBox<ExpedicionModel> getListaexp() {
        return listaExp;
    }

    /**
     * @return the botoncom
     */
    public JButton getBotoncom() {
        return botoncom;
    }
    
     /**
     * @return the botoncom
     */
    public JButton getBotonEli() {
        return BotonEli;
    }
    
   
  
    
}
