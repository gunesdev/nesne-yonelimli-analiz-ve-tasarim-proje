package proje;

import java.time.LocalDateTime;

public class Log implements ILog{
	private LocalDateTime tarih;
	private int kullaniciId;
	private String islem;
	private boolean islemBasariliMi;
	private Double deger;
	private String aciklama;

	public Log(Builder builder){
		this.tarih = LocalDateTime.now();
		this.kullaniciId = builder.kullaniciId;
		this.islem = builder.islem;
		this.islemBasariliMi = builder.islemBasariliMi;
		this.deger = builder.deger;
		this.aciklama = builder.aciklama;
	}

	@Override
	public LocalDateTime getTarih(){
		return tarih;
	}

	@Override
	public int getKullaniciId(){
		return kullaniciId;
	}

	@Override
	public String getIslem(){
		return islem;
	}

	@Override
	public boolean getIslemBasariliMi(){
		return islemBasariliMi;
	}

	@Override
	public Double getDeger(){
		return deger;
	}

	@Override
	public String getAciklama(){
		return aciklama;
	}

	public static class Builder{
		private int kullaniciId;
		private String islem;
		private boolean islemBasariliMi;
		private Double deger;
		private String aciklama;

		public Builder(){}

		public Builder kullaniciId(int kullaniciId){
			this.kullaniciId = kullaniciId;
			return this;
		}

		public Builder islem(String islem){
			this.islem = islem;
			return this;
		}

		public Builder islemBasariliMi(boolean islemBasariliMi){
			this.islemBasariliMi = islemBasariliMi;
			return this;
		}

		public Builder deger(Double deger){
			this.deger = deger;
			return this;
		}

		public Builder aciklama(String mesaj){
			this.aciklama = mesaj;
			return this;
		}

		public Log build(){
			return new Log(this);
		}
	}
}
