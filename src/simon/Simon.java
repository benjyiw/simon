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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JLabel;

public class Simon extends JFrame {

	private JPanel contentPane;
	JOptionPane scorePane = new JOptionPane();
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
    private Timer greenTimer;
    private Timer blueTimer;
    private Timer yellowTimer;
    private Timer redTimer;
    private Timer doNothing;
    JLabel turnOrder;
    int sequence = 0;
    int score = 0;
	Score HighScore = new Score(System.getProperty("user.home") + "/Desktop/SimonHighScores.save");
	String initials;
	Sequence seq = new Sequence();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 732);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		doNothing = new Timer(200, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	   	doNothing.stop();
            }
        });
		
		greenTimer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   	GreenLight.setBackground(normGreen);
            	   	greenTimer.stop();
            }
        });
		
		blueTimer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		BlueLight.setBackground(normBlue);
            		blueTimer.stop();
            }
        });
		
		yellowTimer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		YellowLight.setBackground(normYellow);
            		yellowTimer.stop();
            }
        });
		
		redTimer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RedLight.setBackground(normRed);
                redTimer.stop();
            }
        });

        timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (RedLight.getBackground().equals(Color.RED) ||
                		GreenLight.getBackground().equals(Color.GREEN) ||
                		BlueLight.getBackground().equals(brightBlue) ||
                		YellowLight.getBackground().equals(Color.YELLOW)) {
	                    RedLight.setBackground(normRed);
	                    GreenLight.setBackground(normGreen);
	                    BlueLight.setBackground(normBlue);
	                    YellowLight.setBackground(normYellow);
                }

                else if (sequence < seq.getSequence().size()) {
                    switch(seq.getSequenceChar(sequence)) {
                    case 'Y':
                    		YellowLight.setBackground(Color.YELLOW);
                    		break;
                    case 'B':
                    		BlueLight.setBackground(brightBlue);
                    		break;
                    case 'G':
                    		GreenLight.setBackground(Color.GREEN);
                    		break;
                    case 'R':
                    		RedLight.setBackground(Color.RED);
                    		break;
                    	default:
                    		break;
                    }
                    sequence++;
                } else {
                		sequence = 0;
                    timer.stop();
                }
            }
        });
		
        Score HiScore = new Score("test.save");
        JOptionPane optionPane = new JOptionPane();
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
		PlayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                turnOrder.setText("Simon Says...");
                seq = new Sequence();
                sequence = 0;
                timer.start();
            }
        });
		PlayBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		PlayBtn.setBackground(new Color(255, 69, 0));
		PlayBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, Color.DARK_GRAY));
		PlayBtn.setHorizontalAlignment(SwingConstants.CENTER);
		PlayBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(PlayBtn);
		
		JMenuItem QuitBtn = new JMenuItem("Quit");
        QuitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
		
		turnOrder = new JLabel("");
		turnOrder.setFont(new Font("Phosphate", Font.PLAIN, 27));
		turnOrder.setHorizontalTextPosition(SwingConstants.CENTER);
		turnOrder.setHorizontalAlignment(SwingConstants.CENTER);
		turnOrder.setBounds(255, 29, 391, 58);
		gamePlane.add(turnOrder);
		
		GreenLight = new JButton("");
		GreenLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GreenLight.setBackground(Color.GREEN);
				greenTimer.stop();
				greenTimer.start();
				if(seq.userInput('G') == true) {
					if(seq.turnOver()) {
						turnOrder.setText("Correct! Score Up!");
						score++;
						doNothing.start();
						seq.getUserGuessSequence().clear();
						nextTurn();
					}
					else {
						turnOrder.setText("Go on...");
					}
				}
				else {
					turnOrder.setText("GAME OVER MAN");
					if(HighScore.IfHighScore(score)) {
						HighScore.AddHighScore(score, JOptionPane.showInputDialog(null, "Enter Initials Here", "High Score Got!", JOptionPane.QUESTION_MESSAGE));
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
					else {
						turnOrder.setText("No high score... try again?");
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
				}
				
			}
		});
		GreenLight.setOpaque(true);
		GreenLight.setBorderPainted(false);
		GreenLight.setBackground(new Color(0, 128, 0));
		gamePlane.setLayer(GreenLight, 2);
		GreenLight.setBounds(308, 128, 113, 112);
		gamePlane.add(GreenLight);
		
		RedLight = new JButton("");
		RedLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RedLight.setBackground(Color.RED);
				redTimer.stop();
				redTimer.start();
				if(seq.userInput('R') == true) {
					if(seq.turnOver()) {
						turnOrder.setText("Correct! Score Up!");
						score++;
						doNothing.start();
						seq.getUserGuessSequence().clear();
						nextTurn();
					}
					else {
						turnOrder.setText("Go on...");
					}
				}
				else {
					turnOrder.setText("GAME OVER MAN");
					if(HighScore.IfHighScore(score)) {
						HighScore.AddHighScore(score, JOptionPane.showInputDialog(null, "Enter Initials Here", "High Score Got!", JOptionPane.QUESTION_MESSAGE));
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
					else {
						turnOrder.setText("No high score... try again?");
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
				}
			}
		});
		RedLight.setOpaque(true);
		RedLight.setBorderPainted(false);
		RedLight.setBackground(new Color(139, 0, 0));
		gamePlane.setLayer(RedLight, 1);
		RedLight.setBounds(477, 128, 110, 112);
		gamePlane.add(RedLight);
		
		BlueLight = new JButton("");
		BlueLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BlueLight.setBackground(brightBlue);
				blueTimer.stop();
				blueTimer.start();
				if(seq.userInput('B') == true) {
					if(seq.turnOver()) {
						turnOrder.setText("Correct! Score Up!");
						score++;
						doNothing.start();
						seq.getUserGuessSequence().clear();
						nextTurn();
					}
					else {
						turnOrder.setText("Go on...");
					}
				}
				else {
					turnOrder.setText("GAME OVER MAN");
					if(HighScore.IfHighScore(score)) {
						HighScore.AddHighScore(score, JOptionPane.showInputDialog(null, "Enter Initials Here", "High Score Got!", JOptionPane.QUESTION_MESSAGE));
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
					else {
						turnOrder.setText("No high score... try again?");
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
				}
			}
		});
		BlueLight.setOpaque(true);
		BlueLight.setBorderPainted(false);
		BlueLight.setBackground(new Color(0, 0, 205));
		gamePlane.setLayer(BlueLight, 2);
		BlueLight.setBounds(311, 315, 110, 112);
		gamePlane.add(BlueLight);
		
		YellowLight = new JButton("");
		YellowLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YellowLight.setBackground(Color.YELLOW);
				yellowTimer.stop();
				yellowTimer.start();
				if(seq.userInput('Y') == true) {
					if(seq.turnOver()) {
						turnOrder.setText("Correct! Score Up!");
						score++;
						doNothing.start();
						seq.getUserGuessSequence().clear();
						nextTurn();
					}
					else {
						turnOrder.setText("Go on...");
					}
				}
				else {
					turnOrder.setText("GAME OVER MAN");
					if(HighScore.IfHighScore(score)) {
						HighScore.AddHighScore(score, JOptionPane.showInputDialog(null, "Enter Initials Here", "High Score Got!", JOptionPane.QUESTION_MESSAGE));
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
					else {
						turnOrder.setText("No high score... try again?");
						seq.getUserGuessSequence().clear();
						seq = new Sequence();
						score = 0;
					}
				}
			}
		});
		YellowLight.setOpaque(true);
		YellowLight.setBorderPainted(false);
		YellowLight.setBackground(new Color(204, 204, 0));
		gamePlane.setLayer(YellowLight, 2);
		YellowLight.setBounds(477, 315, 110, 112);
		gamePlane.add(YellowLight);
		
		JButton SimonGame = new JButton("");
		gamePlane.setLayer(SimonGame, 1);
		SimonGame.setIcon(new ImageIcon(Simon.class.getResource("Simon Game.png")));
		SimonGame.setBounds(294, 115, 308, 326);
		gamePlane.add(SimonGame);
		
		JButton BG = new JButton("");
		BG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BG.setOpaque(true);
		BG.setBackground(Color.WHITE);
		BG.setBounds(0, 0, 911, 582);
		gamePlane.add(BG);
	}
	
	public void nextTurn() {
		seq.addSequence();
		turnOrder.setText("Next turn!");
		timer.start();
	}
}
