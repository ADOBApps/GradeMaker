/**
 * Simple class to create JPanel
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

public class MyPanel extends JPanel{
    //Declare UI elements and controls
    GridBagConstraints gbctts;

    //constructor
    public MyPanel(String title){
        //Create border
        Border btitle1 = BorderFactory.createTitledBorder(title);
        //Create a Layout dimension manager
        gbctts = new GridBagConstraints();
        //Set distribution manager
        this.setLayout(new GridBagLayout());
        //Set bordertitle
        this.setBorder(btitle1);
    }

    public void push(Component element,int column, int row, int width, int height, double weightx, boolean expand){
        //Add element
        gbctts.gridx=column;//Columns
        gbctts.gridy=row;//Row
        gbctts.gridwidth=width;//Cell width
        gbctts.gridheight=height;//Cell height
        gbctts.weightx=weightx;//expand width
        if(expand){
            gbctts.fill = GridBagConstraints.HORIZONTAL;//Expand
            this.add(element, gbctts);
            gbctts.fill = GridBagConstraints.NONE;//restore
        } else {
            this.add(element, gbctts);
        }
        gbctts.weightx=1.0;//restore width
    }
}