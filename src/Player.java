import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Player extends Character implements KeyListener{
	public Player(double x,double y,double vx,double vy)
	{
		super(x,y,vx,vy);
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			vx=-5;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			vx=5;
		}
		if (e.getKeyCode()==KeyEvent.VK_UP)
		{
			vy=-5;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			vy=5;
		}
		
	}
		

	
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		vx=0;
		if (e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			vx=0;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			vx=0;
		}
		if (e.getKeyCode()==KeyEvent.VK_UP)
		{
			vy=0;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			vy=0;
		}
	}
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
		public void move()
		{
			super.move();
			if (x<0) x=0;
			if (x>370) x=370;
		}

}
