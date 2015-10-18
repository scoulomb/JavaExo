// Modified from http://zetcode.com/tutorials/javaswingtutorial/basicswingcomponents/

import static javax.swing.GroupLayout.Alignment.BASELINE;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ComboBoxEx extends JFrame
        implements ItemListener {

    private JTextArea display;
    private JComboBox<String> box;
    private String[] studentName;
    private GroupeEleve g; 

    public ComboBoxEx() {

        initUI();

        setTitle("JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {
    	
        g = new GroupeEleve();
        g.fillFromFile("src/eleves.txt");
        studentName = new String[6];
        int i = 0;
       
        studentName[i] = "Choose a student";
        ++i;
        
    	ArrayList<Eleve> eleves = g.getEleves();        
        for(Eleve e : eleves){
        	studentName[i] = e.getNom();
        	++i;
        }
        
        
        box = new JComboBox<>(studentName);
        box.addItemListener(this);

        display = new JTextArea("Select a student");
        display.setVisible(false);
        
        createLayout(box, display);
    }

    private void createLayout(JComponent... arg) {
        
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);        

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createParallelGroup(BASELINE)
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        setPreferredSize( new Dimension( 640, 640 ) );

        pack();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    	    	
        if (e.getStateChange() == ItemEvent.SELECTED) {
        	
        	try {        	
        		Eleve eleve = g.getEleveByName(e.getItem().toString());
        		display.setVisible(true);
              	if(eleve.hasUEBelow10()) {
            		display.setBackground(new Color(250, 72, 60));
            	} else {
            		display.setBackground(new Color(118, 245, 127));
            	}
            	
                display.setText(eleve.toSwingString());
        	} catch(Error error) {
        		display.setBackground(Color.gray);
        		display.setText("Select a student");
        		display.setVisible(false);
        	}
        	
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComboBoxEx ex = new ComboBoxEx();
                ex.setVisible(true);
            }
        });
    }
}