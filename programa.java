import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NumerosGUI extends JFrame implements ActionListener {
    private JLabel label1, label2;
    private final JButton button1;
    private final JButton button2;
    private Timer timer1, timer2;
    private int count1 = 1, count2 = 1;
    
    public NumerosGUI() {
        setTitle("Numeros");
        setLayout(new FlowLayout());
        
        label1 = new JLabel(" ");
        label2 = new JLabel(" ");
        add(label1);
        add(label2);
        
        button1 = new JButton("Iniciar Boton 1");
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("Iniciar Boton 2");
        button2.addActionListener(this);
        add(button2);
        
        timer1 = new Timer(1000, (ActionEvent e) -> {
            if (count1 <= 10) {
                label1.setText(Integer.toString(count1));
                count1++;
            } else {
                timer1.stop();
            }
        });
        
        timer2 = new Timer(1000, (ActionEvent e) -> {
            if (count2 <= 10) {
                label2.setText(Integer.toString(count2));
                count2++;
            } else {
                timer2.stop();
            }
        });
        
        setSize(300, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            timer1.start();
        } else if (e.getSource() == button2) {
            timer2.start();
        }
    }
    
    public static void main(String[] args) {
        NumerosGUI numerosGUI = new NumerosGUI();
    }
}