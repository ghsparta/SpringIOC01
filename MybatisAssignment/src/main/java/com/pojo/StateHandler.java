package com.pojo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedJdbcTypes({JdbcType.INTEGER})
@MappedTypes({State.class})
public class StateHandler extends BaseTypeHandler<State> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, State state, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public State getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int state = resultSet.getInt(s);
        if (state == 0) {
            return State.ACTIVE;
        } else if (state == 1) {
            return State.INACTIVE;
        } else {
            return State.CLOSED;
        }
    }

    @Override
    public State getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int state = resultSet.getInt(i);
        if (state == 0) {
            return State.ACTIVE;
        } else if (state == 1) {
            return State.INACTIVE;
        } else {
            return State.CLOSED;
        }
    }

    @Override
    public State getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
