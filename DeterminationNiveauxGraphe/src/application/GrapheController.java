package application;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import metier.Graphe;
import metier.Sommet;



public class GrapheController {
    
	
	@FXML
	private TextArea console;
	private PrintStream ps ;
	
    public GridPane root = new GridPane();
     
    // Taille max de la matrice
    private int SIZE = 16;
    
    // Matrice de champs pour GridPane
    private TextField matrice[][] = new TextField[SIZE][SIZE];
    
    //nombre de sommets (donc taille matrice-1)
    private int nbsom = SIZE-1;		
    
	//Liste des noms de sommets
    private String[] nomsommets = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

    @FXML
    private ComboBox<String> comboBoxTaille;
    
    @FXML
    private TextArea zoneNiveau;
    
    @FXML
    private Label lblNiveaux;
    
    @FXML
    private Label lblDetail;
    
    
    // Liste de valeurs à intégrer dans la comboBox
    ObservableList<String> lstTailles = FXCollections.observableArrayList("2","3","4","5","6","7","8","9","10","11","12","13","14","15");
    
	@FXML
	public void initialize()
	{	
		
		// Initialisation de la console
		ps = new PrintStream(new Console(console)) ;
		
		// Ajout d'un titre et des valeurs dans la comboBox
		comboBoxTaille.setValue("Choix");
		comboBoxTaille.setItems(lstTailles);
		
      	// Mise en place du GridPane
		configurerGridPane();
		
    	// On cache la zone du bas
    	lblNiveaux.setVisible(false);
    	zoneNiveau.setVisible(false);
    	console.setVisible(false);
    	lblDetail.setVisible(false);
	}
     
    
    /**
     * Récupère la taille choisie, et lance la méthode setupMatrice
     */
    public void recupTailleMatrice(){
    	// On récupère la taille de la comboBox
    	nbsom = Integer.parseInt(comboBoxTaille.getValue());
    	System.out.println("\nDegre de la matrice : " + nbsom);
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
     * Récupération valeurs matrice et en calcule les niveaux
     */
    public void recupValeurMatrice(){
    	
    	// On vide la zone des niveaux
    	zoneNiveau.clear();
    	//zoneNiveau.replaceText(0, zoneNiveau.getLength(), "");
    	
        // Matrice de int de taille choisie par l'utilisateur
        int MATRICE_TEST[][]= new int[nbsom][nbsom];

    	// Pour chaque champ de la matrice de champs
    	for(int i = 1;  i<=nbsom; i++)
        {
            for(int j = 1;  j<=nbsom; j++)
            {
            	// On passe la valeur à notre matrice de int
            	MATRICE_TEST[i-1][j-1] = Integer.parseInt(matrice[i][j].getText());
            	
            	//System.out.println(MATRICE_TEST[i-1][j-1]);

            }
        }
    	
    	// Affichage de la matrice d'adjacence
    	System.out.println(afficheMatrice(MATRICE_TEST));
    	
    	// Création du graphe associé à la matrice
		Graphe graphe = new Graphe(MATRICE_TEST.length, MATRICE_TEST);
    	
    	// Création d'un hashMap (niveau, liste de sommets ayant ce niveau)
		HashMap<String,ArrayList<Sommet>> niveaux = new HashMap<>();
		
		// Détermination des niveaux
		niveaux = graphe.determinationNiveau();
		
		// Affichage du resultat
		for (Entry<String, ArrayList<Sommet>> entree : niveaux.entrySet())
		{
			System.out.print("\nNiveau : " + entree.getKey() + "\n");
			
			// Ajout de l'intitulé du niveau à la zone de texte
			zoneNiveau.appendText("Niveau : " + entree.getKey() + "\n");
			
			// Pour chaque niveau
			for(int j = 0; j < entree.getValue().size(); j++) {
				System.out.print(entree.getValue().get(j).getId() + " ");
				
				
				// Ajout des sommets associés
				zoneNiveau.appendText(entree.getValue().get(j).getId() + " ");
			}
			zoneNiveau.appendText("\n\n");
			
		}
		System.out.println("\n\n------------- Fin Programme -------------\n");
    	
    	// On affiche la zone du bas
    	lblNiveaux.setVisible(true);
    	zoneNiveau.setVisible(true);
    	console.setVisible(true);
    	lblDetail.setVisible(true);
    	
    	System.setOut(ps);
        System.setErr(ps);

    }
    
    /**
     * Réinitialise la matrice
     */
    public void cleanMatrice(){
    	
    	// On vide la zone des détails
    	console.clear();
    	
    	for(int i = 1;  i<=nbsom; i++)
        {
            for(int j = 1;  j<=nbsom; j++)
            {
            	matrice[i][j].setText("0");
            }
        }
    	
    	System.out.println("\nMatrice réinitialisée.");
    	
    	// On cache la zone du bas
    	lblNiveaux.setVisible(false);
    	zoneNiveau.setVisible(false);
    	console.setVisible(false);
    	lblDetail.setVisible(false);
    	

    	
    }
    
    /**
	 * Affichage d'une matrice au format [a b b b b]
	 * @param la matrice à afficher
	 */
	public static String afficheMatrice (int[][] matrice) {
		
    	System.out.println("\nMatrice d'ajacence du graphe :");
    	
	    StringBuilder formatM = new StringBuilder("[");
	    for (int i = 0; i < matrice.length; i++) {
	    	for(int j = 0 ; j < matrice[i].length; j++) {
	    		formatM.append(" " +matrice[i][j] + " ");
	    	}
	    	formatM.append("]\n");
	    	if (i < matrice.length - 1) {
	    		formatM.append("[");
	    	}
	    }
		return formatM.toString();
	}
    

	/**
	 *  Classe pour copier la console dans notre textArea détail
	 *
	 */
	public class Console extends OutputStream {
        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }
    }

	
}


