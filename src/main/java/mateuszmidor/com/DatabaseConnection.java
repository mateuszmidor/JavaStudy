package mateuszmidor.com;

/* Interfejs implementowany przez klasy udostêpniaj¹ce 
 * po³¹czenie z konkretnym typem bazy danych np. MySQL */

import java.sql.Connection;

public interface DatabaseConnection {
	Connection getConnection();
}
