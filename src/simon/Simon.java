package simon;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Simon extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simon frame = new Simon();
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
	public Simon() {
		Score HiScore = new Score("test.save");
		JOptionPane optionPane = new JOptionPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 732);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem HiScoreBtn = new JMenuItem("Check High Scores");
		HiScoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(optionPane, HiScore,"High Scores",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		HiScoreBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		HiScoreBtn.setBackground(new Color(124, 252, 0));
		HiScoreBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(192, 192, 192), new Color(64, 64, 64)));
		HiScoreBtn.setHorizontalAlignment(SwingConstants.CENTER);
		HiScoreBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(HiScoreBtn);
		
		JMenuItem PlayBtn = new JMenuItem("Start New Game");
		PlayBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		PlayBtn.setBackground(new Color(255, 69, 0));
		PlayBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, Color.DARK_GRAY));
		PlayBtn.setHorizontalAlignment(SwingConstants.CENTER);
		PlayBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(PlayBtn);
		
		JMenuItem QuitBtn = new JMenuItem("Quit");
		QuitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		QuitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		QuitBtn.setBackground(new Color(255, 255, 0));
		QuitBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, Color.BLACK));
		QuitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		QuitBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(QuitBtn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane gamePlane = new JLayeredPane();
		contentPane.add(gamePlane, BorderLayout.CENTER);
		
		JButton BG = new JButton("");
		BG.setBackground(Color.WHITE);
		BG.setBounds(0, 0, 911, 582);
		gamePlane.add(BG);
		
		JButton SimonGame = new JButton("");
		gamePlane.setLayer(SimonGame, 1);
		SimonGame.setIcon(new ImageIcon(Simon.class.getResource("background.png")));
		SimonGame.setBounds(294, 114, 308, 326);
		gamePlane.add(SimonGame);
		
		JButton GreenLight = new JButton("");
		GreenLight.setBackground(new Color(173, 255, 47));
		gamePlane.setLayer(GreenLight, 2);
		GreenLight.setBounds(308, 128, 110, 112);
		gamePlane.add(GreenLight);
		
		JButton RedLight = new JButton("");
		RedLight.setBackground(new Color(255, 0, 0));
		gamePlane.setLayer(RedLight, 2);
		RedLight.setBounds(477, 128, 110, 112);
		gamePlane.add(RedLight);
		
		JButton BlueLight = new JButton("");
		BlueLight.setBackground(new Color(0, 191, 255));
		gamePlane.setLayer(BlueLight, 2);
		BlueLight.setBounds(311, 315, 110, 112);
		gamePlane.add(BlueLight);
		
		JButton YellowLight = new JButton("");
		YellowLight.setBackground(Color.YELLOW);
		gamePlane.setLayer(YellowLight, 2);
		YellowLight.setBounds(477, 315, 110, 112);
		gamePlane.add(YellowLight);
	}
}
