import java.util.ArrayList;
import java.util.*;

public class Plateau {
	private String[] configuration;
	private int largeur;
	private int hauteur;


	private ArrayList<String[]> list_config = new ArrayList<String[]>();
	private ArrayList<Integer> valConfig = new ArrayList<Integer>();
	

	public Plateau(int h, int l) {
		this.configuration = new String[h];
		this.largeur = l;
		this.hauteur = h;
	}

	public void display_plateau(String[] configuration) {
		for(int i = 0; i < this.hauteur; i++) {
			String s = configuration[i].replace('P','B');
			String s2= s.replace('p','N');
			String s3 = s2.replace(' ','_');
			System.out.println(s3.substring(0,this.largeur));

			}


	}

	public char isPartieFinie(String[] config) {

		for (int i=0;i<this.largeur ;i++ ) {

			if(config[0].indexOf('P') != -1){
				return 'B';
			}
			if(config[hauteur-1].indexOf('p') != -1){
				return 'N';
			}
		}
		return ' ';
	}



	public String[] getConfiguration() {

		return configuration;
	}





	public Boolean canEat(char p,String[] config,int px,int py,int p_eaten_x,int p_eaten_y){
		if (p_eaten_x >= this.hauteur || p_eaten_y >= this.largeur || isPartieFinie(config) != ' ' ||p_eaten_x < 0 || p_eaten_y <0 ) {
			return false;
		}
		if (config[p_eaten_y].charAt(p_eaten_x) == ' ' || isPartieFinie(config) != ' ') {
			return false;
		}
		if(p == 'P'){
			if(px < this.largeur -1){
				if(config[py-1].charAt(px + 1) == 'p' && isPartieFinie(config) == ' '){
					return true;
				}
			}

			if(px >= 1){
				if( config[py-1].charAt(px - 1) == 'p' && isPartieFinie(config) == ' '){
				return true;
			}
			}

		}
		if(p == 'p'){
			if(px < config.length -1){

				if(config[py+1].charAt(px + 1) == 'P' && isPartieFinie(config) == ' '){
					return true;
				}
			}

			if(px >= 1){
				if( config[py+1].charAt(px - 1) == 'P' && isPartieFinie(config) == ' '){
						return true;
				}
			}

		}
		return false;
	}




	public Boolean canMoveForward(char p,String[] config,int px, int py){

		if(p == ' '){
			return false;
		}
		if(p == 'P'){
			if(config[py-1].charAt(px) == ' '&& isPartieFinie(config) == ' '){
				return true;
			}

		}
		if(p == 'p'){
			if(config[py+1].charAt(px) == ' '&& isPartieFinie(config) == ' '){
				return true;
			}
		}
		return false;
	}

	public String[] eatd(char p_eater,String[] config,int p_eater_x,int p_eater_y){
		
		String[] config_temp = config.clone();

		
			if(p_eater == 'P'){
				if(canEat(p_eater,config_temp,p_eater_x,p_eater_y,p_eater_x + 1, p_eater_y - 1)) {
					config_temp[p_eater_y] = changeChar(config_temp[p_eater_y],p_eater_x,' ');
					config_temp[p_eater_y -1] = changeChar(config_temp[p_eater_y - 1],p_eater_x +1,'P');
				}
			}
				
			
			if(p_eater== 'p'){
				if(canEat(p_eater,config_temp,p_eater_x,p_eater_y,p_eater_x + 1, p_eater_y + 1)) {
				config_temp[p_eater_y] = changeChar(config_temp[p_eater_y],p_eater_y,' ');
				config_temp[p_eater_y + 1] = changeChar(config_temp[p_eater_y + 1],p_eater_x + 1,'p');
				}
			}
			return config_temp;
	}
	public String[] eatg(char p_eater,String[] config,int p_eater_x,int p_eater_y){
		String[] config_temp = config.clone();
		if(p_eater == 'P'){
			if(canEat(p_eater,config_temp,p_eater_x,p_eater_y,p_eater_x -1, p_eater_y - 1)) {
				config_temp[p_eater_y] = changeChar(config_temp[p_eater_y],p_eater_x,' ');
				config_temp[p_eater_y -1] = changeChar(config_temp[p_eater_y - 1],p_eater_x -1,'P');
			}
		}
			
		
		if(p_eater== 'p'){
			if(canEat(p_eater,config_temp,p_eater_x,p_eater_y,p_eater_x -1, p_eater_y + 1)) {
			config_temp[p_eater_y] = changeChar(config_temp[p_eater_y],p_eater_y,' ');
			config_temp[p_eater_y + 1] = changeChar(config_temp[p_eater_y + 1],p_eater_x -1,'p');
			}
		}

		return config_temp;
	}

	public String[] moveForward(char p,String[] config,int px , int py){
		String[] config_temp = config.clone();
		if(p == 'P'){
			config_temp[py] = changeChar(config_temp[py],px,' ');
			config_temp[py-1] = changeChar(config_temp[py-1],px,'P');
			}
		if(p == 'p'){

			config_temp[py] = changeChar(config_temp[py],px,' ');
			config_temp[py+1] = changeChar(config_temp[py+1],px,'p');

		}
		return config_temp;
	}
	public void setConfiguration(String configuration,int i) {
		this.configuration[i] = configuration;
	}

	public ArrayList<String[]> getListConfig(){
		return this.list_config;
	}




	public int calculeVal(ArrayList<String[]> config,int player){
		int winner=1;
		ArrayList<String[]> config_temp =  new ArrayList<String[]>();
		config_temp.addAll(config);
		if(config.size() <1){
			int endofgame = 0;

				if (isPartieFinie(this.configuration)!= ' '){

					endofgame ++;
				}
			if (endofgame >0){
				return 0;
			}
		}
		if(config.size() > 0){
			int endofgame = 0;
			for(int indconf=0; indconf < config.size(); indconf++){
				if (isPartieFinie(config.get(indconf))!= ' '){
					if(isPartieFinie(config.get(indconf))== 'N') {
						winner = -1;
					}
					endofgame ++;
				}
			}
			if (endofgame >0){
				int res=0;
				for(int i=0;i<config.size(); i++) {
					System.out.println("//////////////////////");
					display_plateau(config.get(i));
					
				}
				if (winner == -1){
					res = (getMinList(valConfig)+1) * winner;
				}
				if (winner == 1){
					res = getMinList(valConfig) * winner;
				}
				return res;
			}
		}

		if(config.size() < 1){
			int blocked =0;
				if (!isBlocked(this.configuration)){
					blocked ++;
				}
			if (blocked == 0){
				return 0;
			}
		}
		if(config.size() > 0){
			int blocked =0;
			for(int ind_blocked=0; ind_blocked < config.size(); ind_blocked++){
				if (!isBlocked(config.get(ind_blocked))){
					blocked ++;
				}
			}
			if (blocked == 0){
				return 0;
			}
		}
		
		
			if(config.size() == 0) {
				if(player == 0) {
					for (int y=0;y<this.hauteur ;y++) {
						for (int x=0;x<this.largeur ;x++) {
								if(this.configuration[y].charAt(x) == 'P'){
									if(canMoveForward(this.configuration[y].charAt(x),this.configuration,x,y)){
											config_temp.add(moveForward(this.configuration[y].charAt(x),this.configuration,x,y));
											
											valConfig.add(1);
									}
										    if(eatd(this.configuration[y].charAt(x),this.configuration,x,y) != this.configuration) {
										    	config_temp.add(eatd(this.configuration[y].charAt(x),this.configuration,x,y));
										    	
												valConfig.add(1);
											}
										    if(eatg(this.configuration[y].charAt(x),this.configuration,x,y) != this.configuration) {
										    	config_temp.add(eatg(this.configuration[y].charAt(x),this.configuration,x,y));
										    	
											}
										    
											
									
								}
						}
					}
				}
				if(player == 1) {
					for (int y=0;y<this.hauteur ;y++) {
						for (int x=0;x<this.largeur ;x++) {
								if(this.configuration[y].charAt(x) == 'p'){
									if(canMoveForward(this.configuration[y].charAt(x),this.configuration,x,y)){
											config_temp.add(moveForward(this.configuration[y].charAt(x),this.configuration,x,y));
											
											valConfig.add(1);
									}
										    if(eatd(this.configuration[y].charAt(x),this.configuration,x,y) != this.configuration) {
										    	config_temp.add(eatd(this.configuration[y].charAt(x),this.configuration,x,y));
										    	
												valConfig.add(1);
											}
										    if(eatg(this.configuration[y].charAt(x),this.configuration,x,y) != this.configuration) {
										    	config_temp.add(eatg(this.configuration[y].charAt(x),this.configuration,x,y));
										    	
											}
										    
											
									
								}
						}
					}
				}
			}
			
			if(config.size() > 0) {
				for(int i =0; i<config.size();i++){
					if(player == 0) {
						for (int y=0;y<this.hauteur ;y++) {
							for (int x=0;x<this.largeur ;x++) {
								if(config_temp.get(i)[y].charAt(x) == 'P'){
									if(canMoveForward(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y)){
											config_temp.add(moveForward(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y));
											valConfig.set(i, valConfig.get(i)+1);
									}
									if(eatd(config_temp.get(i)[y].charAt(x),this.configuration,x,y) != config_temp.get(i)) {
								    	config_temp.add(eatd(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y));
										valConfig.add(1);
									}
								    if(eatg(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y) != config_temp.get(i)) {
								    	config_temp.add(eatg(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y));
										valConfig.add(1);
									}
									
								}
							}
						}
					}
					if(player == 1) {
						for (int y=0;y<this.hauteur ;y++) {
							for (int x=0;x<this.largeur ;x++) {
									if(config_temp.get(i)[y].charAt(x) == 'p'){
										if(canMoveForward(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y)){
												config_temp.add(moveForward(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y));
												valConfig.set(i, valConfig.get(i) +1);
												valConfig.add(1);
										}
										if(eatd(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y) != config_temp.get(i)) {
									    	config_temp.add(eatd(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y));
											valConfig.add(1);
										}
									    if(eatg(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y) != config_temp.get(i)) {
									    	config_temp.add(eatg(config_temp.get(i)[y].charAt(x),config_temp.get(i),x,y));
											valConfig.add(1);
										}
										
									}
							}
						}
					}
				}
			}
			
		
		

		if (player ==0) {
			player ++;
		}
		else {
			player --;
		}
		return  calculeVal(config_temp,player);
	}
	

	

	public Boolean isBlocked (String[] config){
		for (int y=0 ;y<this.hauteur ;y++ ) {
			for (int x=0 ;x<this.largeur ;x++ ) {
				if(canMoveForward(config[y].charAt(x),config,x,y)){
					return false;
				}
			}
		}
		return true;
	}

	public String changeChar(String chaine, int idx, char monCharRempl) {
	  char[] tab = chaine.toCharArray();
	  tab[idx] = monCharRempl;
	  return String.valueOf(tab);
	}
	
	public int getMinList(ArrayList<Integer> valconfig) {
		int temp = valconfig.get(0);

		for(int i=1;i<valconfig.size();i++) {
			if(temp > valconfig.get(i)){
				temp = valconfig.get(i);
			}
		}
		return temp;
	}
}



