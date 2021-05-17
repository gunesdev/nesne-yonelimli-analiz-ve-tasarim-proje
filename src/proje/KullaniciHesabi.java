package proje;

public class KullaniciHesabi{
	private int id;
	private String kullaniciAdi;
	private ISubject publisher;

	public KullaniciHesabi(int id, String kullaniciAdi){
		this.id = id;
		this.kullaniciAdi = kullaniciAdi;
	}

	public int getId() {
		return id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
}
