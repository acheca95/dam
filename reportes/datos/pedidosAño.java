package ejercicio1_di;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

public class pedidosAño{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pedidosAño informe = new pedidosAño();
        int año=1998;
        informe.ejecutar(año);
	}
        public static Connection conexion = null;
        String baseDatos = "jdbc:hsqldb:hsql://localhost";
        String usuario = "sa";
        String clave = "";
        
   //Constructor que conecta a la base de datos de prueba
    public pedidosAño()
    {
        try{
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            conexion = DriverManager.getConnection(baseDatos,usuario,clave);
        }

        catch (ClassNotFoundException cnfe){
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        }

        catch (SQLException sqle){
            System.err.println("No se pudo conectar a BD");
            System.exit(1);
        }

        catch (java.lang.InstantiationException sqlex){
            System.err.println("Imposible Conectar");
            System.exit(1);
        }

        catch (Exception ex){
            System.err.println("Imposible Conectar");
            System.exit(1);
        }

    }

    //El método ejecutar recibe el parametro del informe
    public void ejecutar(int año) 
    {
    	
        //Ruta del informe respecto del proyecto NetBeans
        String archivojasper="C:\\Users\\antonio\\eclipse-workspace\\ejercicio1_di\\src\\informes\\anio.jasper";

        try
        {
            //Cargamos los parametros del informe en una tabla Hash
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("año",año);
            
            //Generamos el informe en memoria
            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);

            // Exporta el informe a PDF  
            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\antonio\\eclipse-workspace\\ejercicio1_di\\src\\informes\\informe.pdf");

            //Abre el archivo PDF generado
            File path = new File ("informes/informe.pdf");
            Desktop.getDesktop().open(path);
            
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.WARNING_MESSAGE);
        }

    }

}

