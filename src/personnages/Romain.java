package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		// invariant: la force d'un Romain est toujours positive
		if (force <= 0) {
			throw new IllegalArgumentException("la force d'un Romain n'est pas positive !");
		}
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		// précondition: la force d'un Romain est positive
//		assert force > 0 : "la force d'un Romain n'est pas positive !";
//		int forceInitiale = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		// post-condition: la force d'un Romain a diminué
//		assert force < forceInitiale : "la force d'un Romain n'a pas diminué !";
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition: la force d'un Romain est positive
		assert force > 0 : "la force d'un Romain n'est pas positive !";
		int oldForce = force;

		forceCoup = calculResistanceEquipement(forceCoup);

		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post-condition: la force d'un Romain a diminué
		assert force < oldForce : "la force d'un Romain n'a pas diminué !";
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grâce à mon équipement, sa force est diminuée de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 1;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		default:
			ajouterEquipement(equipement);
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + " !");
		equipements[nbEquipement] = equipement;
		nbEquipement++;
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