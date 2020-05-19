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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class TakeAttendence extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JButton btnOK, btnBack ;
	private Choice choice,choiceFirst,choiceSecond;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeAttendence frame = new TakeAttendence();
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
	
	public TakeAttendence() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 676, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("EMPLOYEE ATTENDENCE");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(20, 37, 623, 78);
		contentPane.add(btnNewButton);
		
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
		lblX.setBounds(631, 0, 45, 35);
		contentPane.add(lblX);
		
		JLabel lblEmpID = new JLabel("EMPLOYEE ID");
		lblEmpID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmpID.setBounds(39, 169, 155, 45);
		contentPane.add(lblEmpID);
		
		choice = new Choice();
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.setBounds(243, 177, 131, 29);
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
		
		JLabel lblFirst = new JLabel("FIRST HALF");
		lblFirst.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblFirst.setBounds(39, 224, 143, 45);
		contentPane.add(lblFirst);
		
		JLabel lblSecond = new JLabel("SECOND HALF");
		lblSecond.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSecond.setBounds(39, 279, 143, 45);
		contentPane.add(lblSecond);

		
		choiceFirst = new Choice();
		choiceFirst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choiceFirst.setFocusable(false);
		choiceFirst.setForeground(Color.BLACK);
		choiceFirst.setBackground(Color.WHITE);
		choiceFirst.setBounds(243, 234, 131, 29);
		choiceFirst.add("");
		choiceFirst.add("Present");
		choiceFirst.add("Absent");
		choiceFirst.add("Leave");
		contentPane.add(choiceFirst);
		
		choiceSecond = new Choice();
		choiceSecond.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choiceSecond.setFocusable(false);
		choiceSecond.setForeground(Color.BLACK);
		choiceSecond.setBackground(Color.WHITE);
		choiceSecond.setBounds(243, 293, 131, 29);
		choiceSecond.add("");
		choiceSecond.add("Present");
		choiceSecond.add("Absent");
		choiceSecond.add("Leave");
		contentPane.add(choiceSecond);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setForeground(new Color(30, 144, 255));
		btnOK.setBackground(new Color(255, 255, 255));
		btnOK.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOK.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnOK.setFocusable(false);
		btnOK.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnOK.setBounds(94, 396, 100, 39);
		contentPane.add(btnOK);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(362, 396, 108, 39);
		contentPane.add(btnBack);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnOK)
		{
			{
				try {
					Conn con = new Conn();
					String sql = "insert into attendence (EmpID,FirstHalf,SecondHalf,Date) values(?,?,?,?) ";
					PreparedStatement st = con.c.prepareStatement(sql);
					
					st.setString(1, choice.getSelectedItem());
					st.setString(2, choiceFirst.getSelectedItem());	
					st.setString(3, choiceSecond.getSelectedItem());
					st.setString(4, new java.util.Date().toString());
					
					st.execute();
					
					JOptionPane.showMessageDialog(null, "Attendence Has Been Added!");
					st.close();
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		}
		
		if(e.getSource() == btnBack)
		{
			setVisible(false);
			new MainPage().setVisible(true);
		}

	}
}