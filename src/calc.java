import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class calc implements ActionListener{
	JFrame f=new JFrame("Calculator");		
	JTextArea t=new JTextArea();
//	t.setEditable(true);
	JTextArea h=new JTextArea();
//	h.setEditable(false);
	
	JScrollPane scroll = new JScrollPane (h, 
			   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	
	JButton bone,btwo,bthree,bfour,bfive,bsix,bseven,beight,bnine,bzero,bdot;
	JButton bplus,bminus,bdiv,bmul,beq,bclear,bback,bcl,bsign,bm;
	JButton bsine,bcos,btan,bln,blog,bexp,bfact,bsq,bxy,bpi,bsqrt,byrt;
	static double a=0,b=0,result=0,pi=3.14,d;
	static int operator=0,pflag=0,more=0;
    String hist ="",temp="";
    // Get JavaScript engine
    ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

    
	
	calc(){
		
		//setting up frame		
		t.setBounds(10,30,420,40);
		h.setBounds(10,80,420,80);
		
		// digits 
		bone=new JButton("1");
		bone.setBounds(200,300,60,40);//x y width height
		btwo=new JButton("2");
		btwo.setBounds(260,300,60,40);
		bthree=new JButton("3");
		bthree.setBounds(320,300,60,40);
		bfour=new JButton("4");
		bfour.setBounds(200,260,60,40);
		bfive=new JButton("5");
		bfive.setBounds(260,260,60,40);
		bsix=new JButton("6");
		bsix.setBounds(320,260,60,40);		
		bseven=new JButton("7");
		bseven.setBounds(200,220,60,40);
		beight=new JButton("8");
		beight.setBounds(260,220,60,40);
		bnine=new JButton("9");
		bnine.setBounds(320,220,60,40);
		bzero=new JButton("0");
		bzero.setBounds(200,340,120,40);		
		bdot=new JButton(".");
		bdot.setBounds(320,340,60,40);
		bcl=new JButton("cl");
		bcl.setBounds(140,180,60,40);
		bsign=new JButton("+-");
		bsign.setBounds(80,180,60,40);
		bm=new JButton("M");
		bm.setBounds(20,180,60,40);
		
		
		//operators
		bplus=new JButton("+");
		bplus.setBounds(380,300,60,40);
		bminus=new JButton("-");
		bminus.setBounds(380,260,60,40);
		bmul=new JButton("*");
		bmul.setBounds(380,220,60,40);
		bdiv=new JButton("/");
		bdiv.setBounds(380,180,60,40);
		beq=new JButton("=");	
		beq.setBounds(380,340,60,40);
		bclear=new JButton("CE");
		bclear.setBounds(200,180,120,40);
		bback=new JButton("back");
		bback.setBounds(320,180,60,40);
		
		//scientific operators

		bsine=new JButton("sin");
		bsine.setBounds(140,260,60,40);
		bcos=new JButton("cos");
		bcos.setBounds(80,260,60,40);
		btan=new JButton("tan");
		btan.setBounds(20,260,60,40);
		bln=new JButton("ln");
		bln.setBounds(140,300,60,40);
		blog=new JButton("log");
		blog.setBounds(80,300,60,40);
		bexp=new JButton("10x");
		bexp.setBounds(20,300,60,40);
		bfact=new JButton("n!");
		bfact.setBounds(140,340,60,40);
		bsq=new JButton("x^2");
		bsq.setBounds(80,340,60,40);
		bxy=new JButton("x^y");
		bxy.setBounds(20,340,60,40);
		bpi=new JButton("pi");
		bpi.setBounds(140,220,60,40);
		bsqrt=new JButton("\u221a");
		bsqrt.setBounds(80,220,60,40);
		byrt=new JButton("yrt");
		byrt.setBounds(20,220,60,40);
		
		
		
		//add actionlisteners
		bone.addActionListener(this);
		btwo.addActionListener(this);
		bthree.addActionListener(this);
		bfour.addActionListener(this);
		bfive.addActionListener(this);
		bsix.addActionListener(this);
		bseven.addActionListener(this);
		beight.addActionListener(this);
		bnine.addActionListener(this);
		bzero.addActionListener(this);
		bdot.addActionListener(this);
		bplus.addActionListener(this);
		bminus.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		beq.addActionListener(this);
		bclear.addActionListener(this);
		bback.addActionListener(this);
		bsine.addActionListener(this);
		bcos.addActionListener(this);
		btan.addActionListener(this);
		bln.addActionListener(this);
		blog.addActionListener(this);
		bexp.addActionListener(this);
		bfact.addActionListener(this);
		bsq.addActionListener(this);
		bxy.addActionListener(this);
		bpi.addActionListener(this);
		bsqrt.addActionListener(this);
		byrt.addActionListener(this);
		bcl.addActionListener(this);
		bsign.addActionListener(this);
		bm.addActionListener(this);
		
		
		
		//add buttons to frame
		f.add(bone);f.add(btwo);f.add(bthree);
		f.add(bfour);f.add(bfive);f.add(bsix);
		f.add(bseven);f.add(beight);f.add(bnine);
		f.add(bzero);f.add(bdot);f.add(beq);
		f.add(bplus);f.add(bminus);f.add(bmul);f.add(bdiv);
		f.add(t);f.add(bback);f.add(bclear);
		f.add(h);f.add(bsine);f.add(bcos);f.add(btan);
		f.add(bln);f.add(blog);f.add(bexp);
		f.add(bfact);f.add(bsq);f.add(bxy);
		f.add(bpi);f.add(bsqrt);f.add(byrt);
		f.add(bcl);f.add(bsign);f.add(bm);
		f.add(scroll);
		
		
		
		f.setSize(450,420);  
		f.setResizable(false);
		f.setLayout(null);  
		f.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e){ 
		//digits
		if(e.getSource()==bone)
            t.setText(t.getText().concat("1"));
		if(e.getSource()==btwo)
            t.setText(t.getText().concat("2"));        
        if(e.getSource()==bthree)
            t.setText(t.getText().concat("3"));        
        if(e.getSource()==bfour)
            t.setText(t.getText().concat("4"));        
        if(e.getSource()==bfive)
            t.setText(t.getText().concat("5"));        
        if(e.getSource()==bsix)
            t.setText(t.getText().concat("6"));        
        if(e.getSource()==bseven)
            t.setText(t.getText().concat("7"));        
        if(e.getSource()==beight)
            t.setText(t.getText().concat("8"));        
        if(e.getSource()==bnine)
            t.setText(t.getText().concat("9"));       
        if(e.getSource()==bzero)
            t.setText(t.getText().concat("0"));
        if(e.getSource()==bdot)
            t.setText(t.getText().concat("."));
        if(e.getSource()==bpi)
         { t.setText(t.getText().concat("pi"));a=3.14;}
        if(e.getSource()==bclear)
            t.setText("");
        if(e.getSource()==bcl)
            {h.setText("");hist="";temp="";}
        
        //operators
        if(e.getSource()==bplus)
        {
        	if(more==1){
        		hist+=t.getText()+")+";
        		pflag=0;
        	}else
        		hist=hist + t.getText()+"+";
            h.setText(hist);
        	a=Double.parseDouble(t.getText());
            operator=1;
            t.setText("");
            more=0;
        }        
        if(e.getSource()==bminus)
        {
        	if(more==1){
        		hist+=t.getText()+")+";
        		pflag=0;
        	}else
        		hist=hist + t.getText()+"-";
        	h.setText(hist);
            a=Double.parseDouble(t.getText());
            operator=2;
            t.setText("");
        }        
        if(e.getSource()==bmul)
        {
        	if(more==1){
        		hist+=t.getText()+")+";
        		pflag=0;
        	}else
        		hist=hist + t.getText()+"*";
        	h.setText(hist);
            a=Double.parseDouble(t.getText());
            operator=3;
            t.setText("");
        }        
        if(e.getSource()==bdiv)
        {
        	if(more==1){
        		hist+=t.getText()+")+";
        		pflag=0;
        	}else
        	hist=hist + t.getText()+"/";
        	h.setText(hist);
            a=Double.parseDouble(t.getText());
            operator=4;
            t.setText("");
        }
        if(e.getSource()==bsine)
        {
        	pflag=1;
        	hist=hist + "Math.sin(";
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=5;
            more=1;
            t.setText("");
        }
        if(e.getSource()==bcos)
        {
        	pflag=1;
        	hist=hist + "Math.cos(";
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=6;
            more=1;
            t.setText("");
        }
        if(e.getSource()==btan)
        {
        	pflag=1;
        	hist=hist +"Math.tan(";
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=7;
            more=1;
            t.setText("");
        }
        if(e.getSource()==bln)
        {
        	pflag=1;
        	hist=hist +"Math.log("+ t.getText();
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=8;
            more=1;
            t.setText("");
        }
        if(e.getSource()==blog)
        {
        	pflag=1;
        	hist=hist +"0.4344*Math.log("+ t.getText();
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=9;
            more=1;
            t.setText("");
        }
        if(e.getSource()==bexp)
        {
        	pflag=1;
        	hist=hist +"Math.pow(10,"+ t.getText();
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=10;
            more=1;
            t.setText("");
        }
        if(e.getSource()==bfact)
        {
        	hist=hist + t.getText()+"fact:";
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=11;
            t.setText("");
        }
        if(e.getSource()==bsq)
        {
        	pflag=2;
        	hist=hist+"Math.pow("+ t.getText();
        	h.setText(hist);
          // a=Double.parseDouble(t.getText());
            operator=12;
            more=1;
            t.setText("");
        }
        if(e.getSource()==bsqrt)
        {
        	pflag=2;
        	hist=hist +"Math.pow("+ t.getText();
        	h.setText(hist);
          //  a=Double.parseDouble(t.getText());
            operator=13;
            more=1;
            t.setText("");
        }
        if(e.getSource()==bxy)
        {
        	pflag=3;
        	hist=hist +"Math.pow("+ t.getText();
        	h.setText(hist);
            a=Double.parseDouble(t.getText());
            operator=14;
            more=1;
            t.setText("");
        }
        if(e.getSource()==byrt)
        {
        	pflag=3;
        	hist=hist +"Math.pow("+ t.getText();
        	h.setText(hist);
            a=Double.parseDouble(t.getText());
            operator=15;
            more=1;
            t.setText("");
        }
        if(e.getSource()==beq)
        {	
        	if(pflag==1){
        		if(operator==4 || operator==5 || operator==6)
        			hist=hist +String.valueOf((3.14/180)*Double.parseDouble(t.getText()))+")";
        		else
        			hist=hist +t.getText()+")";
        		pflag=0;
        	} else if(pflag==2){
        		if(operator==13)
        			hist+=",0.5)";
        		else
        			hist+=",2)";
        		pflag=0;
        	}else if(pflag==3){
        		if(operator==15)
        			hist+=","+String.valueOf(1/Double.parseDouble(t.getText()))+")";
        		else
        			hist+=","+t.getText()+")";
        		pflag=0;
        	}   		
        	else
        		hist=hist + t.getText();
        	
        	try {
                // Evaluate the expression
                Object result = engine.eval(hist);
                d=Double.parseDouble(result.toString());
                t.setText(String.valueOf(d));
                hist=hist+ "="+result+"\n";
                System.out.println(hist + " = " + result);
            }
            catch (ScriptException f) {
                // Something went wrong
                f.printStackTrace();
            }
            
        	b=Double.parseDouble(t.getText());
        	/*
            switch(operator)
            {
                case 1: result=a+b;
                    break;
        
                case 2: result=a-b;
                    break;
        
                case 3: result=a*b;
                    break;
        
                case 4: result=a/b;
                    break;
                case 5:result=Math.sin(Math.toRadians(b));
                	break;
                case 6:result=Math.cos(Math.toRadians(b));
                	break;
                case 7:result=Math.tan(Math.toRadians(b));
                	break;
                case 8:result=Math.log(b);
                	break;
                case 9:result=Math.log(b)/Math.log(10);
                	break;
                case 10:result=Math.pow(10, b);
                	break;
                case 11:result=1;
                	while(b>0){
                	result=result*b;
                	b--;
                    }
                	break;
                case 12:result=Math.pow(b, 2);
                	break;
                case 13:result=Math.pow(b, 0.5);
                	break;
                case 14:
                	result=Math.pow(a, b);
                	break;
                case 15:
                	result=Math.pow(a, (1/b));
                	break;
        
                default: result=0;
            }
            */
        	temp=hist+temp;
        	hist="";
         //   t.setText("");            
            h.setText(temp);
            more=0;
        }
        if(e.getSource()==bback)
        {
            String s=t.getText();
            t.setText("");
            for(int i=0;i<s.length()-1;i++)
            t.setText(t.getText()+s.charAt(i));
        }   
        
	}
	
	
	
	
	public static void main(String args[]){
		new calc();
	}
	
}