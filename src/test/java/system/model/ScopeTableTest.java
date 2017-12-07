package system.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScopeTableTest {

    private ScopeTable scopeTable;

    @Before
    public void setUp() {
        scopeTable = new ScopeTable();
        scopeTable.addVariable("int", new STEntry("int", "test1", false));
    }

    @Test
    public void addIfKeyAlreadyExists() {
        scopeTable.addVariable("int", new STEntry("int", "test2", false));

        assertTrue(scopeTable.getLocalVariables("int").stream()
                .map(STEntry::getIdentifier)
                .anyMatch(v -> v.equals("test2"))
        );
    }

    @Test
    public void addIfKeyDoesNotExists() {
        scopeTable.addVariable("float", new STEntry("float", "test3", false));

        assertTrue(scopeTable.getLocalVariables("float").stream()
                .map(STEntry::getIdentifier)
                .anyMatch(v -> v.equals("test3"))
        );
    }

    @Test
    public void returnNullIfTypeNotPresent() {
        assertEquals(null, scopeTable.getLocalVariables("float"));
    }

    @Test
    public void deepCopyWhenCreatingFromOuterScope() {
        ScopeTable newScopeTable = new ScopeTable(scopeTable, false);

        newScopeTable.addVariable("float", new STEntry("float", "test", false));
        newScopeTable.addVariable("int", new STEntry("int", "test2", false));

        assertNull(scopeTable.getLocalVariables("float"));
        assertTrue(!scopeTable.getLocalVariables("int").contains("test2"));
    }
}