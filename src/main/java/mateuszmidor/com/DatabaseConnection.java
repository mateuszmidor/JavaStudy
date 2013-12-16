package mateuszmidor.com;

/* Interfejs implementowany przez klasy udostępniające 
 * połączenie z konkretnym typem bazy danych np. MySQL */

import java.sql.Connection;

public interface DatabaseConnection {
	Connection getConnection();
}
