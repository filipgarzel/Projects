public class Samochod extends Thread{
    public SkrzyniaBiegow skrzynia;
    public Pozycja aktPozycja;
    public Silnik silnik;
    private boolean stanWlaczenia;
    private String nrRejestracyjny;
    private String model;
    private int predkoscMax;
    private Pozycja cel;
    private int obwKoła = 70;
    private double dt = 0.01;

    Samochod(SkrzyniaBiegow skrzynia, Pozycja pozycja, Silnik silnik, String nrRejestracyjny, String model, int predkoscMax) {
        this.skrzynia = skrzynia;
        this.aktPozycja = pozycja;
        this.silnik = silnik;
        this.nrRejestracyjny = nrRejestracyjny;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.stanWlaczenia = true;
        this.cel = aktPozycja;
        start();
    }

    @Override
    public String toString() {
        return nrRejestracyjny + "  " + model;
    }

    public void wlacz() {
        stanWlaczenia = true;
        silnik.uruchom();;
    }

    public void wylacz() {
        stanWlaczenia = false;
        silnik.zatrzymaj();
        skrzynia.setAktualnyBieg(0);
        skrzynia.setAktualnePrzelozenie(0.3);
    }

    public void jedzDo(double x, double y) {
      this.cel = new Pozycja(x, y);
    }

    public void run(){
        if(stanWlaczenia) {
            while (true) {
                double V = getAktPredkosc();
                aktPozycja.przenies(V, this.dt, this.cel);
                System.out.printf("(%f, %f)%n", this.aktPozycja.x, this.aktPozycja.y);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
        else
            System.out.println("Najpierw wlacz auto");
    }
    public String getNazwa(){
        return model;
    }
    public String getNrRejestracyjny(){
        return nrRejestracyjny;
    }

    public int getWaga() {
        return skrzynia.getWaga() + skrzynia.sprzeglo.getWaga() + silnik.getWaga() + 1000;
    }

    public double getAktPredkosc() {
        if (stanWlaczenia == true) {
            if(skrzynia.getAktBieg()==0){
                return 0;
            }
            else{
                if(silnik.getAktObroty() * skrzynia.getAktPrzelozenie()* obwKoła/3000<predkoscMax){
                    return silnik.getAktObroty() * skrzynia.getAktPrzelozenie()* obwKoła/3000;
                }
                else{
                    return predkoscMax;
                }

            }
        }
        else{
            return 0;
        }
    }

    public Pozycja getAktPozycja() {
        return this.aktPozycja;
    }
    public boolean getstanWlaczenia() {
        return this.stanWlaczenia;
    }



}
