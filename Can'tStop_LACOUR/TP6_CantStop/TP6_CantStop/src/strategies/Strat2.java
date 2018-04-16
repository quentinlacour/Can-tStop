package strategies;

import cantstop.Jeu;

public class Strat2
  implements Strategie
{
  private double computeScore(Jeu jeu, int _choix)
  {
    int somme = 0;
    int nb = 1;
    if (jeu.getLesChoix()[_choix][1] > 0) {
      nb = 2;
    }
    for (int i = 0; i < nb; i++) {
      somme += Math.abs(7 - jeu.getLesChoix()[_choix][i]);
    }
    return 100 - somme;
  }
  
  public int choix(Jeu jeu)
  {
    double max = 0.0D;
    int choix = 0;
    for (int i = 0; i < jeu.getNbChoix(); i++)
    {
      double score = computeScore(jeu, i);
      if (score > max)
      {
        max = score;
        choix = i;
      }
    }
    return choix;
  }
  
  public boolean stop(Jeu jeu)
  {
    boolean res = false;
    for (int i = 0; i < 11; i++) {
      if (jeu.getBloque()[i] != false) {
        res = true;
      }
    }
    return res;
  }
  
  public String getName()
  {
    return "Stratégie basique";
  }
  
  public int getGroupe()
  {
    return 7;
  }
}
