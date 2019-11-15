import java.awt.* ; //BorderLayout  //GridLayout  //Component
import java.awt.Window ; //setVisible

import javax.swing.* ; //JFrame : getContentPane()  //

// - - -

public class CalendrierExe extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                initComponents() ;
            }
        }
        ) ;

    }


    public static void initComponents() {
    JFrame linterface = new JFrame("Un joli calendrier") ;
    Calendrier leCal = new Calendrier() ;

    linterface.setVisible(true) ;
    linterface.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
    linterface.add(leCal) ;
    linterface.pack() ;
    }


}
