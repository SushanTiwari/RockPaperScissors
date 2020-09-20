package test;

public class Round {
		private int numberOfRounds;
	 	private int numberOfPlayers;
	 	private int presentRound=1;
	 	private int ready=0;
	 	
	 	static int draws=0 ;
	 	private static int rockWin=0;
	 	static int paperWin=0;
	    static int scissorsWin=0;
	    private int rock_counter=0;
	    private int paper_counter=0;
	    private int scissors_counter=0;
	    private int winMoveid = 3;
	    private int winId = 0;
	     //   private boolean roundDraw=false;
	    private boolean debug;
	    private boolean done=false;
	    	
	    public Round(int n,int p , boolean d) //new round
	        {
	             numberOfRounds = n;
	             numberOfPlayers=p;
	             debug=d;
	           
	        }
	          
	        public  int getPlayers() // returns number of players
	       {
	             return numberOfPlayers;
	       }
	     	
	   	public int getRounds() //returns number of rounds
	       {
	            return  numberOfRounds;
	      }
	    
	        public synchronized static int getRock() //returns no of time rock wins game
	         {
	             return rockWin;
	        }
	        public synchronized static int getDraw() //returns no of time game is drawn
	        {
	            return draws;
	          }
	    
	       public  synchronized static int getScissors() //returns no of time Scissors wins game
	       {
	           return scissorsWin;
	         }
	        public  synchronized static int getPaper()  //returns no of time Paper wins game
	       {
	        	          return paperWin;
	        	       }
	        	 
	        	
	        	        
	        		private boolean roundDraw() //function to check whether the present is a draw
	        	       {
	        	        if((rock_counter==1 && scissors_counter==0)||(scissors_counter==1 && paper_counter==0)||(paper_counter==1 && rock_counter==0))
	        	       {
	        	            return false;
	        	        }
	        	        else
	        	         {
	        	           return true;
	        	       }
	        	  	
	        	       }
	        	  	
	        	     public synchronized void playRound(int playerId, int id)
	        	      {
	        	          ++ready;  //increment the players count
	        	         
	        	           if(id == 0) //if rock
	        	         {
	        	               ++rock_counter;
	        	         }
	        	         else if (id == 1) //if scissors
	        	         {
	        	             ++scissors_counter;
	        	          }
	        	          
	        	         else   //if paper
	        	             ++paper_counter;
	        	        
	        	         FindWinner(playerId,id); // calls the function winner
	        	         
	        	        if(ready<numberOfPlayers)
	        	         {
	        	              
	        	             try
	        	            {
	        	            	 wait(); //wait till all functions are complete
	        	                   	}
	        	                     	catch(InterruptedException e) {}
	        	                	}
	        	                  	else
	        	                  	{
	        	                     	notifyAll();  //notify all players
	        	                      	printResult(); //print result
	        	                      	ready=0;
	        	                      	winId = -1;
	        	                      	//counter set to 0 for next round
	        	                       	rock_counter=0;
	        	                       	paper_counter=0;
	        	                       	scissors_counter=0;
	        	                     	winMoveid=-1;
	        	                      	
	        	                      	++presentRound; //increase no of rounds
	        	                   	}
	        	             	}
	        	     public void printMove(String s) //function to print output of rounds
	        	     {
	        	       	System.out.println("Round "+ presentRound +": " +s);
	        	       }
	        	       public void FindWinner(int playerId,int id) //winner decision
	        	       {
	        	      	if(     (id==0&&rock_counter==1&&scissors_counter==0)||
	        	                   (id==1&&paper_counter==0&&scissors_counter==1)||
	        	                  (id==2&&paper_counter==1&&rock_counter==0)||
	        	                 (id==1&&rock_counter==1&&scissors_counter==0)||
	        	                  (id==0&&paper_counter==1&&scissors_counter==1)||
	        	                  (id==0&&paper_counter==1&&rock_counter==0)||
	        	                  (id==2&&rock_counter==1&&scissors_counter==0)||
	        	                 (id==2&&scissors_counter==1&&paper_counter==0)||
	        	                 (id==1&&paper_counter==1&&rock_counter==0))
	        	      	{
	        	           	winId=playerId;
	        	         	winMoveid=id;
	        	       	}
	        	       }
	        	     
	        	      	
	        	     	private void printResult() //print the results
	        	     	{
	        	     		      	if(roundDraw())
	        	     		          	
	        	     		     	{
	        	     		          	++draws;
	        	     		         	if (debug)
	        	     		         	{
	        	     		              System.out.println("Round " + presentRound + ": Draw\n");
	        	     		           	}
	        	     		      	}
	        	     	     	else
	        	     		      	{
	        	     		          	if(winMoveid == 0) //if rock wins
	        	     		              	++rockWin;
	        	     		         	else if(winMoveid == 1) //if scissors win
	        	     		             	++scissorsWin;
	        	     		             	else	//if paper wins
	        	     		                 	++paperWin;
	        	     		          	if (debug)
	        	     		         	
	        	     		         	{
	        	     		                  System.out.println("Round " + presentRound + ": Player " + winId +" wins!");
	        	     		          	}
	        	     		         	if (winId==1)
	        	   		        	
	        	     		         	{
	        	     		                 System.out.println("Round " +  presentRound + ": Player " + (winId+1) +" loses!\n");
	        	     		           	   
	        	     		        	}
	        	     		         	else
	        	     		          	{
	        	     		                   System.out.println("Round " +  presentRound + ": Player " + (winId-1) +" loses!\n");
	        	     		          	}
	        	     		      	}
	        	     		 	}
	        	     		 
	        	     		
	        	     		  	public synchronized void finalInfo()
	        	     		  	{
	        	     		      	
	        	     		  	if(!done)
	        	     		  	{
	        	     		      	System.out.println("Summary Statistics:");
	        	     		     	System.out.println("Number of draws: " + draws);
	        	     		     	     	System.out.println("Number of times scissors won: " + scissorsWin);
	        	     		     	     	System.out.println("Number of times rock won: " + rockWin);
	        	     		          	System.out.println("Number of times paper won: " + paperWin);
	        	     		     	     	
	        	     		     	      	done=true;
	        	     		     	   	}
	        	     		     		}
	        	     		     	   }
	        	     	
	        	            	 
	        	            