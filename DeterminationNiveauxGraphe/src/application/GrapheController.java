package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GrapheController {
	
	// Grille
	public GridPane root = new GridPane();
	
	// Matrice
	private TextField matrice[][] = new TextField[16][16];
	
	// Taille matrice
	private int nbsom = 15;		
	
	// Liste des sommets possibles
	private String[] nomsommets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
	
	@FXML
	public void initialize(){
		int SIZE = 16;
        int length = SIZE;
        int width = SIZE;
		
		for(int y = 0; y < length; y++)
        {
            for(int x = 0; x < width; x++)
            {
            	TextField tf = new TextField() {
            	    @Override public void replaceText(int start, int end, String text) {
            	        if (text.matches("[0-99]")) {
            	            super.replaceText(start, end, text);
            	        }
            	    }

            	    @Override public void replaceSelection(String text) {
            	        if (text.matches("[0-99]")) {
            	            super.replaceSelection(text);
            	        }
            	    }
            	};
            	tf.setAlignment(Pos.CENTER);
            	tf.setMaxSize(50,25);
            	tf.setMinSize(50,25);
            	tf.setVisible(true);
            	tf.setText("0");
               	matrice[y][x] = tf;
            	if(x==0 && y==0)
            	{
            		tf.setEditable(false);
            		matrice[y][x].setVisible(false);
            	}
            	else if(x==0)
            	{
            		tf.setEditable(false);
            		matrice[y][x].setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            		matrice[y][x].setStyle("-fx-background-color: lightblue");
            		matrice[y][x].setText(nomsommets[y-1]);
            	}
            	else if(y==0)
            	{
            		tf.setEditable(false);
            		matrice[y][x].setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            		matrice[y][x].setStyle("-fx-background-color: lightblue");
            		matrice[y][x].setText(nomsommets[x-1]);
            	}
            	else if(x==y)
            	{
            		matrice[y][x].setFont(Font.font("Verdana",FontWeight.NORMAL, 13));
            		matrice[y][x].setText("0");
            		matrice[y][x].setStyle("-fx-background-color: LightSteelBlue");
            		matrice[y][x].setEditable(false);

            	}
            	else if (y>x)
            	{
            		matrice[y][x].setStyle("-fx-background-color: LightSteelBlue");
            		matrice[y][x].setEditable(false);
            	}
            	else
            	{
            		matrice[y][x].setOnAction(new EventHandler<ActionEvent>()
                	{
                          public void handle(ActionEvent event)
                          {
                            for(int y = 0;  y<length; y++)
              	            {
              	                for(int x = 0;  x<width; x++)
              	                {
              	                	if(matrice[y][x] == event.getSource())
              	                	{
              	                		matrice[x][y].setText(matrice[y][x].getText());
              	                   	}
              	                }
              	            }
                          }
                    });
            	}
            	GridPane.setRowIndex(tf,y);
            	GridPane.setColumnIndex(tf,x);
            	root.getChildren().add(tf);
            	root.setVisible(true);


            }
        }	root.setHgap(1);
        root.setVgap(2);	
		
	}
	
	
	
	
}


