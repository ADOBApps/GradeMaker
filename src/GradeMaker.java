/**
 * Simple class to receive and calculate
 * grade avarage
 * date: 24/07/2022
 * @author [Acxel Orozco (ADOB Apps)]
 * 
 */

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.*;

//re-use our class made at CheckMake
import mycontrollers.MyVerifier;

class GradeMaker implements ActionListener{

	//Declare UI and IO elements
	Border btitle1, btitle2, btitle3;
	Container contentPane;
	GridBagConstraints gbctts;
	JButton jb_calc, jb_del;
	JFrame frame1;
	JLabel jl_g1, jl_g2, jl_g3;
	JPanel jp_math, jp_es, jp_en, jp_control;
	JTextField jtf_g_m1, jtf_g_m2, jtf_g_m3;
	JTextField jtf_g_es1, jtf_g_es2, jtf_g_es3;
	JTextField jtf_g_en1, jtf_g_en2, jtf_g_en3 

	//Constructor function
	public GradeMaker(){

		//Define border with title for each JPanel
		btitle1 = BorderFactory.createTitledBorder("Matematicas");
		btitle2 = BorderFactory.createTitledBorder("Español");
		btitle3 = BorderFactory.createTitledBorder("Ingles");

		//Create a Layout dimension manager
		gbctts = new GridBagConstraints();

		//button calculate average
		jb_calc = new JButton("Promedio");
		//Listener 
		jb_calc.addActionListener(this);
		//Button to clean JTextFields
		jb_del = new JButton("Borrar todo");
		//Listener
		jb_del.addActionListener(this);

		//Define JFrame
		frame1 = new JFrame();
		frame1.setTitle("Generador de promedios");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Define JFrame's content manager
		contentPane = frame1.getContentPane();
	}

	//main function
	public static void main (String arg[]){
		GradeMaker gm = new GradeMaker();
	}

	//Control button's action 
	//using interface ActionListener
	public void actionPerformed(ActionEvent ae){}
}