package homework6.zipcode;
/** Creates a Place with the given zip, town name, and
 *  state
 *  @param inputzip The 5-digit zip code
 *  @param inputtown The town name
 *  @param inputstate The state abbreviation
 */

public class Place{
	private String zip;
	private String state;
	private String town;
	
	public Place(String inputzip,String inputstate, String inputtown){
		this.zip=inputzip;
		this.state=inputstate;
		this.town=inputtown;
	}
	public String getZip()
	{
	    return this.zip;
	}
	public String getState()
	{
	    return this.state;
	}
	public String getTown()
	{
	    return this.town;
	}
	public String toString() {
		if(state.length()<town.length())
			return "zipcode: "+zip+"\n"+town+", "+state;
		else 
			return "zipcode: "+zip+"\n"+state+", "+town;
	}
	public int compareTo(String sibling) {
		// sibling is a zipcode of an object of the same type
		int zipsibling=Integer.parseInt(sibling,10);
		
		int zip=Integer.parseInt(this.getZip(),10);
		
		if(zip<zipsibling) {
			return -1;
		}
		else if(zip>zipsibling){
			return 1;
		}
		else{
			return 0;
		}
	}

}
