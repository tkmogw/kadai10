
public class EnemyBase extends Enemy{
	public EnemyBase (double x,double y,double vx,double vy)	
	{
		super(x,y,vx,vy);
		life=GameWorld.stage*2+20;       
		score=10;
	}
	public void move()
	{
		super.move();
		if (x>450) vx=-GameWorld.stage;
		if (x<0) vx=GameWorld.stage;
		if (Math.random()<0.05)
		{
			GameWorld.enemies.add(new StraightEnemy(x,y,0,1+GameWorld.stage));
		}
		if (Math.random()<0.05)
		{
			GameWorld.enemies.add(new RandomEnemy(GameWorld.stage*2+x,y,0,GameWorld.stage));
		}
		if (Math.random()<0.05)
		{
			GameWorld.enemies.add(new DropEnemy(x,y,0,GameWorld.stage));
		}
		if (Math.random()<0.05)
		{
			GameWorld.enemies.add(new CurveEnemy(GameWorld.stage*2+x,y,0,GameWorld.stage));
		}
		if (Math.random()<0.05)
		{
			GameWorld.enemies.add(new StealthEnemy(x,y,0,GameWorld.stage));
		}
		
		
	}
	public void draw(MyFrame f)
	{
		f.setColor(0,128,0);
		f.fillOval(x,y,32,32);
		f.setColor(200,200,200);
		f.fillOval(x-16,y+8,64,16);
	}

}
