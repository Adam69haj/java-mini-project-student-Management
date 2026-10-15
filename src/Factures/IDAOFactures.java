package Factures;

import java.util.Optional;

public interface IDAOFactures {

	public void save(Facture f);

	public Optional<Facture> findByNumero(String numero);
}
