package mateuszmidor.com;

/* Klasa odpowiedzialna za stworzenie interfejsu u¿ytkownika okna Edytor Uzytkownika 
 * oraz udostêpnienie eventów typu cancelBtnClickedEvent dla klasy dziedzicz¹cej */

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserEditorWindowGui extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="136,10"
	protected JLabel jLabel = null;
	protected JTextField jtfFName = null;
	protected JLabel jLabel1 = null;
	protected JTextField jtfLName = null;
	protected JLabel jLabel2 = null;
	protected JTextField jtfAddress = null;
	protected JLabel jLabel3 = null;
	protected JTextField jtfNickName = null;
	protected JLabel jLabel4 = null;
	protected JButton jbtnOK = null;
	protected JButton jbtnCancel = null;
	protected JLabel jLabel5 = null;
	protected JPasswordField jtfPassword1 = null;  //  @jve:decl-index=0:
	protected JPasswordField jtfPassword2 = null;

	public UserEditorWindowGui() {
		super((Frame)null, true);
		initialize();
	}

	// buduje i konfiguruje interfejs uzytkownika
	private void initialize() {
		this.setSize(240, 400);
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setTitle("Edytor u¿ytkownika");
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(10, 280, 188, 16));
			jLabel5.setText("Powtórz has³o");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(10, 227, 194, 16));
			jLabel4.setText("Has³o");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(10, 174, 188, 16));
			jLabel3.setText("Nazwa u¿ytkownika");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(10, 121, 137, 16));
			jLabel2.setText("Adres");
			jLabel2.setEnabled(true);
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(10, 68, 141, 16));
			jLabel1.setText("Nazwisko");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(10, 15, 38, 16));
			jLabel.setText("Imiê");
			jLabel.setToolTipText("Imiê");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new Dimension(226, 330));
			jContentPane.add(jLabel, null);
			jContentPane.add(getTf_fname(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getTf_lname(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getTf_address(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getTf_nickname(), null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getBtn_ok(), null);
			jContentPane.add(getBtn_cancel(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJPasswordField(), null);
			jContentPane.add(getJPasswordField1(), null);
		}
		return jContentPane;
	}

	private JTextField getTf_fname() {
		if (jtfFName == null) {
			jtfFName = new JTextField();
			jtfFName.setBounds(new Rectangle(30, 33, 181, 20));
		}
		return jtfFName;
	}

	private JTextField getTf_lname() {
		if (jtfLName == null) {
			jtfLName = new JTextField();
			jtfLName.setBounds(new Rectangle(30, 86, 181, 20));
		}
		return jtfLName;
	}

	private JTextField getTf_address() {
		if (jtfAddress == null) {
			jtfAddress = new JTextField();
			jtfAddress.setBounds(new Rectangle(30, 139, 181, 20));
		}
		return jtfAddress;
	}

	private JTextField getTf_nickname() {
		if (jtfNickName == null) {
			jtfNickName = new JTextField();
			jtfNickName.setBounds(new Rectangle(30, 192, 181, 20));
		}
		return jtfNickName;
	}

	private JButton getBtn_ok() {
		if (jbtnOK == null) {
			jbtnOK = new JButton();
			jbtnOK.setBounds(new Rectangle(30, 340, 79, 21));
			jbtnOK.setText("OK");
			jbtnOK.addMouseListener(new java.awt.event.MouseAdapter() {			
				public void mouseClicked(java.awt.event.MouseEvent e) {
					okBtnClickedEvent();				
				}
			});
		}
		return jbtnOK;
	}
	
	// event, do zaimplementowania przez klase dziedzicz¹c¹
	public void okBtnClickedEvent() {}

	private JButton getBtn_cancel() {
		if (jbtnCancel == null) {
			jbtnCancel = new JButton();
			jbtnCancel.setBounds(new Rectangle(126, 340, 84, 21));
			jbtnCancel.setText("Anuluj");
			jbtnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					cancelBtnClickedEvent();
				}
			});
		}
		return jbtnCancel;
	}

	// event, do zaimplementowania przez klase dziedzicz¹c¹
	public void cancelBtnClickedEvent() {}
	
	private JPasswordField getJPasswordField() {
		if (jtfPassword1 == null) {
			jtfPassword1 = new JPasswordField();
			jtfPassword1.setBounds(new Rectangle(30, 245, 181, 20));
			jtfPassword1.setText("");
		}
		return jtfPassword1;
	}

	private JPasswordField getJPasswordField1() {
		if (jtfPassword2 == null) {
			jtfPassword2 = new JPasswordField();
			jtfPassword2.setBounds(new Rectangle(30, 298, 180, 20));
		}
		return jtfPassword2;
	}

}  //  @jve:decl-index=0:visual-constraint="170,41"
