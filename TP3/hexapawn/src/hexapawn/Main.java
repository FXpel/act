import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {


	    Scanner valn = new Scanner(System.in);
	    int n = valn.nextInt();
			System.out.println("n :" + n);

			Scanner valm = new Scanner(System.in);
			int m = valm.nextInt();
			System.out.println("m: " + m);

			Plateau plateau = new Plateau(n,m);

			Scanner point = new Scanner(System.in);
			for (int i=0;i<n ;i++ ){
				String config = point.nextLine();
				plateau.setConfiguration(config,i);
				}

			plateau.display_plateau(plateau.getConfiguration());
			ArrayList<String[]> temp = plateau.getListConfig();
			System.out.println(plateau.calculeVal(temp,0));


	}
}

