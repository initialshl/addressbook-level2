package seedu.addressbook.data.person;

/**
 * Represents the unit in an address.
 * Guarantees: immutable
 */
public class Unit
{
	private final String value;
	
	/**
     * Initializes given address unit.
     */
    public Unit(String unit) {
    	unit = unit.trim();
        this.value = unit;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
