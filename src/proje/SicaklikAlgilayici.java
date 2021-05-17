package proje;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
	@Override
	public double sicaklikOku(){
		Random random = new Random();
		return random.nextInt(30 - 7 + 1) - 7 + random.nextDouble();
	}
}