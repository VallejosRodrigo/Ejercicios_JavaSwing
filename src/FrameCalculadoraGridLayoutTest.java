import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FrameCalculadoraGridLayoutTest extends JFrame
{
    FrameCalculadoraGridLayoutTest frameCalculadoraGridLayoutTest;
    private JButton botonPantalla;
    private Boolean principio = true;

    private double acumuladorNumerosClaculadora = 0;


    private double resultado = 0;
    private String ultimaOperacion;



    public FrameCalculadoraGridLayoutTest()
    {

        setBounds(800, 25, 250, 350);
        setTitle("Calculadora - Test GridLayout");

        PanelDisplay panelDisplay = new PanelDisplay();
        add(panelDisplay);


        addWindowListener(new EventoCierreVentana());

        setVisible(true);


    }

    private class PanelNumeroCalculadora extends JPanel
    {


        public PanelNumeroCalculadora()
        {

            GridLayout gridLayout = new GridLayout(5, 4);
            setLayout(gridLayout);

            EventoCalculos eventoCalculos = new EventoCalculos();
            EventoBotonCalculadoraNumeros eventoBotonCalculadoraNumeros = new EventoBotonCalculadoraNumeros();

            add(cargarBotones("", eventoBotonCalculadoraNumeros));
            add(cargarBotones("", eventoBotonCalculadoraNumeros));
            add(cargarBotones("", eventoBotonCalculadoraNumeros));
            add(cargarBotones("C", eventoCalculos)).setBackground(new Color(236, 70, 70));
            add(cargarBotones("7", eventoBotonCalculadoraNumeros));
            add(cargarBotones("8", eventoBotonCalculadoraNumeros));
            add(cargarBotones("9", eventoBotonCalculadoraNumeros));
            add(cargarBotones("/", eventoCalculos));
            add(cargarBotones("4", eventoBotonCalculadoraNumeros));
            add(cargarBotones("5", eventoBotonCalculadoraNumeros));
            add(cargarBotones("6", eventoBotonCalculadoraNumeros));
            add(cargarBotones("x", eventoCalculos));
            add(cargarBotones("1", eventoBotonCalculadoraNumeros));
            add(cargarBotones("2", eventoBotonCalculadoraNumeros));
            add(cargarBotones("3", eventoBotonCalculadoraNumeros));
            add(cargarBotones("-", eventoCalculos));
            add(cargarBotones(",", eventoBotonCalculadoraNumeros));
            add(cargarBotones("0", eventoBotonCalculadoraNumeros));
            add(cargarBotones("=", eventoCalculos)).setBackground(new Color(122, 159, 245));
            add(cargarBotones("+", eventoCalculos));

            ultimaOperacion = "=";

        }

        private JButton cargarBotones(String texto, ActionListener listener)
        {
            JButton boton = new JButton(texto);
            boton.addActionListener(listener);
            return boton;
        }

        private class EventoBotonCalculadoraNumeros implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String txtBoton = e.getActionCommand(); //guarda en variable txtBoton el valor del texto del boton cual trae el evento

                if(principio)
                {
                    botonPantalla.setText("");
                    principio = false;
                }
                botonPantalla.setText(botonPantalla.getText() + txtBoton);



             //   acumuladoGuardado1 = Double.parseDouble(botonPantalla.getText());
            //    System.out.println(acumuladoGuardado1);

            }
        }

        private class EventoCalculos implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                principio = true;
                String operacion = e.getActionCommand();
                calcular(Double.parseDouble(botonPantalla.getText()));
                ultimaOperacion = operacion;





          /*      botonPantalla.setText("0");
                acumuladorSuma = acumuladorSuma + acumuladoGuardado1;
                acumuladoGuardado1 = 0;

                if(Objects.equals("+")){
                    botonPantalla.setText(""+acumuladorSuma);
                    acumuladorSuma = 0;
                    acumuladoGuardado1 = 0; }*/


            }

            public void calcular(double x)
            {
                    switch (ultimaOperacion)
                    {
                        case "C" -> resultado = 0;
                        case "+" -> resultado += x;
                        case "-" -> resultado -= x;
                        case "x" -> resultado *= x;
                        case "/" -> resultado /= x;
                        case "=" -> resultado = x;
                    }
                    botonPantalla.setText(""+resultado);
            }

        }



    }
        private class EventoCierreVentana extends WindowAdapter
        {

            public void windowClosing(WindowEvent e)
            {
                FrameTest.ventanaCalculadoraAbierta = false;
            }

        }

        private class PanelDisplay extends JPanel
        {

            public PanelDisplay()
            {

                setLayout(new BorderLayout());
                botonPantalla = new JButton("0");
                botonPantalla.setEnabled(false); //deja desactivado el boton, solamente muestra texto
                add(botonPantalla, BorderLayout.NORTH); //ubicamos el boton pantalla en el norte
                add(new PanelNumeroCalculadora(), BorderLayout.CENTER); //y el GridLayout con los numero en el centro

            }

        }

    }
