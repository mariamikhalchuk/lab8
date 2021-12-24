package catalog;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;

import java.util.stream.Collectors;

public class Controller {

    @FXML
    private TableView<Shoe> Table;

    @FXML
    private Button SortButton;

    @FXML
    private ComboBox<String> SelectManufacturerButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TableColumn<Shoe, String> TableName;

    @FXML
    private TableColumn<Shoe, String> TableType;

    @FXML
    private TableColumn<Shoe, String> TableManufacturer;

    @FXML
    private Button AddButton;

    @FXML
    private TextField NameField;

    @FXML
    private TextField TypeField;

    @FXML
    private TextField ManufactureField;

    ObservableList<Shoe> shoesTemp;

    @FXML
    void initialize() {
        SelectManufacturerButton.getItems().add("All");

        AddButton.setOnAction(event -> {
            AddTableRow();
        });

        DeleteButton.setOnAction(event -> {
            DeleteTableRow();
        });

        SortButton.setOnAction(event -> {
            Table.getSortOrder().add(TableType);
        });

        SelectManufacturerButton.setOnAction(event -> {
            String selected = SelectManufacturerButton.getSelectionModel().getSelectedItem();
            selectManufacturer(selected);
        });
    }

    private void AddTableRow() {

        String name = NameField.getText();
        String type = TypeField.getText();
        String manufacturer = ManufactureField.getText();

        TableName.setCellValueFactory(new PropertyValueFactory<Shoe, String>("name"));
        TableType.setCellValueFactory(new PropertyValueFactory<Shoe, String>("type"));
        TableManufacturer.setCellValueFactory(new PropertyValueFactory<Shoe, String>("manufacturer"));

        Shoe shoe = new Shoe(name, type, manufacturer);
        ObservableList<Shoe> shoes = Table.getItems();
        shoes.add(shoe);
        Table.setItems(shoes);

        shoesTemp = shoes;

        if (!SelectManufacturerButton.getItems().contains(manufacturer))
            updateSelect(manufacturer);
    }

    private void updateSelect(String manufacturer) {
        SelectManufacturerButton.getItems().add(manufacturer);
    }

    private void selectManufacturer(String manufacturer) {
        if (SelectManufacturerButton.getSelectionModel().getSelectedItem().equals("All")) {
            Table.setItems(shoesTemp);
        } else {
            ObservableList<Shoe> updatedShoes = shoesTemp.stream().filter(s -> s.getManufacturer().contains(manufacturer))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            Table.setItems(updatedShoes);
        }
    }

    private void DeleteTableRow() {
        int selectedID = Table.getSelectionModel().getSelectedIndex();
        if (selectedID != -1)
            Table.getItems().remove(selectedID);
    }
}
