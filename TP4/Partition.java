import java.util.ArrayList;
import java.util.Scanner;

public class Partition extends CertificatJSP{

	public Partition(int n,ArrayList<Pair> list_tab,int d,Pair Certificat[]){
		super(2,n,list_tab,d,Certificat);

	}
	public Partition(int m, int n,ArrayList<Pair> list_tab,int d){
		super(m,n,list_tab,d);

	}
	public static int totalSum(ArrayList<Pair> list){
		int sum = 0;
		for(int i=0; i < list.size(); i++){
			sum +=list.get(i).get_second();
		}
		return sum;

	}

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


		}
		else{

			m = 2;
			n = 5;
			//d = totalSum(task_list);
			task_list.add(new Pair(0,5));
			task_list.add(new Pair(0,12));
			task_list.add(new Pair(0,7));
			task_list.add(new Pair(0,4));
			task_list.add(new Pair(0,4));






		}
		d = totalSum(task_list)/2;


		Pair test_certificat[] = new Pair[n];
		test_certificat[0]=new Pair(0,0);
		test_certificat[1]=new Pair(0,1);
		test_certificat[2]=new Pair(5,0);
		test_certificat[3]=new Pair(12,0);
		test_certificat[4]=new Pair(12,1);









		Partition testcerficat = new Partition(n,task_list,d,test_certificat);
		System.out.println("Certificat de départ");
		testcerficat.affiche();
		if(testcerficat.estCorrect()){
			System.out.println("Le certificat de départ est correct  ");
		}
		
 		while(!testcerficat.estCorrect()){
			testcerficat.suivant();
			if(testcerficat.estCorrect()){
				System.out.println("Certificat correct : ");
				testcerficat.affiche();
				

			}


		}
 	}





}


