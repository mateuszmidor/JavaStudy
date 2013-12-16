package mateuszmidor.com;


public class UserEditorWindow extends UserEditorWindowGui {

	private static final long serialVersionUID = 1L;
	private boolean dialog_result_accepted = false; // true, jesli kliknieto przycisk OK
	
	public UserEditorWindow() {
		super();
	}

	// tworzenie nowego u¿ytkownika
	public User newUser()
	{	
		setTitle("Stwórz u¿ytkownika");
		if (showDialog()) 
			return fetchUserFromForm();
		
		return null;
	}
	
	// edycja danych u¿ytkownika
	public User editUser(User user)
	{
		setTitle("Edytuj u¿ytkownika");
		loadUserIntoForm(user);
		if (showDialog()) 
		{
			User modified_user = fetchUserFromForm();
			modified_user.id = user.id; // id jest przydzielane przez DBE i musi zostaæ zachowane
			return modified_user;
		}
			
		return null;
	}
	
	// wyœwietla okienko w trybie modalnym,
	// czeka, a¿ okienko zostanie zamkniête
	// i zwraca, czy zosta³o zamkniête w wyniku klikniêcia przycisku OK
	private boolean showDialog()
	{
		setVisible(true);
		return dialog_result_accepted;
	}
	
	private void closeDialog(boolean accept_changes)
	{
		dialog_result_accepted = accept_changes;
		dispose();
	}
	
	public void okBtnClickedEvent()
	{
		try {
			validateForm();
			closeDialog(true);
		}
		catch (Exception err)
		{
			MessageDialog.showException("Niepoprawnie wype³niony formularz", err);
		}			
	}
	
	public void cancelBtnClickedEvent()
	{
		closeDialog(false);
	}
	
	
	// sprawdza, czy formularz zosta³ poprawnie wype³niony
	@SuppressWarnings("deprecation")
	private void validateForm() throws Exception 
	{
		if (jtfFName.getText().length() < 2)
			throw new Exception("Imiê musi mieæ minimum 2 znaki");
		if (jtfLName.getText().length() < 2)
			throw new Exception("Nazwisko musi mieæ minimum 2 znaki");
		if (jtfAddress.getText().length() < 6) // co najmniej kod pocztowy
			throw new Exception("Podaj przynajmniej kod pocztowy (6 znaków)");
		if (jtfNickName.getText().length() < 5)
			throw new Exception("Nazwa u¿ytkownika musi mieæ minimum 5 znaków");
		if (jtfPassword1.getPassword().length < 4)
			throw new Exception("Has³o musi mieæ minimum 4 znaki");	
		if (!jtfPassword1.getText().equals(jtfPassword2.getText()))
			throw new Exception("Has³a nie zgadzaj¹ siê");	
	} 
	
	// wczytuje u¿ytkownika do formularza
	private void loadUserIntoForm(User user)
	{
		jtfFName.setText(user.first_name);
		jtfLName.setText(user.last_name);
		jtfAddress.setText(user.address);
		jtfNickName.setText(user.nick_name);
		jtfPassword1.setText(user.password);
		jtfPassword2.setText(user.password);
	}
	
	// pobiera z formularza dane o u¿ytkowniku
	@SuppressWarnings("deprecation")
	private User fetchUserFromForm()
	{
		User user = new User();
		user.first_name = jtfFName.getText();
		user.last_name = jtfLName.getText();
		user.address = jtfAddress.getText();
		user.nick_name = jtfNickName.getText();
		user.password = jtfPassword1.getText();
		return user;
	}

}  //  @jve:decl-index=0:visual-constraint="145,86"
