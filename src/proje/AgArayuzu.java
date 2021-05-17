package proje;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AgArayuzu implements IAgArayuzu {
	IAnaIslemPlatformu platform;
	ISogutucuBilgiSistemi sogutucuBilgiSistemi;
	ISubject publisher;

	public AgArayuzu(IAnaIslemPlatformu platform,
					 ISogutucuBilgiSistemi sogutucuBilgiSistemi, ISubject publisher) {
		this.platform = platform;
		this.sogutucuBilgiSistemi = sogutucuBilgiSistemi;
		this.publisher = publisher;
	}

	@Override
	public void arayuz() {
		int secim;
		while(true) {
			System.out.println("1- Arayuze giris yap");
			System.out.println("2- Programi sonlandir");
			System.out.println("Yapmak istediginiz islemi seciniz: ");
			Scanner input = new Scanner((System.in));
			secim = input.nextInt();
			switch (secim) {
				case 1:
					KullaniciHesabi kullaniciHesabi = girisYap();
					int secim2;
					do {
						System.out.println("1- Sogutucuyu calistir");
						System.out.println("2- Sogutucuyu durdur");
						System.out.println("3- Sicaklik goruntule");
						System.out.println("4- Cikis yap");
						System.out.println("Yapmak istediginiz islemi seciniz: ");
						Scanner input2 = new Scanner((System.in));
						secim2 = input.nextInt();
						switch (secim2) {
							case 1:
								if (platform.sogutucuAc()) {
									Araclar.bekle();
									String mesaj = "Sogutucu acildi";
									System.out.println(mesaj + ".");
									publisher.notify("Sogutucu acma islemi", true,
											null, mesaj, kullaniciHesabi, sogutucuBilgiSistemi);
									Araclar.enteraBasilmasiniBekle();
								} else {
									Araclar.bekle();
									String mesaj = "Sogutucu zaten acik";
									System.out.println(mesaj + ".");
									publisher.notify("Sogutucu acma islemi", false,
											null, mesaj, kullaniciHesabi, sogutucuBilgiSistemi);
									Araclar.enteraBasilmasiniBekle();
								}
								break;
							case 2:
								if (platform.sogutucuKapat()) {
									Araclar.bekle();
									String mesaj = "Sogutucu kapatildi";
									System.out.println(mesaj + ".");
									publisher.notify("Sogutucu kapatma islemi", true,
											null, mesaj, kullaniciHesabi, sogutucuBilgiSistemi);
									Araclar.enteraBasilmasiniBekle();
								} else {
									Araclar.bekle();
									String mesaj = "Sogutucu zaten kapali";
									System.out.println(mesaj + ".");
									publisher.notify("Sogutucu kapatma islemi", false,
											null, mesaj, kullaniciHesabi, sogutucuBilgiSistemi);
									Araclar.enteraBasilmasiniBekle();
								}
								break;
							case 3:
								Double sicaklik = BigDecimal.valueOf(platform.sicaklikAlgila())
										.setScale(1, RoundingMode.HALF_UP)
										.doubleValue();
								Araclar.bekle();
								System.out.println("Mevcut sicaklik: " + sicaklik + " derece celsius.");
								publisher.notify("Sicaklik sorgulama islemi", true,
										sicaklik, "Sicaklik sorgulandi", kullaniciHesabi, sogutucuBilgiSistemi);
								Araclar.enteraBasilmasiniBekle();
								break;
							case 4:
								publisher.notify("Cikis islemi", true,
										null, "Cikis yapildi", kullaniciHesabi, sogutucuBilgiSistemi);
								cikisYap();
								break;
							default:
								System.out.println("Hatali giris. Lutfen tekrar deneyiniz.");
								Araclar.enteraBasilmasiniBekle();
						}
					} while (secim2 != 4);
					break;
				case 2:
					System.out.println("Program sonlandiriliyor.");
					Araclar.bekle();
					return;
			}
		}
	}

	@Override
	public KullaniciHesabi girisYap() {
		KullaniciHesabi kullaniciHesabi;
		for (int i = 0; true; i++) {
			System.out.println("Kullanici adinizi giriniz: ");
			Scanner input = new Scanner(System.in);
			String kullaniciAdi = input.next();
			System.out.println("Sifrenizi giriniz: ");
			String parola = input.next();
			kullaniciHesabi = sogutucuBilgiSistemi.kullaniciDogrula(kullaniciAdi, parola);
			Araclar.bekle();
			if(kullaniciHesabi == null) {
				System.out.println("Giris islemi basarisiz.");
				Araclar.bekle();
				if (i == 2) {
					System.out.println("Kullanici adinizi veya sifrenizi 3 kez yanlis girdiniz. " +
							"Lutfen daha sonra tekrar deneyiniz.");
					Araclar.enteraBasilmasiniBekle();
					System.exit(0);
				}
				System.out.println("Kullanici adinizi veya sifrenizi yanlis girdiniz. Lutfen tekrar deneyiniz.");
				Araclar.enteraBasilmasiniBekle();
			}else{
				System.out.println("Giris islemi basarili. Hosgeldiniz " + kullaniciAdi + ".");
				publisher.notify("Giris islemi", true,
						null, "Giris yapildi", kullaniciHesabi, sogutucuBilgiSistemi);
				Araclar.enteraBasilmasiniBekle();
				break;
			}
		}
		return kullaniciHesabi;
	}

	@Override
	public void cikisYap(){
		System.out.println("Cikis yapildi.");
	}
}
