package seedu.addressbook.data.person;

/**
 * Represents the postal code in an address.
 * Guarantees: immutable
 */
public class PostalCode
{
	private final String value;
	
	/**
     * Initializes given postal code.
     */
    public PostalCode(String postalCode) {
    	postalCode = postalCode.trim();
        this.value = postalCode;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
