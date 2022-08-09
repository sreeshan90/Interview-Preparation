package com.designpattens.impl.visitor;

public interface ComputerPartVisitor {
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Computer computer);
}
