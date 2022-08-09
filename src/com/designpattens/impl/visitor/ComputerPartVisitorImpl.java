package com.designpattens.impl.visitor;

public class ComputerPartVisitorImpl implements ComputerPartVisitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer");
    }
}
