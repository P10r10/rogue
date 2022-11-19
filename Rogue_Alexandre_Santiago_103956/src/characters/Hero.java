package characters;

import java.util.ArrayList;
import java.util.List;

import items.Pickable;
import logic.GameElement;
import logic.HpBar;
import pt.iscte.poo.utils.Point2D;

public class Hero extends GameElement implements Living {
	/* Hero implements the singleton pattern */
	private static Hero INSTANCE = null;
	private int hp = 10; // initial hp
	private final HpBar hpBar = new HpBar(10);
	private List<Pickable> inventory = new ArrayList<>();
	private boolean canCarry = true;

	private Hero(Point2D position) {
		super(position);
	}

	public static Hero getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Hero(new Point2D(1, 1));//Initial position
		return INSTANCE;
	}
	
	public void addInventory(Pickable item ) {
		if (canCarry) {
			inventory.add(item);
		}
		if (inventory.size() == 3) {
			canCarry = false;
		}
	}
	
	public boolean canCarry() {
		return canCarry;
	}
	
	public HpBar getHpBar() {
		return hpBar;
	}

	@Override
	public boolean isDead(int damage) {//change to TAKESDAMAGE
		hp = hp - damage;
		hpBar.setHp(hp);
		if (hp <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public String getName() {
		if (hp <= 0) { // Hero is dead!
			return "Grave";
		}
		return "Hero";
	}

	@Override
	public int getLayer() {
		return 9;
	}
}
