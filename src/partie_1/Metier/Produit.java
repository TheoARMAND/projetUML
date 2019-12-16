package partie_1.Metier;

public class Produit implements  I_Produit{

	protected int quantiteStock;
	protected String nom;
	protected double prixUnitaireHT;
	protected double tauxTVA = 0.2;
	
	
	public Produit(String nom, int quantité, double prixUnitaireHT) {
		this.nom=nom;
		this.prixUnitaireHT=prixUnitaireHT;
		this.quantiteStock=quantité;
	}
	
	
	@Override
	public boolean ajouter(int qteAchetee) {
		if (qteAchetee<=0)
			return false;
		else {
			this.quantiteStock+=qteAchetee;
			return true;
		}
	}

	@Override
	public boolean enlever(int qteVendue) {
		if (qteVendue<=0|| qteVendue<this.quantiteStock)
			return false;
		else {
			this.quantiteStock-=qteVendue;
			return true;
		}
	}
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getQuantite() {
		return this.quantiteStock;
	}

	@Override
	public double getPrixUnitaireHT() {
		return this.prixUnitaireHT;
	}

	@Override
	public double getPrixUnitaireTTC() {
		return this.prixUnitaireHT+(this.prixUnitaireHT*this.tauxTVA);
	}

	@Override
	public double getPrixStockTTC() {
		// TODO Auto-generated method stub
		return getPrixUnitaireTTC()*this.quantiteStock;
	}

	
}
