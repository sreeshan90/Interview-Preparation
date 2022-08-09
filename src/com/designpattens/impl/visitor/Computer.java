package com.designpattens.impl.visitor;

import java.util.Arrays;

public class Computer implements ComputerPart{

    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] {new Keyboard(), new Mouse()};
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        Arrays.stream(parts).forEach(part -> part.accept(visitor));
        visitor.visit(this);
    }
}
