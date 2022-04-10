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
 IloNumVar var_decis [][] = new IloNumVar[ 20 14 0 13 0 0 8 8;...
    12 0 0 10 15 20 8 9;...
    0 20 12 0 8 11 14 12;...
    0 0 0 0 17 0 0 16;...
    18 12 15 0 0 0 8 0;...
    10 0 9 14 15 8 12 13;...
    0 17 0 11 13 10 0 0;...
    0 0 14 0 0 12 16 0;...
    0 0 0 0 12 18 0 18];
 for (int i=0;i<2;i++){
 var_decis[i][0]= simplexe.numVar(0, Double.MAX_VALUE);
}
// declaration de la fonction objectif
 IloLinearNumExpr objectif = simplexe.linearNumExpr();
// Définition des coefficients de la fonction objectif
 objectif.addTerm(8, var_decis[0][0]);
// Définir le type d'otimisation de la fonction (max ou min )
 simplexe.addMaximize(objectif);
 
 // contrainte 1 : sum X[i][j]<= 1
 IloLinearNumExpr contrainte_1 = simplexe.linearNumExpr();
contrainte_1.addTerm(1, var_decis[0][0]);
contrainte_1.addTerm(2, var_decis[1][0]);
 simplexe.addLe(contrainte_1, 8);
// la meme chose pour les autres contraintes
simplexe.solve(); // lancer la resolution
// Afficher des résultat
System.out.println("Voici la valeur de la fonction objectif "+ simplexe.getObjValue());
 System.out.println(" Voici les valeurs des variables de décision: ") ;
 for (int i=0;i<2;i++)
 System.out.println( "X"+i+ " = "+ simplexe.getValue(var_decis[i][0]));
} catch (IloException e){
System.out.print("Exception levée " + e);
 }
}
}
