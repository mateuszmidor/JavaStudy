package mateuszmidor.com;

/* Tabelka, kt�rej p�l nie mo�na edytowa� */
import javax.swing.JTable;

public class ReadonlyJTable extends JTable {
	private static final long serialVersionUID = 1L;

	public boolean isCellEditable(int row, int column)
	{
	     return false;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"