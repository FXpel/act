
public class Pion {
	private int x;
	private int y;
	private String couleur;

	public Pion(int x, int y, String c) {
		this.x = x;
		this.y = y;
		this.couleur = c;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}
