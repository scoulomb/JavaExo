import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GroupeEleve {

	public GroupeEleve() {
		super();
		this.eleves = new ArrayList<Eleve>();
	}
	
	public void addEleve(Eleve eleve){
		this.eleves.add(eleve);
	}
	
	public void fillFromFile(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				String [] split = sCurrentLine.split("&");
				Eleve e = new Eleve(split[0], split[1], split[2]);
				for(int i = 3; i < 8; ++i){
					e.pushNote(new Note("UE" + (i - 3), Double.parseDouble(split[i])));
				}
				
				eleves.add(e);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
	public void afficherEtudiantAvecUEARattraper() {
		for (Eleve eleve : eleves) {
			if(eleve.hasUEBelow10()){
				System.out.println(eleve.toString());
				
			}
		}
			
	}
	
	
	

	public ArrayList<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(ArrayList<Eleve> eleves) {
		this.eleves = eleves;
	}


	public Eleve getEleveByName(String nom){
		
		for (Eleve eleve : eleves) {
			if(eleve.getNom().equals(nom)){
				return eleve;
				
			}
		}
		throw new Error("Student " + nom + " not found :(");
		
	}
	
	public void displayEleveByName(String nom){
		Eleve foundStudent = this.getEleveByName(nom);
		System.out.println(foundStudent.toString());
	}


	private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
}
