package system.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScopeTableTest {

    private ScopeTable scopeTable;

    @Before
    public void setUp() {
        scopeTable = new ScopeTable();
        scopeTable.addVariable("int", "test");
    }

    @Test
    public void addIfKeyAlreadyExists() {
        scopeTable.addVariable("int", "test2");

        assertTrue(scopeTable.getLocalVariables("int").contains("test2"));
    }

    @Test
    public void addIfKeyDoesNotExists() {
        scopeTable.addVariable("float", "test3");

        assertTrue(scopeTable.getLocalVariables("float").contains("test3"));
    }

    @Test
    public void returnNullIfTypeNotPresent() {
        assertEquals(null, scopeTable.getLocalVariables("float"));
    }

    @Test
    public void deepCopyWhenCreatingFromOuterScope() {
        ScopeTable newScopeTable = new ScopeTable(scopeTable);

        newScopeTable.addVariable("float", "test");
        newScopeTable.addVariable("int", "test2");

        assertNull(scopeTable.getLocalVariables("float"));
        assertTrue(!scopeTable.getLocalVariables("int").contains("test2"));
    }
}