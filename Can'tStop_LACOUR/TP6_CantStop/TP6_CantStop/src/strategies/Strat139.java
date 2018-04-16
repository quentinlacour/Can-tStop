package strategies;

import cantstop.Jeu;
        
/**
 * Votre Stratégie (copie de la Strat0 pour l'instant)
 *
 * Expliquez votre stratégie en une 20aine de lignes maximum.
 *
 * RENDU: Ce fichier, correctement nommé et rempli avec le numéro de la stratégie choisie.
 *
 * @author VOS NOMS (en binome maximum)
 */
public class Strat139 implements Strategie {

   /**
    * @param j le jeu
    * @return 
    */
    
    int cpt_tour=0; //Compte les tours à partir desquels tous les bonzes sont placés
    
   public int choix(Jeu j) {
       int[] somme_prob = {0,0,0,0,0,0};
       int[] proba = {1,2,3,4,5,6,5,4,3,2,1};
       int indice=0;
       int max=0;
       int indice_meilleur_avancement=0;
       /* On sépare en plusieurs cas, si il reste des bonzes ou non*/
       if(j.getBonzesRestants()==0){
           /* On classe par probabilité les différents choix de voie et on choisit le plus probable aux dés*/
           for(int i=0; i<6; i++){
               if(j.getLesChoix()[i][0]!=0 && j.getLesChoix()[i][1]!=0){
                   somme_prob[i]=proba[ j.getLesChoix()[i][0]-2 ]+proba[ j.getLesChoix()[i][1]-2 ];
               }
               if(j.getLesChoix()[i][0]!=0 && j.getLesChoix()[i][1]==0){
                   somme_prob[i]=proba[ j.getLesChoix()[i][0]-2 ];
               }
           }
           for(int i=0; i<6; i++){
                if(somme_prob[i] > max){
                    max = somme_prob[i];
                    indice=i;
                }
            }
           /* On choisit en priorité les voies sur lesquelles l'avancement est le meilleur (>3)
           par rapport à la voie déjà choisie*/ 
           for (int i=0; i<3; i++){
               if(j.getBonzes()[i][1]>j.getBonzes()[indice_meilleur_avancement][1]+2){
                   indice_meilleur_avancement=i;
               }
           }
           
           return indice;
        }
       
       return 0;
       
   }

   /**
    * @param j le jeu
    * @return toujours vrai (pour s'arrêter)
    */
   public boolean stop(Jeu j) {
       int C0=2; //C0 = [2,3,11,12]
       int C1=10; //C1 = [4,5,9,10]
       int C2=30; //C2 = [6,7,8]
       int somme=0;
       if(j.getBonzesRestants() != 0){ // Sert à compter le nombre
           cpt_tour=0;
       }
       if (j.getBonzesRestants()==0){  
           for (int i=0; i<3; i++){
               if(j.getBonzes()[i][0]==2 || j.getBonzes()[i][0]==3 || j.getBonzes()[i][0]==11 || j.getBonzes()[i][0]==12){
                   somme+= C0;
               }
               if(j.getBonzes()[i][0]==4 || j.getBonzes()[i][0]==5 || j.getBonzes()[i][0]==9 || j.getBonzes()[i][0]==10){
                   somme+= C1;
               }
               if(j.getBonzes()[i][0]==6 || j.getBonzes()[i][0]==7 || j.getBonzes()[i][0]==8){
                   somme+= C2;
               }
           }
           cpt_tour+=1; // incrémente le nb de tour lorsque tous les bonzes sont posés
       }
       
       /* Mise en place de la condition d'arrêt en fonction des emplacements des bonzes (et proba d'obtenir
       leurs chiffres)*/
       if ((cpt_tour==5 && somme==90) || (cpt_tour==4 && somme==70) || (cpt_tour==3 && somme==62) || 
               (cpt_tour==2 && somme==42) || (cpt_tour==2 && somme==34) || (cpt_tour==1 && somme==30) || 
               (cpt_tour==1 && somme==22) || (cpt_tour==1 && somme==14) || (cpt_tour==1 && somme==6)){
           return true;
       }
       
       /*Après la fin d'une colonne, on s'arrête */ 
       for(int i=0; i<11; i++){
           if(j.getBloque()[i]){
               return true;
           }
       }
       
       return false;
   }

   /**
    * @return vos noms
    */
   public String getName() {
       return "Quentin LACOUR";
   }

   /**
    * @return votre groupe
    */
   public int getGroupe() {
       return 6;
   }
}
