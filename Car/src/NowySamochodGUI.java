import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NowySamochodGUI extends JFrame{
    private JPanel panel1;
    private JTextField nrRejestracyjny;
    private JTextField Model;
    private JTextField Marka;
    private JTextField Vmax;
    private JRadioButton a5BiegowaManualnaRadioButton;
    private JRadioButton a7BiegowaManualnaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton benzynaRadioButton;
    private JButton Dodaj;
    private JButton Anuluj;
    String NazwaSilnika;
    int wagaSilnika;
    int cena;
    int maxObroty;
    String NazwaSkrzyni;
    int wagaSkrzyni;
    int cenask;
    int LiczbaBiegow;
    int sumawag=0;
    Samochod samochod;

    public boolean formularz() {
        try {
            Integer.parseInt(Vmax.getText());
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
            return true;
    }



    public NowySamochodGUI(JComboBox<Samochod> comboBox){
        setContentPane(panel1);
        ButtonGroup SilnikGroup = new ButtonGroup();
        SilnikGroup.add(benzynaRadioButton);
        SilnikGroup.add(dieselRadioButton);

        ButtonGroup SkrzyniaGroup = new ButtonGroup();
        SkrzyniaGroup.add(a5BiegowaManualnaRadioButton);
        SkrzyniaGroup.add(a7BiegowaManualnaRadioButton);
        Dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(formularz()){
                    if (benzynaRadioButton.isSelected()){
                        NazwaSilnika = "benzyna";
                        wagaSilnika = 300;
                        cena = 3000;
                        maxObroty = 7000;
                    }
                    else if(dieselRadioButton.isSelected()){
                        NazwaSilnika = "diesel";
                        wagaSilnika = 250;
                        cena = 2000;
                        maxObroty = 5000;
                    }

                    if (a5BiegowaManualnaRadioButton.isSelected()){
                        NazwaSkrzyni = "5 biegow";
                        wagaSkrzyni = 80;
                        cenask = 500;
                        LiczbaBiegow = 5;
                    }
                    else if(a7BiegowaManualnaRadioButton.isSelected()){
                        NazwaSkrzyni = "7 biegow";
                        wagaSkrzyni = 130;
                        cenask = 900;
                        LiczbaBiegow = 7;
                    }

                    Sprzeglo spr = new Sprzeglo("nowe", 300, 50);
                    SkrzyniaBiegow skr = new SkrzyniaBiegow(NazwaSkrzyni, cenask, wagaSkrzyni, LiczbaBiegow, spr);
                    Silnik sil = new Silnik(NazwaSilnika, cena, wagaSilnika, maxObroty);
                    Pozycja poz = new Pozycja(0, 0);
                    Samochod sam = new Samochod(skr, poz, sil, nrRejestracyjny.getText(), Model.getText(), Integer.parseInt(Vmax.getText()));
                    comboBox.addItem(sam);
                }
                else{
                    System.out.println("wpisz liczbę jako prędkość maksymalną");
                }
            }


        });
        Anuluj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

