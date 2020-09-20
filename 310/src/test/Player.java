package test;
  /* a thread is created for each player */
  import java.awt.Graphics;
  import java.util.Random;
 
 
  @SuppressWarnings("unused")
  class Player extends Thread
  {
  	private static String[] options= {"Rock","Scissors","Paper"};
 	private int index; //defining our option
  	private int player_Id; //id of player
 	private Random random; // a random class
 	private Round rounds; //will use for our convinence
 	private boolean debug;
 	
 	
  	public Player(int i, Round r, boolean d) // a constructor for new player
 	{
     	player_Id = i ;
     	random=new Random();
     	rounds = r;
     	debug=d;
  	}
  	
  public synchronized String getOption() //retrive the option of player
  {
  	return options[index];
  }   public void run()
  	{
     	try {
        	Thread.sleep(1000); //to slow down execution
         	}
  	 catch (InterruptedException e) {
      	e.printStackTrace();
      	
  	}
     	for(int i = 1; i <= rounds.getRounds(); i++)//execute loop n times
     		      	{
     		         	index=random.nextInt(3); // random selection of rock, paper, scissors
     		        	if(debug)
     		         	{
     		            	rounds.printMove("Player "+ player_Id +" selects "+getOption());
     		        	}
     		               rounds.playRound(player_Id,index);
     	     	}
     		         	rounds.finalInfo();  //showing final info
     		
     		     	} 
  }