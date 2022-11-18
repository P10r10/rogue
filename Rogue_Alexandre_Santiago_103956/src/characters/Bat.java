package characters;
import logic.GameElement;
import logic.Movement;
import pt.iscte.poo.utils.Point2D;

public class Bat extends GameElement implements Movable, Living {

	private int hp = 3; // initial hp
	private int layer = 1;
	
	public Bat(Point2D position) {
		super(position);
	}
	
	@Override
	public boolean isDead(int damage) {
		hp = hp - damage;
		if (hp <= 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getHp() {
		return hp;
	}
	
	public void heal() {
		if (hp < 3) {
			hp++;
		}
	}

	@Override
	public String getName() {
		if (hp <= 0) {
			layer = 0;
			return "DeadBat";
		}
		return "Bat";
	}

	@Override
	public int getLayer() {
		return layer;
	}
	
	@Override
	public void move() {
		Movement.move(this);
	}
}
