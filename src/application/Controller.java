package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TableView<Order> table = new TableView<Order>(); // 테이블에 Order 데이터를
	@FXML
	private TableColumn<Order, String> fc;
	@FXML
	private TableColumn<Order, String> sc;
	
	@FXML
	private TableView<Menu> table1 = new TableView<Menu>();
	@FXML
	private TableColumn<Menu, String> fc1;
	@FXML
	private TableColumn<Menu, String> sc1;
	
	final Button Button = new Button();
	
	private  ObservableList<Order> data;
	private  ObservableList<Menu> MenuData;
	
	private Main mainApp; 
	
	@FXML
	private TextField SumPrice;
		
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	public void setData(ObservableList<Order> data) { //주문내역 리스트 불러오는 메서드
		this.data = data;
		table.setItems(data);
	}
	public void setMenuData(ObservableList<Menu> MenuData) { //메뉴데이터 불러오는 메서드
		this.MenuData = MenuData;
		table1.setItems(MenuData);
	}
	@FXML
	private void DBClickMenu() { //클릭을하게되면 리스트로 이동되는 메서드
		Menu selectedItem = table1.getSelectionModel().getSelectedItem();
		mainApp.AddMenu(selectedItem.getMenuName(),selectedItem.getPrice());
		int oldsum =Integer.parseInt(SumPrice.getText());
		int price =Integer.parseInt(selectedItem.getPrice());
		SumPrice.setText(String.format("%d",oldsum+price));
	}
	@FXML
	private void delete() { // 하나씩삭제되는기능
		Order selectedItem = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(selectedItem);
		int oldsum =Integer.parseInt(SumPrice.getText());
		int price =Integer.parseInt(selectedItem.getPrice());
		SumPrice.setText(String.format("%d",oldsum-price));
	}
	@FXML
	private void btpayment() {
		mainApp.ShowPaymentView();
	}
	@FXML
	private void initialize() { //메뉴데이터, 리스트데이터 불러오는 메서드
		table1.setItems(MenuData);
		fc1.setCellValueFactory(cellData -> cellData.getValue().MenuNameProperty());
		sc1.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());

		table.setItems(data);
		fc.setCellValueFactory(cellData -> cellData.getValue().MenuName1Property());
		sc.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());

	}
}
