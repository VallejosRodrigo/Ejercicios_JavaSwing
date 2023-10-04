import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameCheckBoxRadioButton extends JFrame
{
    int tipo = 0;
    int tamanio = 2;
    PanelCheckBox panelCheckBox = new PanelCheckBox();
    PanelRadioButton panelRadioButton = new PanelRadioButton();

    JLabel texto = new JLabel("Texto de ejemplo :D");

    public FrameCheckBoxRadioButton(){

        iniciar();

    }

    private void iniciar(){

        setBounds(600,300,500,300);

        addWindowListener(new EventoCierreVentana());

        setLayout(new BorderLayout());

        addTexto(); //funcion propia creada abajo

        add(panelCheckBox,BorderLayout.SOUTH);

        add(panelRadioButton,BorderLayout.NORTH);

        setVisible(true);
    }

    private void addTexto(){
        texto.setHorizontalAlignment(SwingConstants.CENTER); //para centrar el texto de forma horizontal

        Font font = new Font("Arial",Font.PLAIN,24);

        texto.setFont(font);

        add(texto,BorderLayout.CENTER); //para colocar el texto en el centro del BorderLayout
    }

    private class PanelCheckBox extends JPanel{

        JCheckBox negrita = new JCheckBox("Negrita",false);
        JCheckBox cursiva = new JCheckBox("Cursiva", false);
        EventoCheckBox eventoCheckBox = new EventoCheckBox();

        public PanelCheckBox(){
            negrita.addActionListener(eventoCheckBox);
            cursiva.addActionListener(eventoCheckBox);

            add(negrita);
            add(cursiva);

        }

        private class EventoCheckBox implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tipo = 0;

                if(negrita.isSelected())
                    tipo+= Font.BOLD;
                if(cursiva.isSelected())
                    tipo+= Font.ITALIC;


                if(tamanio == 1)
                    texto.setFont(new Font("Arial", tipo, 18));
                else if(tamanio == 2)
                    texto.setFont(new Font("Arial", tipo, 24));
                else if(tamanio == 3)
                    texto.setFont(new Font("Arial", tipo, 30));
                else if(tamanio == 4)
                    texto.setFont(new Font("Arial", tipo, 38));

            }
        }

    }

    private class EventoCierreVentana extends WindowAdapter
    {

        public void windowClosing(WindowEvent e)
        {
            FrameTest.ventanaCheckBoxRadioBAbierta = false;
        }

    }

    private class PanelRadioButton extends JPanel{

        JRadioButton chico = new JRadioButton("Chico",false),
                mediano = new JRadioButton("Mediano",true),
                grande = new JRadioButton("Grande",false),
                muyGrande = new JRadioButton("Muy Grande",false);
        ButtonGroup buttonGroup = new ButtonGroup();

        EventoRadioButton eventoRadioButton = new EventoRadioButton();

        public PanelRadioButton(){
            buttonGroup.add(chico);    //se agrega al ButtonGroup para que cumpla la funcion de solo
            buttonGroup.add(mediano);   // seleccionar uno a la vez
            buttonGroup.add(grande);
            buttonGroup.add(muyGrande);

            chico.addActionListener(eventoRadioButton);
            mediano.addActionListener(eventoRadioButton);
            grande.addActionListener(eventoRadioButton);
            muyGrande.addActionListener(eventoRadioButton);

            add(chico);
            add(mediano);
            add(grande);
            add(muyGrande);
        }

        private class EventoRadioButton implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() == chico)
                {
                    texto.setFont(new Font("Arial", tipo, 18));
                    tamanio = 1;
                }
                else if(e.getSource() == mediano)
                {
                    texto.setFont(new Font("Arial", tipo, 24));
                    tamanio = 2;
                }
                else if(e.getSource() == grande)
                {
                    texto.setFont(new Font("Arial", tipo, 30));
                    tamanio = 3;
                }
                else if(e.getSource() == muyGrande)
                {
                    texto.setFont(new Font("Arial", tipo, 38));
                    tamanio = 4;
                }

            }
        }

    }

}
