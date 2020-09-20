package test;

  import java.awt.*;
  import java.awt.event.*;
  import java.util.*;
  import java.applet.*;
 
 @SuppressWarnings("serial")
  public class BarGraph extends Frame
  {
  	
  public static final int FRAME_SIZE_X=600;
  public static final int FRAME_SIZE_Y=600;
 
 
//  	public static void main(String[] args) {
  public static void Run() {
      	int draw_c=0,rock_c=0,scissors_c=0, paper_c=0;
          	RunGame rps= new RunGame();
          	int noRounds = rps.getnoRounds();
          	
          	int numberOfPlayers=2;
          	Round round=new Round(noRounds,numberOfPlayers,true);
          	
          	Player player1=new Player(1,round,true);
          	Player player2=new Player(2,round,true);
          	
          	player1.start();
          	player2.start();
          	
          	while(player1.isAlive()||player2.isAlive()) {
              	Thread.yield();
              	
          	}
          	draw_c=Round.getDraw();
          	rock_c=Round.getRock();
          	paper_c=Round.getPaper();
          	scissors_c=Round.getScissors();
          	
          	new BarGraph(draw_c,rock_c,paper_c,scissors_c);
      	}
      @SuppressWarnings("deprecation")
  	BarGraph (int dc,int rc,int sc,int pc){
      	super("Bar Chart");
      	addWindowListener(new WindowAdapter()
              	{
          	public void windowClosing(WindowEvent e) {System.exit(0);}});
      	setSize(FRAME_SIZE_X,FRAME_SIZE_Y);
      	setResizable(false);
 	     setLocationRelativeTo(null);
      	add("Center",new CvBar(dc,rc,sc,pc));
          setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      	show();
              	
  	}
  	class CvBar extends Canvas{
      	int dc,rc,pc,sc;
      	RunGame rps= new RunGame();
      	CvBar(int draw_c,int rock_c,int scissors_c,int paper_c){
          	this.dc=draw_c;
          	this.rc=rock_c;
          	this.sc=scissors_c;
       	   this.pc=paper_c;
      	}
      	
      	public void paint(Graphics g)
     	{
          	int[] finalValues= {dc,rc,pc,sc};
          	Arrays.parallelSort(finalValues);
          	String []finalOptions=new String[4];
          	int []finalValue=new int[4];
          	boolean added1=false;
          	boolean added2=false;
          	boolean added3=false;
          	boolean added4=false;  
          	int[] x_coord= {100,200,300,400};
          	
          	for (int i=0; i<4; i++) {
                  if(finalValues[i]==dc&&!added1) {
                      finalOptions[i]="Draw";
                      finalValue[i]=Round.getDraw();
                  	added1=true;
              	}
              	else if(finalValues[i]==sc&&!added2) {
  	                finalOptions[i]="Paper";
                  	added2=true;
               	}
              	else if(finalValues[i]==rc&&!added3) {
                      finalOptions[i]="Rock";
                  	added3=true;
                   }
              	else if(finalValues[i]==pc&&!added4) {
                      finalOptions[i]="Scissors";
                  	added4=true;
               	}
      	}
          	String a1= finalOptions[0];
          	
          	g.drawString(a1, 100, 480);
          	g.setColor(Color.yellow);
          	g.fillRect(90, (440-finalValues[0]), 40,finalValues[0]);
            g.setColor(Color.black);
          	g.drawString(Integer.toString(finalValues[0]), 100, 500);

    
          	g.setColor(Color.black);
              String a2= finalOptions[1];
          	g.drawString(a2, 200, 480);
          	g.setColor(Color.green);
          	g.fillRect(190, (440-finalValues[1]), 40,finalValues[1]);
          	g.setColor(Color.black);
          	g.drawString(Integer.toString(finalValues[1]), 200, 500);
 
          	String a3= finalOptions[2];
          	g.setColor(Color.black);
          	g.drawString(a3, 300, 480);
          	g.setColor(Color.blue);
          	g.fillRect(290, (440-finalValues[2]), 40,finalValues[2]);
        	g.setColor(Color.black);
          	g.drawString(Integer.toString(finalValues[2]), 300, 500);
          	
          	
          	String a4= finalOptions[3];
          	g.setColor(Color.black);
          	g.drawString(a4, 400, 480);
         	g.setColor(Color.red);
          	g.fillRect(390, (440-finalValues[3]), 40,finalValues[3]);
        	g.setColor(Color.black);
          	g.drawString(Integer.toString(finalValues[3]), 400, 500);
          	
          	g.setColor(Color.black);
          	g.drawString("Relative wins and Draws with 2 Players and "+ rps.getnoRounds() +" Rounds", 100, 50);
          	

  	}
  	}
  }


