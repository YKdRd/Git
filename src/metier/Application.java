package metier;

import java.util.List;

import metier.Operation.typeOperation;

public class Application {

	public static void main(String[] args) {
		
		
		try {
			
			Compte compteCourant = new CompteCourant(11000,200);			
			Compte compteEpargne = new CompteEpargne(100, 2.2);
			
			compteCourant.verser(500);
			
			compteCourant.retirer(100);
			
			System.out.println("Le solde du compte courant est " + compteCourant.consulterSolde());
			
			compteCourant.virement(600, compteEpargne);
			
			System.out.println("Le solde du ompte epargne est " + compteEpargne.consulterSolde());
			
			System.out.println("Le solde du compte courant après virement est " + compteCourant.consulterSolde());
			
			compteEpargne.updateSolde();
			
			System.out.println("Le solde du compte epargne MAJ est " + compteEpargne.consulterSolde());
			
System.out.println("pppppppppppp" + compteCourant.totalOperations());
			
			for(Operation o : compteCourant.listOperations){
				if(typeOperation.retrait.equals(o.typeOperations)){
				System.out.println(compteCourant.toString()+"-----" + o.typeOperations.name()+"-----" +o.getNumero()+"------"+o.getDateOperation()+"-----"+o.getMontant());
				}else if(typeOperation.versement.equals(o.typeOperations)){
					System.out.println(compteCourant.toString()+"-----" + o.typeOperations.name()+"-----" +o.getNumero()+"------"+o.getDateOperation()+"-----"+o.getMontant());
					}
			}
			
			System.out.println("-------------------");
			for(Operation o : compteEpargne.listOperations){
				if(typeOperation.retrait.equals(o.typeOperations)){
				System.out.println(compteCourant.toString()+"-----" + o.typeOperations.name()+"-----" +o.getNumero()+"------"+o.getDateOperation()+"-----"+o.getMontant());
				}else if(typeOperation.versement.equals(o.typeOperations)){
					System.out.println(compteCourant.toString()+"-----" + o.typeOperations.name()+"-----" +o.getNumero()+"------"+o.getDateOperation()+"-----"+o.getMontant());
					}
			}
			
			compteCourant.consulterCompte();
			compteEpargne.consulterCompte();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
