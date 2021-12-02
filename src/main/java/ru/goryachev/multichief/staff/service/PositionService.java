package ru.goryachev.multichief.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.staff.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.staff.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.staff.model.Position;
import ru.goryachev.multichief.staff.repository.PositionRepository;

import java.util.List;

/**
 * PositionService works with types: Position, PositionDTO.
 * @author Lev Goryachev
 * @version 3
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class PositionService {

    @Value("${model.entity.alias.position}")
    private String positionEntityAlias;

    private PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAll(String posName) throws MultiChiefEmptyListException {
        if (posName == null) {
            List<Position> allPositions = positionRepository.findAll();
            if (allPositions.isEmpty()) {
                throw new MultiChiefEmptyListException(positionEntityAlias);
            }
            return allPositions;
        }
        List<Position> allPositions = positionRepository.findAllByPosName(posName);
        if (allPositions.isEmpty()) {
            throw new MultiChiefEmptyListException(positionEntityAlias);
        }
        return allPositions;
    }

    public Position getById(Long id) throws MultiChiefObjectNotFoundException {
        Position position = positionRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(positionEntityAlias, id));
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
