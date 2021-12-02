package ru.goryachev.multichief.staff.exception;
/**
 * MultiChiefEmptyListException is a custom MultiChief application exception
 * (informs about DTO/entity type of object list having problems)
 * @author Lev Goryachev
 * @version 1.1
 */
public class MultiChiefEmptyListException extends RuntimeException {

    public MultiChiefEmptyListException(String entityTypeName) {
        super(String.format("Requested list is empty. No %s" + "s" + " " + "found in database", entityTypeName));
    }
}
