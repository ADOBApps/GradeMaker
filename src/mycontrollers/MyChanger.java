/**
* Detect JTextfields text change using java swing
* Using special implementation at class where
* was imported adaptation of MyChanger class
* codified for Checkmake project
* Created on 31/07/2022
* @author  Acxel Orozco (ADOB Apps)
 */
package mycontrollers;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class MyChanger implements DocumentListener{

	public void changedUpdate(DocumentEvent e){}

	public void insertUpdate(DocumentEvent de){
		/**Get owner, it value  and relate totalvalue
		 * using docs properties get previus JTextfields relate
		*/ 
		Object val1 = de.getDocument().getProperty("val1");
		Object val2 = de.getDocument().getProperty("val2");
		Object val3 = de.getDocument().getProperty("val3");
		Object tval = de.getDocument().getProperty("assTVal");

		/**Convert text to float and get total value
		 * and force conversion Object to JTexfield
		 * also force conversion float to string
		*/
		Float myValue = Float.parseFloat(((JTextField)val1).getText()) + Float.parseFloat(((JTextField)val2).getText()) + Float.parseFloat(((JTextField)val3).getText());;
		((JTextField)tval).setText( ((String)Float.toString(myValue)) );
	}

	public void removeUpdate(DocumentEvent e){}
}