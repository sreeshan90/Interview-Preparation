package com.design;

interface IConnection {

    public IConnection getConnection(String connectionString);
}

class ConnectionPool {

    private static ConnectionPool instance;

    public static ConnectionPool getInstance() {

        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public IConnection acquireConnectionImpl() {

        return null;
    }

    public void releaseConnectionImpl(IConnection connection) {

    }
 }

class ConnectionImpl implements IConnection{

    @Override
    public IConnection getConnection(String connectionString) {
        return null;
    }
}
