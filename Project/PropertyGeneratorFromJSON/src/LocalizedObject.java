import com.fasterxml.jackson.annotation.JsonProperty;

public class LocalizedObject {

    @JsonProperty("locale")
    String locale;

    @JsonProperty("country")
    String country;

    @JsonProperty("string")
    String string;

    @JsonProperty("locale")
    public String getLocale() { return locale; }

    @JsonProperty("locale")
    public void setLocale(String locale) { this.locale = locale; }

    @JsonProperty("country")
    public String getCountry() { return country; }

    @JsonProperty("country")
    public void setCountry(String country) { this.country = country; }

    @JsonProperty("string")
    public String getString() { return string; }

    @JsonProperty("string")
    public void setString(String string) { this.string = string; }
}