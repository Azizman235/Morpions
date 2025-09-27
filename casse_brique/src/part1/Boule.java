package part1;
public class Boule{
	public void setVd(int vd) {
		this.vd = vd;
	}
	public void setVg(int vg) {
		this.vg = vg;
	}
	public int getVd() {
		return vd;
	}
	public int getVg() {
		return vg;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	private int x;
	private int y;
	private int rayon;
	private int vd;
	private int vg;
	
	public Boule(int x, int y, int rayon) {
		super();
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		this.vd=1;
		this.vg=1;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	void deplacer(){
		++this.x;
		++this.y;
	}
	
}