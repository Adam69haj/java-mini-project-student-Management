package Factures;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
@EqualsAndHashCode (of = "numero") 
public class Facture {
	private String numero;
	private LocalDate dateCreation;
	private double montant;
	private Client proprietaire;//  Une facture appartient a 1 client
	private List<Reglement> reglements = new ArrayList<>();// Une facture peut avoir plusieurs règlements

	public Facture(String numero, LocalDate dateCreation, double montant, Client proprietaire) {
    this.numero = numero;
    this.dateCreation = dateCreation;
    this.montant = montant;
    this.proprietaire = proprietaire;
    this.reglements = new ArrayList<>(); //au moment où on crée la facture, le client n'a pas encore payé
}

}







//si on n'avait pas mis new ArrayList<>() ici :
/* on autre classe
public void afficheReg(Facture f) {
    // Si la liste est nulle, on ne fait rien pour éviter le crash
    if (f.getReglements() != null) {
        for (Reglement r : f.getReglements()) {
            System.out.println(r);
        }
    } else {
        System.out.println("Aucun règlement pour cette facture.");
    }
} */

	//on peut ajouter cette methode 
	//sans cette methode en main:
		//facture.getReglements().add(monCheque);
	//avec cette methode ici :
		/*public void addReglement(Reglement r) {
    this.reglements.add(r);
}*/
	//en main :
	 	//Facture.addReglement(monCheque);

