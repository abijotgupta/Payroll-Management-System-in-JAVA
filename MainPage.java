package payroll;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainPage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenu m1,m2,m3,m4,m5,m6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 1100);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		m1 = new JMenu("Home");
		m1.setBackground(Color.WHITE);
		m1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menuBar.add(m1);
		m1.setForeground(Color.BLACK);
		
		JMenuItem m1Item1 = new JMenuItem("New Employee");
		m1Item1.setBackground(Color.WHITE);
		m1Item1.setFont(new Font("Monospaced", Font.PLAIN,12));
		m1Item1.setMnemonic('N');
		m1Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		m1Item1.addActionListener(this);
		
		JMenuItem m1Item2 = new JMenuItem("Salary");
		m1Item2.setBackground(Color.WHITE);
		m1Item2.setFont(new Font("Monospaced", Font.PLAIN,12));
		m1Item2.setMnemonic('S');
		m1Item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		m1Item2.addActionListener(this);
		
		JMenuItem m1Item3 = new JMenuItem("List Employee");
		m1Item3.setBackground(Color.WHITE);
		m1Item3.setFont(new Font("Monospaced", Font.PLAIN,12));
		m1Item3.setMnemonic('L');
		m1Item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		m1Item3.addActionListener(this);
		
		m1.add(m1Item1);
		m1.add(m1Item2);
		m1.add(m1Item3);
		
		m2 = new JMenu("Update");
		m2.setForeground(Color.BLACK);
		m2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menuBar.add(m2);
		
		JMenuItem m2Item1 = new JMenuItem("Update Salary");
		m2Item1.setBackground(Color.WHITE);
		m2Item1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m2.add(m2Item1);
		m2Item1.addActionListener(this);
		
		JMenuItem m2Item2 = new JMenuItem("Update Employe");
		m2Item2.setBackground(Color.WHITE);
		m2Item2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m2.add(m2Item2);
		m2Item2.addActionListener(this);
		
		JMenuItem m2Item3 = new JMenuItem("Take Attendence");
		m2Item3.setBackground(Color.WHITE);
		m2Item3.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m2.add(m2Item3);
		m2Item3.addActionListener(this);
		
		m3 = new JMenu("Reports");
		m3.setForeground(Color.BLACK);
		m3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menuBar.add(m3);
		
		JMenuItem m3Item1 = new JMenuItem("Generate Payslip");
		m3Item1.setBackground(Color.WHITE);
		m3Item1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m3.add(m3Item1);
		m3Item1.addActionListener(this);
		
		JMenuItem m3Item2 = new JMenuItem("List Employee");
		m3Item2.setBackground(Color.WHITE);
		m3Item2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m3.add(m3Item2);
		m3Item2.addActionListener(this);
		
		m4 = new JMenu("Utilities");
		m4.setForeground(Color.BLACK);
		m4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menuBar.add(m4);
		
		JMenuItem m4Item1 = new JMenuItem("Calculator");
		m4Item1.setBackground(Color.WHITE);
		m4Item1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m4.add(m4Item1);
		m4Item1.addActionListener(this);
		
		JMenuItem m4Item2 = new JMenuItem("Notepad");
		m4Item2.setBackground(Color.WHITE);
		m4Item2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m4.add(m4Item2);
		m4Item2.addActionListener(this);
		
		
		
		m5 = new JMenu("Exit");
		m5.addActionListener(this);
		m5.setForeground(Color.BLACK);
		m5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		menuBar.add(m5);
	
		JMenuItem m5Item1 = new JMenuItem("Log Out");
		m5Item1.setBackground(Color.WHITE);
		m5Item1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m5.add(m5Item1);
		m5Item1.addActionListener(this);
		
		JMenuItem m5Item2 = new JMenuItem("Exit");
		m5Item2.setBackground(Color.WHITE);
		m5Item2.setFont(new Font("Monospaced", Font.PLAIN, 12));
		m5.add(m5Item2);
		m5Item2.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Icon/payroll.jpg"));
		Image i = img1.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(i); 
		
		JLabel lblNewLabel = new JLabel(img2);
		lblNewLabel.setBounds(10, 10, 1520, 802);
		contentPane.add(lblNewLabel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s = e.getActionCommand();
		
		if(s.equals("New Employee"))
		{
			this.setVisible(false);
			new NewEmployee().setVisible(true);
		}
		else if(s.equals("Salary"))
		{
			this.setVisible(false);
			new Salary().setVisible(true);
		}
		else if(s.equals("List Employee"))
		{
			this.setVisible(false);
			new ListEmployee().setVisible(true);
		}
		else if(s.equals("Update Salary"))
		{
			this.setVisible(false);
			new UpdateSalary().setVisible(true);
		}
		else if(s.equals("Update Employee"))
		{
			this.setVisible(false);
			new UpdateEmployee().setVisible(true);
		}
		else if(s.equals("Take Attendence"))
		{
			this.setVisible(false);
			new TakeAttendence().setVisible(true);
		}
		else if(s.equals("Generate Payslip"))
		{
			this.setVisible(false);
			new PaySlip().setVisible(true);
		}
		else if(s.equals("Notepad"))
		{
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(s.equals("Calculator"))
		{
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(s.equals("Web Browser"))
		{
			try {
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(s.equals("Log Out"))
		{
			this.setVisible(false);
			new Login().setVisible(true);
		}
		else if(s.equals("Exit"))
		{
			System.exit(0);
		}
		
		
	}
}