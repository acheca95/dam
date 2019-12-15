package ejercicio1_di;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.commons.digester.Digester;
@SuppressWarnings("unused")
public class agenda {
	public static void main(String[] args) throws InstantiationException, JRException {
		// TODO Auto-generated method stub
		agenda informe = new agenda();
        String ciudad="GRANADA";
        informe.ejecutar(ciudad);
	}
        public static Connection conexion = null;
        String baseDatos = "jdbc:mysql://localhost/agenda";
        String usuario = "root";
        String clave = "";
        
   //Constructor que conecta a la base de datos de prueba
    public agenda() 
    {
        try{
        	
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "");
        }

        catch (ClassNotFoundException cnfe){
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        }

        catch (SQLException sqle){
            System.err.println("No se pudo conectar a BD");
            System.exit(1);
        }

        catch (Exception ex){
            System.err.println("Imposible Conectar");
            System.exit(1);
        }

    }

    //El método ejecutar recibe el parametro del informe
    public void ejecutar(String ciudad) 
    {
    	
        //Ruta del informe respecto del proyecto NetBeans
        String archivojasper="C:\\Users\\antonio\\eclipse-workspace\\ejercicio1_di\\src\\ejercicio1_di\\agenda.jasper";
    	
    	
        try
        {
            //Cargamos los parametros del informe en una tabla Hash
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("ciudad",ciudad);
            
            //Generamos el informe en memoria
            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);

            // Exporta el informe a PDF  
            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\antonio\\eclipse-workspace\\ejercicio1_di\\src\\ejercicio1_di\\informe.pdf");

            //Abre el archivo PDF generado
            File path = new File ("C:\\Users\\antonio\\eclipse-workspace\\ejercicio1_di\\src\\ejercicio1_di\\informe.pdf");
            Desktop.getDesktop().open(path);
            
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.WARNING_MESSAGE);
        }

    }
}
