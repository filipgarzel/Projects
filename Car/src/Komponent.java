public class Komponent {
    private String nazwa;
    private int waga;
    private int cena;

    public Komponent(String x,int y, int z ){
        this.nazwa = x;
        this.cena = y;
        this.waga = z;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getWaga() {
        return waga;
    }

    public int getCena() {
        return cena;
    }

    public void setNazwa(String name){
        this.nazwa=name;
    }
    public void setWaga(int weight){
        this.waga=weight;
    }


}


