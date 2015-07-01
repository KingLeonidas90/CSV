package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class Control {
	
	ObservableList <ObservableContactDetails> obserContactDetailsList;
	private  ListView <ObservableContactDetails> listView;
	private  TableView <ObservableContactDetails> tableView;
	private  Button btnprint;
	private  Button btnadd;
	
	public Control(ListView<ObservableContactDetails> listViewIN,TableView<ObservableContactDetails> tableViewIN,Button btnprintIN, Button btnaddIN){
	//Übergabeobjekte übernehmen
	this.listView = listViewIN;
	this.tableView = tableViewIN;
	this.btnprint = btnprintIN;
	this.btnadd = btnaddIN;
	
	obserContactDetailsList = FXCollections.observableArrayList(ObservableContactDetails.getObsContactDetails());
	
	//Button listener
	btnprint.setOnAction(i -> printalles());
	btnadd.setOnAction(i -> addcontact());
	
	// observableArrayList für TableView (Werden für FX Views benötigt um Listen zu übergeben)
			obserContactDetailsList.addAll(new ObservableContactDetails("Peter", "Pan", "Nimmerland 3"));
			obserContactDetailsList.addAll(new ObservableContactDetails("Sepp", "Blatter", "Korruptionsweg 900"));
			obserContactDetailsList.addAll(new ObservableContactDetails("Frodo", "Beutling", "Auenland 4"));

			// observableArrayList für die ListView mit allen Keys
		    // ObservableList<ObservableContactDetails> observableContactDetails = FXCollections.observableArrayList();
		    
		    // Spalten für die TableView anlegen
	        TableColumn<ObservableContactDetails, String> firstNameCol = new TableColumn<ObservableContactDetails,String>("Vorname");
	        TableColumn<ObservableContactDetails, String> lastNameCol = new TableColumn<ObservableContactDetails,String>("Nachname");
	        TableColumn<ObservableContactDetails, String> adressCol = new TableColumn<ObservableContactDetails,String>("Adresse");
	        
	        // Lamba zum füllen der Spalten
	        firstNameCol.setCellValueFactory(e -> e.getValue().getVornameProperty());
	        lastNameCol.setCellValueFactory( e -> e.getValue().getNameProperty());
	        adressCol.setCellValueFactory( e -> e.getValue().getAdresseProperty());
	        
	        // Textfeld setzen für editierbarkeit
	        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        adressCol.setCellFactory(TextFieldTableCell.forTableColumn());
	        
	        // Spalten der Tableview übergeben
	        tableView.getColumns().addAll(firstNameCol,lastNameCol,adressCol);
	        
	        //Editable TableView
	        tableView.setEditable(true);
	        //tableView.setOn(a -> handleTableEdit(a));
	        // Verhindert bei Übergröße das Anzeigen einer zusätzlichen Spalte, nur letzte Spalte wird vergrößert
	        tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY);
			
	        // Zellwerte der ListView und der TableView mit unseren Daten füllen 
			//listView.setItems((ObservableList<ObservableContactDetails>) obser);
	        //listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	        // listView.setItems(obserContactDetailsList);
	        //listView.setCellFactory(TextFieldListCell.forListView());
			tableView.setItems(obserContactDetailsList);		
			
			//listView.itemsProperty().bind(obserContactDetailsList);
			listView.setItems(obserContactDetailsList);
			listView.setEditable(true);
			//ruft eigene listCellMethode auf
			listView.setCellFactory(p -> new MyListCell()); 
			//listView.setCellFactory();
	
	}
	
	// Methode um neuen leeren Kontakt anzulegen
	private Object addcontact() {
		ObservableContactDetails newContact= new ObservableContactDetails("Vorname", "Nachname", "Adresse");
		obserContactDetailsList.add(newContact);
		return null;
	}

	// Methode um alles aus der Observable Contact Details Liste auf der Konsole auszugeben
	private void printalles(){
		for (ObservableContactDetails i:obserContactDetailsList){
			System.out.println("Vorname: " + i.getVornameProperty().getValue() + "\t Nachname: " + i.getNameProperty().getValue() + "\t Adresse: " + i.getAdresseProperty().getValue());
		}
	}
	
	// eigene ListCell für die ListView, da die ListVIew mit selbst definierten Objekten nicht umgehen kann
	 class MyListCell extends ListCell<ObservableContactDetails> {
		private TextField textField = new TextField(); //Das Textfeld das an der Stelle des Eintrags der editiert werden soll angezeigt wird
		private StringProperty nameProperty = new SimpleStringProperty();
		
		public MyListCell(){
			this.textField.visibleProperty().bind(this.editingProperty());//Bindet die Sichtbarkeit des EditTextfeldes an die editing Property der Zelle, also wenn die Zelle im bearbeiten Modus ist, wird das Textfeld gezeigt sonst nicht
			this.textField.setOnAction(a -> commitEdit(new ObservableContactDetails(this.getItem().getVorname(),textField.getText(),this.getItem().getAdresse())));
			this.setGraphic(this.textField);// Eine Zelle besteht aus seinem Text und einer Graphic, die jede Form von Node sein kann, in unserem Fall eben das EditTextfeld
			this.setContentDisplay(ContentDisplay.RIGHT);// Legt die Ausrichtung der Grafik fest
		}
		
		

		 //Diese Methode wird immer dann aufgerufen wenn sich der Inhalt der Zelle ändert auch beim erstmaligen beschreiben

		@Override
		protected void updateItem(ObservableContactDetails t, boolean bln) {
			super.updateItem(t, bln);// führt die Standartaufgaben der Methode durch
			if (this.getItem() != null) {// Wenn die Zelle nicht null ist, wobei get Item das ObservableContactDetails-Object aus unserer Liste darstellt 
				this.nameProperty.bind(this.getItem().getNameProperty()); //Bindet unseren Namen an 
				this.textField.setText(nameProperty.get());//legt den Text fürs EditTextfeld fest
				setText(nameProperty.get());//legt den Anzeigetext fest(ohne edit)
			}
		}
		}

}
