package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {
    Entry<String> root;
    List<Entry<String>> elements = new ArrayList<>();

    public CustomTree() {
        root = new Entry<>("ourRoot");
        elements.add(root);
    }

    @Override
    public String get(int index) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s){
        Entry<String> newEntry = new Entry<>(s);
        Entry<String> tryGetChild;
        boolean anyCanHaveChildren = false;
        for (int i = 0; i < elements.size(); i++) {
            tryGetChild = elements.get(i);
            if (tryGetChild.isAvailableToAddChildren()){
                anyCanHaveChildren = true;
                if (tryGetChild.availableToAddLeftChildren){
                    tryGetChild.availableToAddLeftChildren = false;
                    tryGetChild.leftChild = newEntry;
                    newEntry.parent = tryGetChild;
                    elements.add(newEntry);
                    return true;
                } else {
                    tryGetChild.availableToAddRightChildren = false;
                    tryGetChild.rightChild = newEntry;
                    newEntry.parent = tryGetChild;
                    elements.add(newEntry);
                    return true;
                }
            }
        }
        if (!anyCanHaveChildren){
            Entry<String> returnAbilityToHaveChildren;
            for (int i = elements.size() - 1; i >= 0; i--) {
                returnAbilityToHaveChildren = elements.get(i);
                if (returnAbilityToHaveChildren.rightChild == null && returnAbilityToHaveChildren.leftChild == null){
                    returnAbilityToHaveChildren.availableToAddRightChildren = true;
                    returnAbilityToHaveChildren.availableToAddLeftChildren = true;
                } else {
                    return add(s);
                }
            }
        }
        return false;
    }

    public boolean remove(Object o) throws UnsupportedOperationException{
        if (!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        String stringToRemove = (String) o;
        Entry<String> entryToRemove;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).elementName.equals(stringToRemove)){
                entryToRemove = elements.get(i);
                return deleteElementAndAllChildren(entryToRemove);
            }
        }
        return false;
    }

    public boolean deleteElementAndAllChildren(Entry<String> entry){
        if (entry.rightChild != null){
            deleteElementAndAllChildren(entry.rightChild);
        }
        if (entry.leftChild != null){
            deleteElementAndAllChildren(entry.leftChild);
        }
        if (entry.parent.leftChild == entry){
            entry.parent.leftChild = null;
        } else {
            entry.parent.rightChild = null;
        }
        return elements.remove(entry);
    }

    public String getParent(String s){
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).elementName.equals(s)){
                return elements.get(i).parent.elementName;
            }
        }
        return null;
    }

    public int size() {
        return elements.size() - 1;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
