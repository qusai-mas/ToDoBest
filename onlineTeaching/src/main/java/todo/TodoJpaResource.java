package todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaResource {

    @Autowired
    private TodoHardcodedService todoService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoJpaRepository.findByEmail(username);
        //return todoService.findAll();
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        return todoJpaRepository.findById(id).get();
        //return todoService.findById(id);
    }

    @PostMapping("/jpa/users/todos")
    public ResponseEntity<Todo> addTodo(@RequestParam ("username") String username,@RequestParam ("Task")String Task){
    	Todo todo  = new  Todo();
		todo.setEmail(username);
		todo.setTask(Task);
		todo.setDone(false);
        Todo createdTodo = todoJpaRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        //Passing the new URL back
        return ResponseEntity.created(uri).build();
    }
  

    @PutMapping("/jpa/users/{email}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        Todo todoUpdated = todoJpaRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo (@PathVariable String username, @PathVariable long id){
        todoJpaRepository.deleteById(id); //return void

        return ResponseEntity.noContent().build();
    }

}
