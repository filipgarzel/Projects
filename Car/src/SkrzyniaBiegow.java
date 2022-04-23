public class SkrzyniaBiegow extends Komponent {
    Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String x, int y, int z, int iloscBiegow, Sprzeglo sprzeglo){
        super(x, y, z);
        this.iloscBiegow=iloscBiegow;
        this.sprzeglo=sprzeglo;
        this.aktBieg = 0;
    }

    private int aktBieg;
    private int iloscBiegow;
    private double aktPrzelozenie = 0.3;

    public void zwiekszBieg(){
        if(sprzeglo.getStanSprzegla()==true) {
            if (this.aktBieg < this.iloscBiegow) {
                this.aktBieg += 1;
                this.aktPrzelozenie = this.aktPrzelozenie * 1.4;

            }
        }
    }
    public void zmniejszBieg(){
        if(sprzeglo.getStanSprzegla()==true) {
            if (this.aktBieg >= 1) {
                this.aktBieg -= 1;
                this.aktPrzelozenie = this.aktPrzelozenie / 1.4;
            }
        }
    }

    public int getAktBieg() {
        return aktBieg;
    }

    public double getAktPrzelozenie() {
        return aktPrzelozenie;
    }

    public int getIloscBiegow() {
        return iloscBiegow;
    }

    public void setAktualnyBieg(int aktualnyBieg) {
        this.aktBieg = aktualnyBieg;
    }

    public void setAktualnePrzelozenie(double aktualnePrzelozenie) {
        this.aktPrzelozenie = aktualnePrzelozenie;
    }
}
