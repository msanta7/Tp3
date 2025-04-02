package tp3exo1;

import java.util.ArrayList;

public class Model {
	ArrayList<Contact> contacts;
	
	public Model()
	{
		this.contacts=new ArrayList<>();
	}
	
	public void add(Contact con)
	{
		contacts.add(con);
	}
	
	public void delete(Contact con)throws ContactNotFoundException
	{
		if(contacts.contains(con))
		{
			contacts.remove(con);
		}
		else {
			throw new ContactNotFoundException("Contact non trouvee");
		}
	}
	
	public void edit(Contact con,String nouvNom,String nouvPrenom,String nouvNumTel,String nouvType)throws ContactNotFoundException
	{
		if(contacts.contains(con))
		{
			con.setNom(nouvNom);
			con.setPrenom(nouvPrenom);
			con.setNumTel(nouvNumTel);
			con.setType(nouvType);
			
		}
		else {
			throw new ContactNotFoundException("Contact non trouvee");
		}
	}
	
	public ArrayList<Contact> getContacts() {
	        return contacts;
	    }
	 
}
