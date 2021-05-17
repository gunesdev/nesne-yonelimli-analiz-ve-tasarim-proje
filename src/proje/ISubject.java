package proje;

public interface ISubject {
	void attach(IObserver o);
	void detach(IObserver o);
	void notify(String islem, boolean islemBasariliMi,Double deger, String mesaj,
				KullaniciHesabi kullaniciHesabi, ISogutucuBilgiSistemi sogutucuBilgiSistemi);
}
