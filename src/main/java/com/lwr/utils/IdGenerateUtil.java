package com.lwr.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerateUtil implements IdentifierGenerator{
    private static Random ra =new Random(); 
    
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String dateString = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS");
        int num = ra.nextInt(899)+100;
        return dateString + String.valueOf(num);
    }
    
}
