package homework2.zipcodecontinued;

public class LocatedPlace extends Place{
	private String latitude;
	private String longitude;
	public LocatedPlace(String inputzip,String inputstate, String inputtown,String latitude,String longitude){
		super(inputzip,inputstate,inputtown);
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public String getLatitude()
	{
	    return this.latitude;
	}
	public String getLongitude()
	{
	    return this.longitude;
	}
	public String toString() {
		if(this.getState().length()<this.getTown().length())
			return "zipcode: "+this.getZip()+"\n"+this.getTown()+", "+this.getState()+" "+this.getLatitude()+" "+this.getLongitude();
		else 
			return "zipcode: "+this.getZip()+"\n"+this.getState()+", "+this.getTown()+" "+this.getLatitude()+" "+this.getLongitude();
	
			
		
	}
	
}
