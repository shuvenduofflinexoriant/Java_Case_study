package com.xoriant.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {
		String prefix = "ST";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(userid) from students");

            if(rs.next())
            {
                int id=rs.getInt(1)+1;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
	}



//	@Override
//	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		try {
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-MM-mm-ss");
//			return "S" + super.generate(session, object);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

