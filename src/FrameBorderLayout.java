import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FrameBorderLayout extends JFrame
{
    public FrameBorderLayout(){
        setBounds(25,25,450,300);

        setTitle("Frame Test Border Layout");

        PanelBorder panelBorder = new PanelBorder();
        add(panelBorder);

        addWindowListener(new EventoCierreVentanaBorder());

        setVisible(true);


    }

    private class PanelBorder extends JPanel{
        public PanelBorder(){


            setLayout(new BorderLayout());

            add(new JButton("TEST NORTH"),BorderLayout.NORTH);
            add(new JButton("TEST SOUTH"),BorderLayout.SOUTH);
            add(new JButton("TEST WEST"),BorderLayout.WEST);
            add(new JButton("TEST EAST"),BorderLayout.EAST);
            add(new JButton("TEST CENTER"),BorderLayout.CENTER);
        }
    }

    private class EventoCierreVentanaBorder extends WindowAdapter
    {
        public void windowClosing(WindowEvent e){
            FrameTest.ventanaFrameBorderLayout = false;
        }

    }

}
