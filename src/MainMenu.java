import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class
MainMenu {
    public static void main(String[] args) {
        int select = openMenu();

        if (select == 0) {
            JFrame frame = new JFrame("Brick Breaker Game");
            GamePlaySingleplayer BRD = new GamePlaySingleplayer();
            frame.addKeyListener(BRD);
            frame.add(BRD);
            frame.setSize(1280, 720);
            frame.setTitle("Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.setVisible(true);
        } else if (select == 1) {
            JFrame frame = new JFrame("Brick Breaker Game");
            GamePlayMultiplayer BRD = new GamePlayMultiplayer();
            frame.addKeyListener(BRD);
            frame.add(BRD);
            frame.setSize(1280, 720);
            frame.setTitle("Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.setVisible(true);
        } else {
            JFrame frame = new JFrame("Brick Breaker Game");
            GamePlayVersus BRD = new GamePlayVersus();
            frame.addKeyListener(BRD);
            frame.add(BRD);
            frame.setSize(1280, 720);
            frame.setTitle("Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.setVisible(true);
        }
    }

    public static int openMenu() {
        Object[] Modes = {"Singleplayer Mode", "Multiplayer Mode", "Versus Mode"};

        int selection = JOptionPane.showOptionDialog(
                null,
                "Select game mode:",
                "Brick Breaker",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Modes,
                Modes[0]);
        return selection;
    }
}
