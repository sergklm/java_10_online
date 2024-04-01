package org.example.db;

import org.example.entity.Owner;
public class DbOwner {

    private Owner[] owners = new Owner[10];

    public void create(Owner owner) {
        if (owners[owners.length - 1] != null) {
            Owner[] largerOwners = new Owner[20];
            System.arraycopy(owners, 0, largerOwners, 0, owners.length);
            owners = largerOwners;
        }

        for (int i = 0; i < owners.length; i++) {
            if (owners[i] == null) {
                owners[i] = owner;
                owner.setId(i);
                break;
            }
        }
    }

    public void update(Owner owner) {
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null && owners[i].getId() == owner.getId()) {
                owners[i] = owner;
                break;
            }
        }
    }

    public void delete(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null && owners[i].getId() == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < owners.length - 1; i++) {
                owners[i] = owners[i + 1];
            }
            owners[owners.length - 1] = null;
            for (int i = indexToRemove; i < owners.length - 1; i++) {
                if (owners[i] != null) {
                    owners[i].setId(i);
                }
            }
        }
//        int indexToRemove = -1;
//        for (int i = 0; i < owners.length; i++) {
//            if (owners[i] != null && owners[i].getId() == id) {
//                indexToRemove = i;
//                break;
//            }
//        }
//
//        if (indexToRemove != -1) {
//            for (int i = indexToRemove; i < owners.length - 1; i++) {
//                owners[i] = owners[i + 1];
//            }
//            owners[owners.length - 1] = null;
//        }
    }

    public Owner[] findAll() {
        return owners;
    }

    public Owner findById(int id) {
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null && owners[i].getId() == id) {
                return owners[i];
            }
        }
        return null;
    }
}
