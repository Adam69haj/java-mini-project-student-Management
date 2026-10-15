package Clubs;

import java.util.Optional;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Club {
	@Getter
	@Setter
	private String nom;
	@Getter
	private Set<Etudiant> membres;//set for the students //= new HashSet<Etudiant>(); we don't need it
	//set est une interface pas class comme hashset or class standard du JDK comme (optional,sys,string)
	
	//constructor
	/*
	public Club (String nom , Set<Etudiant> membres) {
		this.nom=nom;
		this.membres=membres;
	}*/
	//Getter
	/*
	public Set<Etudiant> getMembres() {
        return membres;
    }*/
	
	
	public Optional<Etudiant> chercheMembre(String email){
		if (email==null) 
			return Optional.empty();
			//return null; 
		return membres.stream().filter(e->email.equals(e.getEmail())).findFirst();
		
	}
	
	
	public boolean addMembre(Etudiant d) {  //method 1
		if (d==null || chercheMembre(d.getEmail()).isEmpty()==false) {
			return false;
		}
		membres.add(d);
		return true;
		
		//return membres.add(d); //will return false if the element exists (method 2)
	}
	
	
	public void setEmailMember(String email1,String email2) {
		if(email2==null) {
			return;
		}
		if (chercheMembre(email2).isPresent()) {
			return;
		}
		if (chercheMembre(email1).isEmpty()==false) {
			Optional<Etudiant> e = chercheMembre(email1);
			if (e.isPresent()) {
				Etudiant e1 = e.get();
				membres.remove(e1);
				e1.setEmail(email2);
				addMembre(e1);
				}
		}
		else return;
	}
	
}
