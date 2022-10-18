package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Equipement;

public class Scenario {

	public static void main(String[] args) {
		
		// Personnages
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Gaulois obelix = new Gaulois("Obélix", 100);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		
		// Scénario
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		if (minus.getForce() > 0) {
			asterix.frapper(minus);
		}
//		do {
//			asterix.frapper(minus);
//		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(milexcus);
	}
}