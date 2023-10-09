import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class FrameSpinner extends JFrame //en esta clase vamos a evitar el principio de modularización y hacer todo en una sola clase
{
    JPanel panelSpinner = new JPanel();
    JSpinner jSpinnerNumeros, jSpinnerFechas;
    JTextArea textArea = new JTextArea("");
    JLabel label2 = new JLabel("Ingrese su numero de grupo y fecha de nacimiento: ");
    JButton jButton = new JButton("Registrarse");
    int getNumero;
    Date getFecha;
    JScrollPane jScrollPane;

    public FrameSpinner()
    {
        iniciarFrame();
        iniciarComponentes();


        this.setVisible(true);
    }

    private void iniciarComponentes(){

        jButton.setBackground(Color.GREEN.darker().darker());
        jButton.setForeground(Color.BLACK);




        panelSpinner.setLayout(new BorderLayout());

        jSpinnerNumeros = new JSpinner(new SpinnerNumberModel(5,0,10,1));
        jSpinnerFechas = new JSpinner(new SpinnerDateModel());

        jSpinnerNumeros.setToolTipText("xD");


        JFormattedTextField textField = ((JSpinner.DefaultEditor) jSpinnerNumeros.getEditor()).getTextField(); //para quitar edicion
        textField.setEditable(false);


        textArea.setEditable(false);
        jScrollPane = new JScrollPane(textArea);

        jButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                getNumero = (int)jSpinnerNumeros.getValue();
                getFecha = (Date)jSpinnerFechas.getValue();


                textArea.setText(textArea.getText()+"Grupo: |" + getNumero + "| Nacimiento: " + getFecha+"\n");
            }
        });

        panelSpinner.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(); //para poder editar las proporciones del GridBagLayout

        constraints.weightx = 2.0;
        panelSpinner.add(label2,constraints);
        constraints.weightx = 1.0;
        panelSpinner.add(jSpinnerNumeros,constraints);
        constraints.weightx = 1.0;
        panelSpinner.add(jSpinnerFechas,constraints);
        constraints.weightx = 1.0;
        panelSpinner.add(jButton,constraints);

        this.add(panelSpinner,BorderLayout.NORTH);
        this.add(jScrollPane,BorderLayout.CENTER);

    }

    private void iniciarFrame(){

        this.setBounds(359,40,600,300);
        this.setTitle("Ventana ejemplo control JSpinner");
        setLayout(new BorderLayout());

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                FrameTest.ventanaSpinner = false;
            }
        });

    }
}
