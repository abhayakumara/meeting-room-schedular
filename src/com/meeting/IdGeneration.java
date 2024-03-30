package com.meeting;

public class IdGeneration {
    private static IdGeneration idGeneration = null;
    private Integer uniqueId;
    private IdGeneration() {
        uniqueId = 0;
    }


    public static synchronized IdGeneration getInstance() {
        if(idGeneration == null) {
            idGeneration = new IdGeneration();
        }
        return idGeneration;
    }

    public Integer getUniqueId() {
        uniqueId += 1;
        return uniqueId;
    }
}
