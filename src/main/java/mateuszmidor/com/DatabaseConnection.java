package mateuszmidor.com;

/* Interfejs implementowany przez klasy udost�pniaj�ce 
 * po��czenie z konkretnym typem bazy danych np. MySQL */

import java.sql.Connection;

public interface DatabaseConnection {
	Connection getConnection();
}
