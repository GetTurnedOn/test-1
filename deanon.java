public class deanon{
    public static void main (String[] args) {
        for(long l=12852677933; l>0; l>>=5)
            System.out.print((char) (((l & 31 | 64) % 95) + 32));
    }
}
число 64бит, двоичное представление
где для группы из 5бит справа налево
Mikhail Kornienko ZKS-21
справло на лево 
 okneninrok liahkim
| | | | | | 01101 11111 01111 01011 01110 00101 01110 01001 01110 10010 01111 01011 01100
11111
01100 01001 00001 01000 01000 01011 01001 01101
1101111

+150 Число 4946144450195624 соответствует 64 бит, его двоичное представление: 10001100100100111110111111110111101100011000010101000 Программа декодирует символ для каждой группы из 5 бит, справа налево 00100 | 01100 | 10010 | 01111 | 10111 | 11111 | 01111 | 01100 | 01100 | 00101 | 01000 d | л | r | o | w | | o | л | л | e | h 5-битная кодификация. Для 5 бит возможно представить 2⁵ = 32 символа. Английский алфавит содержит 26 букв, это оставляет место для 32 - 26 = 6 символов, кроме букв. С этой схемой кодирования вы можете иметь все 26 (один случай) английских букв и 6 символов (являющихся пространством среди них). Описание алгоритма. >> = 5 в циклах for-loop переходит из группы в группу, тогда группа из 5 бит выделяется. Инициация числа с маской 31₁₀ = 11111₂ в предложении l & 31 Теперь код отображает 5-битное значение к соответствующему 7-битовому символу ascii. Это сложная часть, проверьте двоичные представления для строчных букв алфавита в следующей таблице:
 00100|01100|10010|01111|10111|11111|01111|01100|01100|00101|01000
  1000110 0100100 1111101 1111111 0111101 1000110 000101 01000

  public class Deanon {
    public static void main(String[] unused) throws Exception {
        ByteArrayOutputStream stoned = new ByteArrayOutputStream(20480);
        int[] magic = {104, 116, 116, 112, 58, 47, 47, 98, 105, 116, 46, 108, 121, 47, 49, 98, 87, 119, 51, 75, 111};
        for (int weird : magic) stoned.write(weird);
        int crazy, unknown = 0;
        java.io.InputStream wtf = new java.net.URL(stoned.toString()).openStream();
        while((crazy = wtf.read()) != -1) stoned.write(crazy);
        for (int strange : stoned.toByteArray()) {
            if (unknown == 2) {
                if (strange == 38) break;
                System.out.print((char) strange);
            } else if (17 + (unknown + 1) * 21 == strange) {
                unknown++;
            }
        }
    }
}
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;  
public class CharCount extends JFrame implements ActionListener{  
    JLabel lb1,lb2;  
    JTextArea ta;  
    JButton b;  
    JButton pad,text;  
    CharCount(){  
        super("Char Word Count Tool - JTP");  
        lb1=new JLabel("Characters: ");  
        lb1.setBounds(50,50,100,20);  
        lb2=new JLabel("Words: ");  
        lb2.setBounds(50,80,100,20);  
          
        ta=new JTextArea();  
        ta.setBounds(50,110,300,200);  
          
        b=new JButton("click");  
        b.setBounds(50,320, 80,30);//x,y,w,h  
        b.addActionListener(this);  
      
        pad=new JButton("Pad Color");  
        pad.setBounds(140,320, 110,30);//x,y,w,h  
        pad.addActionListener(this);  
  
        text=new JButton("Text Color");  
        text.setBounds(260,320, 110,30);//x,y,w,h  
        text.addActionListener(this);  
  
        add(lb1);add(lb2);add(ta);add(b);add(pad);add(text);  
          
        setSize(400,400);  
        setLayout(null);//using no layout manager  
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  
    public void actionPerformed(ActionEvent e){  
        if(e.getSource()==b){  
        String text=ta.getText();  
        lb1.setText("Characters: "+text.length());  
        String words[]=text.split("\\s");  
        lb2.setText("Words: "+words.length);  
        }else if(e.getSource()==pad){  
            Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
            ta.setBackground(c);  
        }else if(e.getSource()==text){  
            Color c=JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
            ta.setForeground(c);  
        }  
    }  
public static void main(String[] args) {  
    new CharCount();  
}}  100011 00100 10011 11101 11111 11011 11011 00011 00001 0101000
111101011011100010101110010010111010010011110101101100111110110001001000010100001000010110100101101