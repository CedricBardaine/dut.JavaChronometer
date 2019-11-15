import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.TimeZone;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Chrono extends JFrame {

    private static final DateFormat DF = new SimpleDateFormat("mm:ss");

    private JTextField timeField;

    private JButton startStopButton;
    private JButton resetButton;

    private JRadioButton chronoButton;
    private JRadioButton timerButton;

    public Chrono() {
        super("Chronometre");
        setDefaultCloseOperation(3);

        this.timeField = new JTextField();
        this.timeField.setPreferredSize(new Dimension(100, 25));
        this.timeField.setHorizontalAlignment(0);
        this.timeField.setEditable(false);
        setTime(0L);


        JPanel JP1 = new JPanel(new GridLayout(2, 1, 5, 5));

        this.startStopButton = new JButton("start");
        this.resetButton = new JButton("reset");
        this.resetButton.setEnabled(false);

        JP1.add(this.startStopButton);
        JP1.add(this.resetButton);


        JPanel JP2 = new JPanel(new GridLayout(1, 2, 5, 5));
        ButtonGroup localButtonGroup = new ButtonGroup();

        this.chronoButton = new JRadioButton("Chronometre");
        this.timerButton = new JRadioButton("Compte a rebours");

        localButtonGroup.add(this.chronoButton);
        localButtonGroup.add(this.timerButton);

        JP2.add(this.chronoButton);
        JP2.add(this.timerButton);

        this.chronoButton.setSelected(true);


        ChronoListener leChronoListener = new ChronoListener(this);
        this.startStopButton.addActionListener(leChronoListener);
        this.resetButton.addActionListener(leChronoListener);
        this.chronoButton.addActionListener(leChronoListener);
        this.timerButton.addActionListener(leChronoListener);


        setLayout(new BorderLayout(5, 5));
        add(this.timeField, "Center");
        add(JP1, "East");
        add(JP2, "North");
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Chrono leChrono = new Chrono();
                leChrono.pack();
                leChrono.setVisible(true);
            }

        }                           ) ; //fin du SwingUtilisties

    }


    static {
        DF.setTimeZone(TimeZone.getTimeZone("UTC"));
    }



    public void setTime(long paramLong) {
        String time = DF.format(Long.valueOf(paramLong));

        this.timeField.setText(time);
    }


    public long getTime() {

        try {
            String str = this.timeField.getText();
            return DF.parse(str).getTime();
        }
        catch (Exception localException) { setTime(0L); }

        return 0L;
    }


    public JButton getStartStopButton() { return this.startStopButton ; }
    public JButton getResetButton() { return this.resetButton ; }
    public JRadioButton getChronoButton() { return this.chronoButton ; }
    public JRadioButton getTimerButton() { return this.timerButton ; }
    public JTextField getTimeField() { return this.timeField ; }
}
