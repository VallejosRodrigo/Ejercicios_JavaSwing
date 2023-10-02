import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class FrameTextArea extends JFrame
{
   PanelMain panelMain = new PanelMain();
    EventClosing eventClosing = new EventClosing();

    public FrameTextArea(){
        setBounds(300,300,400,400);
        setTitle("Ejemplo Text Area");
        addWindowListener(eventClosing);

        add(panelMain);

        setVisible(true);

    }

    private class PanelMain extends JPanel{

        JButton send;
        JTextArea txtArea;
        public PanelMain(){
            send = new JButton("Enviar");
            txtArea = new JTextArea(5,10);

            JScrollPane jScrollPane = new JScrollPane(txtArea); //agrego el txtArea al scroll pane para usar su propiedad
            txtArea.setLineWrap(true); //para que el txtArea tire saltos de linea

            send.addActionListener(new EventoTxtArea());

            add(send);
            add(jScrollPane); //añadimos el JScroll como componente compuesto
        }

        private class EventoTxtArea implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(txtArea.getText());
            }
        }


    }

    private class EventClosing extends WindowAdapter
    {
        public void windowClosing(WindowEvent e){
            FrameTest.ventanaTextAreaAbierta = false;
        }

    }

}
