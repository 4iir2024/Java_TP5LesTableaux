package revision_Atelier5_Exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TableauEmploye {
	
	private Employe[] employes = new Employe[5];
	
	public void remplir()
	{
		employes[0] = new Employe("samir","lami","SA3022",23222);
		employes[1] = new Employe("nadir","rami","SD3022",23232);
		employes[2] = new Employe("farid","liwi","SL3052",24222);
		employes[3] = new Employe("jamal","dirwi","SA3522",29222);
		employes[4] = new Employe("said","wari","SA3422",26222);
		
		
	}

	
	public void trier(Comparator<Employe> cmp) {
		Arrays.sort(employes, cmp);
	}
	
	public double calculerSalaires() {
		
		double somme=0;
		for(Employe emp : employes)
			somme+=emp.getSalaire();
		
		return somme;

	}
	
	public double calculerMoyenne() {
		return this.calculerSalaires()/employes.length;
	}
	
	public boolean existeEmploye(Employe emp) {
		for(Employe emp1 : employes)
			if(emp1.equals(emp)) return true;
		return false;
	}
	
	public boolean supprimerEmploye(Employe emp) {
		if(this.existeEmploye(emp))
		{
			ArrayList<Employe> list = new ArrayList<Employe>(Arrays.asList(employes));
			list.remove(emp);
			employes = list.toArray(new Employe[list.size()]);
			return true;
		}
		return false;
	}
	
	public Employe[] copieRang(int start,int end) {
		if(start>=0 && start<end)
			return Arrays.copyOfRange(employes, start, end);
		return null;
	}
	
	public void insererEmploye(Employe emp,int position) {
		if(position>=0 && position<employes.length)
		{ArrayList<Employe> liste = new ArrayList<Employe>(Arrays.asList(employes));
		liste.add(position,emp);
		employes = liste.toArray(new Employe[liste.size()]);
		}
		
		throw new IllegalArgumentException("la position doit etre comprise entre 0 et la taill de tableau");
	}
	
	
	public void afficherSalaireMinEtMax() {
		
		Arrays.sort(employes, new CmpSalaire());
		System.out.println("Le salaire maximum est : "+employes[employes.length-1].getSalaire()+", et le minimum est: "+employes[0].getSalaire());
	}
	
	public void inverserOrdre() {
		ArrayList<Employe> liste = new ArrayList<Employe>(Arrays.asList(employes));
		Collections.reverse(liste);
		employes = liste.toArray(new Employe[liste.size()]);
	}
	
	
	public Employe empSalaireMax() {
		
		Arrays.sort(employes, new CmpSalaire());
		return employes[employes.length-1];
	}
	
	
	public boolean testerEgalite(Employe[] tabEmployes) {
		return Arrays.equals(this.employes, tabEmployes);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
