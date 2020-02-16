package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Security {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name_full")
    private String nameFull;

    @JsonProperty("cfi")
    private String cfi;

    @JsonProperty("date_to")
    private Date dateTo;

    @JsonProperty("state_reg_date")
    private String stateRegDate;

    @JsonProperty("state")
    private State state;

    @JsonProperty("currency")
    private Currency currency;

    @Override
    public String toString() {
        return "SECURITY{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + nameFull + '\'' +
                ", cfi='" + cfi + '\'' +
                ", date_to='" + dateTo + '\'' +
                ", state_reg_date='" + stateRegDate + '\'' +
                ", state=" + state +
                ", currency=" + currency +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getCfi() {
        return cfi;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public String getStateRegDate() {
        return stateRegDate;
    }

    public State getState() {
        return state;
    }

    public Currency getCurrency() {
        return currency;
    }
}
