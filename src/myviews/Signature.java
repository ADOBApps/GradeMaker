/**
 * Simple class to create signature type JPanel
 * date: 31/07/2022
 * @author [Acxel Orozco (ADOB Apps)]
 * 
 */

package myviews;


import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.*;

public class Signature extends JPanel{

	//Declare UI elements and controls
	GridBagConstraints gbctts;
	public JTextField jtf_g1, jtf_g2;
	public JTextField jtf_g3, jtf_gt;
	public JLabel jl_g1, jl_g2, jl_g3, jl_gt;

	//Constructor function
	public Signature(String title, InputVerifier pv){

		//Create border
		Border btitle1 = BorderFactory.createTitledBorder(title);
		//Create a Layout dimension manager
		gbctts = new GridBagConstraints();
		//Set distribution manager
		this.setLayout(new GridBagLayout());
		//Set bordertitle
		this.setBorder(btitle1);

		//Jlabel grade1
		jl_g1 = new JLabel();
		jl_g1.setText("Nota 1");

		//Jlabel grade2
		jl_g2 = new JLabel();
		jl_g2.setText("Nota 2");

		//Jlabel grade3
		jl_g3 = new JLabel();
		jl_g3.setText("Nota 3");

		//Jlabel average grade
		jl_gt = new JLabel();
		jl_gt.setText("Promedio");

		//JTextField grade 1
		jtf_g1 = new JTextField(3);
		jtf_g1.setInputVerifier(pv);

		//JTextField grade 2
		jtf_g2 = new JTextField(3);
		jtf_g2.setInputVerifier(pv);

		//JTextField grade 3
		jtf_g3 = new JTextField(3);
		jtf_g3.setInputVerifier(pv);

		//JTextField average grade
		jtf_gt = new JTextField(3);
		jtf_gt.setEditable(false);

		addGrades();
	}

	//Add TextFields for grades
	private void addGrades(){
		
		//Grade JLabel1
		gbctts.gridx=0;//Columns
		gbctts.gridy=0;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jl_g1, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE;//restore

		//Grade JLabel2
		gbctts.gridx=1;//Columns
		gbctts.gridy=0;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jl_g2, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore

		//Grade JLabel3
		gbctts.gridx=2;//Columns
		gbctts.gridy=0;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jl_g3, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore

		//Grade average JLabel
		gbctts.gridx=3;//Columns
		gbctts.gridy=0;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jl_gt, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore

		//Grade JTextField1
		gbctts.gridx=0;//Columns
		gbctts.gridy=1;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jtf_g1, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore

		//Grade JTextField2
		gbctts.gridx=1;//Columns
		gbctts.gridy=1;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jtf_g2, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore

		//Grade JTextField3
		gbctts.gridx=2;//Columns
		gbctts.gridy=1;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jtf_g3, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore

		//Grade average JTextField
		gbctts.gridx=3;//Columns
		gbctts.gridy=1;//Row
		gbctts.gridwidth=1;//Cell width
		gbctts.gridheight=1;//Cell height
		gbctts.weightx=2.0;//expand width
		gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
		this.add(jtf_gt, gbctts);
		gbctts.weightx=1.0;//restore width
		gbctts.fill = GridBagConstraints.NONE; //restore
	}
}