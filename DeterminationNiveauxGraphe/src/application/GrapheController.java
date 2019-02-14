package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class GrapheController {

	//Scène principale
    public TextField nbsommets =  new TextField();
    
    public GridPane root = new GridPane();
     
    // Taille max de la matrice
    private int SIZE = 16;
    
    // Définition de la matrice
    private TextField matrice[][] = new TextField[SIZE][SIZE];
    
    //nombre de sommets (donc taille matrice-1)
    private int nbsom = SIZE-1;		
    
	//Liste des noms de sommets
    private String[] nomsommets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

    @FXML
    private ComboBox<String> comboBoxTaille;
    
    @FXML
    private TextField niveauA;
    @FXML
    private TextField niveauB;
    @FXML
    private TextField niveauC;
    @FXML
    private TextField niveauD;
    @FXML
    private TextField niveauE;
    @FXML
    private TextField niveauF;
    @FXML
    private TextField niveauG;
    @FXML
    private TextField niveauH;
    @FXML
    private TextField niveauI;
    @FXML
    private TextField niveauJ;
    @FXML
    private TextField niveauK;
    @FXML
    private TextField niveauL;
    @FXML
    private TextField niveauM;
    @FXML
    private TextField niveauN;
    @FXML
    private TextField niveauO;
    
    
    // Liste de valeurs à intégrer dans la comboBox
    ObservableList<String> lstTailles = FXCollections.observableArrayList("2","3","4","5","6","7","8","9","10","11","12","13","14","15");
    
	@FXML
	public void initialize()
	{	
		// Ajout d'un titre et des valeurs dans la comboBox
		comboBoxTaille.setValue("Choix");
		comboBoxTaille.setItems(lstTailles);
		
      	// Mise en place du GridPane
		configurerGridPane();
	}
     
    
    /**
     * Récupère la taille choisie, et lance la méthode setupMatrice
     */
    public void recupTailleMatrice(){
    	// On récupère la taille de la comboBox
    	nbsom = Integer.parseInt(comboBoxTaille.getValue());
    	System.out.println("\nTaille Choisie : " + nbsom);
        setupmatrice(nbsom);
    }
    
    
    /**
     * Initialise la matrice et cache les champs en fonction de la taille choisie
     * @param nbsom : nombre de sommets choisis
     */
    private void setupmatrice(int nbsom)
    {
        for (int y = 0; y < SIZE; y++) 
        {
            for (int x = 0; x < SIZE; x++) 
            {
            	// On cache les champs d'indices supérieurs à la taille souhaitée
                if(y>nbsom || x>nbsom){
                	matrice[y][x].setVisible(false);	
                }
                // Dans le cas inverse on les fait réaparaître
                else if(!(x==0 && y==0))
                {
                    matrice[y][x].setVisible(true);
                }
            }
        }
    }
    
    
    /**
     * Configure le GridPane, génère les champs de la matrice
     */
    
    private void configurerGridPane(){
    	//Paramétrage écart entre les cases
      	root.setHgap(1);
      	root.setVgap(2);
      	
      	//Initialisation du Gridpane : 1 case = 1 textfield 
        for(int y = 0; y < SIZE; y++)
        {
            for(int x = 0; x < SIZE; x++)
            {
            	//Création d'un nouveau textfield générique pour chaque case
                TextField tf = new TextField()
                {
                   //Gestion de l'écriture dans les textfield : que du numérique
                   @Override
                   public void replaceText(int start, int end, String text)
                   {
                        if (text.matches("[0-99]")) {
                            super.replaceText(start, end, text);
                        }
                   }
                   @Override
                   public void replaceSelection(String text)
                    {
                        if (text.matches("[0-99]")) {
                            super.replaceSelection(text);
                        }
                    }
                };
                
                //Paramétrage du textfield générique
                tf.setAlignment(Pos.CENTER);
                tf.setMaxSize(50,25);
                tf.setMinSize(50,25);
                tf.setVisible(true);
                tf.setText("0");
                
                //affectation à la matrice
                matrice[y][x] = tf;
                
                //Paramétrage des textfields en fonction de leur position dans la matrice
                
                if(x==0 && y==0)	//Coin en haut à gauche
                {
                	matrice[y][x].setEditable(false);
                    matrice[y][x].setVisible(false);
                }
                else if(x==0) // 1ère  colonne : noms des sommets
                {
                	matrice[y][x].setEditable(false);
                    matrice[y][x].setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                    matrice[y][x].setStyle("-fx-background-color: lightblue");
                    matrice[y][x].setText(nomsommets[y-1]);
                }
                else if(y==0) // 1ère  ligne : noms des sommets
                {
                	matrice[y][x].setEditable(false);
                    matrice[y][x].setFont(Font.font("Verdana", FontWeight.BOLD, 13));
                    matrice[y][x].setStyle("-fx-background-color: lightblue");
                    matrice[y][x].setText(nomsommets[x-1]);
                }
                else // La matrice
                {                       
                    //Ajout d'un event au clic sur une case pour la sélectionnée entièrement mais la fonction selectall() chie
                    matrice[y][x].addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
                    {
                        @Override
                        public void handle(MouseEvent mouseEvent)
                        {
                            for(int i = 0;  i<=nbsom; i++)
                              {
                                  for(int j = i;  j<=nbsom; j++)
                                  {
                                      if(mouseEvent.getSource() == matrice[i][j])
                                      {
                                          matrice[i][j].requestFocus();
                                          matrice[i][j].selectAll(); // fonctionne pas... utiliser tabulation
                                          
                                      }
                                  }
                              }
                        }
                    });
                }
                //Plaçage du textfield dans le gridpane
                GridPane.setRowIndex(matrice[y][x],y);
                GridPane.setColumnIndex(matrice[y][x],x);
                root.getChildren().add(matrice[y][x]);
                root.setVisible(true);
            }
        }	
    }
    
    /**
     * Récupération valeurs matrice
     */
    public void recupValeurMatrice(){
    	
    	System.out.println("\nValeur des cases de la matrice : ");
    	
    	for(int i = 1;  i<=nbsom; i++)
        {
            for(int j = 1;  j<=nbsom; j++)
            {
            	System.out.println(matrice[i][j].getText());
            }
        }
    }
    
    /**
     * Réinitialise la matrice
     */
    public void cleanMatrice(){
    	for(int i = 1;  i<=nbsom; i++)
        {
            for(int j = 1;  j<=nbsom; j++)
            {
            	matrice[i][j].setText("0");
            }
        }
    	
    	System.out.println("\nMatrice réinitialisée.");
    }
    
}


