package metier;

import java.util.Date;

import metier.Operation.typeOperation;

public class CompteCourant extends Compte{
	
	private double decouvert ;
	
	public CompteCourant(double solde, double decouvert){
		super(solde);
		this.decouvert = decouvert;
	}
	
	@Override
	public void retirer (double montant){
		Operation r = new Operation(typeOperation.retrait,listOperations.size()+1, new Date(),montant);
		listOperations.add(r);
		if(montant> solde + decouvert) throw new RuntimeException("Solde de votre compte courant est insuffisant");
		solde -= montant;		
	}
	
	@Override
	public void updateSolde(){
	
	}

}
