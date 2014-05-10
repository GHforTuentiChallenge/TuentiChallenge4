import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;


public class Challenge3 {

	public static void main(String[] args) {


		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(reader);
		
		int repeat=sc.nextInt();
		for (int i = 0; i < repeat; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			String pass=calculate(x, y);
			System.out.println(pass);
		}

	}

	private static String calculate(int x, int y) {
		float answer=(float) Math.sqrt(x*x+y*y);
		answer=(float) (Math.round(answer*100)/100.0);
		DecimalFormat df=new DecimalFormat("#.##");
		DecimalFormatSymbols otherSymbols = new   DecimalFormatSymbols(Locale.ENGLISH);
		otherSymbols.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(otherSymbols);
		return df.format(answer);
	}


}
