import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		GameWorld.player=new Player(100,300,0,0);
		addKeyListener(GameWorld.player);
		GameWorld.stage=1;
		GameWorld.score=0;
		while(true) {
			GameWorld.player.x=100;
			GameWorld.player.y=300;

			GameWorld.playerBullets=new Vector<PlayerBullet>();
			GameWorld.enemies=new Vector<Enemy>();
			GameWorld.enemies.add(new EnemyBase(100,50,GameWorld.stage,0));
			GameWorld.enterPressed=false;
			while(true)
			{
				clear();
				drawString("stage="+GameWorld.stage,400,50,15);
				drawString("score="+GameWorld.score,400,80,15);
				GameWorld.player.draw(this);
				GameWorld.player.move();
				movePlayerBullets();
				moveEnemies();
				checkPlayerAndEnemies();
				checkPlayerBulletAndEnemies();
				for (int i=0 ; i<GameWorld.enemies.size(); i++)
				{
					Enemy e=GameWorld.enemies.get(i);


					if (Math.abs(e.x-GameWorld.player.x)<=30 && 
							Math.abs(e.y-GameWorld.player.y)<30)
					{
						System.out.println("やられた！");
						GameWorld.player.y=-1000;

					}

				}
				if (GameWorld.enemies.size()==0)
				{
					setColor(0,0,0);
					drawString("クリア",100,200,40);
					if(GameWorld.enterPressed)
					{
					GameWorld.stage++;
						break;
						
					}
				}
				else if(GameWorld.player.y<0)
				{
					setColor(0,0,0);
					drawString("け゛ーむ　おーは゛ー",50,200,40);
					if(GameWorld.enterPressed)
					{
						GameWorld.stage=1;
						GameWorld.score=0;
						break;
					}
				}
				sleep(0.01);
		}
		}
	}
		public void movePlayerBullets() 
		{
			int i=0;
			while(i<GameWorld.playerBullets.size())
			{
				PlayerBullet b=GameWorld.playerBullets.get(i);
				b.draw(this);
				b.move();
				if (b.y<0) 
				{
				GameWorld.playerBullets.remove(i);	
				}
				else
				{
			 	i++;
				}
			}
			
		}
		public void moveEnemies()
		{
			for (int i=0 ; i<GameWorld.enemies.size() ; i++)
			{
				Enemy e=GameWorld.enemies.get(i);
				e.draw(this);
				e.move();
			}
			int i=0;
			while (i<GameWorld.enemies.size())
			{
				Enemy e=GameWorld.enemies.get(i);
                 {
					if (e.y>450)
					{
						GameWorld.enemies.remove(i);
					}
					else
					{
						i++;
					}
				}
			}
		}
		public void checkPlayerAndEnemies()
		{
			for (int i=0 ; i<GameWorld.enemies.size(); i++)
			{
				Enemy e=GameWorld.enemies.get(i);
				if (checkHit(GameWorld.player,e))
				{
					System.out.println("やられた！");
					GameWorld.player.y=-1000;
					
				}
			}
		}

		public void checkPlayerBulletAndEnemies() 
		{
			int i=0;
			while (i<GameWorld.playerBullets.size())
			{
				PlayerBullet b=GameWorld.playerBullets.get(i);
				int j=0;
				int hits=0;
				while (j<GameWorld.enemies.size())
				{
					Enemy e=GameWorld.enemies.get(j);
					if (checkHit(e,b))
					{
						System.out.println("あたり");
						hits++;
						e.life--;
					}
					if (e.life<=0)
					{
						GameWorld.score+=e.score;
						GameWorld.enemies.remove(j);
					}
					else
					{
						j++;
					}
				//	j++;
				}
			//	i++;
				if (hits>0)
				{
					GameWorld.playerBullets.remove(i);
				}
				else 
				{
					i++;
				}
				
			}
		}
		public boolean checkHit(Character a, Character b)
		{
			if (Math.abs(a.x-b.x)<=25 && Math.abs(a.y-b.y)<=25)
			{
			return true;
		}
			else
			{
			return false;
		}
}
	
		
				
	

}
