package com.designpattens.impl.visitor;

public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
