/**
* Verify JTextfields text number using java swing
*
* Created on 31/07/2022
* @author  Acxel Orozco (ADOB Apps)
 */
package mycontrollers;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.InputVerifier;

import java.awt.*;
import java.awt.event.*;

public class MyVerifier extends InputVerifier{

	public boolean verify(JComponent input){
		if(input instanceof JTextField){
			JTextField tf = (JTextField) input;
			String text = ((JTextField)tf).getText();
			if (text.equals("")){
				tf.setText("0.0");
			} else{
				if( (Float.parseFloat(text))>5.0f ){
					JOptionPane.showMessageDialog(tf, "Valor no valido, las notas deben ser <= 5.0");
					tf.setText("0.0");
				}
				try{
					//Try to convert text to Float to verify number
					Float.parseFloat(text);
					return true;
				}catch(Exception e){
					JOptionPane.showMessageDialog(tf, "Valor no valido");
					return false;
				}
			}
		}
		return true;
	}
}