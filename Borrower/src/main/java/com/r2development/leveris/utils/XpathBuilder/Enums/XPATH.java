package com.r2development.leveris.utils.XpathBuilder.Enums;

import java.util.LinkedList;

public enum XPATH {

    BUILDER (ELEMENTS.getValues(), ACTIONS.getValues(), ATTRIBUTES.getValues());

    private LinkedList<ELEMENTS> elements;

    private LinkedList<ACTIONS> actions;

    private LinkedList<ATTRIBUTES> attributes;

    XPATH(LinkedList<ELEMENTS> elements, LinkedList<ACTIONS> actions, LinkedList<ATTRIBUTES> attributes){
        this.elements = elements;
        this.actions = actions;
        this.attributes = attributes;
    }

    public LinkedList<ELEMENTS> getElements(){
        return elements;
    }

    public LinkedList<ACTIONS> getActions(){
        return actions;
    }

    public LinkedList<ATTRIBUTES> getAttributes(){
        return attributes;
    }

    public static <T extends Enum<T>> T xpathGetValueFromEnum(Class<T> enumType, String name){
        T[] result = enumType.getEnumConstants();
        for(T oneConstant : result) {
            if(name.equalsIgnoreCase(oneConstant.toString())){
                return oneConstant;
            }
        }
        throw new IllegalArgumentException(
                "No enum constant Matched " + enumType.getCanonicalName() + "." + name);
    }
}