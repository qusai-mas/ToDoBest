package todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;


@Entity(name="Todo")
@Table(name="Todos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
    private String email;
	@Column
    private String task;
	@Column
    private boolean done;

    protected Todo() {

    }
    public Todo(String email, String task, boolean done) {
     
        this.email= email;
        this.task = task;
        this.done = done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTask(String task) {
        this.task = task;
    }

 
    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTask() {
        return task;
    }

 

    public boolean isDone() {
        return done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
