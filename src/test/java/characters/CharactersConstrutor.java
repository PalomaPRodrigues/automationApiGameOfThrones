package characters;

import com.google.gson.Gson;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONObject;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersConstrutor {

    private String firstName;
    private String lastName;
    private String fullName;
    private String title;
    private String family;
    private String image;
    private String imageUrl;

    public CharactersConstrutor(String firstName, String lastName, String fullName, String title, String family, String image, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.title = title;
        this.family = family;
        this.image = image;
        this.imageUrl = imageUrl;
    }

    public JSONObject getJson() {

        return new JSONObject(new Gson().toJson(this));
    }


}
