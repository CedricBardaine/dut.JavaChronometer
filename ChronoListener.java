import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

import javax.swing.JButton ;
import javax.swing.JRadioButton ;
import javax.swing.JTextField ;
import javax.swing.Timer ;

public class ChronoListener implements ActionListener {
    private Chrono chrono ;
    private long time ;
    private Timer timer ;
    private int accel = 1 ;
    private boolean started ;
    private boolean isChrono = true ;


    public ChronoListener(Chrono paramChrono) {
        this.chrono = paramChrono ;
        this.timer = new Timer(1000, this) ;
    }


    public void actionPerformed(ActionEvent paramActionEvent) {
        Object localObject = paramActionEvent.getSource() ;

        if ( localObject == this.chrono.getStartStopButton() ) {
            if (this.started == true) { stopChrono() ; }
            else { startChrono() ; }
        }
        else if (localObject == this.chrono.getResetButton())           { resetChrono() ; }
        else if (localObject == this.timer)                             { tic() ; }
        else if (   (localObject == this.chrono.getChronoButton()) ||
                    (localObject == this.chrono.getTimerButton())  )    { changeMode() ; }
    }


    private void changeMode()
    {
        this.isChrono = this.chrono.getChronoButton().isSelected();
        this.chrono.getTimeField().setEditable(!this.isChrono);
    }

    private void startChrono() {

        this.time = this.chrono.getTime() ;

        if ((this.isChrono) || (this.time > 0L)) {
            this.started = true;
            this.chrono.getStartStopButton().setText("Stop");
            enableComponents();
            this.timer.start();
        }

    }


    private void stopChrono() {
        this.timer.stop() ;
        this.started = false;
        this.chrono.getStartStopButton().setText("Start");
        enableComponents();
    }

    private void resetChrono() {
        this.chrono.setTime(0L) ;
    }

    private void tic() {
        if (this.isChrono) { this.time += 1000L ; } //the L makes the number a long type and so the multiplication has a long as a result
        else {
            this.time -= 1000L ;
            if (this.time <= 0L) { stopChrono() ; }
        }

        this.chrono.setTime(this.time);
    }

    private void enableComponents() {
        this.chrono.getResetButton().setEnabled(!this.started);
        this.chrono.getChronoButton().setEnabled(!this.started);
        this.chrono.getTimerButton().setEnabled(!this.started);
        this.chrono.getTimeField().setEditable((!this.started) && (!this.isChrono));
    }
}
