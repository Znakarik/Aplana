package groupId.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Currency {

    @JsonProperty("id")
    private int id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name_short")
    private String nameShort;

    @JsonProperty("name_full")
    private String nameFull;

    @Override
    public String toString() {
        return "CURRENCY{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_short='" + nameShort + '\'' +
                ", name_full='" + nameFull + '\'' +
                '}';
    }
}
