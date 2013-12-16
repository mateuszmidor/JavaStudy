package mateuszmidor.com;

/* Klasa umo¿liwiaj¹ca ³atwe wyœwietlanie komunikatów 
 * tekstowych w zgrabnym okienku dialogowym */

import javax.swing.JOptionPane;


public class MessageDialog {
	private static void showDialog(String title, String message, int type)
	{
		JOptionPane.showMessageDialog(null,  message, title, type);		
	}
	
	public static void showInformation(String title, String message)
	{
		showDialog(title, message, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showError(String title, String message)
	{
		showDialog(title, message, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showException(String title, Exception e)
	{
		showError(title, e.getMessage());
	}
}
