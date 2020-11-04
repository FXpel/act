import java.util.ArrayList;
import java.util.Scanner;

public class Sum extends Partition{

	public Sum(int n,ArrayList<Pair> list_tab,Pair Certificat[]){
		super(n,list_tab,list_tab.get(list_tab.size()-1).get_second(),Certificat);
		

	}
	public Sum(int m, int n,ArrayList<Pair> list_tab,int d){
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
			task_list.add(new Pair(0,4));
			task_list.add(new Pair(0,6));
			task_list.add(new Pair(0,8));
			task_list.add(new Pair(0,2));
			task_list.add(new Pair(0,20));









		}


		Pair test_certificat[] = new Pair[n];
		test_certificat[0]=new Pair(0,0);
		test_certificat[1]=new Pair(4,0);
		test_certificat[2]=new Pair(10,0);
		test_certificat[3]=new Pair(18,0);
		test_certificat[4]=new Pair(0,0);











		Sum testcerficat = new Sum(n,task_list,test_certificat);
		System.out.println("Certificat de départ");
		testcerficat.affiche();
		
 		while(!testcerficat.estCorrect()){
			testcerficat.suivant();
			if(testcerficat.estCorrect()){
				System.out.println("Certificat correct : ");
				testcerficat.affiche();
				

			}


		}





	}

}
