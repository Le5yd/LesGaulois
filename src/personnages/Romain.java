package personnages;

import java.util.Iterator;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		default:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + " !");
				equipements[nbEquipement] = equipement;
				nbEquipement += 1;
			}
		}
	}

	public static void main(String[] args) {
		Romain caiusBonus = new Romain("Caius Bonus", 10);
		caiusBonus.parler("Ave, César !");
		caiusBonus.recevoirCoup(1);
		caiusBonus.recevoirCoup(30);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		caiusBonus.sEquiper(Equipement.CASQUE);
		caiusBonus.sEquiper(Equipement.CASQUE);
		caiusBonus.sEquiper(Equipement.BOUCLIER);
		caiusBonus.sEquiper(Equipement.CASQUE);
	}
}