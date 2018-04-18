package simon;

import java.awt.BorderLayout;
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
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class SimonApp extends JFrame {

	private JPanel contentPane;
	JButton GreenLight;
	JButton YellowLight;
	JButton BlueLight;
	JButton RedLight;
	Color normYellow = new Color(204, 204, 0);
	Color normRed = new Color(139, 0, 0);
	Color normGreen = new Color(0, 128, 0);
	Color normBlue = new Color(0, 0, 205);
	Color brightBlue = new Color(0, 191, 255);
    private Timer timer;

    private LocalTime startTime, endTime;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimonApp frame = new SimonApp();
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
	public SimonApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 732);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem HiScoreBtn = new JMenuItem("Check High Scores");
		HiScoreBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		HiScoreBtn.setBackground(new Color(124, 252, 0));
		HiScoreBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(192, 192, 192), new Color(64, 64, 64)));
		HiScoreBtn.setHorizontalAlignment(SwingConstants.CENTER);
		HiScoreBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(HiScoreBtn);
		
		JMenuItem PlayBtn = new JMenuItem("Start New Game");
		PlayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		PlayBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		PlayBtn.setBackground(new Color(255, 69, 0));
		PlayBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, Color.DARK_GRAY));
		PlayBtn.setHorizontalAlignment(SwingConstants.CENTER);
		PlayBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(PlayBtn);
		
		timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endTime = LocalTime.now();
                Duration duration = Duration.between(startTime, endTime);
            }
        });
		
		JMenuItem QuitBtn = new JMenuItem("Quit");
		QuitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sequence.newSequence();
				for(int i = 0; i <= Sequence.getSequence().size()-1; i++) {
					if(Sequence.getSequenceChar(i) == 'Y') {
						YellowLight.setBackground(Color.YELLOW);
						timer.start();
						timer.stop();
						//YellowLight.setBackground(normYellow);
					}
					else if(Sequence.getSequenceChar(i) == 'R') {
						RedLight.setBackground(Color.RED);
						timer.start();
						//RedLight.setBackground(normRed);
					}
					else if(Sequence.getSequenceChar(i) == 'B') {
						BlueLight.setBackground(brightBlue);
						timer.start();
						//BlueLight.setBackground(normBlue);
					}
					else {
						GreenLight.setBackground(Color.GREEN);
						timer.start();
						//GreenLight.setBackground(normGreen);
					}
				}

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
		
		GreenLight = new JButton("");
		GreenLight.setOpaque(true);
		GreenLight.setBorderPainted(false);
		GreenLight.setBackground(new Color(0, 128, 0));
		gamePlane.setLayer(GreenLight, 2);
		GreenLight.setBounds(308, 128, 113, 112);
		gamePlane.add(GreenLight);
		
		RedLight = new JButton("");
		RedLight.setOpaque(true);
		RedLight.setBorderPainted(false);
		RedLight.setBackground(new Color(139, 0, 0));
		gamePlane.setLayer(RedLight, 1);
		RedLight.setBounds(477, 128, 110, 112);
		gamePlane.add(RedLight);
		
		BlueLight = new JButton("");
		BlueLight.setOpaque(true);
		BlueLight.setBorderPainted(false);
		BlueLight.setBackground(new Color(0, 0, 205));
		gamePlane.setLayer(BlueLight, 2);
		BlueLight.setBounds(311, 315, 110, 112);
		gamePlane.add(BlueLight);
		
		YellowLight = new JButton("");
		YellowLight.setOpaque(true);
		YellowLight.setBorderPainted(false);
		YellowLight.setBackground(new Color(204, 204, 0));
		gamePlane.setLayer(YellowLight, 2);
		YellowLight.setBounds(477, 315, 110, 112);
		gamePlane.add(YellowLight);
		
		JButton SimonGame = new JButton("");
		gamePlane.setLayer(SimonGame, 1);
		SimonGame.setIcon(new ImageIcon(SimonApp.class.getResource("Simon Game.png")));
		SimonGame.setBounds(294, 115, 308, 326);
		gamePlane.add(SimonGame);
		
		JButton BG = new JButton("");
		BG.setOpaque(true);
		BG.setBackground(Color.WHITE);
		BG.setBounds(0, 0, 911, 582);
		gamePlane.add(BG);
	}
	
	public static void sleep(int milliseconds) {
		try {
		    Thread.sleep(milliseconds);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}
