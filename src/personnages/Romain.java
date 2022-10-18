package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

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

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0 : "La force d'un romain doit être positive !";
//		int forceInitial = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force < forceInitial : "La force d'un romain doit diminuer !";
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;

		forceCoup = CalculResistanceEquipement(forceCoup);

		force -= forceCoup;
// 		if (force > 0) {
// 		parler("Aïe");
// 		} else {
// 		equipementEjecte = ejecterEquipement();
// 		parler("J'abandonne...");
// 		}
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grâce à mon équipement, sa force est diminuée de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
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
		nbEquipement ++;
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