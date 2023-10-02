import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class FrameInterfaceEmailPass extends JFrame
{

    public FrameInterfaceEmailPass(){
        start();
    }

    private void start(){
       setBounds(25,350,450,250);
       setTitle("Usuario y contraseña TEST");

       addWindowListener(new EvemtClosing());

       PanelMain panelMain = new PanelMain();

       add(panelMain);
       setVisible(true);

    }

    private class PanelMain extends JPanel{

        JButton buttonSendAll;
        PanelUsserPass panelUsserPass = new PanelUsserPass();
        boolean comprobacionArroba, comprobacionPunto;


        public PanelMain(){
            setLayout(new BorderLayout());
            add(buttonSendAll = new JButton("Enviar"), BorderLayout.SOUTH);

            add(panelUsserPass,BorderLayout.NORTH);


        }

        private class PanelUsserPass extends JPanel{

            JButton buttonTestUsser, buttonTestPass;
            JTextField tbxUsser;
            JPasswordField tbxPassword;
            JLabel labelUseser, labelPass, labelInfoPass = new JLabel(""), labelInfoUsser = new JLabel("");


            public PanelUsserPass(){
                setLayout(new GridLayout(4,2));

                add(labelUseser = new JLabel("Usuario:"));
                add(tbxUsser = new JTextField());
                tbxUsser.getDocument().addDocumentListener(new EventInUsserPass());
                add(new JLabel()); //para completar espacio del Grid
                add(labelInfoUsser, new EventInUsserPass());

                add(labelPass = new JLabel("Contraseña:"));
                add(tbxPassword = new JPasswordField());
                tbxPassword.getDocument().addDocumentListener(new EventInUsserPass());
                add(new JLabel("")); //para completar espacio del Grid

                add(labelInfoPass, new EventInUsserPass());

            }

            private class EventInUsserPass implements DocumentListener{
                @Override
                public void insertUpdate(DocumentEvent e)
                {
                    if(e.getDocument() == tbxUsser.getDocument())
                        verificarUsser();

                    else if(e.getDocument() == tbxPassword.getDocument())
                        verificarPass();

                }

                @Override
                public void removeUpdate(DocumentEvent e)
                {
                    if(e.getDocument() == tbxUsser.getDocument())
                        verificarUsser();

                    else if(e.getDocument() == tbxPassword.getDocument())
                        verificarPass();

                }

                @Override
                public void changedUpdate(DocumentEvent e)
                {

                }

                private void verificarUsser(){
                    String usuarioInsertado = tbxUsser.getText();
                    int longitud = usuarioInsertado.length();

                    for(int i=0; i<longitud; i++){
                        char caracter = usuarioInsertado.charAt(i);

                        if(usuarioInsertado.charAt(i) == '@')
                            comprobacionArroba = true;

                        if(usuarioInsertado.charAt(i) == '.')
                            comprobacionPunto = true;

                    }

                    if(!Objects.equals(tbxUsser.getText(),"")){
                        if(comprobacionArroba && comprobacionPunto){
                            labelInfoUsser.setText("Email Correcto!");
                            comprobacionArroba = false;
                            comprobacionPunto = false;

                        }else
                            labelInfoUsser.setText("Email Incorrecto");

                    }else
                        labelInfoUsser.setText("");

                }

                private void verificarPass(){
                    char[] password = tbxPassword.getPassword();

                    if(password.length>0){
                        if(password.length <8 || password.length>12){
                            tbxPassword.setBackground(Color.red.brighter().brighter().brighter().brighter());
                            labelInfoPass.setText("Debe ingresar entre 8 y 12 caracteres");

                        }else {
                            tbxPassword.setBackground(Color.white);
                            labelInfoPass.setText("");
                        }
                    }else{
                        labelInfoPass.setText("");
                        tbxPassword.setBackground(Color.white);
                    }


                }



            }

        }


    }


private class EvemtClosing extends WindowAdapter{

        public void windowClosing(WindowEvent e){
            FrameTest.ventanaEmailPass = false;
        }
}

}
