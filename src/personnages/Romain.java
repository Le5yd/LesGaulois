package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un romain doit être positive !";
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0 : "La force d'un romain doit être positive !";
		int forceInitial = force;
		force -= forceCoup;
		assert forceInitial > force : "La force d'un romain doit diminuer !";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public static void main(String[] args) {
		Romain caiusBonus = new Romain("Caius Bonus", 10);
		caiusBonus.parler("Ave, César !");
		caiusBonus.recevoirCoup(1);
		caiusBonus.recevoirCoup(30);
	}
}