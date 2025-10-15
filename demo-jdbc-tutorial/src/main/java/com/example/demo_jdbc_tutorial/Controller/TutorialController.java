package com.example.demo_jdbc_tutorial.Controller;

import com.example.demo_jdbc_tutorial.model.Tutorial;
import com.example.demo_jdbc_tutorial.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    private final TutorialRepository repository;

    @Autowired
    public TutorialController(TutorialRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Tutorial tutorial) {
        int retValue = repository.save((tutorial));
        if (retValue == 1) return ResponseEntity.ok("Tutorial created!");
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Tutorial tutorial) {
        Tutorial _tutorial = repository.findById(id);
        if (_tutorial == null) return ResponseEntity.notFound().build();
        _tutorial.setTitle(tutorial.getTitle());
        _tutorial.setCategory(tutorial.getCategory());
        _tutorial.setDescription(tutorial.getDescription());
        _tutorial.setPublished(tutorial.isPublished());
        return ResponseEntity.ok("Tutorial updated!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id) {
        Tutorial tutorial = repository.findById(id);
        if (tutorial == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tutorial);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category
    ) {
        List<Tutorial> tutorials = new ArrayList<>();

        if (title != null) {
            tutorials.addAll(repository.findAllByTitleContaining(title));
        }
        if (category != null) {
            tutorials.addAll(repository.findByCategory(category));
        }
        if (title == null && category == null) {
            tutorials.addAll(repository.findAll());
        }
        return ResponseEntity.ok(tutorials);
    }

    @GetMapping("/published/{published}")
    public ResponseEntity<List<Tutorial>> findByPublished(@PathVariable Boolean published) {
        return ResponseEntity.ok(repository.findByPublished(published));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        int retValue = repository.deleteById(id);
        if (retValue == 0) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok("Tutorial deleted!");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll() {
        int retValue = repository.deleteAll();
        return ResponseEntity.ok("Deleted" + retValue + "Tutorials!");
    }
}
