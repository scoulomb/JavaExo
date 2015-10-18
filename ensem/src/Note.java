// structure note
public class Note {
	

	
	public Note(String ue, double d) {
		super();
		this.ue = ue;
		this.value = d;
	}
	
	
	
	@Override
	public String toString() {
		return "<ue=" + ue + ", value=" + value +">";
	}



	public String ue;
	public double value;
	
}