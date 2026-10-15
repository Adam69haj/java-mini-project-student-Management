package Factures;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.ToString;
@ToString (callSuper = true)
public class Cheque extends Reglement {
	private String numCheque;
	private String banque;
	private LocalDate dateEch;
	
	public Cheque(LocalDate dateReg , String numCheque, String banque, LocalDate dateEch) {
		super(dateReg);
		this.numCheque=numCheque;
		this.banque=banque;
		this.dateEch=dateEch;
	}
}
