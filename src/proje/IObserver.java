package proje;

public interface IObserver {
	void update(String islem, boolean islemBasariliMi, Double deger, String mesaj,
				KullaniciHesabi kullaniciHesabi, ISogutucuBilgiSistemi sogutucuBilgiSistemi);
}
