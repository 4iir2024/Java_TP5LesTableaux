package revision_Atelier5_Exo1;

import java.util.Comparator;

public class CmpPrenom  implements Comparator<Employe>{

	@Override
	public int compare(Employe o1, Employe o2) {
		
		return o1.getPrenom().compareTo(o2.getPrenom());
	}
	

}
