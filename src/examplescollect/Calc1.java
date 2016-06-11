/*
 * Copyright (C) 2016 Evegen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package examplescollect;

/**
 *
 * @author Evegen
 */
import java.awt.*;
import java.lang.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
public class Calc1 extends JFrame 
{
int firstValue = 0;
String operation = "+";
public Calc1 (String s)
{ 
super(s);
setLayout(null);
Font f = new Font("Serif", Font.BOLD, 12);
Font f1 = new Font("Serif", Font.ITALIC, 20);//потом придумаю какой шрифт использовать в строке
Color c = Color.black;//на всякий случай
setFont(f1);
setSize(350, 320);
setVisible(true);
final JTextField tfl = new JTextField();
tfl.setBounds(10, 20, 320, 35); 
tfl.setFont(f1);
add(tfl);
//создали панели.
JPanel bP1 = new JPanel(new GridLayout(4,3));//панель с цифровами кнопками
JPanel bP2 = new JPanel(new GridLayout(4,1));//панель с арифметическими кнопками
JPanel bP3 = new JPanel(new GridLayout(4,1));//панель с арифметическими кнопками второго порядка
//и разместили их в окне
bP1.setBounds(70, 60, 200, 150);
bP2.setBounds(280, 60, 50, 150);
bP3.setBounds(10, 60, 50, 150);
//Описываем здесь все кнопки, которые нам надо.
JButton b1 = new JButton("1");
//b1.setBounds(110, 100, 40, 40);//в этой конструкции почему-то не учитывается, возможно потому, что размещение идет внутри панели по сетке.
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
JButton bb3 = new JButton("1/x");
bb3.setFont(f);
JButton bb4 = new JButton("=");
bb4.setFont(f);
//собираем панели
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
//создаём слушателей кнопок
b1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"1");
}
});
b2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"2");
}
});
b3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"3");
}
});
b4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"4");
}
});
b5.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"5");
}
});
b6.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"6");
}
});
b7.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"7");
}
});
b8.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"8");
}
});
b9.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"9");
}
});
b10.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"0");
}
});
b11.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String temp = tfl.getText();
tfl.setText(temp.substring(0,temp.length()-1));
}
});
b12.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+",");
}
});

//пишем математические операции

ba1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"+");
}
});
ba2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"-");
}
});
ba3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"/");
}
});
ba4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"*");
}
});

bb1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"(");
}
});

bb2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+")");
}
});
bb4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
tfl.setText(tfl.getText()+"="+(evalExpr2(tfl.getText().toString()))+"");//идет обращение к парсеру 
}
});

/*ого! я нашел способ ввода данных с клавиатуры. 
Однако при таком способе всё потребуется 
парсер скобок и математических знаков
*/
char inChar1;
try {
inChar1=(char)System.in.read();
tfl.setText(Character.toString(inChar1));
} catch  (IOException e) {
System.out.println("Input ERROR");
}




}
// Спиздил парсер строки формул из интернета
public static int find(String expr){
int num = 0;
int ans = -1;
for (int i=0; i<expr.length(); i++){
char c = expr.charAt(i);
if (c=='(') num++;
if (c==')') num--;
if ((c=='+' || c=='-' || c=='*' || c=='%')&& num==1)  ans=i;
}
return ans;
}
public static int chrToInt(char c1,char c2,char c3){//calculate expression
int n1,n2;
n1=c1-'0';
n2=c2-'0';
if(c3=='+')return n1+n2;
else if(c3=='-')return n1-n2;
else if(c3=='%')return n1%n2;
return n1*n2;
}
public  static int evalExpr1(String expr){
    int a=find(expr);
    char c1,c2,c3;
    if(a==-1){//if string contains from 1 char
        int n;
        n=expr.charAt(0)-'0';
        return n;
    }
    if(expr.length()==5){//if string contains from light expression (x+y)
        //c1 left num,c2 right num,c3 +,-,%,*
        c1=expr.charAt(1);
        c2=expr.charAt(3);
        c3=expr.charAt(2);
        return chrToInt(c1,c2,c3);
    }
    String s1,s2;
    s1=expr.substring(1,a);
    s2=expr.substring(a+1,expr.length()-1);
    c1=expr.charAt(a);
    if(c1=='-')return evalExpr1(s1)-evalExpr1(s2);
    if(c1=='%')return evalExpr1(s1)%evalExpr1(s2);
    if(c1=='*')return evalExpr1(s1)*evalExpr1(s2);
    return evalExpr1(s1)+evalExpr1(s2);
}
public static  boolean isLegalExp(String expr){
boolean b=true;
int a=find(expr);
if(a==-1){
if(expr.length()==1){
char c;
c=expr.charAt(0);
if( c<='9'&&c>='0') return b;
else return b=false;
}
else return b=false;
}
String s1,s2;
s1=expr.substring(1,a);
s2=expr.substring(a+1,expr.length()-1);
return isLegalExp(s1)&&isLegalExp(s2);      
}
public static  String evalExpr2(String expr){
if(isLegalExp(expr)){
int n=evalExpr1(expr);
return String.valueOf(n);
}
return "error";
}

public static void main(String[] args) {
Frame f = new Calc1 ("Калькулятор");
f.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent ev){
System.exit(0);
}
});
}
}
