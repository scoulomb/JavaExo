import java.util.ArrayList;



public class Eleve {
	
	// constructor	
	public Eleve() {
		super();
	}


	public Eleve(String nom, String prenom, String specialite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
	}

	// getters and setters
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public ArrayList<Note> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}
	
	// Display 
	@Override
	public String toString() {
		return "nom=" + nom + ", prenom=" + prenom + ", specialite="
				+ specialite + ", Notes=[" + this.getAllNotesIntoString() +"]";
	}
	
	public String toSwingString() {
		String string = new String("Nom: " + nom + "\nPrenom:" + prenom + "\nSpecialite:"
				+ specialite + "\n------------\nNotes\n------------\n");
		
		for(Note note : this.notes) {
			String s = new String("UE: " + note.ue + "\nNote obtenue: " + note.value + "\n\n");
			string += s;
		}
		
		string += "\n------------\nMoyenne (rounded)\n------------\n" + Math.round(this.getMoyenne());
		
		string += "\n------------\nSoumis au rattrapage\n------------\n";
		if(hasUEBelow10()) { string += "YES"; } else { string += "NO";};
		
		
		
		return string;
	}
	
	public void displayUEBelow10() {
		System.out.println("nom=" + nom + ", prenom=" + prenom + ", specialite="
				+ specialite + ", Notes=[" + this.getNotesBelow10IntoString() +"]");
	}
	
	// methode metier
	
	public void pushNote(Note note) {
		notes.add(note);
	}

	public double getMoyenne() {
		
		Double sum = 0.0;
		  if(!notes.isEmpty()) {
		    for (Note note : notes) {
		        sum += note.value;
		    }
		    return sum.doubleValue() / notes.size();
		  }
		  return sum;	
	}
	
	public boolean hasUEBelow10() {
		
		if(!notes.isEmpty()) {
			for (Note note : notes) {
				if(note.value < 10) {
					return true;
			    }
			}
		  }
		  return false;
	}

	// helper methods
	private String getAllNotesIntoString() {
		
		String noteString = "";
		if(!notes.isEmpty()) {
			for (Note note : notes) {
				noteString+= note.toString() + ";";
				
			}
		}
		return noteString;
	}
	
	private String getNotesBelow10IntoString() {
		
		String noteString = "";
		if(!notes.isEmpty()) {
			for (Note note : notes) {
				if(note.value < 10){
					noteString+= note.toString() + ";";
				}
			}
		}
		return noteString;
	}
	

	// class member
	
	private String nom;
	private String prenom;
	private String specialite;
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	


}
