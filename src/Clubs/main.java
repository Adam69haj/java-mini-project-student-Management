package Clubs;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Etudiant e1 = new Etudiant ("Adam",LocalDate.of(2001, 11, 4),"sdcvs@gmail.com");
		Etudiant e2 = new Etudiant ("Josef",LocalDate.of(2010, 7, 22),"Josef123@gmail.com");
		Club c1 = new Club("fss",new HashSet<>());
		
		System.out.println(c1.addMembre(e1));
		System.out.println(c1.addMembre(e2));
		System.out.println(c1.getMembres());
		//Optional<Etudiant> ee =c1.chercheMembre(e1.getEmail());
		Optional<Etudiant> ee =c1.chercheMembre("JHFY");
		System.out.println(ee);
		
		c1.setEmailMember("sdcvs@gmail.com", "sdfeafas@gmail.com");
		System.out.println(c1.getMembres());
		
		
	}

}
