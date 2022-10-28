ackage personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophees = 0;
	
	public Musee() {
		int nbTropheesMax = 200;
		this.trophees = new Trophee[nbTropheesMax];
	}

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophees] = trophee;
		nbTrophees += 1;
	}
}