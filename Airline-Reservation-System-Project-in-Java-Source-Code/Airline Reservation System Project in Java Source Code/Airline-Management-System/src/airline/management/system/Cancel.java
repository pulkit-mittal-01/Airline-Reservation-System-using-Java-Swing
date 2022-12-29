package airline.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JTable;

public class Cancel extends JFrame{  //Second Frame

    private JTable table,table1;
    private JTextField textField,textField1;
    
    public static void main(String[] args){		 
	new Cancel().setVisible(true);    
    }
    
    public Cancel(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("CONSUMER NAME");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
        
        JLabel Fcode1 = new JLabel("PNR_NO");
	Fcode1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode1.setBounds(470, 100, 200, 30);
	add(Fcode1);
		
	JLabel FlightDetails = new JLabel("CANCEL  RESERVATION");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        JButton btndel = new JButton("DELETE");
	btndel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            /*private Object DbUtils;*/
            @Override
            @SuppressWarnings("CallToPrintStackTrace")
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                String p_n=null;
                
                try {
                    conn c = new conn();
                    String  pn_no="select * from passenger where name = '"+code+"'";
                    
                    ResultSet rs1 = c.s.executeQuery(pn_no);
                     table.setModel(DbUtils.resultSetToTableModel(rs1));
	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
        
        btndel.addActionListener(new ActionListener() {
            /*private Object DbUtils;*/
            @Override
            @SuppressWarnings("CallToPrintStackTrace")
            public void actionPerformed(ActionEvent ae) {
	
                String code1 = textField1.getText();
                String nm=null;
                try {
                    conn c = new conn();
                    
                    String  pn_no="delete from reservation where pnr_no = '"+code1+"'";
                  
                    c.s.executeUpdate(pn_no);
                 
                   String  name="select name from passenger where pnr_no = '"+code1+"'";
                   ResultSet rs1 = c.s.executeQuery(name);
                   if (rs1.next())
                   {
                   nm=rs1.getString(1);
                   }
                   
                   String  res="select * from passenger where name = '"+nm+"'";
                   ResultSet rs2 = c.s.executeQuery(res);
                   table.setModel(DbUtils.resultSetToTableModel(rs2));
                   
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });
        
        btndel.setBounds(600, 150, 120, 30);
	add(btndel);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        table1 = new JTable();
        table1.setBackground(Color.WHITE);
	table1.setBounds(523, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
        
        textField1 = new JTextField();
        textField1.setBounds(580, 100, 200, 30);
	add(textField1);
		
		JLabel PNR_NO = new JLabel("PNR_NO");
	PNR_NO.setFont(new Font("Tahoma", Font.PLAIN, 13));
        PNR_NO.setBounds(23, 220, 126, 14);
	add(PNR_NO);
		
	JLabel TICKET_ID = new JLabel("TICKET_ID");
        TICKET_ID.setFont(new Font("Tahoma", Font.PLAIN, 13));
	TICKET_ID.setBounds(145, 220, 120, 14);
	add(TICKET_ID);
		
	JLabel F_CODE = new JLabel("F_CODE");
	F_CODE.setFont(new Font("Tahoma", Font.PLAIN, 13));
	F_CODE.setBounds(275, 220, 104, 14);
	add(F_CODE);
		
	JLabel JNY_DATE = new JLabel("JNY_DATE");
	JNY_DATE.setFont(new Font("Tahoma", Font.PLAIN, 13));
	JNY_DATE.setBounds(367, 220, 120, 14);
	add(JNY_DATE);
		
		
	JLabel JNY_TIME = new JLabel("JNY_TIME");
	JNY_TIME.setFont(new Font("Tahoma", Font.PLAIN, 13));
	JNY_TIME.setBounds(497, 220, 111, 14);
	add(JNY_TIME);
		
	JLabel SOURCE = new JLabel("SOURCE");
	SOURCE.setFont(new Font("Tahoma", Font.PLAIN, 13));
	SOURCE.setBounds(587, 220, 120, 14);
	add(SOURCE);
		
	JLabel DESTIGNATION = new JLabel("DESTIGNATION");
	DESTIGNATION.setFont(new Font("Tahoma", Font.PLAIN, 13));
	DESTIGNATION.setBounds(700, 220, 111, 14);
	add(DESTIGNATION);
		
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}
