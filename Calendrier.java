import java.util.* ; //Calendar  //Locale

import javax.swing.* ; //JLabel  //

// _-_-_

public class Calendrier extends JPanel {
    private int lAnnee ;
    private int leMois ;
    private int leJour ;
    // private String leNomDuJour ;  //DAY_OF_MONTH



    public Calendrier() {
        Calendar leCalendrier = Calendar.getInstance(Locale.FRANCE) ;
        this.lAnnee = leCalendrier.get(Calendar.YEAR) ;
        JLabel leLabelYear = new JLabel(String.valueOf(lAnnee)) ; // ou : new Integer.toString(year)
    }

    public int getYear() { return this.lAnnee ; }
    public JLabel retLabelYear() { return new JLabel(Integer.toString(getYear())) ; }

}
