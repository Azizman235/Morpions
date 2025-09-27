package part1;

public class Plateforme {
    public void setL(int l) {
        L = l;
    }
    public void setl(int l) {
        this.l = l;
    }
    public int getL() {
        return L;
    }
    public int getl() {
        return l;
    }
    private int L;
	private int l;
    public Plateforme(int L,int l){
        this.L=L;
        this.l=l;
    }
   
}
