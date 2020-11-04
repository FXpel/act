import java.util.ArrayList;

class CertificatJSP implements Certificat{
	private int max_time;
	private int nb_current_machine;
	private int nb_machine;
	private int nb_task;
	private Pair task_Certificat[];
	private ArrayList<Pair> list_task;
	public CertificatJSP(int m, int n,ArrayList<Pair> list_tab,int d,Pair Certificat[]){
		this.nb_machine =m;
		this.nb_task = n;
		this.task_Certificat = Certificat;
		this.list_task = list_tab;
		this.max_time = d;
	}
	public CertificatJSP(int m, int n,ArrayList<Pair> list_tab,int d){
		this.nb_machine =m;
		this.nb_task = n;
		this.task_Certificat = new Pair [this.nb_task];
		this.list_task = list_tab;
		this.max_time = d;
		reset();
	}

  @Override
  public void alea(){
	  int random_start,random_engine;
	    int temps[] = new int[this.nb_machine];
	    for(int i=0; i< this.list_task.size();i++){
	    	random_start = (int)(Math.random() * (this.list_task.get(i).get_first() + this.max_time) - this.list_task.get(i).get_first());
	    	random_engine = (int)(Math.random() * this.nb_machine);
	    	if (temps[random_engine] < random_start){
	    		temps[random_engine] += random_start- temps[random_engine] ;

	    	}
	    	System.out.println("tâche " + i +" : début " + temps[random_engine] +", machine " +random_engine + ", durée : " + this.list_task.get(i).get_second());
	    	temps[random_engine] += this.list_task.get(i).get_second();
	    }
  }
@Override
public void suivant() {



		for(int i=0; i< this.nb_task ; i++){

			if (this.task_Certificat[i].get_second() != this.nb_machine -1){
				this.task_Certificat[i].set_second(this.task_Certificat[i].get_second()+1);
				return;
			}
			this.task_Certificat[i].set_second(0) ;
		}

	for(int parcours_machine= 0; parcours_machine < this.nb_task ;parcours_machine ++){

		for(int i=0; i< this.nb_task ; i++){
			if(this.task_Certificat[i].get_first() != this.list_task.get(i).get_first()+this.max_time){
					this.task_Certificat[i].set_first(this.task_Certificat[i].get_first() +1 );
					return;
				}
			this.task_Certificat[i].set_first(this.list_task.get(i).get_first());

		}
	}



	}







@Override
public void reset() {
	for(int i =0; i < this.nb_task; i++){
		this.task_Certificat[i].set_first(this.list_task.get(i).get_first());
		this.task_Certificat[i].set_second(0);
	}

}

@Override
public boolean estCorrect() {
	int sum_start_cert[] = new int[this.nb_machine];
	int sum_start[] = new int[this.nb_machine];
	for(int j=0;j< this.nb_task;j++ ){
		for(int i=0; i< this.nb_task;i++){
			sum_start[task_Certificat[i].get_second()] += this.list_task.get(i).get_first();
			sum_start_cert[task_Certificat[i].get_second()] += this.task_Certificat[i].get_first();
			if ( sum_start[task_Certificat[i].get_second()] - sum_start_cert[task_Certificat[i].get_second()] >this.max_time){
				return false;
			}
			if( i != j){

				if (task_Certificat[i].get_second() == task_Certificat[j].get_second()){
					//on regarde le chevauchement
					if(this.task_Certificat[i].get_first() + this.list_task.get(i).get_second()> this.task_Certificat[j].get_first() &&this.task_Certificat[j].get_first() + this.list_task.get(j).get_second()> this.task_Certificat[i].get_first() ) {

						return false;
					}

				}

			}
		sum_start_cert[task_Certificat[i].get_second()] += this.list_task.get(i).get_second();
		sum_start[task_Certificat[i].get_second()] += this.list_task.get(i).get_second();

		}
	}









	return true;
}

@Override
public void saisie() {
	// TODO Auto-generated method stub

}

@Override
public void affiche() {
	for(int i =0; i < this.task_Certificat.length; i++){
		System.out.print("tâche " + i);
		System.out.print(" : début " + this.task_Certificat[i].get_first());
		System.out.println(", machine " +this.task_Certificat[i].get_second());

	}

}

@Override
public boolean estDernier() {

	for(int i=0; i< this.nb_task; i++){
		if(this.list_task.get(i).get_first()+this.max_time != this.task_Certificat[i].get_first()){
			return false;
		}
		if(this.task_Certificat[i].get_second() != this.nb_machine){
			return false;
		}
	}

	return true;
}
}
