package tiidelab.tiidelabass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUBJECT")
public class Subject {
    @Id
    @GeneratedValue
    private int id;
    private String subjectName;




    public void setName(Object name) {

    }

    public Object getName() {
        return null;
    }
}
