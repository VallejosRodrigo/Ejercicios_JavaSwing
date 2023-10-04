import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameComboBoxSlider extends JFrame
{
    static JLabel txtTest = new JLabel("Texto de prueba ;)");
    static String txtSeleccionado = "Serif";
    static int tamanioSeleccionado = 14;

    EventClosing eventClosing = new EventClosing();
    public FrameComboBoxSlider(){
        setBounds(750,300,600,300);

        setLayout(new BorderLayout());

        addWindowListener(eventClosing);

        add(new PanelComboBox(),BorderLayout.NORTH);
        add(new PanelComboBox.PanelJSlider(),BorderLayout.SOUTH);

        txtTest.setFont(new Font(txtSeleccionado,Font.PLAIN,tamanioSeleccionado));
        txtTest.setHorizontalAlignment(SwingConstants.CENTER);
        add(txtTest);

        setVisible(true);
    }

    private static class PanelComboBox extends JPanel{
         JComboBox<String> jComboBox = new JComboBox<>();

        public PanelComboBox(){
            jComboBox.addActionListener(new EventoCambioFuente());

            jComboBox.addItem("Serif");
            jComboBox.addItem("Sans-Serif");
            jComboBox.addItem("Monospaced");

            jComboBox.setEditable(true);
            add(jComboBox);
        }

        private class EventoCambioFuente implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                txtTest.setFont(new Font((String)jComboBox.getSelectedItem(),Font.PLAIN, tamanioSeleccionado));
                txtSeleccionado = (String)jComboBox.getSelectedItem();
            }
        }

        private static class PanelJSlider extends JPanel{
            JSlider jSlider = new JSlider(8,50,tamanioSeleccionado);

            public PanelJSlider(){
                jSlider.setMajorTickSpacing(14);
                jSlider.setMinorTickSpacing(1);

                jSlider.setPaintLabels(true);
                jSlider.setPaintTicks(true);
                jSlider.setSnapToTicks(true); //para que se aferre a cada indice y que no quede en el "aire"
                jSlider.setPreferredSize(new Dimension(400,50));

                jSlider.addChangeListener(new EventoJSlider());

                add(jSlider);
            }

            private class EventoJSlider implements ChangeListener{
                @Override
                public void stateChanged(ChangeEvent e)
                {
                    txtTest.setFont(new Font(txtSeleccionado,Font.PLAIN,jSlider.getValue()));
                    tamanioSeleccionado = jSlider.getValue();
                }
            }

        }

    }

    private class EventClosing extends WindowAdapter
    {
        public void windowClosing(WindowEvent e){
            FrameTest.ventanaComboBoxSlider = false;
        }
    }
}
