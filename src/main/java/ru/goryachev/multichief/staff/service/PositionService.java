package ru.goryachev.multichief.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.staff.model.Position;
import ru.goryachev.multichief.staff.repository.PositionRepository;

import java.util.List;

/**
 * PositionService works with types: Position, PositionDTO.
 * @author Lev Goryachev
 * @version 3
 */

@Service
public class PositionService {


    private PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAll(String posName) throws EmptyListException {
        if (posName == null) {
            List<Position> allPositions = positionRepository.findAll();
            if (allPositions.isEmpty()) {
                throw new EmptyListException();
            }
            return allPositions;
        }
        List<Position> allPositions = positionRepository.findAllByLastName(posName);
        if (allPositions.isEmpty()) {
            throw new EmptyListException();
        }
        return allPositions;
    }

    public Position getById(Long id) throws EntityNotFoundException {
        Position position = positionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return position;
    }

    public Position create(Position position) {
        return positionRepository.save(position);
    }

    public Position update(Position modifiedPosition) {
        return positionRepository.save(modifiedPosition);
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
