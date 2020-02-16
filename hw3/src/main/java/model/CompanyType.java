package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyType {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name_short")
    private String name_short;

    @Override
    public String toString() {
        return "COMPANY TYPE{" +
                "id=" + id +
                ", name_short='" + name_short + '\'' +
                ", name_full='" + name_full + '\'' +
                '}';
    }

    @JsonProperty("name_full")
    private String name_full;

}