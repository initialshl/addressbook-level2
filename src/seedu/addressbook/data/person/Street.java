package seedu.addressbook.data.person;

/**
 * Represents the street name in an address.
 * Guarantees: immutable
 */
public class Street
{
	private final String value;
	
	/**
     * Initializes given street name.
     */
    public Street(String street) {
    	street = street.trim();
        this.value = street;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
