package proje;

public class Araclar {
	private static final int sure = 1000;

	public static void bekle(){
		try
		{
			Thread.sleep(sure);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

	public static void enteraBasilmasiniBekle()
	{
		System.out.println("Devam etmek icin entera basiniz.");
		try
		{
			System.in.read();
		}
		catch(Exception e)
		{}
	}
}
