package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class fxmain extends Application {
	//		// observableArrayList für TableView (Werden für FX Views benötigt um Listen zu übergeben)
	
	
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("edit Lists GUI");
		BorderPane root = new BorderPane();
		HBox hbox = new HBox(); 
		
		//Button erzeugen
		Button btnprint = new Button("DRUCK");
		Button btnadd = new Button("NEU");
		

		
	
		// ListView und TableView erzeugen
		final ListView<ObservableContactDetails> listView = new ListView<ObservableContactDetails>();
		final TableView<ObservableContactDetails> tableView = new TableView<ObservableContactDetails>();
		new Control(listView,tableView,btnprint,btnadd);
		
		
		
		// ListView und TableView auf der BorderPane platzieren
		root.setLeft(listView);
		root.setCenter(tableView);
		hbox.getChildren().addAll(btnprint,btnadd);
		root.setBottom(hbox);
		// Scene erstellen und auf PrimaryStage anzeigen
		Scene scene = new Scene (root);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	


	public static void main(String[] args) {
		launch(args);
	}
}
