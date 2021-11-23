import java.awt.*;
import java.awt.event.*;
public class calculator
//作者:陳定宏;
////
{
   static Frame frm=new Frame("calculator");//視窗上標題
   static Button num[]=new Button[10];//設定1-9 10個 按鈕
   static TextField ta=new TextField("");//輸出顯示部分
   static Button add,dis,pro,div,equal,C,dod;//其他button
   static float save,savedodnext;//存第一個做運算的運篹元  存小數點點外變數
   static int savedod;//存小數點前變數
   static int readop;//判斷運算子
   static float secnum;//存第二個數
   static GridLayout grid=new GridLayout(5,4,3,3);//用grid做版面配置 
   static Panel pan2=new Panel(grid);//用panel包裝避免變形
   public static void main(String args[])
   {	
	   
	  frm.setLocation(200,200);//初始位置給定
	  ta.setEditable(false);
	  ta.setBounds(20,40,120,20);
	  ta.setBackground(new Color(163,237,172));
	  //
     
      frm.setLayout(null);
      frm.setSize(160,180);
      frm.setResizable(false);//視窗固定
      pan2.setBounds(20,60,120,105);
      frm.add(ta);//ta塞入視窗
      
      //
      add=new Button("+");//+
      pan2.add(add);
      add.addActionListener(new ActLis());
      //
      dis=new Button("-");//-
      pan2.add(dis);
      dis.addActionListener(new ActLis());
      //
      pro=new Button("*");//*
      pan2.add(pro);
      pro.addActionListener(new ActLis());
      //
      div=new Button("/");// /
      pan2.add(div);
      div.addActionListener(new ActLis());
      //
      for(int i=0;i<=2;i++) {//數字紐放入,給定listener
    	  num[7+i]=new Button(Integer.toString(7+i));
    	  pan2.add(num[7+i]);
    	  num[7+i].addActionListener(new ActLis());
      }
      pan2.add(new Button(" "));//無用按鈕
      for(int i=0;i<=2;i++) {//數字紐放入,給定listener
    	  num[4+i]=new Button(Integer.toString(4+i));
    	  pan2.add(num[4+i]);
    	  num[4+i].addActionListener(new ActLis());
      }
      C=new Button("C");//歸零
      pan2.add(C);
      C.addActionListener(new ActLis());
      //
      for(int i=0;i<=2;i++) {//數字紐放入,給定listener
    	  num[1+i]=new Button(Integer.toString(1+i));
    	  pan2.add(num[1+i]);
    	  num[1+i].addActionListener(new ActLis());      
      }
      equal=new Button("=");//輸出答案
      pan2.add(equal);
      equal.addActionListener(new ActLis());
      //
      pan2.add(new Button(" "));
      //
      num[0]=new Button("0");
      pan2.add(num[0]);
      num[0].addActionListener(new ActLis());
      //
      dod=new Button(".");
      pan2.add(dod);
      dod.addActionListener(new ActLis());
      
      pan2.add(new Button(" "));
      frm.add(pan2);
      frm.setVisible(true);//使顯示
      frm.addWindowListener(new WindowAdapter(){//overwrite 讓視窗關閉有效
		  public void windowClosing(WindowEvent e) {System.exit(0);}});
	  //
   }
public static class ActLis implements ActionListener{//ctLis實作ActionListener
	public void actionPerformed(ActionEvent e) {
        Button btn=(Button) e.getSource();
        try {
        for(int i=0;i<=9;i++){//當數字時記錄前次並合併輸入
            if(btn==num[i]){
            	String constant=Integer.toString(i);
            		ta.setText(ta.getText()+constant);
             
            }
        }
            if(btn==add) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=1;//給定標籤等等寫作用
            }
            if(btn==dis) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=2;//給定標籤等等寫作用
            }
            if(btn==pro) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=3;//給定標籤等等寫作用
            }
            if(btn==div) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=4;//給定標籤等等寫作用
            }
            if(btn==equal) {
            	secnum=Float.parseFloat(ta.getText());//將存入拿出做運算
            	if(readop==1) {//+
            		secnum=save+secnum;
            	}
            	if(readop==2) {//-
            		secnum=save-secnum;
            	}
            	if(readop==3) {//*
            		secnum=save*secnum;
            	}
            	if(readop==4) {///
            		secnum=save/secnum;
            	}
            	ta.setText(Float.toString(secnum));//輸出螢幕
            }
            if(btn==C) {
            	ta.setText("");
            }
            if(btn==dod) {//小數點時做動作 合併儲存
            	savedod=Integer.parseInt(ta.getText());
            	ta.setText(savedod+".");
            	savedodnext=Integer.parseInt(ta.getText());
            }
        }
        catch(Exception e2){
        	
        }
	}
}
}
