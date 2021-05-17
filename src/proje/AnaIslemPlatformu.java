package proje;

public class AnaIslemPlatformu implements IAnaIslemPlatformu{
	IEyleyici eyleyici;
	ISicaklikAlgilayici algilayici;
	AnaIslemPlatformu(IEyleyici eyleyici, ISicaklikAlgilayici algilayici){
		this.algilayici = algilayici;
		this.eyleyici = eyleyici;
	}

	@Override
	public boolean sogutucuAc(){
		return eyleyici.sogutucuAc();
	}

	@Override
	public boolean sogutucuKapat(){
		return eyleyici.sogutucuKapat();
	}

	@Override
	public double sicaklikAlgila(){
		return algilayici.sicaklikOku();
	}
}
