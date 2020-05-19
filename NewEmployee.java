package payroll;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;



@SuppressWarnings("serial")
public class NewEmployee extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtAddress,txtCity,txtState,txtEmpName;
	private JButton btnRegister, btnBack ;
	@SuppressWarnings("rawtypes")
	private JComboBox comboGender;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployee frame = new NewEmployee();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NewEmployee() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 801, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("EMPLOYEE REGISTRATION");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(20, 37, 766, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCity.setBounds(39, 422, 143, 45);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblState.setBounds(39, 477, 143, 45);
		contentPane.add(lblState);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setBounds(39, 532, 143, 45);
		contentPane.add(lblEmail);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(new Color(30, 144, 255));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblX.setBounds(756, 0, 45, 35);
		contentPane.add(lblX);
		
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhone.setBounds(39, 587, 143, 45);
		contentPane.add(lblPhone);
		
		JLabel lblEmpName = new JLabel("EMPLOYEE NAME");
		lblEmpName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmpName.setBounds(39, 257, 155, 45);
		contentPane.add(lblEmpName);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGender.setBounds(39, 312, 143, 45);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(39, 367, 143, 45);
		contentPane.add(lblAddress);
		
		JLabel lblNewLabel = new JLabel("NEW EMPLOYEE");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 24));
		lblNewLabel.setBounds(283, 141, 227, 45);
		contentPane.add(lblNewLabel);
		
		
		txtEmpName = new JTextField();
		txtEmpName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmpName.setColumns(10);
		txtEmpName.setBounds(212, 267, 258, 29);
		contentPane.add(txtEmpName);
		
		comboGender = new JComboBox();
		comboGender.setBackground(Color.WHITE);
		comboGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE", "OTHERS"}));
		comboGender.setBounds(212, 322, 131, 29);
		contentPane.add(comboGender);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAddress.setColumns(10);
		txtAddress.setBounds(212, 377, 258, 29);
		contentPane.add(txtAddress);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCity.setColumns(10);
		txtCity.setBounds(212, 432, 258, 29);
		contentPane.add(txtCity);
		
		txtState = new JTextField();
		txtState.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtState.setColumns(10);
		txtState.setBounds(212, 487, 258, 29);
		contentPane.add(txtState);
		
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPhone.setColumns(10);
		txtPhone.setBounds(212, 597, 258, 29);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(212, 542, 258, 29);
		contentPane.add(txtEmail);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(this);
		btnRegister.setForeground(new Color(30, 144, 255));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegister.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnRegister.setBounds(72, 694, 131, 39);
		contentPane.add(btnRegister);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(411, 694, 108, 39);
		contentPane.add(btnBack);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	
		if(ae.getSource() == btnRegister)
		{
			try {
				Conn con = new Conn();
				String sql = "insert into employee (name,gender,address,city,state,email,phone) values(?,?,?,?,?,?,?) ";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, txtEmpName.getText());
				st.setString(2, (String)comboGender.getSelectedItem());	
				st.setString(3, txtAddress.getText());
				st.setString(4, txtCity.getText());
				st.setString(5, txtState.getText());
				st.setString(6, txtEmail.getText());
				st.setString(7, txtPhone.getText());
				
				st.execute();
				
			
				JOptionPane.showMessageDialog(null, "New Employee Has Been Added!");
				
				
				txtEmpName.setText("");
				txtAddress.setText("");
				txtCity.setText("");
				txtState.setText("");
				txtEmail.setText("");
				txtPhone.setText("");
				comboGender.setSelectedItem("");
				
				txtEmpName.requestFocus();
			
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