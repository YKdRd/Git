package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.Operation.typeOperation;

public abstract class Compte {

	protected int code;
	protected double solde;
	private static int nbComptes;
	
	List<Operation> listOperations = new ArrayList<>();
	
	public Compte(double solde){
		++nbComptes;
		this.code= nbComptes;
		this.solde = solde;
	}
	
	public void verser(double montant){
		Operation v = new Operation (typeOperation.versement,listOperations.size()+1, new Date(), montant);
		listOperations.add(v);
		solde += montant;
	}
	
	public abstract void retirer(double montant);
	
	public double consulterSolde(){
		return solde;
	}
	
	public void consulterCompte(){
		System.out.println("Le code est " + code + "Le solde est "+ solde);
	}
	
	public void virement(double montant, Compte compte){
		retirer(montant);
		compte.verser(montant);
	}
	
	public abstract void updateSolde();
	
	public List<Operation> consulterListOperations(){
		return listOperations;
	}

	public double totalOperations(){
		double somme = 0;
		for(Operation o : listOperations){
			if(typeOperation.retrait.equals(o.typeOperations)){
				somme = somme + o.getMontant();
				System.out.println("Le total des retraits est de : " + somme);
			}else if(typeOperation.versement.equals(o.typeOperations)){
				somme = somme + o.getMontant();
				System.out.println("Le total des versements est de : " + somme);
			}		
		}
		return somme;
	}
	
	public double totalVersements(){
		double somme = 0;	
		for(Operation o : listOperations){
			if(typeOperation.versement.equals(o.typeOperations))
			somme += o.getMontant();
		}
		return somme;
	}
	
	public double totalRetraits(){
		double somme = 0;
		for(Operation o : listOperations){
			if(typeOperation.retrait.equals(o.typeOperations))
				somme += o.getMontant();
		}
		return somme;
	}
	
	
}
