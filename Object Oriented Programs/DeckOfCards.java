
class DeckOfCards
{
  String deck[] = new String[52];
  String [][]twoDArray = new String[10][10];

  public void initialize()
  {
    String[] rank = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    String[] suits = {"Club","Diamond","Heart","Spade"};

    for(int i=0;i<deck.length;i++)
      deck[i] = suits[i/13] + " " + rank[i%13];

      for(int k=0;k<deck.length;k++)
		{
			int random=(int)(Math.random()*deck.length);
			String temp=deck[k];
			deck[k]=deck[random];
			deck[random]=temp;
    }

      int k=0;
      for(int i=0;i<4;i++)
        for(int j=0;j<9;j++)
        {
          twoDArray[i][j] = deck[k];
          k++;
        }

        for(int i=0;i<4;i++)
        {
          System.out.println("\n\nPlayer "+(i+1)+" has ");
          for(int j=0;j<9;j++)
          {
            System.out.println(twoDArray[i][j]);
          }
        }

  }

  public static void main(String args[]){
    DeckOfCards d = new DeckOfCards();
    d.initialize();
  }
}
