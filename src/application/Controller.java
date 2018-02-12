package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TableView<Order> table = new TableView<Order>(); // ���̺� Order �����͸�
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

	public void setData(ObservableList<Order> data) { //�ֹ����� ����Ʈ �ҷ����� �޼���
		this.data = data;
		table.setItems(data);
	}
	public void setMenuData(ObservableList<Menu> MenuData) { //�޴������� �ҷ����� �޼���
		this.MenuData = MenuData;
		table1.setItems(MenuData);
	}
	@FXML
	private void DBClickMenu() { //Ŭ�����ϰԵǸ� ����Ʈ�� �̵��Ǵ� �޼���
		Menu selectedItem = table1.getSelectionModel().getSelectedItem();
		mainApp.AddMenu(selectedItem.getMenuName(),selectedItem.getPrice());
		int oldsum =Integer.parseInt(SumPrice.getText());
		int price =Integer.parseInt(selectedItem.getPrice());
		SumPrice.setText(String.format("%d",oldsum+price));
	}
	@FXML
	private void delete() { // �ϳ��������Ǵ±��
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
	private void initialize() { //�޴�������, ����Ʈ������ �ҷ����� �޼���
		table1.setItems(MenuData);
		fc1.setCellValueFactory(cellData -> cellData.getValue().MenuNameProperty());
		sc1.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());

		table.setItems(data);
		fc.setCellValueFactory(cellData -> cellData.getValue().MenuName1Property());
		sc.setCellValueFactory(cellData -> cellData.getValue().PriceProperty());

	}
}
