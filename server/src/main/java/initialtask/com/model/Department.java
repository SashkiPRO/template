package initialtask.com.model;

import initialtask.com.util.UniqeDepartmentCheck;
import net.sf.oval.constraint.*;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "department")
public class Department extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @NotNull(message = "Null field")
    @NotEmpty(message = "Empty field")
    @CheckWith(value = UniqeDepartmentCheck.class, message = "Department with the same name is already exists!")
    @MinLength(value = 2, message = "This field cannot be shorter than 2 characters")
    @MaxLength(value = 20, message = "Maximal value of this field is 20 symbols!")
    @Column(name = "name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

}
