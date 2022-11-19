package logic;

import java.util.ArrayList;
import java.util.List;

import items.Item;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

public class ItemBar {
	private List<ImageTile> items = new ArrayList<>();
	private int currentSlot = 0;

	public ItemBar() {
		items.add(new Item(new Point2D(7, 10)));
		items.add(new Item(new Point2D(8, 10)));
		items.add(new Item(new Point2D(9, 10)));
	}

	public List<ImageTile> getComponents() {
		return items;
	}
	
	public void dropFromSlot(int slot) {
		Item item = (Item) items.get(slot);
		item.setCurrentImage("Black");
		currentSlot = slot;
	}

	public void addItem(ImageTile image) {
		if (currentSlot < 3) {
			Item item = (Item) items.get(currentSlot);
			item.setCurrentImage(image.toString());
			currentSlot++;
		}
	}
}
