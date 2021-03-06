/*********************************************
 * OPL 12.6.0.0 Model
 * Author: CATECH
 * Creation Date: 2022-04-10 at 4:22:29 PM
 *********************************************/

int NbI = ...;
int NbJ = ...;

range i =1..NbI;
range j =1..NbJ;

int y[j]= ...;
int H[i]= ...;
int D[i][j]= ...;
dvar boolean X[i][j];

minimize sum(i in 1..NbI ,j in 1..NbJ)(H[i]*D[i][j]*X[i][j]);
subject to { 
  forall(j in 1..12) {
     ct1:
     sum(j in 1..NbJ)y[j]==3;  
  }      
  forall(i in 1..12 ){
   forall(j in 1..12){
     ct2:
     sum(i in 1..NbI ,j in 1..NbJ)X[i][j]== 1;
   }   
  }  
  forall(i in 1..12 ){
    forall(j in 1..12){
     ct3:
     sum(i in 1..NbI ,j in 1..NbJ)X[i][j]<= sum (j in 1..NbJ)y[j];
    } 
  }      
}     
