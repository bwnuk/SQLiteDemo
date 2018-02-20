package model;

public class Czytelnik {
	
    private int id;
    private String imie;
    private String nazwisko;
    private String pesel;
    
    public int Get_ID()
    {
    	return id;
    }
    
    public void Set_ID(int i)
    {
    	id = i;
    }
    
    public String Get_Imie()
    {
    	return imie;
    }
    
    public void Set_Imie(String i)
    {
    	imie = i;
    }
    
    public String Get_Nazwisko()
    {
    	return nazwisko;
    }
    
    public void Set_Nazwisko(String n)
    {
    	nazwisko = n;
    }
    
    public String Get_Pesel()
    {
    	return pesel;
    }
    
    public void Set_Pesel(String p)
    {
    	pesel = p;
    }

    public Czytelnik() {}
    
    public Czytelnik(int id, String imie, String nazwisko, String pesel) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }
    
    @Override
    public String toString() {
        return "["+id+"] - "+imie+" "+nazwisko+" - "+pesel;
    }
    
}
