import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Thread.sleep;

public class SwingGUI extends Thread{
    private JTextField modelSamochodu;
    private JTextField nrRejestracyjny;
    private JTextField wagaSamochodu;
    private JTextField predkosc;
    private JTextField nazwaSkrzynii;
    private JTextField cenaSkrzynii;
    private JTextField wagaSkrzynii;
    private JTextField bieg;
    private JTextField nazwaSilnika;
    private JTextField cenaSilnika;
    private JTextField wagaSilnika;
    private JTextField obroty;
    private JTextField nazwaSprzegla;
    private JTextField cenaSprzegla;
    private JTextField wagaSprzegla;
    private JTextField stanSprzegla;
    private JButton wyłączButton;
    private JButton włączButton;
    private JButton zwiększBiegButton;
    private JButton zmniejszBiegButton;
    private JButton dodajGazuButton;
    private JButton ujmijGazuButton;
    private JButton nacisnijButton;
    private JButton zwolnijButton;
    private JComboBox wybierzSamochod;
    private JButton dodajNowySam;
    private JButton usunSam;
    private JPanel mainPanel;
    private JPanel mapa;
    private JLabel ikona;
    private JTextField suma;
    public int sumasam=0;


    private Samochod samochod;


    public SwingGUI() {
        start();
        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.wlacz();
                System.out.println("Włączono samochód");
                refresh();
            }
        });
        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.wylacz();
                System.out.println("Wyłączono samochód");
                refresh();
            }
        });
        zwiększBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.skrzynia.zwiekszBieg();
                System.out.println("zwiększono bieg do: " + samochod.skrzynia.getAktBieg());
                refresh();
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.skrzynia.zmniejszBieg();
                System.out.println("zmniejszono bieg do: " + samochod.skrzynia.getAktBieg());
                refresh();
            }
        });
        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.silnik.zwiekszObroty();
                System.out.println("zwiększono obroty do: " + samochod.silnik.getAktObroty());
                refresh();
            }
        });
        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.silnik.zmniejszObroty();
                System.out.println("zmniejszono obroty do: " + samochod.silnik.getAktObroty());
                refresh();
            }
        });
        nacisnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.skrzynia.sprzeglo.wcisnij();
                System.out.println("naciśnięto sprzęgło");
                refresh();
            }
        });
        zwolnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.skrzynia.sprzeglo.zwolnij();
                System.out.println("zwolniono sprzęgło");
                refresh();
            }
        });
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (samochod.getstanWlaczenia()) {
                    samochod.jedzDo(e.getX(), e.getY());
                }
            }
        });
        dodajNowySam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowySamochodGUI(wybierzSamochod);
                f.pack();
                f.setVisible(true);
            }
        });

        usunSam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.interrupt();
                wybierzSamochod.removeItem(samochod);

            }
        });
        wybierzSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod = (Samochod) wybierzSamochod.getSelectedItem();
            }
        });
    }
    private void policzwage(){
       int size = wybierzSamochod.getItemCount();
       int waga=0;
       if(size==0){
           suma.setText("0");
       }
       else{
           for(int i=0; i<size; i++){
               Samochod kolejny=(Samochod) wybierzSamochod.getItemAt(i);
               waga+=kolejny.getWaga();
           }
           suma.setText(Integer.toString(waga));
       }

    }



    public void refresh() {
        if(samochod!=null){
            modelSamochodu.setText(samochod.getNazwa());
            nrRejestracyjny.setText(samochod.getNrRejestracyjny());
            wagaSamochodu.setText(Integer.toString(samochod.getWaga()));
            predkosc.setText(Double.toString(samochod.getAktPredkosc()));
            nazwaSkrzynii.setText(samochod.skrzynia.getNazwa());
            cenaSkrzynii.setText(Integer.toString(samochod.skrzynia.getCena()));
            wagaSkrzynii.setText(Integer.toString(samochod.skrzynia.getWaga()));
            bieg.setText(Integer.toString(samochod.skrzynia.getAktBieg()));
            nazwaSilnika.setText(samochod.silnik.getNazwa());
            cenaSilnika.setText(Integer.toString(samochod.silnik.getCena()));
            wagaSilnika.setText(Integer.toString(samochod.silnik.getWaga()));
            obroty.setText(Integer.toString(samochod.silnik.getAktObroty()));
            nazwaSprzegla.setText(samochod.skrzynia.sprzeglo.getNazwa());
            cenaSprzegla.setText(Integer.toString(samochod.skrzynia.sprzeglo.getCena()));
            wagaSprzegla.setText(Integer.toString(samochod.skrzynia.sprzeglo.getWaga()));
            stanSprzegla.setText(samochod.skrzynia.sprzeglo.getCzyWciśnięte());
            ikona.setLocation((int) samochod.getAktPozycja().getX(), (int) samochod.getAktPozycja().getY());
            policzwage();
        }
    }
    public void cleartxt(){
        modelSamochodu.setText("");
        nrRejestracyjny.setText("");
        wagaSamochodu.setText("");
        predkosc.setText("");
        nazwaSkrzynii.setText("");
        cenaSkrzynii.setText("");
        wagaSkrzynii.setText("");
        bieg.setText("");
        nazwaSilnika.setText("");
        cenaSilnika.setText("");
        wagaSilnika.setText("");
        obroty.setText("");
        nazwaSprzegla.setText("");
        cenaSprzegla.setText("");
        wagaSprzegla.setText("");
        stanSprzegla.setText("");
    }
    public void run() {
        while(true) {
            if(samochod!=null){
                refresh();
            }
           else{
               cleartxt();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SwingGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}

