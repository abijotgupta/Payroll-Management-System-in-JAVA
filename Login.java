package payroll;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JButton btnLogin, btnCancel;
	private JLabel lblUserName;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 405, 507);
		panel.setLayout(null);
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\user (1).png"));
		label.setBounds(70, 206, 325, 277);
		panel.add(label);
		
		JLabel lblStudent = new JLabel("LOG IN");
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 42));
		lblStudent.setBounds(128, 137, 254, 49);
		panel.add(lblStudent);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(401, 0, 546, 507);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPassword.setBounds(263, 219, 221, 32);
		panel_1.add(txtPassword);
		
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("");
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtUsername.setColumns(10);
		txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(263, 135, 221, 32);
		panel_1.add(txtUsername);
		
		
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
		lblX.setBounds(501, 0, 45, 35);
		panel_1.add(lblX);
		
		
		
		btnLogin = new JButton("LOG IN");
		btnLogin.addActionListener(this); 
		btnLogin.setForeground(new Color(30, 144, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLogin.setFocusable(false);
		btnLogin.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(146, 352, 100, 32);
		panel_1.add(btnLogin);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		btnCancel.setForeground(new Color(30, 144, 255));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCancel.setFocusable(false);
		btnCancel.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(384, 352, 100, 32);
		panel_1.add(btnCancel);
		
		lblUserName = new JLabel("USERNAME");
		lblUserName.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		lblUserName.setBounds(91, 144, 140, 32);
		panel_1.add(lblUserName);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		lblPassword.setBounds(91, 228, 140, 32);
		panel_1.add(lblPassword);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnLogin)
		{
			//Boolean status  = false;
			try {
				Conn con = new Conn();
				String user = txtUsername.getText();
				String pass = txtUsername.getText();
				String sql = "Select * from login where username='"+user+"' and password='"+pass+"'";
				
				ResultSet rs = con.s.executeQuery(sql);
	
				if(rs.next())
				{
					this.setVisible(false);
					new MainPage().setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Please Enter Correct Credentials");
					txtUsername.setText("");
					txtPassword.setText("");
					txtUsername.requestFocus();
				
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		if(ae.getSource() == btnCancel)
		{
			System.exit(0);
		}
	}

}