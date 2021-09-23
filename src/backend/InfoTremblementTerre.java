package backend;

public class InfoTremblementTerre {
	private int id;
	private String date;
	private float magnitude;
	private String departements;
	private String communes;
	
	public int getId() {
		return id;
	}
	public int setId(int id) {
		return this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(float magnitude) {
		this.magnitude = magnitude;
	}
	public String getDepartements() {
		return departements;
	}
	public void setDepartements(String departements) {
		this.departements = departements;
	}
	public String getCommunes() {
		return communes;
	}
	public void setCommunes(String communes) {
		this.communes = communes;
	}
}
