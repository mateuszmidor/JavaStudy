package com.mateuszmidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// odczyt linii z bazy w Chinach zajmuje naprawdê du¿o czasu :)
interface HeavyDAO {
	String readLine();
}

// invocation handler dla naszego proxy DAO
class HeavyDaoInvocationHandler implements InvocationHandler {
	final static BufferedReader reader = new BufferedReader(new StringReader(
			"Sia³a baba mak,\n" + "Nie wiedzia³a jak.\n"
					+ "Dziadek wiedzia³, nie powiedzia³,\n" + "A to by³o tak:"));

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		if (method.getName() == "readLine") {
			return reader.readLine();
		}

		return null;
	}
}

public class App {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Dynamic proxy example.");
		System.out.println("Reading from pseudo database DAO:");
		
		// tworzymy proxy na podstawie interfejsu. 
		// dostarczamy mu handlera wywo³añ metod
		HeavyDAO dao = (HeavyDAO) Proxy.newProxyInstance(
				HeavyDAO.class.getClassLoader(), new Class[]{HeavyDAO.class},
				new HeavyDaoInvocationHandler());

		// u¿ywamy proxy jak normalnego obiektu
		for (String line = dao.readLine(); line != null; line = dao.readLine()) {
			System.out.println(line);
		}

		System.out.println();
	}

}
