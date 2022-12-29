package airline.management.system;

/*import java.awt.EventQueue;*/


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Ticket extends JFrame{ //Third Frame

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;

        public Ticket(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("TICKET");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 80, 150, 27);
            add(Name);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 400, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel Pnrno = new JLabel("PNR NO");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 120, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel Source = new JLabel("SOURCE");
            Source.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Source.setBounds(60, 170, 150, 27);
            add(Source);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
            		
            JLabel Destination = new JLabel("DESTINATION");
            Destination.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Destination.setBounds(60, 220, 150, 27);
            add(Destination);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
           
	
            JLabel Time = new JLabel("TIME");
            Time.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Time.setBounds(60, 270, 150, 27);
            add(Time);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
            
            JLabel Date = new JLabel("DATE");
            Date.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Date.setBounds(60, 320, 150, 27);
            add(Date);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 320, 150, 27);
            add(textField_5);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("TICKET CREATION");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            add(AddPassengers);
			
    
            JLabel Flightcode = new JLabel("FLIGHT CODE");
            Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Flightcode.setBounds(60, 30, 150, 27);
            add(Flightcode);

            textField_6 = new JTextField();
            textField_6.setBounds(200, 30, 150, 27);
            add(textField_6);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/emp.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,280,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String Name = textField.getText();
                    String Pnr_no = textField_1.getText();
                    String Source =  textField_2.getText();
                    String Destination = textField_3.getText();
                    String Time = textField_4.getText();
                    String Flight_code = textField_6.getText();
                    String Date = textField_5.getText();
                    
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO reservation values( '"+Pnr_no+"', '"+Name+"', '"+Flight_code+"','"+Date+"', '"+Time+"', '"+Source+"','"+Destination+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Ticket Created");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(400,200);
			
	}
        
    public static void main(String[] args){
        new Ticket();
    }   
}