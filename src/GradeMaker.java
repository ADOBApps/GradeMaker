/**
 * Simple class to receive and calculate
 * grade avarage
 * date: 30/07/2022
 * @author [Acxel Orozco (ADOB Apps)]
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
//Our Signature panel
import myviews.Signature;
//Our panel
import myviews.MyPanel;

class GradeMaker implements ActionListener, ItemListener{

	//Declare UI and IO elements
	public ArrayList<String> data;
	public Stack<Float> grades;
	Container contentPane;
	JButton jb_calc, jb_del, jb_back;
	JFrame frame1;
	Toolkit tk;

	//My signatures
	private Signature s_math, s_es, s_en;

	//My panel
	private MyPanel jp_mp, mp_control;

	//Option selection
	private JComboBox<String> combo1;
	
	int screenW, screenH;

	Float t_grades;

	String selected;

	//Constructor function
	public GradeMaker(){
		data = new ArrayList<String>();
		grades = new Stack<>();
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

		starGraph();

	}

	//main function
	public static void main (String arg[]){
		GradeMaker gm = new GradeMaker();
	}

	//create GUI
	private void starGraph(){
		//Clean frame
		contentPane.removeAll();
		jp_mp = new MyPanel("Seleccione la materia");

		//Combox define
		combo1=new JComboBox<String>();
		combo1.addItem("Seleccione una asignatura");
		//Add math
		combo1.addItem("Matematicas");
		//Add es
		combo1.addItem("Castellano");
		//Add en
		combo1.addItem("Ingles");
		//Add listener
		combo1.addItemListener(this);
		//Add to MyPanel
		jp_mp.push(combo1, 0, 0, 1, 1, 2.0, true);

		//Add to frame
		contentPane.add(jp_mp, BorderLayout.CENTER);

		//Adatable frame
		//frame1.pack();
		//Frame size JFrame.setSize(int width, int height);
		//Adatable size to device screen size
		frame1.setSize( ((int)(screenW*0.5)), ((int)(screenH*0.5)) );
		//Show frame
		frame1.setVisible(true);
	}

	//create signature
	private void makeSignature(int s_option){
		//Def Signature object
		s_math = new Signature("Matematicas", new MyVerifier());
		//Def Signature object
		s_en = new Signature("Ingles", new MyVerifier());
		//Def Signature object
		s_es = new Signature("Castellano", new MyVerifier());

		//button calculate average
		jb_calc = new JButton("Promedio");
		//Listener 
		jb_calc.addActionListener(this);
		//Button to clean JTextFields
		jb_del = new JButton("Borrar todo");
		//Listener
		jb_del.addActionListener(this);
		//Button back
		jb_back = new JButton("Atras");
		//Listener
		jb_back.addActionListener(this);

		mp_control = new MyPanel("");
		mp_control.push(jb_calc, 0, 0, 1, 1, 2.0, true);
		mp_control.push(jb_del, 1, 0, 1, 1, 2.0, true);
		mp_control.push(jb_back, 2, 0, 1, 1, 2.0, true);

		//Clean frame
		contentPane.removeAll();

		switch(s_option){
			//matematicas
			case 1:
				//Add Matematicas panel to Frame
				contentPane.add(s_math, BorderLayout.CENTER);
				//Add to frame
				contentPane.add(mp_control, BorderLayout.SOUTH);
			break;

			//castellano
			case 2:
				//Add Castellano panel to Frame
				contentPane.add(s_es, BorderLayout.CENTER);
				//Add to frame
				contentPane.add(mp_control, BorderLayout.SOUTH);
			break;

			//ingles
			case 3:
				//Add Ingles panel to Frame
				contentPane.add(s_en, BorderLayout.CENTER);
				//Add to frame
				contentPane.add(mp_control, BorderLayout.SOUTH);
			break;

			default:
				starGraph();
			break;
		}
		frame1.setSize( ((int)(screenW*0.5)), ((int)(screenH*0.5)) );
		//Show frame
		frame1.setVisible(true);
	}

	//Control button's action 
	//using interface ActionListener
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jb_calc){
			t_grades = 0.0f;
			if( (data.get(0)).equals("math") ){
				//Add grades
				grades.push(Float.parseFloat(s_math.jtf_g1.getText()));
				grades.push(Float.parseFloat(s_math.jtf_g2.getText()));
				grades.push(Float.parseFloat(s_math.jtf_g3.getText()));
				//Calculate average grades using for loop
				for(int i = 0; i < grades.size(); i++){
					t_grades = t_grades + grades.get(i);
				}
				//Set grade average
				s_math.jtf_gt.setText( ((String)Float.toString(t_grades/3)) );

			} else if ( (data.get(0)).equals("es") ){
				grades.push(Float.parseFloat(s_es.jtf_g1.getText()));
				grades.push(Float.parseFloat(s_es.jtf_g2.getText()));
				grades.push(Float.parseFloat(s_es.jtf_g3.getText()));
				//Calculate average grades using while loop
				int i=0;
				while(i<grades.size()){
					t_grades = t_grades + grades.get(i);
					i+=1;
				}
				//Set grade average
				s_es.jtf_gt.setText( ((String)Float.toString(t_grades/3)) );
			} else if( (data.get(0)).equals("en") ){
				grades.push(Float.parseFloat(s_en.jtf_g1.getText()));
				grades.push(Float.parseFloat(s_en.jtf_g2.getText()));
				grades.push(Float.parseFloat(s_en.jtf_g3.getText()));
				//Calculate average grades using do-while loop
				int i=0;
				do{
					t_grades = t_grades + grades.get(i);
					i+=1;
				}while(i<grades.size());
				//Set grade average
				s_en.jtf_gt.setText( ((String)Float.toString(t_grades/3)) );
			}
		} else if(ae.getSource()==jb_del){
			//Remove grades
			grades.clear();
			//Clen cumulated value
			t_grades = 0.0f;
			//Clean JTesxtField
			if( (data.get(0)).equals("math") ){
				s_math.jtf_g1.setText("0.0");
				s_math.jtf_g2.setText("0.0");
				s_math.jtf_g3.setText("0.0");
				s_math.jtf_gt.setText("0.0");
			} else if ( (data.get(0)).equals("es") ){
				s_es.jtf_g1.setText("0.0");
				s_es.jtf_g2.setText("0.0");
				s_es.jtf_g3.setText("0.0");
				s_es.jtf_gt.setText("0.0");
			} else if( (data.get(0)).equals("en") ){
				s_en.jtf_g1.setText("0.0");
				s_en.jtf_g2.setText("0.0");
				s_en.jtf_g3.setText("0.0");
				s_en.jtf_gt.setText("0.0");
			}
		} else if(ae.getSource()==jb_back){
			starGraph();
		}
	}

	//Control combox selection
	//using interfave ItemListener
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==combo1) {
			selected =(String)combo1.getSelectedItem();
			if( selected.equals("Matematicas") ){
				data.add(0, "math");
				makeSignature(1);
			}
			else if( selected.equals("Castellano") ){
				data.add(0, "es");
				makeSignature(2);
			}
			else if( selected.equals("Ingles") ){
				data.add(0, "en");
				makeSignature(3);
			}
			else{
				starGraph();
			}
		}
	}
}