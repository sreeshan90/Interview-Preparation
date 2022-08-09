package com.designpattens.impl.visitor;

public interface ComputerPart {
    public void accept(ComputerPartVisitor visitor);
}
