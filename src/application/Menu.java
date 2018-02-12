package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Menu {

	private final SimpleStringProperty MenuName;
	private final SimpleStringProperty Price;

	public Menu(String MenuName, String Price) {
		this.MenuName = new SimpleStringProperty(MenuName);
		this.Price = new SimpleStringProperty(Price);
	}
	public String getMenuName() {
		return MenuName.get();
	}
	public StringProperty MenuNameProperty() {
		return MenuName;
	}
	public String getPrice() {
		return Price.get();
	}
	public StringProperty PriceProperty() {
		return Price;
	}
	public void setMenuName(String MenuName) {

		this.MenuName.set(MenuName);
	}
	public void setPrice(String price) {
		this.Price.set(price);
	}

}
