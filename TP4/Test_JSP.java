import java.util.ArrayList;
import java.util.Scanner;

public class Test_JSP {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int m,n,d;
		ArrayList<Pair> task_list = new ArrayList<Pair>();
		
		Scanner valtest = new Scanner(System.in);
		int test = valtest.nextInt();
		System.out.println("test: " + test);
		if (test == 0){
			Scanner valm = new Scanner(System.in);
			m = valm.nextInt();
			System.out.println("m: " + m);
	
		    Scanner valn = new Scanner(System.in);
		    n = valn.nextInt();
			System.out.println("n :" + n);
	
	
	
			
			for(int parcours =0; parcours < n;parcours++) {
		    	Scanner t = new Scanner(System.in);
			    String t2 = t.nextLine();
			    String[] task = t2.split(" ");
			    Pair p = new Pair(Integer.valueOf(task[0]),Integer.valueOf(task[1]));
			    task_list.add(p);
		    }
			
			Scanner vald = new Scanner(System.in);
		    d = vald.nextInt();
			System.out.println("d :" + d);
		}
		else{
			
			m = 2;
			n = 5;
			d = 1;
			task_list.add(new Pair(2,2));
			task_list.add(new Pair(0,1));
			task_list.add(new Pair(5,3));
			task_list.add(new Pair(4,4));
			task_list.add(new Pair(0,6));
		}
		Pair test_certificat[] = new Pair[n];
		test_certificat[0]=new Pair(2,0);
		test_certificat[1]=new Pair(0,0);
		test_certificat[2]=new Pair(6,0);
		test_certificat[3]=new Pair(4,0);
		test_certificat[4]=new Pair(0,0);
		

		
		CertificatJSP testcerficat = new CertificatJSP(m,n,task_list,d,test_certificat);
		
		System.out.println("Certificat de départ");
		testcerficat.affiche();
		System.out.println("Certificat aléatoire");
		testcerficat.alea();
 		while(!testcerficat.estCorrect()){
			testcerficat.suivant();
			if(testcerficat.estCorrect()){
				System.out.println("Certificat correct : ");
				testcerficat.affiche();
				

			}


		}
 		
 		

		
		
		
		
		
		
		
		
	    






	}

}
