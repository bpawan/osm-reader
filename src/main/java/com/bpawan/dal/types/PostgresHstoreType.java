package com.bpawan.dal.types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class PostgresHstoreType implements UserType {
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }

    public Object deepCopy(Object o) throws HibernateException {
        // It's not a true deep copy, but we store only String instances, and they
        // are immutable, so it should be OK
        Map m = (Map) o;
        return new HashMap(m);
    }

    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    public boolean equals(Object o1, Object o2) throws HibernateException {
        Map m1 = (Map) o1;
        Map m2 = (Map) o2;
        return m1.equals(m2);
    }

    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    public Object nullSafeGet(
            ResultSet resultSet,
            String[] names,
            SharedSessionContractImplementor session,
            Object owner
    ) throws HibernateException, SQLException {
        String col = names[0];
        String val = resultSet.getString(col);
        return HstoreHelper.toMap(val);
    }

    @Override
    public void nullSafeSet(
            PreparedStatement preparedStatement,
            Object value,
            int index,
            SharedSessionContractImplementor session
    ) throws HibernateException, SQLException {
        String s = HstoreHelper.toString((Map) value);
        preparedStatement.setObject(index, s, Types.OTHER);
    }

    public boolean isMutable() {
        return true;
    }

    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

    public Class returnedClass() {
        return Map.class;
    }

    public int[] sqlTypes() {
        /*
         * i'm not sure what value should be used here, but it works, AFAIK only
         * length of this array matters, as it is a column span (1 in our case)
         */
        return new int[]{Types.INTEGER};
    }
}
