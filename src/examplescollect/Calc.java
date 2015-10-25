package examplescollect;
/**
 *
 * @author Lartsev
 */
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.*;
import javax.swing.*;
class Calc extends JFrame 
{
    BigDecimal firstValue;
    BigDecimal secondValue;
    String operation = "+";
    Font f = new Font("Serif", Font.BOLD, 12);
    Font f1 = new Font("Serif", Font.ITALIC, 20);
        
    Calc (String s)
           {
               //super(s);
               setTitle(s);
               setLayout(null);
               setSize(370, 280);
               
               setFont(f1);
               
               //Container Cntnr=getContentPane();
               
               JTextField tfl = new JTextField();
               tfl.setBounds(10, 20, 320, 35);
               tfl.setFont(f1);
               add(tfl);
//панель с цифровами кнопками               
               JPanel bP1 = new JPanel(new GridLayout(4,3));
//панель с арифметическими кнопками
               JPanel bP2 = new JPanel(new GridLayout(4,1));
//панель с арифметическими кнопками второго порядка
               JPanel bP3 = new JPanel(new GridLayout(4,1));
//и разместили их в окне
               bP1.setBounds(70, 60, 200, 150);
               bP2.setBounds(280, 60, 50, 150);
               bP3.setBounds(10, 60, 50, 150);
//Вначале создаём здесь все кнопки, которые нам надо.
               JButton b1 = new JButton("1");
               b1.setFont(f);
               JButton b2 = new JButton("2");
               b2.setFont(f);
               JButton b3 = new JButton("3");
               b3.setFont(f);
               JButton b4 = new JButton("4");
               b4.setFont(f);
               JButton b5 = new JButton("5");
               b5.setFont(f);
               JButton b6 = new JButton("6");
               b6.setFont(f);
               JButton b7 = new JButton("7");
               b7.setFont(f);
               JButton b8 = new JButton("8");
               b8.setFont(f);
               JButton b9 = new JButton("9");
               b9.setFont(f);
               JButton b10 = new JButton("0");
               b10.setFont(f);
               JButton b11 = new JButton("bs");
               b11.setFont(f);
               JButton b12 = new JButton(",");
               b12.setFont(f);
//расписывем арифметические кнопки
               JButton ba1 = new JButton("+");
               ba1.setFont(f);
               JButton ba2 = new JButton("-");
               ba2.setFont(f);
               JButton ba3 = new JButton("/");
               ba3.setFont(f);
               JButton ba4 = new JButton("*");
               ba4.setFont(f);
//расписываем арифметические кнопки второго порядка
               JButton bb1 = new JButton("(");
               bb1.setFont(f);
               JButton bb2 = new JButton(")");
               bb2.setFont(f);
               JButton bb3 = new JButton("^");
               bb3.setFont(f);
               JButton bb4 = new JButton("=");
               bb4.setFont(f);
//из созданных кнопок собираем панели
               bP1.add(b1);
               bP1.add(b2);
               bP1.add(b3);
               bP1.add(b4);
               bP1.add(b5);
               bP1.add(b6);
               bP1.add(b7);
               bP1.add(b8);
               bP1.add(b9);
               bP1.add(b10);
               bP1.add(b11);
               bP1.add(b12);
               add(bP1);
               bP2.add(ba1);
               bP2.add(ba2);
               bP2.add(ba3);
               bP2.add(ba4);
               add(bP2);
               bP3.add(bb1);
               bP3.add(bb2);
               bP3.add(bb3);
               bP3.add(bb4);
               add(bP3);
               

               
//создаём слушателей цифровых кнопок
               b1.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"1");
               });
               b2.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"2");
               });
               b3.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"3");
               });
               b4.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"4");
               });
               b5.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"5");
               });
               b6.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       tfl.setText(tfl.getText()+"6");
                       }
                   });
               b7.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       tfl.setText(tfl.getText()+"7");
                       }
                   });
               b8.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"8");
               });
               b9.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"9");
               });
               b10.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"0");
               });
               b11.addActionListener((ActionEvent e) -> {
                   String temp = tfl.getText();
                   tfl.setText(temp.substring(0,temp.length()-1));
               });
               b12.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+".");
               });
               bb1.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+"(");
               });
               bb2.addActionListener((ActionEvent e) -> {
                   tfl.setText(tfl.getText()+")");
               });
//назначаем математическим кнопкам своих слушателей
               ba1.addActionListener((ActionEvent e) -> {
                   firstValue = new BigDecimal(tfl.getText());
                   tfl.setText("");
                   operation = "+";
               });
               ba2.addActionListener((ActionEvent e) -> {
                   //а вот таким вот методом мы разрешаем ставить первым символом 
                   //знак минус то есть создали условие - если строка пустая, 
                   //то значит можно написать минус :-)
                   if (tfl.getText().length() == 0 ) {
                       tfl.setText("-");
                   }
                   else {
                       firstValue = new BigDecimal(tfl.getText());
                       tfl.setText("");
                       operation = "-";}
               });
               ba3.addActionListener((ActionEvent e) -> {
                   firstValue = new BigDecimal(tfl.getText());
                   tfl.setText("");
                   operation = "/";
               });
               ba4.addActionListener((ActionEvent e) -> {
                   firstValue = new BigDecimal(tfl.getText());
                   tfl.setText("");
                   operation = "*";
               });
               bb3.addActionListener((ActionEvent e) -> {
                   firstValue = new BigDecimal(tfl.getText());
                   tfl.setText("");
                   operation = "^";
               });
//Пишем что будет, если нажать знак равно
               bb4.addActionListener((ActionEvent e) -> {
                   secondValue = new BigDecimal(tfl.getText());
//считываем второе значение из строки калькулятора,
//и далее математическая операция если выполняются условия 
// (а условие здесь - это нахождение своебразной метки типа String:
                   if ("+".equals(operation)) {
                       BigDecimal s1 = firstValue.add(secondValue);
                       tfl.setText(s1.toString() + "");
                   }
                   if ("-".equals(operation)) {
                       BigDecimal s2 = firstValue.subtract(secondValue);
                       tfl.setText(s2.toString() + "");
                   }
                   if ("/".equals(operation)) {
                       BigDecimal s3 = firstValue.divide(secondValue,6,BigDecimal.ROUND_HALF_EVEN);
                       tfl.setText(s3.toString() + "");
                   }
                   if ("*".equals(operation)) {
                       BigDecimal s4 = firstValue.multiply(secondValue);
                       tfl.setText(s4.toString() + "");
                   }
                   /*а вот здесь интересней
                   потому как в классе BigDecimal не предусмотрена степень как таковая,
                   поэтому приходится переменные конвертировать в другой,
                   близкий по точности тип переменных, и далее работать уже с ними,
                   применяя по ним методы класса Math
                   */
                   if("^".equals(operation)) {
                       double a = firstValue.doubleValue();
                       double c = secondValue.doubleValue();
                       String q = Double.toString(Math.pow(a,c));
                       tfl.setText(q+"");
                   }
               });
               /* ого! я нашел способ ввода данных с клавиатуры.
               Однако при таком способе всё потребуется
               парсер скобок и математических знаков
               */
               char inChar1;
               try {
                   //читаем символ из входного потока
                   inChar1=(char)System.in.read();
                   //преобразуем в строку и отправляем в строку калькулятора
                   tfl.setText(Character.toString(inChar1));
                   } catch  (IOException e) {
                       System.out.println("Input ERROR");
                       }
               }
       
    public static void main (String[] args){
        java.awt.EventQueue.invokeLater(() -> {
            Calc calc = new Calc("Калькулятор");
            calc.setVisible(true);
            calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calc.setVisible(true);
        });
    /*
        Frame f = new Calc ("Калькулятор");
        f.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent ev){
                System.exit(0);
                }
            });
        */
    
        }
}
    
