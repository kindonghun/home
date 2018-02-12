package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {

	private final SimpleStringProperty MenuName1;
	private final SimpleStringProperty price;
	
	public Order(String menuName1, String price) {
	
		this.MenuName1 = new SimpleStringProperty(menuName1);
		this.price = new SimpleStringProperty(price);
	}
	
	public String getMenuName1() {
		return MenuName1.get();
	}
	public StringProperty MenuName1Property() {
		return MenuName1;
	}
	public String getPrice() {
		return price.get();
	}
	public StringProperty PriceProperty() {
		return price;
	}
	
	public void setMenuName1(String MenuName1) {
		
		this.MenuName1.set(MenuName1);
	}
	public void setPrice(String price) {
		this.price.set(price);
	}

}
