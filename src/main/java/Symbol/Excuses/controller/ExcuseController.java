package Symbol.Excuses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Symbol.Excuses.entity.Excuse;
import Symbol.Excuses.service.ExcuseService;

@RestController
@RequestMapping("/excuses")
public class ExcuseController {

    @Autowired
    private ExcuseService excuseService;

    // CREATE
    @PostMapping
    public ResponseEntity<Excuse> createExcuse(@RequestBody Excuse excuse) {
        try {
            Excuse createdExcuse = excuseService.createExcuse(excuse);
            return new ResponseEntity<>(createdExcuse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ
    @GetMapping("/{httpCode}")
    public ResponseEntity<Excuse> getExcuseByHttpCode(@PathVariable("httpCode") int httpCode) {
        try {
            Excuse excuse = excuseService.getExcuseByHttpCode(httpCode);
            if (excuse == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(excuse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Excuse>> getAllExcuses() {
        try {
            List<Excuse> excuses = excuseService.getAllExcuses();
            if (excuses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(excuses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE
    @PutMapping("/{httpCode}")
    public ResponseEntity<Excuse> updateExcuse(@PathVariable("httpCode") int httpCode, @RequestBody Excuse excuse) {
        try {
            Excuse updatedExcuse = excuseService.updateExcuse(httpCode, excuse);
            if (updatedExcuse == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedExcuse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE
    @DeleteMapping("/{httpCode}")
    public ResponseEntity<HttpStatus> deleteExcuse(@PathVariable("httpCode") int httpCode) {
        try {
            excuseService.deleteExcuseById(httpCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
