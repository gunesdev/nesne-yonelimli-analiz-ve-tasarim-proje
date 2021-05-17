package proje;

import java.time.LocalDateTime;

public interface ILog {
	LocalDateTime getTarih();
	int getKullaniciId();
	String getIslem();
	boolean getIslemBasariliMi();
	Double getDeger();
	String getAciklama();
}
