package logic;

import java.util.ArrayList;
import java.util.List;

import characters.Hero;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;
import structures.BlackSquare;

public class HpBar {

	private List<ImageTile> stubs = new ArrayList<>();
	private int hp;

	public HpBar(int hp) {
		this.hp = hp;
		stubs.add(new HpStub(new Point2D(0, 10), 2));
		stubs.add(new HpStub(new Point2D(1, 10), 4));
		stubs.add(new HpStub(new Point2D(2, 10), 6));
		stubs.add(new HpStub(new Point2D(3, 10), 8));
		stubs.add(new HpStub(new Point2D(4, 10), 10));
		stubs.add(new BlackSquare(new Point2D(5, 10)));//only visual/never changes
		stubs.add(new BlackSquare(new Point2D(6, 10)));//only visual/never changes
	}

	public List<ImageTile> getComponents() {
		return stubs;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	private class HpStub implements ImageTile {

		private Point2D position;
		private int limit;
		//Hero hero = GameEngine.getInstance().getGurrentRoom().getHero();

		public HpStub(Point2D position, int limit) {
			this.position = position;
			this.limit = limit;
		}

		@Override
		public String getName() {
			if (hp >= limit) {
				return "Green";
			}
			if (hp == limit - 1) {
				return "GreenRed";
			}
			return "Red";
		}

		@Override
		public Point2D getPosition() {
			return position;
		}

		@Override
		public int getLayer() {
			return 1;
		}
	}
}
