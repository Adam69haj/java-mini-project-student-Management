package Factures;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c1 = new Client("sdac","adjkb@djcb","hassen",CategorieClient.FIDELE);
		System.out.println(c1);
		


		//////////////////////////////////////// plus juste pour tester
		Facture f1 = new Facture("FAC-100", LocalDate.now(), 520.0, c1);
		System.out.println("\n=== FACTURE ===");
		System.out.println(f1);

		f1.getReglements().add(new Cash(LocalDate.now()));
		f1.getReglements().add(new Cheque(LocalDate.now(), "CHQ-7788", "BIAT", LocalDate.of(2026, 12, 1)));
		f1.getReglements().add(new CarteVisa(LocalDate.now(), "4970-0000-1111-2222", "Ali Ben Salah", LocalDate.of(2028, 4, 30)));

		System.out.println("\n=== RÈGLEMENTS DE LA FACTURE ===");
		for (Reglement r : f1.getReglements()) {
			System.out.println("- " + r);
		}
		//////////////////////////////////////////
		/// test bd
		IDAOFactures fauxDao = new IDAOFactures() {
    		private List<Facture> bdd = new ArrayList<>();
    	@Override
    	public void save(Facture f) {
    	    bdd.add(f);
    	}
    @Override
    public java.util.Optional<Facture> findByNumero(String numero) {
        return bdd.stream().filter(f -> f.getNumero().equals(numero)).findFirst();
    }
};

GestionFactures service = new GestionFactures(fauxDao);
service.enregistrer(f1);
service.afficheReg(f1);
	}

}
