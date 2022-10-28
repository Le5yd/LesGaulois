package personnages;

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
	public String extraireInstructionsCaml() {
		String texte = "let musee = [";
		for (int i = 0; trophees[i] != null; i++) {
			if (i != 0) {
				texte += ";";
			}
			Trophee trophee = trophees[i];
			String gaulois = trophee.donnerNom();
			Equipement equipement = trophee.getEquipement();
			texte += "\n     \"" + gaulois + "\", \"" + equipement + "\"";
		}
		texte += "\n]";
		return texte;
	}
}