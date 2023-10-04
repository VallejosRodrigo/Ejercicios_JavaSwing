import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FrameTest extends JFrame
{

    FrameBorderLayout frameBorderLayout;
    FrameCalculadoraGridLayoutTest frameCalculadoraGridLayoutTest;
    FrameInterfaceEmailPass frameInterfaceEmailPass;
    FrameTextArea frameTextArea;
    FrameCheckBoxRadioButton frameCheckBoxRadioButton;
    FrameComboBoxSlider frameComboBoxSlider;

    static Boolean ventanaCalculadoraAbierta = false,
            ventanaFrameBorderLayout = false,
            ventanaEmailPass = false,
            ventanaTextAreaAbierta = false,
            ventanaCheckBoxRadioBAbierta = false,
            ventanaComboBoxSlider = false;

    FrameTest(){
        start();
    }

    protected void start(){

        setBounds(300,200,600,350);

        setTitle("Test Layout");

        PanelButton panelButton = new PanelButton();

        add(panelButton);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }

    private class PanelButton extends JPanel{
        JButton buttonGoTextAreaTest = new JButton("Abrir TEST TEXT AREA");
        JButton buttonGoBorderPanel = new JButton("Abrir panel Border");
        JButton buttonGoCalculadoraGridLayoutPanel = new JButton("Abrir Calculadora");
        JButton buttonGoInterfaceEmailPass = new JButton("Abrir Interface Usuario y Contraseña");
        JButton buttonGoCheckBoxRadioB = new JButton("Abrir CheckBox RadioButton");
        JButton buttonAmarillo = new JButton("Amarillo");
        JButton buttonRojo = new JButton("Rojo");
        JButton buttonAzul = new JButton("Azul");
        JButton buttonGoComboBoxSlider = new JButton("Abrir ComboBox JSlider");

        public PanelButton(){

            setLayout(new FlowLayout(FlowLayout.LEFT,20,50)); //cambia la ubicacion del FlowLayout a la izquierda y la separacion en pixeles entre ejes X e Y

            iniciarBotones();

        }


        private void iniciarBotones(){

            buttonGoBorderPanel.addActionListener(new EventoAbrirPanel());
            buttonGoCalculadoraGridLayoutPanel.addActionListener(new EventoAbrirPanel());
            buttonAmarillo.addActionListener(new EventoAbrirPanel());
            buttonAzul.addActionListener(new EventoAbrirPanel());
            buttonRojo.addActionListener(new EventoAbrirPanel());
            buttonGoInterfaceEmailPass.addActionListener(new EventoAbrirPanel());
            buttonGoTextAreaTest.addActionListener(new EventoAbrirPanel());
            buttonGoCheckBoxRadioB.addActionListener(new EventoAbrirPanel());
            buttonGoComboBoxSlider.addActionListener(new EventoAbrirPanel());

            buttonAmarillo.setBackground(Color.yellow);
            add(buttonAmarillo);

            buttonRojo.setBackground(Color.red);
            add(buttonRojo);

            buttonAzul.setBackground(Color.blue);
            add(buttonAzul);

            add(buttonGoBorderPanel);

            buttonGoCalculadoraGridLayoutPanel.setBackground(Color.CYAN);
            add(buttonGoCalculadoraGridLayoutPanel);

            buttonGoInterfaceEmailPass.setBackground(Color.green);
            add(buttonGoInterfaceEmailPass);

            buttonGoTextAreaTest.setForeground(Color.green);
            buttonGoTextAreaTest.setBackground(Color.BLACK);
            add(buttonGoTextAreaTest);

            buttonGoCheckBoxRadioB.setForeground(Color.MAGENTA.brighter());
            buttonGoCheckBoxRadioB.setBackground(Color.BLACK);
            add(buttonGoCheckBoxRadioB);

            buttonGoComboBoxSlider.setForeground(Color.blue);
            buttonGoComboBoxSlider.setBackground(Color.WHITE);
            add(buttonGoComboBoxSlider);
        }

        private class EventoAbrirPanel implements ActionListener{


            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object evento = e.getSource();

                if(evento == buttonGoCalculadoraGridLayoutPanel){

                    if(!ventanaCalculadoraAbierta){
                        frameCalculadoraGridLayoutTest = new FrameCalculadoraGridLayoutTest();
                        frameCalculadoraGridLayoutTest.setVisible(true);
                        ventanaCalculadoraAbierta = true;
                    }else{
                        // Si la ventana ya está abierta, enfócala (hazla visible si está minimizada)
                        if (frameCalculadoraGridLayoutTest.getState() == JFrame.ICONIFIED)
                            frameCalculadoraGridLayoutTest.setState(JFrame.NORMAL);

                        frameCalculadoraGridLayoutTest.toFront();
                    }



                }else if(evento == buttonGoBorderPanel){

                    if(!ventanaFrameBorderLayout){
                        frameBorderLayout = new FrameBorderLayout();
                        frameBorderLayout.setVisible(true);
                        ventanaFrameBorderLayout = true;
                    }else{

                        if (frameBorderLayout.getState() == JFrame.ICONIFIED)
                            frameBorderLayout.setState(JFrame.NORMAL);

                        frameBorderLayout.toFront();
                    }

                }else if(evento == buttonGoComboBoxSlider){

                    if(!ventanaComboBoxSlider){
                        frameComboBoxSlider = new FrameComboBoxSlider();
                        frameComboBoxSlider.setVisible(true);
                        ventanaComboBoxSlider = true;
                    }else{

                        if (frameComboBoxSlider.getState() == JFrame.ICONIFIED)
                            frameComboBoxSlider.setState(JFrame.NORMAL);

                        frameComboBoxSlider.toFront();
                    }

                }else if(evento == buttonGoCheckBoxRadioB){

                    if(!ventanaCheckBoxRadioBAbierta){
                        frameCheckBoxRadioButton = new FrameCheckBoxRadioButton();
                        frameCheckBoxRadioButton.setVisible(true);
                        ventanaCheckBoxRadioBAbierta = true;
                    }else{

                        if (frameCheckBoxRadioButton.getState() == JFrame.ICONIFIED)
                            frameCheckBoxRadioButton.setState(JFrame.NORMAL);

                        frameCheckBoxRadioButton.toFront();
                    }

                }else if(evento == buttonGoInterfaceEmailPass){
                    if(!ventanaEmailPass){
                        frameInterfaceEmailPass = new FrameInterfaceEmailPass();
                        frameInterfaceEmailPass.setVisible(true);
                        ventanaEmailPass = true;
                    }else {

                        if(frameInterfaceEmailPass.getState() == JFrame.ICONIFIED)
                            frameInterfaceEmailPass.setState(JFrame.NORMAL);

                        frameInterfaceEmailPass.toFront();
                    }

                }else if(evento == buttonGoTextAreaTest){

                    if(!ventanaTextAreaAbierta){
                        frameTextArea = new FrameTextArea();
                        frameTextArea.setVisible(true);
                        ventanaTextAreaAbierta = true;
                    }else{

                        if (frameTextArea.getState() == JFrame.ICONIFIED)
                            frameTextArea.setState(JFrame.NORMAL);

                        frameTextArea.toFront();
                    }

                }

                else if(evento == buttonAmarillo)
                    setBackground(Color.yellow.darker());
                else if(evento == buttonRojo)
                    setBackground(Color.red.darker());
                else if(evento == buttonAzul)
                    setBackground(Color.blue.darker());





            }
        }

    }





}
