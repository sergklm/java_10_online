package org.example.service;

import org.example.db.DbOwner;
import org.example.entity.Owner;
public class OwnerService {

    private final DbOwner dbOwner = new DbOwner();

    public void create(Owner owner) {
        if (owner.getLastname() != null && owner.getFirstname() != null) {
            dbOwner.create(owner);
        }
    }

    public void update(Owner owner) {
        Owner current = dbOwner.findById(owner.getId());
        if (current != null) {
            dbOwner.update(owner);
        }
    }

    public void delete(int id) {
        Owner current = dbOwner.findById(id);
        if (current != null) {
            dbOwner.delete(id);
        }
    }

    public Owner[] findAll() {
        return dbOwner.findAll();
    }

    public Owner findById(int id) {
        return dbOwner.findById(id);
    }
}
