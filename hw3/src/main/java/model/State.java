package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class State {

    private int id;

    private String name;

    @Override
    public String toString() {
        return "STATE: " +
                "id: " + id +
                ", name: " + name + '\'';
    }

}
