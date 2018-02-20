package model;

public class Wypozyczenia {
	private int idKsiazka;
    private int idCzytelnik;
 
    public int getIdKsiazka() 
    {
        return idKsiazka;
    }
    
    public void setIdKsiazka(int idKsiazka) 
    {
        this.idKsiazka = idKsiazka;
    }
    
    public int getIdCzytelnik() 
    {
        return idCzytelnik;
    }
    
    public void setIdCzytelnik(int idCzytelnik) 
    {
        this.idCzytelnik = idCzytelnik;
    }
 
    public Wypozyczenia() {}
    
    public Wypozyczenia(int idKsiazka, int idCzytelnik) 
    {
        this.idKsiazka = idKsiazka;
        this.idCzytelnik = idCzytelnik;
 
    }
}
