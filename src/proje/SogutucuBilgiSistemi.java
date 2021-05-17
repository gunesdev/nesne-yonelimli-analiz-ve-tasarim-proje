package proje;

public class SogutucuBilgiSistemi implements ISogutucuBilgiSistemi{
	private ISogutucuBilgiSistemi veritabani;

	public SogutucuBilgiSistemi(ISogutucuBilgiSistemi veritabani){
		this.veritabani = veritabani;
	}

	@Override
	public KullaniciHesabi kullaniciDogrula(String kullaniciAdi, String parola){
		return veritabani.kullaniciDogrula(kullaniciAdi, parola);
	}

	@Override
	public long logla(ILog log){
		return veritabani.logla(log);
	}
}
