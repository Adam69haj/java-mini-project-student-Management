package Factures;

import java.util.Optional;

public interface IGestionFactures {

	public void enregistrer(Facture f);

	public Optional<Facture> chercherParNumero(String numero);

	public void afficheReg(Facture f);
}
