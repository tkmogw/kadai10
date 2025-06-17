
public class PlayerBullet extends Character{
	public void draw(MyFrame f)
	{
		f.setColor(100,100,100);
		f.fillRect(x,y+20,30,10);
		f.setColor(100,200,100);
		f.fillRect(x+10,y,10,30);
	}
	public PlayerBullet(double x,double y,double vx,double vy)
	{
		super(x,y,vx,vy);
	}

}
