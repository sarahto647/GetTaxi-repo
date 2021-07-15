package model.backend;

public final class BackendFactory {
    static Backend instance = null;

    public final static Backend getInstance(Context context) {

        if (mode == "lists") {
            if (instance == null)
                instance = new model.datasource.DatabaseList();
            returninstance;
        }

        if (mode == "fb") {
            if (instance == null)
                instance = new model.datasource.DatabaseFb(context);
            returninstance;
        }
        else {
            return null;
        }
    }
}
