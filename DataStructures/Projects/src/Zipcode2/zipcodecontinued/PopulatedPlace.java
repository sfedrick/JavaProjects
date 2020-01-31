package homework2.zipcodecontinued;

public class PopulatedPlace extends LocatedPlace {
	private String population;
	public PopulatedPlace(String inputzip,String inputstate, String inputtown,String latitude,String longitude,String population){
		super(inputzip,inputstate,inputtown,latitude,longitude);
		this.population=population;	
	}
	
	public int getPopulationint()
	{
		try{
			return Integer.parseInt(this.population);
		}
		catch(Exception e) {
	    	return 0;
		}
	}
	public String getPopulation()
	{
		return this.population;
	}
	public String toString() {
		
		if(this.getState().length()<this.getTown().length())
			return "zipcode: "+this.getZip()+"\n"+this.getTown()+", "+this.getState()+" "+this.getLatitude()+" "+this.getLongitude()+" "+this.getPopulation();
		else 
			return "zipcode: "+this.getZip()+"\n"+this.getState()+", "+this.getTown()+" "+this.getLatitude()+" "+this.getLongitude()+" "+this.getPopulation();
	}
	
}
