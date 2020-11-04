import java.util.ArrayList;
import java.util.List;

public class Plateau {
	private int largeur;
	private int hauteur;
	private int nbPoint;
	private List<Point> points = new ArrayList<Point>();

	public Plateau(int l, int h, int p) {
		this.setOordonnées(l);
		this.setAbscisse(h);
		this.setNbPoint(p);
	}

	public Plateau(int l, int h, int p, ArrayList<Point> lP) {
		this.setOordonnées(l);
		this.setAbscisse(h);
		this.setNbPoint(p);
		this.setPoints(lP);
	}

	// METHODS
	public int surface(List<Point> points) {
		Point hmax =new Point(0,0);
		int h=1;
		int res = 0;
		int res2 = 0;
		int sur_1=0;
		int sur_2 =0;
				
			for(int i = 0; i < points.size(); i++) {
				if (i == points.size()-2){
					Point pt1 = new Point(points.get(points.size()-2).getX_i(),points.get(points.size()-1).getY_i());
					res = (res > calc_air(points.get(points.size()-2),points.get(points.size()-1),pt1))? res : calc_air(points.get(points.size()-2),points.get(points.size()-1),pt1);
				}
				if (i ==points.size()-1){
					Point pt1 = new Point(points.get(points.size()-1).getX_i(),largeur);
					Point pt2 = new Point(hauteur,points.get(points.size()-1).getY_i());
					res = (res > calc_air(points.get(points.size()-1),pt2,pt1))? res : calc_air(points.get(points.size()-1),pt2,pt1);
					}
				else{
				for(int j = i+1; j < points.size()-1; j++) {
						
						hmax= points.get(i+1);
						if(hmax.getY_i() <points.get(i+1).getY_i()){
							while (hmax.getY_i() <points.get(i+h).getY_i()){

							h++;
							}
						

						}

						sur_2= points.get(i+h+1).getX_i()-points.get(i).getX_i();
						h=1;

						sur_1= hmax.getY_i();

						res = (res > sur_1 * sur_2) ? res : sur_1 * sur_2;
					}
					
				}
			}
		
		return res;
	}

	public int cote(Point p1,Point p2){
		double xa = p1.getX_i();
		double ya = p1.getY_i();
		double xb = p2.getX_i();
		double yb = p2.getY_i();
		double res =  (Math.sqrt(Math.pow((xb-xa),2) + Math.pow((yb-ya),2)));
		return (int)res;
	}

	public int div_pour(){
		int hmin = this.points.get(2).getY_i();
		int index = -1;
		for(int i = 0; i<this.nbPoint ; i++){
			if (hmin >= this.points.get(i).getY_i()){
				hmin = this.points.get(i).getY_i();
				index = i;

			}
		}
		List<List<Point>> div = new ArrayList<>();
		div = div(points,index);
		double res  = Math.max(surface(div.get(0)),surface(div.get(1)));
		return (int) res;

	}

	public List<List<Point>> div(List<Point> points,int ind){
		List<List<Point>> res = new ArrayList<>();
		List<Point> p1 = new ArrayList<Point>();
		List<Point> p2 = new ArrayList<Point>();
		for (int i =0; i <ind; i++){
				p1.add(points.get(i));

		}
		for (int i =ind;i < points.size() ;i++ ) {
			p2.add(points.get(i));
		}
		res.add(p1);
		res.add(p2);

		return res;
	}
		

	public int calc_air(Point p1,Point p2, Point p3){
		int l1,l2;
		l1 = cote(p1,p2);
		l2 = cote(p1,p3);
		return l1*l2; 
	}

	public void add(Point p) {
		this.points.add(p);
	}

	// GETTER AND SETTER
	/**
	 * @return the oordonnées
	 */
	public int getOordonnées() {
		return largeur;
	}

	/**
	 * @param oordonnées the oordonnées to set
	 */
	public void setOordonnées(int oordonnées) {
		this.largeur = oordonnées;
	}

	/**
	 * @return the abscisse
	 */
	public int getAbscisse() {
		return hauteur;
	}

	/**
	 * @param abscisse the abscisse to set
	 */
	public void setAbscisse(int abscisse) {
		this.hauteur = abscisse;
	}

	/**
	 * @return the nbPoint
	 */
	public int getNbPoint() {
		return nbPoint;
	}

	/**
	 * @param nbPoint the nbPoint to set
	 */
	public void setNbPoint(int nbPoint) {
		this.nbPoint = nbPoint;
	}

	/**
	 * @return the points
	 */
	public List<Point> getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
