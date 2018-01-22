package initialtask.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import initialtask.com.util.UniqeCheck;
import net.sf.oval.constraint.*;


import javax.persistence.*;
import java.sql.Date;



@javax.persistence.Entity
@Table(name = "employee")
public class Employee extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @NotEmpty(message = "This field can't be empty!")
    @MinLength(value = 2, message = "Minimal length of this field - 4!")
    @MaxLength(value = 20, message = "This field cannot be longer than 20 symbols!")
    @NotNull(message = "This field can't be empty")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "This field can't be empty!")
    @NotNull(message = "This field can't be empty!")
    @Column(name = "date_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @NotEmpty(message = "This field can't be empty!")
    @NotNull(message = "This field can't be empty!")
    @Column(name = "salary")
    private Double salary;
    @Email(message = "Wrong email format!")
    @NotEmpty(message = "This field can't be empty!")
    @CheckWith(value = UniqeCheck.class, message = "User with the same email is already exists!")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "This field can't be empty!")
    @NotNull(message = "This field can't be empty!")
    @Column(name = "department_id")

    private Integer departmentId;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }

}
