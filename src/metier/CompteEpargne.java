package metier;

import java.util.Date;

import metier.Operation.typeOperation;

public  class CompteEpargne extends Compte{
	
	private double taux;
	
	public CompteEpargne (double solde, double taux){
		super(solde);
		this.taux = taux;
	}

	@Override
	public void retirer(double montant){
		Operation r = new Operation(typeOperation.retrait,listOperations.size()+1,new Date(), montant);
		listOperations.add(r);
		if(montant > solde) throw new RuntimeException("Solde de votre compte epargne est insuffisant");
		solde -= montant;
		
	}
	
	@Override
	public void updateSolde(){
		solde = solde + solde * taux /100;
	}
	
}
