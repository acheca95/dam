
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.util.Map;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class ejecutable {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejecutable window = new ejecutable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ejecutable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textField.getText();

				String reportSource = "./datos/agenda.jrxml";
				String reportHTML = "./datos/Informe.html";
				String reportPDF = "./datos/Informe.pdf";
				String reportXML = "./datos/Informe.xml";

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("titulo", " agenda.");
				params.put("autor", "antonio");
				params.put("fecha", (new java.util.Date()).toString());
				params.put("ciudad", texto);
				try {
					JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root",
							"");
					JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, conn);
					File path = new File("./datos/Informe.pdf");
					Desktop.getDesktop().open(path);
					//JasperViewer.viewReport(MiInforme);

					JasperExportManager.exportReportToHtmlFile(MiInforme, reportHTML);

					JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);

					JasperExportManager.exportReportToXmlFile(MiInforme, reportXML, false);

				} catch (CommunicationsException c) {
					System.out.println(" Error de comunicación con la BD. No está arrancada.");
				} catch (ClassNotFoundException c) {
					System.out.println(" Error driver. ");
				} catch (SQLException a) {
					System.out.println(" Error al ejecutar sentencia SQL ");
				} catch (JRException ex) {
					System.out.println(" Error Jasper.");
					ex.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(52, 67, 97, 25);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(55, 127, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ciudad");
		lblNewLabel.setBounds(55, 105, 56, 16);
		frame.getContentPane().add(lblNewLabel);
	}
}
