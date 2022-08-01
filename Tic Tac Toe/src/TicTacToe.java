import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe  implements ActionListener {
    Random random = new Random();
    JFrame jFrame = new JFrame();
    JPanel title_Panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

TicTacToe(){
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(800,800);
    jFrame.getContentPane().setBackground(new Color(50,50,50));
    jFrame.setLayout(new BorderLayout());
    jFrame.setVisible(true);

    textField.setBackground(new Color(25,25,25));
    textField.setForeground(new Color(25,255,0));
    textField.setFont(new Font("Ink Free",Font.BOLD,75));
    textField.setHorizontalAlignment(JLabel.CENTER);
    textField.setText("Tic-Tac-toe");
    textField.setOpaque(true);
    title_Panel.setLayout(new BorderLayout());
    title_Panel.setBounds(0,0,800,100);

    button_panel.setLayout(new GridLayout(3,3));
    button_panel.setBackground(new Color(150,150,150));
    for (int i=0;i<9;i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]);
        buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }
    jFrame.add(button_panel);
    title_Panel.add(textField);
    jFrame.add(title_Panel,BorderLayout.NORTH);
    firstTurn();

}
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<9;i++){
            if (e.getSource()==buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (random.nextInt(2)==0){
        player1_turn=true;
        textField.setText("X turn");
    }
    else {
        player1_turn=false;
        textField.setText("O turn");

    }
    }
    public void check(){
        if (
                        (buttons[0].getText()=="X")&&
                        (buttons[1].getText()=="X")&&
                        (buttons[2].getText()=="X")
        ){
            xWin(0,1,2);
        }
        if (
                        (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")
        ){
            xWin(3,4,5);
        }
        if (
                        (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWin(6,7,8);
        }
        if (
                        (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xWin(0,3,6);
        }
        if (
                        (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")
        ){
            xWin(1,4,7);
        }
        if (
                        (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWin(2,5,8);
        }
        if (
                        (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ){
            xWin(0,4,8);
        }
        if (
                        (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ){
            xWin(2,4,6);
        }
        if (
                (buttons[0].getText()=="O")&&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")
        ){
            oWin(0,1,2);
        }
        if (
                (buttons[3].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")
        ){
            oWin(3,4,5);
        }
        if (
                (buttons[6].getText()=="O")&&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWin(6,7,8);
        }
        if (
                (buttons[0].getText()=="O")&&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            oWin(0,3,6);
        }
        if (
                (buttons[1].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")
        ){
            xWin(1,4,7);
        }
        if (
                (buttons[2].getText()=="O")&&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWin(2,5,8);
        }
        if (
                (buttons[0].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ){
            oWin(0,4,8);
        }
        if (
                (buttons[2].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ){
            oWin(2,4,6);
        }
    }

    public void xWin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
}
    public void oWin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }
}
