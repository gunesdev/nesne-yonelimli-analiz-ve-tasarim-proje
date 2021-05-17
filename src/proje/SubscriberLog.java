package proje;

public class SubscriberLog implements IObserver{
	@Override
	public void update(String islem, boolean islemBasariliMi, Double deger, String mesaj,
					   KullaniciHesabi kullaniciHesabi, ISogutucuBilgiSistemi sogutucuBilgiSistemi) {
		Log log = new Log.Builder()
				.kullaniciId(kullaniciHesabi.getId())
				.islem(islem)
				.islemBasariliMi(islemBasariliMi)
				.deger(deger)
				.aciklama(mesaj)
				.build();
		sogutucuBilgiSistemi.logla(log);
	}
}
