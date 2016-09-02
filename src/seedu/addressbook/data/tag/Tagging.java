package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents a Tagging associated with the person and tag operation. 
 * Guarantees: immutable
 */
public class Tagging {

    public enum TaggingType {
        ADD, REMOVE
    };

    private final TaggingType taggingType;
    private final Person person;
    private final Tag tag;

    /**
     * Creates Tagging with specified type of operation.
     */
    public Tagging(TaggingType taggingType, Person person, Tag tag) {
        this.taggingType = taggingType;
        this.person = person;
        this.tag = tag;
    }

    @Override
    public String toString() {
        switch (taggingType) {
        case ADD:
            return "+ " + person + " [" + tag + "]";
        case REMOVE:
            return "- " + person + " [" + tag + "]";
        }
        return "  " + person + " [" + tag + "]";
    }
}
