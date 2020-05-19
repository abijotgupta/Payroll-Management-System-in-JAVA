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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class UpdateEmployee extends JFrame implements ActionListener, ItemListener
{

	private JPanel contentPane;
	private JTextField txtAddress,txtCity,txtState,txtEmpName;
	private JButton btnUpdate, btnDelete ;
	@SuppressWarnings("rawtypes")
	private JComboBox comboGender;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private Choice choice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 820, 701);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("UPDATE EMPLOYEE  DETAILS");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(20, 37, 766, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCity.setBounds(39, 376, 143, 45);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblState.setBounds(39, 431, 143, 45);
		contentPane.add(lblState);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmail.setBounds(39, 486, 143, 45);
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
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtAddress.setColumns(10);
		txtAddress.setBounds(243, 331, 258, 29);
		contentPane.add(txtAddress);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtCity.setColumns(10);
		txtCity.setBounds(243, 386, 258, 29);
		contentPane.add(txtCity);
		
		txtState = new JTextField();
		txtState.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtState.setColumns(10);
		txtState.setBounds(243, 441, 258, 29);
		contentPane.add(txtState);
		
		
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhone.setBounds(39, 541, 143, 45);
		contentPane.add(lblPhone);
		
		JLabel lblEmpName = new JLabel("EMPLOYEE NAME");
		lblEmpName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmpName.setBounds(39, 211, 155, 45);
		contentPane.add(lblEmpName);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGender.setBounds(39, 266, 143, 45);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(39, 321, 143, 45);
		contentPane.add(lblAddress);
		
		txtEmpName = new JTextField();
		txtEmpName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtEmpName.setColumns(10);
		txtEmpName.setBounds(243, 221, 258, 29);
		contentPane.add(txtEmpName);
		
		comboGender = new JComboBox();
		comboGender.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE", "OTHERS"}));
		comboGender.setBounds(243, 276, 131, 29);
		contentPane.add(comboGender);
		
		
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setForeground(new Color(30, 144, 255));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnUpdate.setBounds(56, 634, 131, 39);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);
		btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDelete.setForeground(new Color(30, 144, 255));
		btnDelete.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(430, 634, 108, 39);
		contentPane.add(btnDelete);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPhone.setColumns(10);
		txtPhone.setBounds(243, 551, 258, 29);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(243, 496, 258, 29);
		contentPane.add(txtEmail);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmployeeId.setBounds(39, 156, 155, 45);
		contentPane.add(lblEmployeeId);
		
		choice = new Choice();
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.setBounds(243, 167, 121, 29);
		choice.add("");
		contentPane.add(choice);
		choice.addItemListener(this);
		
		
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
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnDelete)
		{
			Conn c = new Conn();
			try {
				c.s.executeUpdate("delete from employee where id="+choice.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Successfully Deleted");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == btnUpdate)
		{
			String name = txtEmpName.getText();
			String id = choice.getSelectedItem();
			String gender = (String) comboGender.getSelectedItem();
			String address = txtAddress.getText();
			String city = txtCity.getText();
			String state = txtState.getText();
			String email = txtEmail.getText();
			String phone = txtPhone.getText();
			
			
			String sql = "update employee set name='"+name+"',gender='"+gender+"',address='"+address+"',city='"+city+"',state='"+state+"',email='"+email+"',phone='"+phone+"' where id="+id;
			
			Conn c = new Conn();
			try {
				c.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Employee Details Updated");
				
				txtEmpName.setText("");
				txtAddress.setText("");
				txtCity.setText("");
				txtState.setText("");
				txtEmail.setText("");
				txtPhone.setText("");
				
				txtEmpName.requestFocus();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from employee where id="+choice.getSelectedItem());
			if(rs.next())
			{
				txtEmpName.setText(rs.getString("name"));
				comboGender.setSelectedItem(rs.getObject("gender"));
				txtAddress.setText(rs.getString("address"));
				txtCity.setText(rs.getString("city"));
				txtState.setText(rs.getString("state"));
				txtEmail.setText(rs.getString("email"));
				txtPhone.setText(rs.getString("phone"));
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}