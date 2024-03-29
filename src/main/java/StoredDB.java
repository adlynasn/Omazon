package main.java;

public abstract class StoredDB {

    private boolean inDatabase;

    protected void setInDatabase(boolean inDatabase) {
        this.inDatabase = inDatabase;
    }

    protected boolean inDatabase() {
        return inDatabase;
    }

    protected static String getPrimaryKey() {
        return null;
    }

    public abstract String insertQuery();
    public abstract String updateQuery();
    public abstract String deleteQuery();
}
