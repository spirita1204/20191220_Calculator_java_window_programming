import java.awt.*;
import java.awt.event.*;
public class calculator
//�@��:���w��;
////
{
   static Frame frm=new Frame("calculator");//�����W���D
   static Button num[]=new Button[10];//�]�w1-9 10�� ���s
   static TextField ta=new TextField("");//��X��ܳ���
   static Button add,dis,pro,div,equal,C,dod;//��Lbutton
   static float save,savedodnext;//�s�Ĥ@�Ӱ��B�⪺�B꿤�  �s�p���I�I�~�ܼ�
   static int savedod;//�s�p���I�e�ܼ�
   static int readop;//�P�_�B��l
   static float secnum;//�s�ĤG�Ӽ�
   static GridLayout grid=new GridLayout(5,4,3,3);//��grid�������t�m 
   static Panel pan2=new Panel(grid);//��panel�]���קK�ܧ�
   public static void main(String args[])
   {	
	   
	  frm.setLocation(200,200);//��l��m���w
	  ta.setEditable(false);
	  ta.setBounds(20,40,120,20);
	  ta.setBackground(new Color(163,237,172));
	  //
     
      frm.setLayout(null);
      frm.setSize(160,180);
      frm.setResizable(false);//�����T�w
      pan2.setBounds(20,60,120,105);
      frm.add(ta);//ta��J����
      
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
      for(int i=0;i<=2;i++) {//�Ʀr�é�J,���wlistener
    	  num[7+i]=new Button(Integer.toString(7+i));
    	  pan2.add(num[7+i]);
    	  num[7+i].addActionListener(new ActLis());
      }
      pan2.add(new Button(" "));//�L�Ϋ��s
      for(int i=0;i<=2;i++) {//�Ʀr�é�J,���wlistener
    	  num[4+i]=new Button(Integer.toString(4+i));
    	  pan2.add(num[4+i]);
    	  num[4+i].addActionListener(new ActLis());
      }
      C=new Button("C");//�k�s
      pan2.add(C);
      C.addActionListener(new ActLis());
      //
      for(int i=0;i<=2;i++) {//�Ʀr�é�J,���wlistener
    	  num[1+i]=new Button(Integer.toString(1+i));
    	  pan2.add(num[1+i]);
    	  num[1+i].addActionListener(new ActLis());      
      }
      equal=new Button("=");//��X����
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
      frm.setVisible(true);//�����
      frm.addWindowListener(new WindowAdapter(){//overwrite ��������������
		  public void windowClosing(WindowEvent e) {System.exit(0);}});
	  //
   }
public static class ActLis implements ActionListener{//ctLis��@ActionListener
	public void actionPerformed(ActionEvent e) {
        Button btn=(Button) e.getSource();
        try {
        for(int i=0;i<=9;i++){//��Ʀr�ɰO���e���æX�ֿ�J
            if(btn==num[i]){
            	String constant=Integer.toString(i);
            		ta.setText(ta.getText()+constant);
             
            }
        }
            if(btn==add) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=1;//���w���ҵ����g�@��
            }
            if(btn==dis) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=2;//���w���ҵ����g�@��
            }
            if(btn==pro) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=3;//���w���ҵ����g�@��
            }
            if(btn==div) {
            	save=Float.parseFloat(ta.getText());
            	ta.setText("");
            	readop=4;//���w���ҵ����g�@��
            }
            if(btn==equal) {
            	secnum=Float.parseFloat(ta.getText());//�N�s�J���X���B��
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
            	ta.setText(Float.toString(secnum));//��X�ù�
            }
            if(btn==C) {
            	ta.setText("");
            }
            if(btn==dod) {//�p���I�ɰ��ʧ@ �X���x�s
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
