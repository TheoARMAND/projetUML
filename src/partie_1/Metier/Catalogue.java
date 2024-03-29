package partie_1.Metier;

import java.util.ArrayList;
import java.util.List;

public class Catalogue implements I_Catalogue{
	private  List<I_Produit>lesProduits;

	public Catalogue() {	
		lesProduits = new ArrayList<I_Produit>();
	}
	
	@Override
	public boolean addProduit(I_Produit produit) {
		if (!isPresent(produit.getNom())) {
			lesProduits.add(produit);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		
		if (!isPresent(nom)) {
			Produit curProduit = new Produit (nom,qte,prix);
			lesProduits.add(curProduit);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int addProduits(List<I_Produit> l) {
		// TODO Auto-generated method stub
		int i =0; 
		while(i<l.size() && !isPresent(l.get(i).getNom())) {
			Produit curProduit = new Produit (l.get(i).getNom(),l.get(i).getQuantite(),l.get(i).getPrixUnitaireHT());
			lesProduits.add(curProduit);
			i++;
		}
		return i;
	}

	@Override
	public boolean removeProduit(String nom) {
		boolean isPresent=false;
		int i=0;
		while (i<lesProduits.size() && !isPresent) {
			if (lesProduits.get(i).getNom()==nom) {
				lesProduits.remove(i);
				isPresent=true;
			}
			i++;
		}
		return isPresent;
	
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		boolean isPresent=false;
		int i=0;
		while (i<lesProduits.size() && !isPresent) {
			if (lesProduits.get(i).getNom()==nomProduit) {
				lesProduits.get(i).ajouter(qteAchetee);
				isPresent=true;
			}
			i++;
		}
		return isPresent;
	
	}

	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		boolean isPresent=false;
		boolean isSold=false;
		int i=0;
		while (i<lesProduits.size()&& !isPresent) {
			if (lesProduits.get(i).getNom()==nomProduit) {
				isSold=lesProduits.get(i).enlever(qteVendue);
				isPresent=true;
			}
			i++;
		}
		return isSold;
	}

	@Override
	public String[] getNomProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getMontantTotalTTC() {
		double montantTotal=0;
		int i =0;
		while (i<lesProduits.size()) {
			montantTotal+=(lesProduits.get(i).getPrixUnitaireTTC())*lesProduits.get(i).getQuantite();
			i++;
		}
		return montantTotal;
	}

	@Override
	public void clear() {
		lesProduits.clear();
	}

	public boolean isPresent(String nom) {
		boolean isPresent=false;
		int i=0;
		while(i<lesProduits.size()&&!isPresent) {
			if (lesProduits.get(i).getNom()==nom) {
				isPresent=true;
			}
			i++;
		}
		return isPresent;
	}
	
	public String toString() {
		int i=0;
		String out = "";
		while(i<lesProduits.size()) {
		
			out += lesProduits.get(i).getNom()+" - prix HT : "+lesProduits.get(i).getPrixUnitaireHT()+ " € - prix TTC : "+lesProduits.get(i).getPrixUnitaireTTC()+" € - quantité en stock : "+lesProduits.get(i).getQuantite()+"\n";
			i++;
		}
		out+="\nMontant total TTC du stock : "+ getMontantTotalTTC()+ " €";
			return out;
	}
	
}
