import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Mainframe extends JFrame {
    private JButton Btn1= new JButton("Example");
    private JButton Btn2= new JButton("Encrypt");
    private JLabel  lb  = new JLabel( "key");
    private JButton Btn3= new JButton("clear");
    private JButton Btn4= new JButton("Exit");
    private Container cp;
    private JTextArea  Jtal= new JTextArea();
    private JTextArea  Jtar= new JTextArea();
    private JScrollPane Jspl = new JScrollPane(Jtal);
    private JScrollPane Jspr = new JScrollPane(Jtar);
    private JTextField Tfkey = new JTextField("3");
    private JPanel cp1 = new JPanel(new GridLayout(6,1,3,3));

    private int c=0;
    Mainframe(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        lb.setHorizontalAlignment(JLabel.CENTER);


        cp1.add(Btn1);
        cp1.add(Btn2);
        cp1.add(lb);
        cp1.add(Tfkey);
        cp1.add(Btn3);
        cp1.add(Btn4);
        cp.add(cp1,BorderLayout.CENTER);
        cp.add(Jspl,BorderLayout.WEST);
        cp.add( Jspr,BorderLayout.EAST);
        Jspl.setPreferredSize(new Dimension(200,400));
        Jspr.setPreferredSize(new Dimension(200,400));
        Jtal.setLineWrap(true);
        Jtar.setLineWrap(true);
      Btn1.addActionListener(new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
              Jtal.setText("China's \"Golden Week\" national holiday is under way, and social media users are making light of travel problems that are dogging the annual getaway.\n" +
                      "Social media are dominated by video and images of the congestion that is hampering travel to popular destinations such as Beijing.\n" +
                      "Official newspaper China Daily estimates that some 650 million people will travel within China this week, with a further six million heading abroad.\n" +
                      "Golden Week is one of only two extended periods in which Chinese people can take time off during the year, the other being Chinese New Year, which falls in January or February.");

          }
      });
        Btn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[ ]= Jtal.getText().toCharArray();
                int len = data.length,key=Integer.parseInt(Tfkey.getText());
                for(int i = 0;i<len;i++){
                    data[i]+=key;
                }
                Jtar.setText(new String( data));

            }
        });
        Btn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jtar.setText("");
                Jtal.setText("");
            }
        });

        Btn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

}
