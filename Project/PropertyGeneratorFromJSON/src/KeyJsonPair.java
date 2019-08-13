public class KeyJsonPair {

    String propertyKey;

    /**
     * Since this class is reusable below variable is used for either:
     *  1. to store JSON for all languages, or
     *  2. to store value for single language.
     */
    String valueAsJsonOrString;

    KeyJsonPair(String key, String json)
    {
        this.propertyKey = key;
        this.valueAsJsonOrString = json;
    }
}