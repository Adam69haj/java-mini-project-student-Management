package Factures;

import java.time.LocalDate;

import lombok.ToString;
@ToString (callSuper = true)
public class Cash extends Reglement {
	public Cash(LocalDate dateReg) {
		super(dateReg);
	}
}
