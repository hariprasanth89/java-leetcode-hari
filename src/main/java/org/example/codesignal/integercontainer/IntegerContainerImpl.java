package org.example.codesignal.integercontainer;


import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class IntegerContainerImpl implements IntegerContainer {

    public IntegerContainerImpl() {
        // TODO: implement
    }


// TODO: implement interface methods here

    ArrayList<Integer> addOrRemove = new ArrayList<>();
    @Override
    public int add(int value) {
        addOrRemove.add(value);
        return addOrRemove.size();
    }

    @Override
    public boolean delete(int value) {

        return addOrRemove.remove(Integer.valueOf(value));
    }

    @Override
    public Optional<Integer> getMedian() {
        if (addOrRemove.isEmpty()) {
            return Optional.empty();
        }
        Collections.sort(addOrRemove);

        int medianIndex = (addOrRemove.size() -1) /2;


        return Optional.of(addOrRemove.get(medianIndex));
    }

    public static void main(String[] args) {
        // IntegerContainerImpl containerImpl = new IntegerContainerImpl();
        // containerImpl.add(10);

    }


}

