package seedu.addressbook.data.person;

/**
 * Represents the block number in an address.
 * Guarantees: immutable
 */
public class Block
{
	private final String value;
	
	/**
     * Initializes given block number.
     */
    public Block(String block) {
        block = block.trim();
        this.value = block;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
