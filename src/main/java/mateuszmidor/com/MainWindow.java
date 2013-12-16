package mateuszmidor.com;

/* Klasa okna g³ównego aplikacji, odpowiedzialna za logikê biznesow¹
 * i obs³ugê eventów z klasy bazowej dostarczaj¹cej zdarzenia GUI */

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends MainWindowGui {
    private static final long serialVersionUID = 1L;

    // Application Entry Point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow thisClass = new MainWindow();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    public MainWindow() {
        super();

        // menu "Edycja" niedostêpne do czasu po³¹czenia z baz¹ danych
        setEditMenuEnabled(false);
    }

    // ³aduje u¿ytkowników z bazy danych do tabelki
    private void loadUserTableFromDatabase() {
        UserModel model = new UserModel();
        ArrayList<User> users;
        try {
            // pobieramy z bazy wszystkich u¿ytkowników
            users = model.getAllUsers();

            // i wrzucamy ich do tabelki
            for (User user : users)
                addUserTableRow(user);

            setEditMenuEnabled(true);
        } catch (SQLException e) {
            MessageDialog.showException("B³¹d podczas ³¹czenia z baz¹ danych", e);
        }
    }

    // czyœci tabelkê u¿ytkowników
    public void clearUserTable() {
        DefaultTableModel model = getTableModel();
        model.getDataVector().removeAllElements();
    }

    // przeladowuje zawartosc tabelki z bazy danych
    public void reloadUserTable() {
        clearUserTable();
        loadUserTableFromDatabase();
    }

    // sprawdza, czy jest zaznaczony jakiœ u¿ytkownik w tabelce
    public boolean isAnyUserSelected() {
        int selected_row = getUserTableSelectedRow();
        return (-1 != selected_row);
    }

    // pobiera u¿ytkownika z zaznaczonego wiersza tabelki
    public User getSelectedUser() {
        int selected_row = getUserTableSelectedRow();
        DefaultTableModel model = getTableModel();
        User user = new User();

        user.id = (String) model.getValueAt(selected_row, 0);
        user.first_name = (String) model.getValueAt(selected_row, 1);
        user.last_name = (String) model.getValueAt(selected_row, 2);
        user.address = (String) model.getValueAt(selected_row, 3);
        user.nick_name = (String) model.getValueAt(selected_row, 4);
        user.password = (String) model.getValueAt(selected_row, 5);

        return user;
    }

    // wstawia u¿ytkownika do tabelki
    public void addUserTableRow(User user) {
        DefaultTableModel model = getTableModel();
        model.addRow(new Object[] { user.id, user.first_name, user.last_name, user.address, user.nick_name, user.password });
    }

    // modyfikuje wiersz w tabelce
    public void updateUserTableRow(int row_id, User user) {
        DefaultTableModel model = getTableModel();
        model.setValueAt(user.id, row_id, 0);
        model.setValueAt(user.first_name, row_id, 1);
        model.setValueAt(user.last_name, row_id, 2);
        model.setValueAt(user.address, row_id, 3);
        model.setValueAt(user.nick_name, row_id, 4);
        model.setValueAt(user.password, row_id, 5);
    }

    // usuwa wiersz z tabelki
    public void deleteUserTableRow(int row_id) {
        DefaultTableModel model = getTableModel();
        model.removeRow(row_id);
    }

    // obs³uga menu aplikacji
    public void connectToDatabaseClickedEvent() {
        reloadUserTable();
    }

    // obs³uga menu aplikacji
    public void exitApplicationClickedEvent() {
        dispose();
    }

    // obs³uga menu aplikacji
    public void addUserClickedEvent() {
        UserEditorWindow editor = new UserEditorWindow();

        // wyswietlamy formularz do tworzenia uzytkownika
        User user = editor.newUser();

        // jesli stworzono uzytkownika
        if (null != user) {
            UserModel model = new UserModel();

            try {
                // zapisujemy go do bazy danych i przeladowujemy tabelke
                model.addUser(user);
                reloadUserTable();
            } catch (SQLException e) {
                MessageDialog.showException("B³¹d podczas dodawania u¿ytkownika", e);

            }

        }

    }

    // obs³uga menu aplikacji
    public void editUserClickedEvent() {
        if (!isAnyUserSelected())
            return;

        UserEditorWindow editor = new UserEditorWindow();

        // wyswietlamy formularz do edycji danych uzytkownika
        User user = editor.editUser(getSelectedUser());

        // jezeli edycja danych u¿ytkownika zakonczona powodzeniem
        if (null != user) {
            UserModel model = new UserModel();

            try {
                // zapisujemy zmiany do bazy i przeladowujemy tabelke
                model.updateUser(user);
                reloadUserTable();
            } catch (SQLException e) {
                MessageDialog.showException("B³¹d podczas edycji danych u¿ytkownika", e);
            }
        }
    }

    // obs³uga menu aplikacji
    public void deleteUserClickedEvent() {
        if (!isAnyUserSelected())
            return;

        // czy na pewno usun¹æ u¿ytkownika?
        if (false == askWhetherDeleteSelectedUser())
            return;

        User user = getSelectedUser();
        UserModel model = new UserModel();

        try {
            // usuwamy uzytkownika z bazy danych i przeladowujemy tabelke
            model.deleteUser(user.id);
            reloadUserTable();
        } catch (SQLException e) {
            MessageDialog.showException("B³¹d podczas usuwania u¿ytkownika", e);
        }
    }

    // pyta operatora, czy na pewno chce usun¹æ zaznaczonego u¿ytkownika
    private boolean askWhetherDeleteSelectedUser() {
        return (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usun¹æ u¿ytokwnika ?", "PotwierdŸ chêæ usuniêcia", JOptionPane.YES_NO_OPTION));
    }

    // obs³uga menu aplikacji
    public void showAboutBoxClickedEvent() {
        JOptionPane.showMessageDialog(null, "\"Baza U¿ytkowników\"\n" + "by Mateusz Midor\n" + "kontakt@mateuszmidor.com", "O programie", JOptionPane.INFORMATION_MESSAGE);
    }
}
