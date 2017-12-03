package system.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScopeTableTest {

    private ScopeTable scopeTable;

    @Before
    public void setUp() throws Exception {
        scopeTable = new ScopeTable();
        scopeTable.add("int", "test");
    }

    @Test
    public void addIfKeyAlreadyExists() {
        scopeTable.add("int", "test2");

        assertTrue(scopeTable.get("int").contains("test2"));
    }

    @Test
    public void addIfKeyDoesNotExists() {
        scopeTable.add("float", "test3");

        assertTrue(scopeTable.get("float").contains("test3"));
    }

    @Test
    public void returnNullIfTypeNotPresent() {
        assertEquals(null, scopeTable.get("float"));
    }
}