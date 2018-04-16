package cantstop;

/**
 * Lancement d'un tournoi ou d'une partie
 * @author afleury 
 */
public class Main {
    public static void main(String[] args) {
        // Mettez dans ce tableau les strats à tester
        int[] stratToTest = {0,1,2,139};
        // On instancie le jeu
        Jeu j = new Jeu();
        
        // Mode affrontement humain vs IA, le paramètre est le numéro de l'IA à affronter 
        //j.humanVsIA(0);
        
        // Mode combat simple :
        // On lance nombreCombats (ici 5000) parties entre les deux stratégies passées en paramètres
        //j.combatSimple(0, 1, 5000);
        
        // Mode Tournoi
        // On lance un tournoi avec 500 exécutions à chaque fois (entre chaque couple d'IA).
        // La notation sera faite sur un plus grand nombre d'exécutions. Selon la rapidité de votre machine, 
        // ne lancez par contre pas sur un chiffre trop grand.
        j.runIA(stratToTest,500);
    }
}
