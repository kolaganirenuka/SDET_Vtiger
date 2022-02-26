package vtiger_crm;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {
	/**
	 * This method is going to generate random number.
	 * @return random number till 1000
	 */
	public int generateRandomNumber() {
		Random random=new Random()	;
		return	random.nextInt(100);
	}
	/**
	 * This method s going to generate first name.
	 * @return first name
	 */
	public String fakefirstName() {
		Faker faker=new Faker();
		return	faker.name().firstName();
	}

	/**
	 * This method s going to generate last name.
	 * @return last name
	 */
	public String fakelastName() {
		Faker faker=new Faker();
		return	faker.name().lastName();
	}
	/**
	 * This method s going to generate address.
	 * @return address
	 */
	public String fakeAddress() {
		Faker faker=new Faker();
		return	faker.address().fullAddress();
	}
	/**
	 * This method s going to generate company name.
	 * @return company name
	 */
	public String fakecompanyName() {
		Faker faker=new Faker();
		return	faker.company().name();
	}


}
