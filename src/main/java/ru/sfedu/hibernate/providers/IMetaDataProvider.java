package ru.sfedu.hibernate.providers;

import java.util.List;

public interface IMetaDataProvider {

    List getAllSchemas();

    List getColumnNames();

    List getDomainName();

    List getAllTypes();
}
