package proje;

public class SubscriberKullanici implements IObserver{
	@Override
	public void update(String islem, boolean islemBasariliMi, Double deger, String mesaj,
					   KullaniciHesabi kullaniciHesabi, ISogutucuBilgiSistemi sogutucuBilgiSistemi) {
		System.out.println(kullaniciHesabi.getKullaniciAdi()
				+ " adli kullaniciya gelen mesaj: " + mesaj + ".");
	}
}
