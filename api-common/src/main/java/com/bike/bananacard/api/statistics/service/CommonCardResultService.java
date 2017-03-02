package com.bike.bananacard.api.statistics.service;


/**
 * Created by a700 on 16/1/15.
 */
public interface CommonCardResultService {

    public String cardResultList(String accountId, Integer cardId, String stime, String etime) ;

    //
    public String statistics(String accountId, String stime, String etime) ;

}
