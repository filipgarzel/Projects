public class Silnik extends Komponent{
    private int maxObroty;
    private int obroty;
    private boolean stan;

    Silnik(String x, int y, int z, int maxObroty){
        super(x, y, z);
        this.maxObroty= maxObroty;
        this.stan = false;
    }
    public void zatrzymaj(){
        this.obroty=0;
        this.stan = false;

    }
    public void uruchom(){
        this.obroty=800;
        this.stan = true;

    }
    public void zwiekszObroty(){
        if (stan == true){
            if(this.maxObroty-this.obroty>=1000){
                this.obroty+=1000;
            }
            else{
                this.obroty=maxObroty;
            }
        }

    }
    public void zmniejszObroty(){
        if(stan == true){
            if(this.obroty-800>=1000){
                this.obroty-=1000;
            }
            else{
                this.obroty=800;
            }
        }

    }
    public int getAktObroty(){
        return this.obroty;
    }
    public int getMaxObroty(){
        return this.maxObroty;
    }

    public boolean getStan(){
        return stan;
    }

    public void setAktObroty(int obr){
        this.obroty=obr;
    }
}
