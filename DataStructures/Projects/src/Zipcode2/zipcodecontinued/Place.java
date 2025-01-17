package homework2.zipcodecontinued;
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
	

}
