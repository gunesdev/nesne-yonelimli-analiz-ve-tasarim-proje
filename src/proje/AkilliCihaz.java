package proje;

import proje.veritabani.PostgresqlSurucu;

public class AkilliCihaz {
	IEyleyici eyleyici;
	ISicaklikAlgilayici algilayici;
	IAnaIslemPlatformu platform;
	IAgArayuzu agArayuzu;
	ISogutucuBilgiSistemi sogutucuBilgiSistemi;
	ISubject publisher;

	public AkilliCihaz(){
		eyleyici = new Eyleyici();
		algilayici = new SicaklikAlgilayici();
		platform = new AnaIslemPlatformu(eyleyici, algilayici);
		sogutucuBilgiSistemi = new SogutucuBilgiSistemi(new PostgresqlSurucu());
		SubscriberLog sLog = new SubscriberLog();
		SubscriberKullanici sKullanici = new SubscriberKullanici();
		publisher = new Publisher();
		publisher.attach(sLog);
		publisher.attach(sKullanici);
		agArayuzu = new AgArayuzu(platform, sogutucuBilgiSistemi, publisher);
	}

	public void arayuz(){
		agArayuzu.arayuz();
	}
}
