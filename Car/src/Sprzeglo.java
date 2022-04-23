public class Sprzeglo extends Komponent{
    public Sprzeglo(String x, int y,int z) {
        super(x, y, z);
    }
    private boolean stanSprzegla=false;
    public void wcisnij(){
        this.stanSprzegla=true;
    }
    public void zwolnij(){
        this.stanSprzegla=false;
    }

    public boolean getStanSprzegla(){
        return this.stanSprzegla;

    }
    public String getCzyWciśnięte(){
        String t = "wciśnięto";
        String n = "puszczono";
        if (this.stanSprzegla==true){
            return t;
        }
        else{
            return n;
        }
    }

}
