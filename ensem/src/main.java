import java.awt.EventQueue;



class ArrayDemo {
    public static void main(String[] args) {
        Eleve eleve = new Eleve("Toto", "Titi", "ISN");
        
        Note note1 = new Note(new String("math"), 7);
        Note note2 = new Note(new String("info"), 10);
        Note note3 = new Note(new String("anglais"), 9);
        Note note4 = new Note(new String("meca"), 15);
        Note note5 = new Note(new String("electronique"), 19);
        
        eleve.pushNote(note1);
        eleve.pushNote(note2);
        eleve.pushNote(note3);
        eleve.pushNote(note4);
        eleve.pushNote(note5);
        
        System.out.println(eleve.toString());
        System.out.println(eleve.getMoyenne());
        System.out.println(eleve.hasUEBelow10());
        eleve.displayUEBelow10();
        
        System.out.println("----------------------");
        GroupeEleve g = new GroupeEleve();
        g.fillFromFile("src/eleves.txt");
        g.afficherEtudiantAvecUEARattraper();
        System.out.println("--------");
        
        try {
        	g.displayEleveByName("DURANT");
        } catch(Error e) {
        	System.out.println("Exception is thrown: " + e.getMessage());
        }
        
        try {
        	g.displayEleveByName("DURAN");
        } catch(Error e) {
        	System.out.println("Exception is thrown: " + e.getMessage());
        }
  
        
    }
} 