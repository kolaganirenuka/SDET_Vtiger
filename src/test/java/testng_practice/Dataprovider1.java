package testng_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1 {
	@Test(dataProvider="city")
	public void travel(String src,String dest,String stop) {
		System.out.println(src+" "+dest+" "+stop);
	}
	@DataProvider
	public Object[][] city() {
		Object arr[][]=new Object[4][3];
		arr[0][0]="hyd";
		arr[0][1]="blr";
		arr[0][2]="zahirabad";

		arr[1][0]="amaravati";
		arr[1][2]="hyd";
		arr[1][2]="guntur";

		arr[2][0]="hyd";
		arr[2][1]="vijayavada";
		arr[2][2]="suryapet";

		arr[3][0]="hyd";
		arr[3][1]="bhongir";
		arr[3][2]="uppal";
		return arr;
	}
}
