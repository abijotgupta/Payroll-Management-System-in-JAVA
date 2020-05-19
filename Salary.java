package payroll;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class Salary extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtHRA,txtDA,txtMED;
	private JButton btnRegister, btnBack ;
	private JTextField txtBasic;
	private JTextField txtPF;
	private Choice choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salary frame = new Salary();
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
	
		public Salary() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 697, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SET EMPLOYEE SALARY");
		btnNewButton.setBounds(20, 37, 644, 78);
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnNewButton.setForeground(new Color(255, 255, 255));
		contentPane.add(btnNewButton);
		
		JLabel lblDA = new JLabel("DA");
		lblDA.setBounds(39, 283, 143, 45);
		lblDA.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblDA);
		
		JLabel lblMed = new JLabel("MEDICAL");
		lblMed.setBounds(39, 338, 143, 45);
		lblMed.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblMed);
		
		JLabel lblPF = new JLabel("PF");
		lblPF.setBounds(39, 393, 143, 45);
		lblPF.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblPF);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(652, 0, 45, 35);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(new Color(30, 144, 255));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblX);
		
		
		JLabel lblBasic = new JLabel("BASIC SALARY");
		lblBasic.setBounds(39, 448, 143, 45);
		lblBasic.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblBasic);
		
	
		JLabel lblEmpID = new JLabel("EMPLOYEE ID");
		lblEmpID.setBounds(39, 173, 143, 45);
		lblEmpID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblEmpID);
		
		JLabel lblHRA = new JLabel("HRA");
		lblHRA.setBounds(39, 228, 143, 45);
		lblHRA.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblHRA);
		
		
		choice = new Choice();
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.setBounds(212, 186, 121, 29);
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
	
		
		txtHRA = new JTextField();
		txtHRA.setBounds(212, 238, 258, 29);
		txtHRA.setColumns(10);
		contentPane.add(txtHRA);
		
		txtDA = new JTextField();
		txtDA.setBounds(212, 293, 258, 29);
		txtDA.setColumns(10);
		contentPane.add(txtDA);
		
		txtMED = new JTextField();
		txtMED.setBounds(212, 348, 258, 29);
		txtMED.setColumns(10);
		contentPane.add(txtMED);
		
		txtPF = new JTextField();
		txtPF.setBounds(212, 403, 258, 29);
		txtPF.setColumns(10);
		contentPane.add(txtPF);
		
		txtBasic = new JTextField();
		txtBasic.setBounds(212, 458, 258, 29);
		txtBasic.setColumns(10);
		contentPane.add(txtBasic);
		
		
		
		btnRegister = new JButton("ADD");
		btnRegister.setBounds(74, 545, 108, 39);
		btnRegister.addActionListener(this);
		btnRegister.setForeground(new Color(30, 144, 255));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegister.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(30, 144, 255)));
		contentPane.add(btnRegister);
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(380, 545, 108, 39);
		btnBack.addActionListener(this);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		contentPane.add(btnBack);
		
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == btnRegister)
		{
			try {
				Conn con = new Conn();
				String sql = "insert into salary (id,hra,da,med,pf,basicsalary) values(?,?,?,?,?,?) ";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, choice.getSelectedItem());
				st.setString(2, txtHRA.getText());
				st.setString(3, txtDA.getText());
				st.setString(4, txtMED.getText());
				st.setString(5, txtPF.getText());
				st.setString(6, txtBasic.getText());
				
				
				st.execute();
				
			
				JOptionPane.showMessageDialog(null, "Successfully Done");
				
			
				txtHRA.setText("");
				txtDA.setText("");
				txtMED.setText("");
				txtPF.setText("");
				txtBasic.setText("");
				
				txtHRA.requestFocus();
			
				st.close();
				
			}
			catch(Exception e1)
			{
				System.out.println(e1);
				//JOptionPane.showMessageDialog(null, e);
			}
		}
		
		if(ae.getSource() == btnBack)
		{
			setVisible(false);
			new MainPage().setVisible(true);
		}
	}
}