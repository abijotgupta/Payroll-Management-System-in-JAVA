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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



@SuppressWarnings("serial")
public class UpdateSalary extends JFrame implements ActionListener, ItemListener
{

	private JPanel contentPane;
	private JTextField txtHRA,txtDA,txtMED;
	private JButton btnUpdate, btnDelete ;
	private Choice choice;
	private JTextField txtBasic;
	private JTextField txtPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSalary frame = new UpdateSalary();
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
	
	public UpdateSalary() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 789, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("UPDATE EMPLOYEE SALARY");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 37, 766, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblDA = new JLabel("DA");
		lblDA.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDA.setBounds(39, 281, 143, 45);
		contentPane.add(lblDA);
		
		JLabel lblMed = new JLabel("MED");
		lblMed.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMed.setBounds(39, 336, 143, 45);
		contentPane.add(lblMed);
		
		JLabel lblPF = new JLabel("PF");
		lblPF.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPF.setBounds(39, 391, 143, 45);
		contentPane.add(lblPF);
		
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
		lblX.setBounds(745, 0, 45, 35);
		contentPane.add(lblX);
		
		
		
		
		
		JLabel lblBasic = new JLabel("BASIC SALARY");
		lblBasic.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBasic.setBounds(39, 446, 143, 45);
		contentPane.add(lblBasic);
		
		JLabel lblEmpID = new JLabel("EMPLOYEE ID");
		lblEmpID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmpID.setBounds(39, 171, 143, 45);
		contentPane.add(lblEmpID);
		
		JLabel lblHRA = new JLabel("HRA");
		lblHRA.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHRA.setBounds(39, 226, 143, 45);
		contentPane.add(lblHRA);
		
	
		
		
		choice = new Choice();
		choice.addItemListener(this);
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.setBounds(212, 182, 131, 29);
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
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setForeground(new Color(30, 144, 255));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnUpdate.setBounds(62, 538, 131, 39);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);
		btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDelete.setForeground(new Color(30, 144, 255));
		btnDelete.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(386, 538, 108, 39);
		contentPane.add(btnDelete);
		
		txtHRA = new JTextField();
		txtHRA.setColumns(10);
		txtHRA.setBounds(212, 236, 258, 29);
		contentPane.add(txtHRA);
		
		txtDA = new JTextField();
		txtDA.setColumns(10);
		txtDA.setBounds(212, 291, 258, 29);
		contentPane.add(txtDA);
		
		txtMED = new JTextField();
		txtMED.setColumns(10);
		txtMED.setBounds(212, 346, 258, 29);
		contentPane.add(txtMED);
		
		txtBasic = new JTextField();
		txtBasic.setColumns(10);
		txtBasic.setBounds(212, 456, 258, 29);
		contentPane.add(txtBasic);
		
		txtPF = new JTextField();
		txtPF.setColumns(10);
		txtPF.setBounds(212, 401, 258, 29);
		contentPane.add(txtPF);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnDelete)
		{
			Conn c = new Conn();
			try {
				c.s.executeUpdate("delete from salary where id="+choice.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Successfully Deleted");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == btnUpdate)
		{
			String hra = txtHRA.getText();
			String id = choice.getSelectedItem();
			String pf = txtPF.getText();
			String med = txtMED.getText();
			String da = txtDA.getText();
			String basic = txtBasic.getText();
		
			String sql = "update salary set hra='"+hra+"',da='"+da+"',med='"+med+"',pf='"+pf+"',basicsalary='"+basic+"' where id="+id;

			Conn c = new Conn();
			try {
				c.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Salary Updated");
				
				txtHRA.setText("");
				txtMED.setText("");
				txtDA.setText("");
				txtPF.setText("");
				txtBasic.setText("");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from salary where id="+choice.getSelectedItem());
			if(rs.next())
			{
				txtDA.setText(rs.getString("da"));
				txtPF.setText(rs.getString("pf"));
				txtBasic.setText(rs.getString("basicsalary"));
				txtMED.setText(rs.getString("med"));
				txtHRA.setText(rs.getString("hra"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}