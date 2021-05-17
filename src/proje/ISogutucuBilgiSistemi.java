package proje;

public interface ISogutucuBilgiSistemi {
	KullaniciHesabi kullaniciDogrula(String kullaniciAdi, String parola);
	long logla(ILog log);
}
