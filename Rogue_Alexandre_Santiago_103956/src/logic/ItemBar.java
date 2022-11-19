package logic;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;
import structures.Item;

public class ItemBar {
	private List<ImageTile> items = new ArrayList<>();

	public ItemBar() {
		items.add(new Item(new Point2D(7, 10)));
		items.add(new Item(new Point2D(8, 10)));
		items.add(new Item(new Point2D(9, 10)));
	}

	public List<ImageTile> getComponents() {
		return items;
	}

	public void addItem(ImageTile image) {
		Item x = (Item) items.get(0);
		x.setCurrentImage("Armor");//HERE
	}
}
