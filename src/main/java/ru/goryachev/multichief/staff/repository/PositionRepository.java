package ru.goryachev.multichief.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.goryachev.multichief.staff.model.Position;

import java.util.List;

/**
 * PositionRepository (CRUD, find by positionName).
 * @author Lev Goryachev
 * @version 1.1
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findAllByPosName(String positionName);
}
