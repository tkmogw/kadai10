
public class StealthEnemy extends Enemy{
	public StealthEnemy (double x,double y,double vx,double vy)	
	{
		super(x,y,vx,vy);
		life=GameWorld.stage*2+1;    
	}
	public void move()
	{
		super.move();
		
		vx=vx+GameWorld.stage*0.005+0.01;
		vy=vy+GameWorld.stage*0.005+0.01;
	}
	public void draw(MyFrame f) {
		f.setColor(245, 245, 245);
		f.fillRect(x, y, 10, 20);
		f.fillRect(x+20, y, 10, 20);
		f.fillRect(x+10, y, 10, 30);
	}


}



