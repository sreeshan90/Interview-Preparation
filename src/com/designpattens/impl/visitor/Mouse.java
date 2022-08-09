package com.designpattens.impl.visitor;

public class Mouse implements ComputerPart{

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
