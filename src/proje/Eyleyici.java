package proje;

public class Eyleyici implements IEyleyici {
	boolean sogutucuAcikMi = false;

	@Override
	public boolean sogutucuAc(){
		if(!sogutucuAcikMi){
			sogutucuAcikMi = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean sogutucuKapat(){
		if(sogutucuAcikMi){
			sogutucuAcikMi = false;
			return true;
		}
		return false;
	}
}
