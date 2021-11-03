package ru.rsreu.javaeewebapp;

import ru.rsreu.javaeewebapp.dao.oracle.OracleDbDaoFactory;

public enum DbType {
    ORACLE {
        @Override
        public DaoFactory getDAOFactory() {
            DaoFactory factory = null;
            try {
                factory = OracleDbDaoFactory.getInstance();
            } catch (Exception e) {

            }
            return factory;
        }
    };

    public static DbType getTypeByName(String dbType) throws Exception {
        return DbType.valueOf(dbType.toUpperCase());
    }

    public abstract DaoFactory getDAOFactory();
}