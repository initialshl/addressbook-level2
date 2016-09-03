package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents a Tagging associated with the person and tag operation. 
 * Guarantees: immutable
 */
public class Tagging {

    public enum TagOperation {
        ADD, REMOVE
    };

    private static final String STRING_PREPEND_TAGOPERATION_ADD = "+ ";
    private static final String STRING_PREPEND_TAGOPERATION_REMOVE = "- ";

    private final TagOperation tagOperation;
    private final Person person;
    private final Tag tag;

    /**
     * Creates Tagging with specified type of operation.
     */
    public Tagging(TagOperation tagOperation, Person person, Tag tag) {
        this.tagOperation = tagOperation;
        this.person = person;
        this.tag = tag;
    }
    
    public TagOperation getTagOperation() {
        return tagOperation;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(person + " [" + tag + "]");
        
        switch (tagOperation) {
        case ADD:
            sb.insert(0, STRING_PREPEND_TAGOPERATION_ADD);
        case REMOVE:
            sb.insert(0, STRING_PREPEND_TAGOPERATION_REMOVE);
        }
        return sb.toString();
    }
}
