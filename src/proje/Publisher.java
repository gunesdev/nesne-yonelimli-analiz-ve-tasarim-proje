package proje;

import java.util.ArrayList;

public class Publisher implements ISubject {

	private ArrayList<IObserver> subscribers = new ArrayList<>();

	@Override
	public void attach(IObserver subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void detach(IObserver subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void notify(String islem, boolean islemBasariliMi, Double deger,String mesaj,
					   KullaniciHesabi kullaniciHesabi, ISogutucuBilgiSistemi sogutucuBilgiSistemi) {
		for(IObserver subscriber: subscribers) {
			subscriber.update(islem, islemBasariliMi, deger, mesaj, kullaniciHesabi, sogutucuBilgiSistemi);
		}
	}
}
