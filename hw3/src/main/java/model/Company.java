package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Company {

    @JsonProperty("id")
    private int id;

    @JsonProperty("code")
    private String code;

    @JsonProperty("name_full")
    private String nameFull;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getInn() {
        return inn;
    }

    public CompanyType getCompany_type() {
        return company_type;
    }

    public String getOgrn() {
        return ogrn;
    }

    public Date getEgrul_date() {
        return egrul_date;
    }

    public Country getCountry() {
        return country;
    }

    public String getFio_head() {
        return fio_head;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getWww() {
        return www;
    }

    public Boolean getIs_resident() {
        return is_resident;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    @JsonProperty("name_short")
    private String nameShort;

    @JsonProperty("inn")
    private String inn;

    @JsonProperty("company_type")
    private CompanyType company_type;

    @JsonProperty("ogrn")
    private String ogrn;

    @JsonProperty("egrul_date")
    private Date egrul_date;

    @JsonProperty("country")
    private Country country;

    @JsonProperty("fio_head")
    private String fio_head;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("e_mail")
    private String e_mail;

    @JsonProperty("www")
    private String www;

    @JsonProperty("is_resident")
    private Boolean is_resident;

    @JsonProperty("securities")
    private List<Security> securities;

    @Override
    public String toString() {
        return "COMPANY{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name_full='" + nameFull + '\'' +
                ", name_short='" + nameShort + '\'' +
                ", inn='" + inn + '\'' +
                ", company_type=" + company_type +
                ", ogrn='" + ogrn + '\'' +
                ", egrul_date=" + egrul_date +
                ", country=" + country +
                ", fio_head='" + fio_head + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", www='" + www + '\'' +
                ", is_resident=" + is_resident +
                ", securities=" + securities +
                '}';
    }
}

