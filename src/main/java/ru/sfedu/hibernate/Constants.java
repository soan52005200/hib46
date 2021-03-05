package ru.sfedu.hibernate;

public class Constants {
    public static final String SQL_ALL_SCHEMAS = "SELECT schema_name FROM information_schema.schemata";
    public static final String SQL_COLUMN_NAMES = "SELECT table_name FROM information_schema.columns";
    public static final String SQL_DOMAIN_NAME = "SELECT domain_name FROM information_schema.domains";
    public static final String SQL_ALL_TYPES = "SELECT table_type FROM information_schema.tables";
    public static final String HIBERNATE_CFG_KEY = "hib";
}
