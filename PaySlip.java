package payroll;


import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PaySlip extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Choice choice;
	private JButton btnGeneratePaySlip;
	private JLabel lblID;
	private JTextArea textArea;
	private JButton btnPrintPaySlip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaySlip frame = new PaySlip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaySlip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 53, 850, 400);
		contentPane.add(textArea);
		
		choice = new Choice();
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.setBounds(352, 10, 121, 24);
		choice.add("");
		contentPane.add(choice);
		
		Conn c = new Conn();
		ResultSet rs;
		try {
			rs = c.s.executeQuery("select * from employee");
			while(rs.next())
			{
				choice.add(rs.getString("id"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnGeneratePaySlip = new JButton("GENERATE PAY SLIP");
		btnGeneratePaySlip.addActionListener(this);
		btnGeneratePaySlip.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGeneratePaySlip.setForeground(new Color(30, 144, 255));
		btnGeneratePaySlip.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnGeneratePaySlip.setFocusable(false);
		btnGeneratePaySlip.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnGeneratePaySlip.setBackground(Color.WHITE);
		btnGeneratePaySlip.setBounds(59, 463, 303, 39);
		contentPane.add(btnGeneratePaySlip);
		
		lblID = new JLabel("SELECT ID");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblID.setBounds(255, 10, 107, 22);
		contentPane.add(lblID);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(860, 53, 17, 400);
		contentPane.add(scrollBar);
		getContentPane().add(textArea);
		
		btnPrintPaySlip = new JButton("PRINT PAY SLIP");
		btnPrintPaySlip.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrintPaySlip.setForeground(new Color(30, 144, 255));
		btnPrintPaySlip.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnPrintPaySlip.setFocusable(false);
		btnPrintPaySlip.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnPrintPaySlip.setBackground(Color.WHITE);
		btnPrintPaySlip.setBounds(472, 463, 303, 39);
		contentPane.add(btnPrintPaySlip);
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnGeneratePaySlip)
		{
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from employee where id="+choice.getSelectedItem());
				rs.next();
				String name = rs.getString("name");
				rs.close();
			
				rs = c.s.executeQuery("select * from salary where id="+choice.getSelectedItem());
			
				double gross = 0;
				double net = 0;
			
				Date d = new Date();
				@SuppressWarnings("deprecation")
				int month = d.getMonth();
			
				textArea.setText("-----------------PAY SLIP FOR THE MONTH OF "+ month+ ", 2020-----------------\n");
				//textArea.append("\n");
			
				while(rs.next())
				{
					textArea.append("\n   Employee ID          "+rs.getString("id"));
					textArea.append("\n   Employee Name        "+name);
				
					double hra = rs.getDouble("hra");
					textArea.append("\n   HRA                  "+hra);
				
					double da = rs.getDouble("da");
					textArea.append("\n   DA                   "+da);
				
					double med = rs.getDouble("med");
					textArea.append("\n   MEDICAL              "+med);
				
					double pf = rs.getDouble("pf");
					textArea.append("\n   PF                   "+pf);
				
					double basic = rs.getDouble("basicsalary");
					textArea.append("\n   BASIC SALARY         "+basic);
				
					gross = hra+med+pf+da+basic;
					net = gross-pf;
				
					textArea.append("\n   GROSS SALARY         "+gross);
					textArea.append("\n   NET SALARY           "+net);
					textArea.append("\n");
					textArea.append("\n");
					textArea.append("\n");
					textArea.append("   Signature");
				}
			
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == btnPrintPaySlip)
		{
			try {
				textArea.print();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
}
