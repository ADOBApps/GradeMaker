/**
 * Simple class to receive and calculate
 * grade avarage
 * date: 30/07/2022
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

//import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;

//re-use our class made at CheckMake
import mycontrollers.MyVerifier;
//re-use and to adapted from CheckMake
import mycontrollers.MyChanger;
//Our Signature panel
import myviews.Signature;

class GradeMaker implements ActionListener{

	//Declare UI and IO elements
	Container contentPane;
	GridBagConstraints gbctts;
	JButton jb_calc, jb_del;
	JFrame frame1;
	Signature s_math, s_es, s_en;
	Toolkit tk;
	
	int screenW, screenH;

	//Constructor function
	public GradeMaker(){

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

		//Toolkit
		tk = Toolkit.getDefaultToolkit();
		screenH = tk.getScreenSize().height;
		screenW = tk.getScreenSize().width;

		makeGraph();

	}

	//main function
	public static void main (String arg[]){
		GradeMaker gm = new GradeMaker();
	}

	//create GUI
	private void makeGraph(){
		//Def Signature object
		s_math = new Signature("Matematicas", new MyVerifier());
		//Def Signature object
		s_en = new Signature("Ingles", new MyVerifier());
		//Def Signature object
		s_es = new Signature("Castellano", new MyVerifier());

		//Add Matematicas panel to Frame
		contentPane.add(s_math, BorderLayout.NORTH);
		//Add Castellano panel to Frame
		contentPane.add(s_es, BorderLayout.CENTER);
		//Add Ingles panel to Frame
		contentPane.add(s_en, BorderLayout.SOUTH);

		//Adatable frame
		//frame1.pack();
		
		//Frame size JFrame.setSize(int width, int height);
		//Adatable size to device screen size
		frame1.setSize( ((int)(screenW*0.5)), ((int)(screenH*0.5)) );
		//Show frame
		frame1.setVisible(true);
	}

	//Control button's action 
	//using interface ActionListener
	public void actionPerformed(ActionEvent ae){}
}