package Factures;

import java.time.LocalDate;

import lombok.ToString;
@ToString (callSuper = true)
public class CarteVisa extends Reglement {
	
	private String numCarte;
	private String nom;
	private LocalDate dateFinValid;
	
	public CarteVisa(LocalDate dateReg , String numCarte , String nom , LocalDate dateFinValid) {
		super(dateReg);
		this.numCarte = numCarte;
		this.nom=nom;
		this.dateFinValid = dateFinValid;
	}
}
