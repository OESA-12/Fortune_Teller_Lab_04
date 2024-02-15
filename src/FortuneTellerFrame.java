import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Toolkit;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;    //top
    JPanel displayPnl;  //middle
    JPanel controlPnl; //bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    JLabel titleLbl1;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;

    ArrayList<String> fortunes = new ArrayList<>();
    ArrayList<Integer> check = new ArrayList<>();

    public FortuneTellerFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*(screenWidth / 4), 3*(screenHeight / 4));
        setLocationRelativeTo(null);

        add(mainPnl);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        fortunes.add("A beautiful, smart, and loving person will be coming into your life.");
        fortunes.add("A dubious friend may be an enemy in camouflage.");
        fortunes.add("A faithful friend is a strong defense.");
        fortunes.add("A feather in the hand is better than a bird in the air.");
        fortunes.add("A fresh start will put you on your way.");
        fortunes.add("A friend asks only for your time not your money.");
        fortunes.add("A friend is a present you give yourself.");
        fortunes.add("A gambler not only will lose what he has, but also will lose what he doesn’t have.");
        fortunes.add("A golden egg of opportunity falls into your lap this month.");
        fortunes.add("A good friendship is often more important than a passionate romance.");
        fortunes.add("A good time to finish up old tasks.");
        fortunes.add("A hunch is creativity trying to tell you something.");
    }

    private void createTopPanel() {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/Teller1.jpeg");

        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }

    private void createMiddlePanel() {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        displayPnl.add(scroller);
    }

    private void createBottomPanel() {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

        fortuneBtn.addActionListener((ActionEvent ae) -> {
            Random rnd = new Random();
            int previousNum;
            int x;

            if (check.size() < 1) {
                previousNum = 0;
            }
            else {
                previousNum = check.size()-1;
            }

            while (true){
                x = rnd.nextInt(fortunes.size());
                check.add(x);
                if (x != check.get(previousNum)) {
                    break;
                }
            }
            displayTA.append(fortunes.get(x) + "\n");
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
    }
}