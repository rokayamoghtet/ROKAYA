import ilog.concert.*;
import ilog.cplex.*;
public class exoTP {
public static void main(String[] args) {
 calcul ();
}
public static void calcul (){
try {
 IloCplex simplexe = new IloCplex ();
// déclaration des Variables de décision de type reel
 IloNumVar var_decis [][] = new IloNumVar[15][15]
 for (int i=0;i<15;i++){
  for(int j=0;j<15;j++){
     var_decis[i][j]= simplexe.numVar(1, Double.MAX_VALUE);
  }
}
// declaration de la fonction objectif
 IloLinearNumExpr objectif = simplexe.linearNumExpr();
// Définition des coefficients de la fonction objectif
 for(int i=0;i<15;i++){
   for(int j=0;j<15;j++){
      objectif.addTerm(15, var_decis[i][j]);
   }
 }
// Définir le type d'otimisation de la fonction (max ou min )
 simplexe.addMaximize(objectif);
 
 // contrainte 1 : sum X[i][j]<= 1
 IloLinearNumExpr contrainte_1 = simplexe.linearNumExpr();
 for(int i=0;i<15;i++){
  for(int j=0;j<15;j++){
     contrainte_1.addTerm(1, var_decis[i][j]);
  }
 }

 simplexe.addLe(contrainte_1, 1);
 
// la meme chose pour les autres contraintes
simplexe.solve(); // lancer la resolution
 
// Afficher des résultat
System.out.println("Voici la valeur de la fonction objectif "+ simplexe.getObjValue());
 System.out.println(" Voici les valeurs des variables de décision: ") ;
 for (int i=0;i<15;i++){
  for(int j=0;j<15;j++){
 System.out.println( "X"+i+j+ " = "+ simplexe.getValue(var_decis[i][j]));
  }
} catch (IloException e){
System.out.print("Exception levée " + e);
 }
}
}
