package fluids;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
	ArrayList<String> output=Read.file("/Users/thedude/Desktop/Matlab/Instron/8_2/compressive tests/paa50/0.01 cm_s/paa50.is_comp_RawData/Specimen_RawData_", 2, 5);
	Read.write(output,"/Users/thedude/Desktop/Matlab/Instron/8_2/compressive tests/paa50/0.01 cm_s/javacsv/0_01paa50.csv");
	}
}
