package com.neeson.java8.annotation;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;

public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    public void checkName(Element element) {
        nameCheckScanner.scan(element);
    }


    private class NameCheckScanner extends ElementScanner8<Void, Void> {

        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(), aVoid);
            checkCamelCase(e, true);
            return super.visitType(e, aVoid);
        }



        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Diagnostic.Kind.WARNING,"普通方法" + name + "不应该与类名重复");
                    checkCamelCase(e,false);
                }
            }
            return super.visitExecutable(e, aVoid);
        }


        private void checkCamelCase(Element e, boolean initialCaps) {
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)) {
                previousUpper = true;
                if (!initialCaps) {
                    messager.printMessage(Diagnostic.Kind.WARNING,"...");
                }
            }
        }
    }

}

