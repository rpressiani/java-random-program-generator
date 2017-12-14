package system.controller.parser;

import org.eclipse.jdt.core.dom.*;
import system.model.STEntry;
import system.model.ScopeTable;

import java.util.List;


public class MyVisitor extends ASTVisitor {

    CompilationUnit compilationUnit;

    ScopeTable scopeTable;

    boolean insideMethod = false;
    private String className;

    boolean isInterface = false;

    public MyVisitor(CompilationUnit compilationUnit, ScopeTable scopeTable) {

        this.compilationUnit = compilationUnit;
        if(scopeTable == null) {
            this.scopeTable = new ScopeTable();
        } else {
            this.scopeTable = scopeTable;
        }
    }

    public MyVisitor(CompilationUnit compilationUnit) {

        this.compilationUnit = compilationUnit;
        this.scopeTable = new ScopeTable();
        this.isInterface = true;
    }

    //DONE
    @Override
    public boolean visit(PackageDeclaration node) {
        return super.visit(node);
    }


    //DONE
    @Override
    public boolean visit(TypeDeclaration node) {
        className = node.getName().toString();
        if (isAbstract(node)) {
            return false;
        }

//        qua forse serve una cosa a parte per le classi perchè vanno dichiarate
//        STEntry stEntry = new STEntry();
//        scopeTable.addVariable(node.getName(), );
        return super.visit(node);
    }

    //This method return true if the node is marked with abstract modifier
    private boolean isAbstract(TypeDeclaration node) {

        for (Object o : node.modifiers()) {
            if (o.toString().equalsIgnoreCase("abstract")) {
                return true;
            }
        }
        return false;
    }

    //TODO: la notazione punto va implementata
    @Override
    public boolean visit(MethodDeclaration node) {

        insideMethod = true;
        if(isInterface){
            String returnType = node.getReturnType2().toString();
            STEntry stEntry = new STEntry(returnType, node.getName().toString(), isStatic(node.modifiers()));
            scopeTable.addMethod(returnType, stEntry);
        } else if(!isPrivate(node.modifiers()) && isStatic(node.modifiers()) && !node.getName().toString().contentEquals("main")) {
            String returnType = node.getReturnType2().toString();
            STEntry stEntry = new STEntry(returnType, className + "." + node.getName().toString(), isStatic(node.modifiers()));
            scopeTable.addMethod(returnType, stEntry);
        }
        return super.visit(node);
    }

    private boolean isPrivate(List modifiers){

        for (Object o : modifiers) {
            if (o.toString().equalsIgnoreCase("private")) {
                return true;
            }
        }
        return false;
    }

    private boolean isStatic(List modifiers){

        for (Object o : modifiers) {
            if (o.toString().equalsIgnoreCase("static")) {
                return true;
            }
        }
        return false;
    }

    //DONE
    @Override
    public boolean visit(VariableDeclarationFragment node) {

        if(!insideMethod){
            return super.visit(node);
        }
        return false;
    }

    public boolean visit(FieldDeclaration node){

        if(!insideMethod && !isPrivate(node.modifiers()) && isStatic(node.modifiers())) {
            String returnType = node.getType().toString();
            for (Object o : node.fragments()) {
                STEntry stEntry = new STEntry(returnType, className+"."+getLeftSide(o.toString()), isStatic(node.modifiers()));
                scopeTable.addField(returnType, stEntry);
            }
        }
        return super.visit(node);
    }

    private String getLeftSide(String fieldFragment){

        String[] parts = fieldFragment.split("=");
        return parts[0];
    }

    public ScopeTable getScopeTable() {

        return scopeTable;
    }
}
