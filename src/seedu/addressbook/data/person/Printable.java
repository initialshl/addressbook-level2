package seedu.addressbook.data.person;

/**
 * An interface to get printable strings.
 */
public interface Printable {

    /**
     * Returns the printable string.
     */
    public String getPrintableString();
    
    /**
     * Returns a concatenated version of the printable strings of each object.
     */
    static String getPrintableString(Printable... printables) {
        String printableString = "";
        for (Printable s : printables) {
            printableString += s.getPrintableString() + " ";
        }
        return printableString;
    }
}
