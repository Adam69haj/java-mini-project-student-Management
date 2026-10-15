package Factures;


import java.util.Optional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestionFactures implements IGestionFactures {
	private IDAOFactures idaoFactures;
	
	//or this constructor
	/*public GestionFactures (IDAOFactures dao) {
		this.idaoFactures=dao; //this.idaoFactures=idaoFactures; but the variable in the parameter idaoFactures
	}*/
	@Override 
	public void enregistrer (Facture f) {
		if (f==null) {return;}
			
		Optional<Facture> d = idaoFactures.findByNumero(f.getNumero());
		if(d.isPresent()) {
			System.out.println("facture deja exist");
		}
		
		else {
			idaoFactures.save(f);
			System.out.println("facture enregistrer");
		}
	}
	
	@Override 
	public void afficheReg(Facture f) {
		for(Reglement r : f.getReglements()){
			System.out.println(r);
		}
	}
/* 
	@Override
public void afficheReg(Facture f) {
    // 1.vérifier si la facture passée est nulle
    if (f == null || f.getNumero() == null) {
        System.out.println("Facture invalide.");
        return;
    }
    // 2. Recherche dans la BD via son numéro
    Optional<Facture> opt = chercherParNumero(f.getNumero());
    // 3. Si la facture n'existe pas en BD, on informe l'utilisateur
    if (opt.isEmpty()) {
        System.out.println("Facture introuvable dans la base de données.");
        return;
    }
    // 4. Si elle existe, on récupère ses règlements
    Facture factureEnBase = opt.get();
    if (factureEnBase.getReglements() == null || factureEnBase.getReglements().isEmpty()) {
        System.out.println("Aucun règlement trouvé pour cette facture.");
        return;
    }
    // 5. Affichage des règlements
    System.out.println("Règlements de la facture N " + factureEnBase.getNumero() + " :");
    for (Reglement r : factureEnBase.getReglements()) {
        System.out.println("- " + r);
    }
}*/

	@Override 
	public Optional<Facture> chercherParNumero(String numero){
		return idaoFactures.findByNumero(numero);
	}
}
