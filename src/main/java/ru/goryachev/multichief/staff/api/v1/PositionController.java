package ru.goryachev.multichief.staff.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.goryachev.multichief.staff.model.Position;
import ru.goryachev.multichief.staff.service.PositionService;

import java.util.List;

/**
 * MultiChiefStaff microservice API: see app/swagger-ui/
 * @author Lev Goryachev
 * @version 1
 */

@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPositions (@RequestParam (value = "positionname", required = false) String posName) {
        return new ResponseEntity<>(positionService.getAll(posName), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Position> getById (@PathVariable Long id) {
            return new ResponseEntity<>(positionService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create (@RequestBody Position position) {
        return new ResponseEntity<>(positionService.create(position), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update (@RequestBody Position modifiedPosition) {
        return new ResponseEntity<>(positionService.update(modifiedPosition), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id) {
        return new ResponseEntity<>(positionService.delete(id),HttpStatus.OK);
    }
}
