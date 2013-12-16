package mateuszmidor.com;

/* Klasa odpowiedzialna za stworzenie interfejsu u¿ytkownika okna g³ównego aplikacji
 * oraz udostêpnienie eventów typu assUserMenuClickedEvent dla klasy dziedzicz¹cej */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class MainWindowGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jmFile = null;
	private JMenuItem jmiConnectToDatabase = null;
	private JMenu jmEdit = null;
	private JMenuItem jmiAddUser = null;
	private JMenuItem jmiEditUser = null;
	private JMenuItem jmiDeleteUser = null;
	private JMenu jMenu1 = null;
	private JMenuItem jmiAboutBox = null;
	private JScrollPane jScrollPane = null;
	private ReadonlyJTable jtUserTable = null;
	private JMenuItem miExit = null;
	
	
	public MainWindowGui() {
		super();
		initialize();

	}

	// buduje i konfiguruje interfejs uzytkownika
	private void initialize() {
		this.setSize(600, 400);	
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Baza u¿ytkowników");
		this.setLocationRelativeTo(null);
		
		setupUserTableColumns();
	}	
	
	// tworzy kolumny w tabelce wyœwietlaj¹cej u¿ytkowników
	private void setupUserTableColumns()
	{
		DefaultTableModel model = getTableModel();
		model.addColumn("id");
		model.addColumn("Imiê");
		model.addColumn("Nazwisko");
		model.addColumn("Adres");
		model.addColumn("Nazwa");
		model.addColumn("Has³o");
	}	
	
	// w³¹cza/wy³¹cza menu "Edycja"
	public void setEditMenuEnabled(boolean enabled)
	{
		jmEdit.setEnabled(enabled);
	}
	
	// udostêpnia obiekt do manipulacji zawartoœci¹ tabelki
	public DefaultTableModel getTableModel()
	{
		return (DefaultTableModel)jtUserTable.getModel();
	}
	
	// zwraca index zaznaczonego wiersza w tabelce
	public int getUserTableSelectedRow()
	{
		return jtUserTable.getSelectedRow();
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu1());
		}
		return jJMenuBar;
	}

	private JMenu getJMenu() {
		if (jmFile == null) {
			jmFile = new JMenu();
			jmFile.setText("Plik");
			jmFile.add(getJMenuItem());
			jmFile.add(getJMenuItem5());
		}
		return jmFile;
	}
	
	private JMenuItem getJMenuItem() {
		if (jmiConnectToDatabase == null) {
			jmiConnectToDatabase = new JMenuItem();
			jmiConnectToDatabase.setText("Po³¹cz z baz¹");
			jmiConnectToDatabase.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					connectToDatabaseClickedEvent();
				}
			});
		}
		return jmiConnectToDatabase;
	}

	// event, do nadpisania przez klase dziedzicz¹c¹
	public void connectToDatabaseClickedEvent() {}
	
	private JMenu getJMenu2() {
		if (jmEdit == null) {
			jmEdit = new JMenu();
			jmEdit.setText("Edycja");
			jmEdit.add(getJMenuItem1());
			jmEdit.add(getJMenuItem2());
			jmEdit.add(getJMenuItem3());
		}
		return jmEdit;
	}
	
	private JMenuItem getJMenuItem1() {
		if (jmiAddUser == null) {
			jmiAddUser = new JMenuItem();
			jmiAddUser.setText("Dodaj u¿ytkownika");
			jmiAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					addUserClickedEvent();
				}
			});
		}
		return jmiAddUser;
	}

	// event, do nadpisania przez klasê dziedzicz¹c¹
	public void addUserClickedEvent() {}
	
	private JMenuItem getJMenuItem2() {
		if (jmiEditUser == null) {
			jmiEditUser = new JMenuItem();
			jmiEditUser.setText("Edytuj u¿ytkownika");
			jmiEditUser.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					editUserClickedEvent();
				}
			});
		}
		return jmiEditUser;
	}

	// event, do nadpisania przez klasê dziedzicz¹c¹
	public void editUserClickedEvent() {}

	private JMenuItem getJMenuItem3() {
		if (jmiDeleteUser == null) {
			jmiDeleteUser = new JMenuItem();
			jmiDeleteUser.setText("Usuñ u¿ytkownika");
			jmiDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					deleteUserClickedEvent();
				}
			});
		}
		return jmiDeleteUser;
	}

	// event, do nadpisania przez klasê dziedzicz¹c¹
	public void deleteUserClickedEvent() {}	
	
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Pomoc");
			jMenu1.add(getJMenuItem4());
		
		}
		return jMenu1;
	}
	
	private JMenuItem getJMenuItem4() {
		if (jmiAboutBox == null) {
			jmiAboutBox = new JMenuItem();
			jmiAboutBox.setText("O programie");
			jmiAboutBox.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					showAboutBoxClickedEvent();
				}
			});
		}
		return jmiAboutBox;
	}
	
	// event, do nadpisania przez klasê dziedzicz¹c¹
	public void showAboutBoxClickedEvent() {}	

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	private JTable getJTable() {
		if (jtUserTable == null) {
			jtUserTable = new ReadonlyJTable();
			jtUserTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jtUserTable;
	}

	private JMenuItem getJMenuItem5() {
		if (miExit == null) {
			miExit = new JMenuItem();
			miExit.setText("Zakoñcz");
			miExit.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					exitApplicationClickedEvent();
				}
			});
		}
		return miExit;
	}

	// event, do nadpisania przez klasê dziedzicz¹c¹
	public void exitApplicationClickedEvent() {}

}  //  @jve:decl-index=0:visual-constraint="110,26"
